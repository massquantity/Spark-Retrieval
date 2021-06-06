package com.mass.tdm.tree

import java.io._
import java.nio.charset.Charset
import java.nio.ByteBuffer

import scala.collection.mutable
import scala.util.{Failure, Success, Using}

import com.google.protobuf.ByteString
import com.mass.sparkdl.utils.{FileWriter => DistFileWriter}
import com.mass.tdm.{encoding, ArrayExtension}
import com.mass.tdm.protobuf.store_kv.KVItem
import com.mass.tdm.protobuf.tree.{IdCodePair, IdCodePart, Node, TreeMeta}
import org.apache.log4j.Logger

class TreeBuilder(outputTreePath: String, embedPath: Option[String] = None) {
  import TreeBuilder._
  val logger: Logger = Logger.getLogger(getClass)

  def build(
      treeIds: Array[Int],
      treeCodes: Array[Int],
      treeData: Option[Array[Array[Float]]] = None,
      idOffset: Option[Int] = None,
      stat: Option[mutable.Map[Int, Int]] = None): Unit = {

    val offset = idOffset match {
      // case Some(_) => math.max(0, treeIds.max) + 1
      // case None => 1
      case Some(i) => i
      case None => math.max(0, treeIds.max) + 1
    }

    val index = treeCodes.argSort(inplace = false)  // from implicit class
    val ids: Array[Int] = index.map(treeIds(_))
    val codes: Array[Int] = index.map(treeCodes(_))
    val embeds: Option[Array[Array[Float]]] = treeData match {
      case Some(d) => Some(index.map(d(_)))
      case None => None
    }

    flattenLeaves(codes)
    writeEmbed(ids, codes, embeds)

    val pstat: Map[Int, Float] = stat match {
      case Some(treeStat) =>
        var tmp = Map.empty[Int, Float]
        ids.zip(codes).foreach { case (id, code) =>
          val ancestors = getAncestors(code)
          ancestors foreach { anc =>
            if (treeStat.contains(id)) {
              tmp += (anc -> (tmp.getOrElse(anc, 0.0f) + treeStat(id)))
            }
          }
        }
        tmp
      case None =>
        Map.empty
    }

    val fileWriter = DistFileWriter(outputTreePath)
    val output: OutputStream = fileWriter.create(overwrite = true)
    Using(new BufferedOutputStream(output)) { writer =>
      val parts = new mutable.ArrayBuffer[IdCodePart]()
      val tmpItems = new mutable.ArrayBuffer[IdCodePair]()
      val savedItems = new mutable.HashSet[Int]()
      var maxLevel = 0

      ids.indices.foreach { i =>
        val id = ids(i)
        val code = codes(i)
        val prob = stat match {
          case Some(s) if s.contains(id) => s(id).toFloat
          case _ => 1.0f
        }
        val leafCatId = 0
        val isLeaf = true
        val leafNode: Node = embeds match {
          case Some(emb) => Node(id, prob, leafCatId, isLeaf, emb(i).toSeq)
          case None => Node(id, prob, leafCatId, isLeaf)
        }
        val leafKV = KVItem(toByteString(code), leafNode.toByteString)
        writeKV(leafKV, writer)

        tmpItems += IdCodePair(id, code)
        if (i == ids.length - 1 || tmpItems.length == 512) {
          val partId = "Part_" + (parts.length + 1)
          parts += IdCodePart(toByteString(partId), tmpItems.clone())
          tmpItems.clear()
        }

        val ancestors = getAncestors(code)
        ancestors.foreach { ancCode =>
          if (!savedItems.contains(ancCode)) {
            val id = ancCode + offset
            val prob = pstat.getOrElse(ancCode, 1.0f)
            val leafCatId = 0
            val isLeaf = false
            val node = Node(id, prob, leafCatId, isLeaf)
            val ancestorKV = KVItem(toByteString(ancCode), node.toByteString)
            writeKV(ancestorKV, writer)
            savedItems += ancCode
          }
        }
        maxLevel = math.max(maxLevel, ancestors.length + 1)
      }

      parts.foreach { p =>
        val partKV = KVItem(p.partId, p.toByteString)
        writeKV(partKV, writer)
      }

      val partIds = parts.map(x => x.partId).toArray
      val meta = TreeMeta(maxLevel, partIds)
      val metaKV = KVItem(toByteString("tree_meta"), meta.toByteString)
      writeKV(metaKV, writer)
      logger.info(s"item num: ${ids.length}, tree level: $maxLevel, " +
        s"leaf code start: ${codes.min}, leaf code end: ${codes.max}")

    } match {
      case Success(_) =>
        output.close()
        fileWriter.close()
      case Failure(e: FileNotFoundException) =>
        println(s"""file "${embedPath.get}" not found""")
        throw e
      case Failure(t: Throwable) =>
        throw t
    }
  }

  def writeEmbed(ids: Array[Int], codes: Array[Int], data: Option[Array[Array[Float]]]): Unit = {
    if (embedPath.isDefined) {
      val fileWriter = DistFileWriter(outputTreePath)
      val output: OutputStream = fileWriter.create(overwrite = true)
      Using(new DataOutputStream(new BufferedOutputStream(output))) { writer =>
        ids.indices.foreach { i =>
          writer.writeBytes(s"${ids(i)}, ${makePrefixCode(codes(i))}")
          data match {
            case Some(embeds) =>
              embeds(i).foreach(d => writer.writeBytes(s", $d"))
            case None =>
          }
          writer.writeBytes("\n")
        }
      } match {
        case Success(_) =>
        case Failure(e: FileNotFoundException) =>
          println(s"""file "${embedPath.get}" not found""")
          throw e
        case Failure(t: Throwable) =>
          throw t
      }
    }
  }
}

object TreeBuilder {

  def getAllocatedLong(i: Long): Long = {
    val bf: ByteBuffer = allocateByteLong(i)
    ByteBuffer.wrap(bf.array()).getLong()
  }

  def allocateByteLong(i: Long): ByteBuffer = {
    ByteBuffer.allocate(8).putLong(i)
  }

  def allocateByteInt(i: Int): ByteBuffer = {
    ByteBuffer.allocate(4).putInt(i)
  }

  def toByteString[T](key: T): ByteString = {
    key match {
      case i: String => ByteString.copyFrom(i, encoding.name())
      // case i: Long => ByteString.copyFrom(allocateByteLong(i).array())
      // case i: Int => ByteString.copyFrom(allocateByteInt(i).array())
      case i => ByteString.copyFrom(i.toString, encoding.name())
    }
  }

  def writeKV(message: KVItem, writer: OutputStream): Unit = {
    // writer.writeInt(message.serializedSize),  DataOutputstream
    val bf: ByteBuffer = allocateByteInt(message.serializedSize)
    writer.write(bf.array())
    message.writeTo(writer)
  }

  def getAncestors(code: Int): Vector[Int] = {
    val ancs = new mutable.ListBuffer[Int]()
    var num = code
    while (num > 0) {
      num = (num - 1) / 2
      ancs += num
    }
    ancs.toVector
  }

  def makePrefixCode(code: Int): String = {
    val prefix = new StringBuilder
    var num = code
    while (num > 0) {
      prefix += (if (num % 2 == 0) '1' else '0')
      num = (num - 1) / 2
    }
    prefix ++= "0"
    prefix.reverse.toString
  }

  // make all leaf nodes in same level
  def flattenLeaves(codes: Array[Int]): Unit = {
    var minCode = 0
    var maxCode = codes.last
    while (maxCode > 0) {
      minCode = minCode * 2 + 1
      maxCode = (maxCode - 1) / 2
    }

    codes.indices.foreach { i =>
      while (codes(i) < minCode) {
        codes(i) = codes(i) * 2 + 1
      }
    }
  }
}

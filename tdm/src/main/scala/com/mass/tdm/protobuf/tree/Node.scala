// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.mass.tdm.protobuf.tree

@SerialVersionUID(0L)
final case class Node(
    id: _root_.scala.Int = 0,
    probality: _root_.scala.Float = 0.0f,
    leafCateId: _root_.scala.Int = 0,
    isLeaf: _root_.scala.Boolean = false,
    embedVec: _root_.scala.Seq[_root_.scala.Float] = _root_.scala.Seq.empty,
    data: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[Node] {
    private[this] def embedVecSerializedSize = {
      4 * embedVec.size
    }
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = id
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(1, __value)
        }
      };
      
      {
        val __value = probality
        if (__value != 0.0f) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeFloatSize(2, __value)
        }
      };
      
      {
        val __value = leafCateId
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(3, __value)
        }
      };
      
      {
        val __value = isLeaf
        if (__value != false) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeBoolSize(4, __value)
        }
      };
      if (embedVec.nonEmpty) {
        val __localsize = embedVecSerializedSize
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__localsize) + __localsize
      }
      
      {
        val __value = data
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(6, __value)
        }
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = id
        if (__v != 0) {
          _output__.writeInt32(1, __v)
        }
      };
      {
        val __v = probality
        if (__v != 0.0f) {
          _output__.writeFloat(2, __v)
        }
      };
      {
        val __v = leafCateId
        if (__v != 0) {
          _output__.writeInt32(3, __v)
        }
      };
      {
        val __v = isLeaf
        if (__v != false) {
          _output__.writeBool(4, __v)
        }
      };
      if (embedVec.nonEmpty) {
        _output__.writeTag(5, 2)
        _output__.writeUInt32NoTag(embedVecSerializedSize)
        embedVec.foreach(_output__.writeFloatNoTag)
      };
      {
        val __v = data
        if (!__v.isEmpty) {
          _output__.writeBytes(6, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withId(__v: _root_.scala.Int): Node = copy(id = __v)
    def withProbality(__v: _root_.scala.Float): Node = copy(probality = __v)
    def withLeafCateId(__v: _root_.scala.Int): Node = copy(leafCateId = __v)
    def withIsLeaf(__v: _root_.scala.Boolean): Node = copy(isLeaf = __v)
    def clearEmbedVec = copy(embedVec = _root_.scala.Seq.empty)
    def addEmbedVec(__vs: _root_.scala.Float*): Node = addAllEmbedVec(__vs)
    def addAllEmbedVec(__vs: Iterable[_root_.scala.Float]): Node = copy(embedVec = embedVec ++ __vs)
    def withEmbedVec(__v: _root_.scala.Seq[_root_.scala.Float]): Node = copy(embedVec = __v)
    def withData(__v: _root_.com.google.protobuf.ByteString): Node = copy(data = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = id
          if (__t != 0) __t else null
        }
        case 2 => {
          val __t = probality
          if (__t != 0.0f) __t else null
        }
        case 3 => {
          val __t = leafCateId
          if (__t != 0) __t else null
        }
        case 4 => {
          val __t = isLeaf
          if (__t != false) __t else null
        }
        case 5 => embedVec
        case 6 => {
          val __t = data
          if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(id)
        case 2 => _root_.scalapb.descriptors.PFloat(probality)
        case 3 => _root_.scalapb.descriptors.PInt(leafCateId)
        case 4 => _root_.scalapb.descriptors.PBoolean(isLeaf)
        case 5 => _root_.scalapb.descriptors.PRepeated(embedVec.iterator.map(_root_.scalapb.descriptors.PFloat(_)).toVector)
        case 6 => _root_.scalapb.descriptors.PByteString(data)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.mass.tdm.protobuf.tree.Node
    // @@protoc_insertion_point(GeneratedMessage[com.mass.tdm.protobuf.Node])
}

object Node extends scalapb.GeneratedMessageCompanion[com.mass.tdm.protobuf.tree.Node] with scalapb.HasBuilder[com.mass.tdm.protobuf.tree.Node] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.mass.tdm.protobuf.tree.Node] with scalapb.HasBuilder[com.mass.tdm.protobuf.tree.Node] = this
  def merge(`_message__`: com.mass.tdm.protobuf.tree.Node, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.mass.tdm.protobuf.tree.Node = newBuilder(_message__).merge(_input__).result()
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.mass.tdm.protobuf.tree.Node] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.mass.tdm.protobuf.tree.Node(
        id = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        probality = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Float]).getOrElse(0.0f),
        leafCateId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        isLeaf = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Boolean]).getOrElse(false),
        embedVec = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Seq[_root_.scala.Float]]).getOrElse(_root_.scala.Seq.empty),
        data = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.com.google.protobuf.ByteString]).getOrElse(_root_.com.google.protobuf.ByteString.EMPTY)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = TreeProto.javaDescriptor.getMessageTypes().get(3)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = TreeProto.scalaDescriptor.messages(3)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.mass.tdm.protobuf.tree.Node(
    id = 0,
    probality = 0.0f,
    leafCateId = 0,
    isLeaf = false,
    embedVec = _root_.scala.Seq.empty,
    data = _root_.com.google.protobuf.ByteString.EMPTY
  )
  final class Builder private (
    private var __id: _root_.scala.Int,
    private var __probality: _root_.scala.Float,
    private var __leafCateId: _root_.scala.Int,
    private var __isLeaf: _root_.scala.Boolean,
    private val __embedVec: _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Float],
    private var __data: _root_.com.google.protobuf.ByteString,
    private var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder
  ) extends _root_.scalapb.MessageBuilder[com.mass.tdm.protobuf.tree.Node] {
    def merge(`_input__`: _root_.com.google.protobuf.CodedInputStream): this.type = {
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 8 =>
            __id = _input__.readInt32()
          case 21 =>
            __probality = _input__.readFloat()
          case 24 =>
            __leafCateId = _input__.readInt32()
          case 32 =>
            __isLeaf = _input__.readBool()
          case 45 =>
            __embedVec += _input__.readFloat()
          case 42 => {
            val length = _input__.readRawVarint32()
            val oldLimit = _input__.pushLimit(length)
            while (_input__.getBytesUntilLimit > 0) {
              __embedVec += _input__.readFloat()
            }
            _input__.popLimit(oldLimit)
          }
          case 50 =>
            __data = _input__.readBytes()
          case tag =>
            if (_unknownFields__ == null) {
              _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
            }
            _unknownFields__.parseField(tag, _input__)
        }
      }
      this
    }
    def result(): com.mass.tdm.protobuf.tree.Node = {
      com.mass.tdm.protobuf.tree.Node(
        id = __id,
        probality = __probality,
        leafCateId = __leafCateId,
        isLeaf = __isLeaf,
        embedVec = __embedVec.result(),
        data = __data,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
      )
    }
  }
  object Builder extends _root_.scalapb.MessageBuilderCompanion[com.mass.tdm.protobuf.tree.Node, com.mass.tdm.protobuf.tree.Node.Builder] {
    def apply(): Builder = new Builder(
      __id = 0,
      __probality = 0.0f,
      __leafCateId = 0,
      __isLeaf = false,
      __embedVec = new _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Float],
      __data = _root_.com.google.protobuf.ByteString.EMPTY,
      `_unknownFields__` = null
    )
    def apply(`_message__`: com.mass.tdm.protobuf.tree.Node): Builder = new Builder(
        __id = _message__.id,
        __probality = _message__.probality,
        __leafCateId = _message__.leafCateId,
        __isLeaf = _message__.isLeaf,
        __embedVec = new _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Float] ++= _message__.embedVec,
        __data = _message__.data,
        `_unknownFields__` = new _root_.scalapb.UnknownFieldSet.Builder(_message__.unknownFields)
    )
  }
  def newBuilder: Builder = com.mass.tdm.protobuf.tree.Node.Builder()
  def newBuilder(`_message__`: com.mass.tdm.protobuf.tree.Node): Builder = com.mass.tdm.protobuf.tree.Node.Builder(_message__)
  implicit class NodeLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.mass.tdm.protobuf.tree.Node]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.mass.tdm.protobuf.tree.Node](_l) {
    def id: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.id)((c_, f_) => c_.copy(id = f_))
    def probality: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Float] = field(_.probality)((c_, f_) => c_.copy(probality = f_))
    def leafCateId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.leafCateId)((c_, f_) => c_.copy(leafCateId = f_))
    def isLeaf: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Boolean] = field(_.isLeaf)((c_, f_) => c_.copy(isLeaf = f_))
    def embedVec: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[_root_.scala.Float]] = field(_.embedVec)((c_, f_) => c_.copy(embedVec = f_))
    def data: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] = field(_.data)((c_, f_) => c_.copy(data = f_))
  }
  final val ID_FIELD_NUMBER = 1
  final val PROBALITY_FIELD_NUMBER = 2
  final val LEAF_CATE_ID_FIELD_NUMBER = 3
  final val IS_LEAF_FIELD_NUMBER = 4
  final val EMBED_VEC_FIELD_NUMBER = 5
  final val DATA_FIELD_NUMBER = 6
  def of(
    id: _root_.scala.Int,
    probality: _root_.scala.Float,
    leafCateId: _root_.scala.Int,
    isLeaf: _root_.scala.Boolean,
    embedVec: _root_.scala.Seq[_root_.scala.Float],
    data: _root_.com.google.protobuf.ByteString
  ): _root_.com.mass.tdm.protobuf.tree.Node = _root_.com.mass.tdm.protobuf.tree.Node(
    id,
    probality,
    leafCateId,
    isLeaf,
    embedVec,
    data
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[com.mass.tdm.protobuf.Node])
}

// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.mass.tdm.protobuf.tree

@SerialVersionUID(0L)
final case class TreeMeta(
    maxLevel: _root_.scala.Int = 0,
    idCodePart: _root_.scala.Seq[_root_.com.google.protobuf.ByteString] = _root_.scala.Seq.empty,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[TreeMeta] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = maxLevel
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(1, __value)
        }
      };
      idCodePart.foreach { __item =>
        val __value = __item
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(2, __value)
      }
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
        val __v = maxLevel
        if (__v != 0) {
          _output__.writeInt32(1, __v)
        }
      };
      idCodePart.foreach { __v =>
        val __m = __v
        _output__.writeBytes(2, __m)
      };
      unknownFields.writeTo(_output__)
    }
    def withMaxLevel(__v: _root_.scala.Int): TreeMeta = copy(maxLevel = __v)
    def clearIdCodePart = copy(idCodePart = _root_.scala.Seq.empty)
    def addIdCodePart(__vs: _root_.com.google.protobuf.ByteString*): TreeMeta = addAllIdCodePart(__vs)
    def addAllIdCodePart(__vs: Iterable[_root_.com.google.protobuf.ByteString]): TreeMeta = copy(idCodePart = idCodePart ++ __vs)
    def withIdCodePart(__v: _root_.scala.Seq[_root_.com.google.protobuf.ByteString]): TreeMeta = copy(idCodePart = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = maxLevel
          if (__t != 0) __t else null
        }
        case 2 => idCodePart
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(maxLevel)
        case 2 => _root_.scalapb.descriptors.PRepeated(idCodePart.iterator.map(_root_.scalapb.descriptors.PByteString(_)).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.mass.tdm.protobuf.tree.TreeMeta
    // @@protoc_insertion_point(GeneratedMessage[com.mass.tdm.protobuf.TreeMeta])
}

object TreeMeta extends scalapb.GeneratedMessageCompanion[com.mass.tdm.protobuf.tree.TreeMeta] with scalapb.HasBuilder[com.mass.tdm.protobuf.tree.TreeMeta] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.mass.tdm.protobuf.tree.TreeMeta] with scalapb.HasBuilder[com.mass.tdm.protobuf.tree.TreeMeta] = this
  def merge(`_message__`: com.mass.tdm.protobuf.tree.TreeMeta, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.mass.tdm.protobuf.tree.TreeMeta = newBuilder(_message__).merge(_input__).result()
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.mass.tdm.protobuf.tree.TreeMeta] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.mass.tdm.protobuf.tree.TreeMeta(
        maxLevel = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        idCodePart = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Seq[_root_.com.google.protobuf.ByteString]]).getOrElse(_root_.scala.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = TreeProto.javaDescriptor.getMessageTypes().get(2)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = TreeProto.scalaDescriptor.messages(2)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.mass.tdm.protobuf.tree.TreeMeta(
    maxLevel = 0,
    idCodePart = _root_.scala.Seq.empty
  )
  final class Builder private (
    private var __maxLevel: _root_.scala.Int,
    private val __idCodePart: _root_.scala.collection.immutable.VectorBuilder[_root_.com.google.protobuf.ByteString],
    private var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder
  ) extends _root_.scalapb.MessageBuilder[com.mass.tdm.protobuf.tree.TreeMeta] {
    def merge(`_input__`: _root_.com.google.protobuf.CodedInputStream): this.type = {
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 8 =>
            __maxLevel = _input__.readInt32()
          case 18 =>
            __idCodePart += _input__.readBytes()
          case tag =>
            if (_unknownFields__ == null) {
              _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
            }
            _unknownFields__.parseField(tag, _input__)
        }
      }
      this
    }
    def result(): com.mass.tdm.protobuf.tree.TreeMeta = {
      com.mass.tdm.protobuf.tree.TreeMeta(
        maxLevel = __maxLevel,
        idCodePart = __idCodePart.result(),
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
      )
    }
  }
  object Builder extends _root_.scalapb.MessageBuilderCompanion[com.mass.tdm.protobuf.tree.TreeMeta, com.mass.tdm.protobuf.tree.TreeMeta.Builder] {
    def apply(): Builder = new Builder(
      __maxLevel = 0,
      __idCodePart = new _root_.scala.collection.immutable.VectorBuilder[_root_.com.google.protobuf.ByteString],
      `_unknownFields__` = null
    )
    def apply(`_message__`: com.mass.tdm.protobuf.tree.TreeMeta): Builder = new Builder(
        __maxLevel = _message__.maxLevel,
        __idCodePart = new _root_.scala.collection.immutable.VectorBuilder[_root_.com.google.protobuf.ByteString] ++= _message__.idCodePart,
        `_unknownFields__` = new _root_.scalapb.UnknownFieldSet.Builder(_message__.unknownFields)
    )
  }
  def newBuilder: Builder = com.mass.tdm.protobuf.tree.TreeMeta.Builder()
  def newBuilder(`_message__`: com.mass.tdm.protobuf.tree.TreeMeta): Builder = com.mass.tdm.protobuf.tree.TreeMeta.Builder(_message__)
  implicit class TreeMetaLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.mass.tdm.protobuf.tree.TreeMeta]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.mass.tdm.protobuf.tree.TreeMeta](_l) {
    def maxLevel: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.maxLevel)((c_, f_) => c_.copy(maxLevel = f_))
    def idCodePart: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[_root_.com.google.protobuf.ByteString]] = field(_.idCodePart)((c_, f_) => c_.copy(idCodePart = f_))
  }
  final val MAX_LEVEL_FIELD_NUMBER = 1
  final val ID_CODE_PART_FIELD_NUMBER = 2
  def of(
    maxLevel: _root_.scala.Int,
    idCodePart: _root_.scala.Seq[_root_.com.google.protobuf.ByteString]
  ): _root_.com.mass.tdm.protobuf.tree.TreeMeta = _root_.com.mass.tdm.protobuf.tree.TreeMeta(
    maxLevel,
    idCodePart
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[com.mass.tdm.protobuf.TreeMeta])
}

// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.mass.tdm.protobuf.store_kv

@SerialVersionUID(0L)
final case class KVItem(
    key: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
    value: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[KVItem] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = key
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(1, __value)
        }
      };
      
      {
        val __value = value
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(2, __value)
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
        val __v = key
        if (!__v.isEmpty) {
          _output__.writeBytes(1, __v)
        }
      };
      {
        val __v = value
        if (!__v.isEmpty) {
          _output__.writeBytes(2, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withKey(__v: _root_.com.google.protobuf.ByteString): KVItem = copy(key = __v)
    def withValue(__v: _root_.com.google.protobuf.ByteString): KVItem = copy(value = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = key
          if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
        }
        case 2 => {
          val __t = value
          if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PByteString(key)
        case 2 => _root_.scalapb.descriptors.PByteString(value)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.mass.tdm.protobuf.store_kv.KVItem
    // @@protoc_insertion_point(GeneratedMessage[com.mass.tdm.protobuf.KVItem])
}

object KVItem extends scalapb.GeneratedMessageCompanion[com.mass.tdm.protobuf.store_kv.KVItem] with scalapb.HasBuilder[com.mass.tdm.protobuf.store_kv.KVItem] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.mass.tdm.protobuf.store_kv.KVItem] with scalapb.HasBuilder[com.mass.tdm.protobuf.store_kv.KVItem] = this
  def merge(`_message__`: com.mass.tdm.protobuf.store_kv.KVItem, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.mass.tdm.protobuf.store_kv.KVItem = newBuilder(_message__).merge(_input__).result()
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.mass.tdm.protobuf.store_kv.KVItem] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.mass.tdm.protobuf.store_kv.KVItem(
        key = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.com.google.protobuf.ByteString]).getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
        value = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.com.google.protobuf.ByteString]).getOrElse(_root_.com.google.protobuf.ByteString.EMPTY)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = StoreKvProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = StoreKvProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.mass.tdm.protobuf.store_kv.KVItem(
    key = _root_.com.google.protobuf.ByteString.EMPTY,
    value = _root_.com.google.protobuf.ByteString.EMPTY
  )
  final class Builder private (
    private var __key: _root_.com.google.protobuf.ByteString,
    private var __value: _root_.com.google.protobuf.ByteString,
    private var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder
  ) extends _root_.scalapb.MessageBuilder[com.mass.tdm.protobuf.store_kv.KVItem] {
    def merge(`_input__`: _root_.com.google.protobuf.CodedInputStream): this.type = {
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __key = _input__.readBytes()
          case 18 =>
            __value = _input__.readBytes()
          case tag =>
            if (_unknownFields__ == null) {
              _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
            }
            _unknownFields__.parseField(tag, _input__)
        }
      }
      this
    }
    def result(): com.mass.tdm.protobuf.store_kv.KVItem = {
      com.mass.tdm.protobuf.store_kv.KVItem(
        key = __key,
        value = __value,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
      )
    }
  }
  object Builder extends _root_.scalapb.MessageBuilderCompanion[com.mass.tdm.protobuf.store_kv.KVItem, com.mass.tdm.protobuf.store_kv.KVItem.Builder] {
    def apply(): Builder = new Builder(
      __key = _root_.com.google.protobuf.ByteString.EMPTY,
      __value = _root_.com.google.protobuf.ByteString.EMPTY,
      `_unknownFields__` = null
    )
    def apply(`_message__`: com.mass.tdm.protobuf.store_kv.KVItem): Builder = new Builder(
        __key = _message__.key,
        __value = _message__.value,
        `_unknownFields__` = new _root_.scalapb.UnknownFieldSet.Builder(_message__.unknownFields)
    )
  }
  def newBuilder: Builder = com.mass.tdm.protobuf.store_kv.KVItem.Builder()
  def newBuilder(`_message__`: com.mass.tdm.protobuf.store_kv.KVItem): Builder = com.mass.tdm.protobuf.store_kv.KVItem.Builder(_message__)
  implicit class KVItemLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.mass.tdm.protobuf.store_kv.KVItem]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.mass.tdm.protobuf.store_kv.KVItem](_l) {
    def key: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] = field(_.key)((c_, f_) => c_.copy(key = f_))
    def value: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] = field(_.value)((c_, f_) => c_.copy(value = f_))
  }
  final val KEY_FIELD_NUMBER = 1
  final val VALUE_FIELD_NUMBER = 2
  def of(
    key: _root_.com.google.protobuf.ByteString,
    value: _root_.com.google.protobuf.ByteString
  ): _root_.com.mass.tdm.protobuf.store_kv.KVItem = _root_.com.mass.tdm.protobuf.store_kv.KVItem(
    key,
    value
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[com.mass.tdm.protobuf.KVItem])
}

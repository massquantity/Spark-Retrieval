// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.mass.dr.protobuf.item_mapping

@SerialVersionUID(0L)
final case class ItemSet(
    items: _root_.scala.Seq[com.mass.dr.protobuf.item_mapping.Item] = _root_.scala.Seq.empty,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[ItemSet] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      items.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
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
      items.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def clearItems = copy(items = _root_.scala.Seq.empty)
    def addItems(__vs: com.mass.dr.protobuf.item_mapping.Item*): ItemSet = addAllItems(__vs)
    def addAllItems(__vs: Iterable[com.mass.dr.protobuf.item_mapping.Item]): ItemSet = copy(items = items ++ __vs)
    def withItems(__v: _root_.scala.Seq[com.mass.dr.protobuf.item_mapping.Item]): ItemSet = copy(items = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => items
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PRepeated(items.iterator.map(_.toPMessage).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.mass.dr.protobuf.item_mapping.ItemSet
    // @@protoc_insertion_point(GeneratedMessage[com.mass.dr.protobuf.ItemSet])
}

object ItemSet extends scalapb.GeneratedMessageCompanion[com.mass.dr.protobuf.item_mapping.ItemSet] with scalapb.HasBuilder[com.mass.dr.protobuf.item_mapping.ItemSet] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.mass.dr.protobuf.item_mapping.ItemSet] with scalapb.HasBuilder[com.mass.dr.protobuf.item_mapping.ItemSet] = this
  def merge(`_message__`: com.mass.dr.protobuf.item_mapping.ItemSet, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.mass.dr.protobuf.item_mapping.ItemSet = newBuilder(_message__).merge(_input__).result()
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.mass.dr.protobuf.item_mapping.ItemSet] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.mass.dr.protobuf.item_mapping.ItemSet(
        items = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Seq[com.mass.dr.protobuf.item_mapping.Item]]).getOrElse(_root_.scala.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = ItemMappingProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = ItemMappingProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = com.mass.dr.protobuf.item_mapping.Item
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.mass.dr.protobuf.item_mapping.ItemSet(
    items = _root_.scala.Seq.empty
  )
  final class Builder private (
    private val __items: _root_.scala.collection.immutable.VectorBuilder[com.mass.dr.protobuf.item_mapping.Item],
    private var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder
  ) extends _root_.scalapb.MessageBuilder[com.mass.dr.protobuf.item_mapping.ItemSet] {
    def merge(`_input__`: _root_.com.google.protobuf.CodedInputStream): this.type = {
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __items += _root_.scalapb.LiteParser.readMessage[com.mass.dr.protobuf.item_mapping.Item](_input__)
          case tag =>
            if (_unknownFields__ == null) {
              _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
            }
            _unknownFields__.parseField(tag, _input__)
        }
      }
      this
    }
    def result(): com.mass.dr.protobuf.item_mapping.ItemSet = {
      com.mass.dr.protobuf.item_mapping.ItemSet(
        items = __items.result(),
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
      )
    }
  }
  object Builder extends _root_.scalapb.MessageBuilderCompanion[com.mass.dr.protobuf.item_mapping.ItemSet, com.mass.dr.protobuf.item_mapping.ItemSet.Builder] {
    def apply(): Builder = new Builder(
      __items = new _root_.scala.collection.immutable.VectorBuilder[com.mass.dr.protobuf.item_mapping.Item],
      `_unknownFields__` = null
    )
    def apply(`_message__`: com.mass.dr.protobuf.item_mapping.ItemSet): Builder = new Builder(
        __items = new _root_.scala.collection.immutable.VectorBuilder[com.mass.dr.protobuf.item_mapping.Item] ++= _message__.items,
        `_unknownFields__` = new _root_.scalapb.UnknownFieldSet.Builder(_message__.unknownFields)
    )
  }
  def newBuilder: Builder = com.mass.dr.protobuf.item_mapping.ItemSet.Builder()
  def newBuilder(`_message__`: com.mass.dr.protobuf.item_mapping.ItemSet): Builder = com.mass.dr.protobuf.item_mapping.ItemSet.Builder(_message__)
  implicit class ItemSetLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.mass.dr.protobuf.item_mapping.ItemSet]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.mass.dr.protobuf.item_mapping.ItemSet](_l) {
    def items: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[com.mass.dr.protobuf.item_mapping.Item]] = field(_.items)((c_, f_) => c_.copy(items = f_))
  }
  final val ITEMS_FIELD_NUMBER = 1
  def of(
    items: _root_.scala.Seq[com.mass.dr.protobuf.item_mapping.Item]
  ): _root_.com.mass.dr.protobuf.item_mapping.ItemSet = _root_.com.mass.dr.protobuf.item_mapping.ItemSet(
    items
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[com.mass.dr.protobuf.ItemSet])
}

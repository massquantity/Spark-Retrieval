// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.mass.dr.protobuf.item_mapping

object ItemMappingProto extends _root_.scalapb.GeneratedFileObject {
  lazy val dependencies: Seq[_root_.scalapb.GeneratedFileObject] = Seq.empty
  lazy val messagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] =
    Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]](
      com.mass.dr.protobuf.item_mapping.ItemSet,
      com.mass.dr.protobuf.item_mapping.Item,
      com.mass.dr.protobuf.item_mapping.Path
    )
  private lazy val ProtoBytes: Array[Byte] =
      scalapb.Encoding.fromBase64(scala.collection.immutable.Seq(
  """ChJpdGVtX21hcHBpbmcucHJvdG8SFGNvbS5tYXNzLmRyLnByb3RvYnVmIkcKB0l0ZW1TZXQSPAoFaXRlbXMYASADKAsyGi5jb
  20ubWFzcy5kci5wcm90b2J1Zi5JdGVtQgriPwcSBWl0ZW1zUgVpdGVtcyJ8CgRJdGVtEh0KBGl0ZW0YASABKAVCCeI/BhIEaXRlb
  VIEaXRlbRIXCgJpZBgCIAEoBUIH4j8EEgJpZFICaWQSPAoFcGF0aHMYAyADKAsyGi5jb20ubWFzcy5kci5wcm90b2J1Zi5QYXRoQ
  griPwcSBXBhdGhzUgVwYXRocyIoCgRQYXRoEiAKBWluZGV4GAEgAygFQgriPwcSBWluZGV4UgVpbmRleGIGcHJvdG8z"""
      ).mkString)
  lazy val scalaDescriptor: _root_.scalapb.descriptors.FileDescriptor = {
    val scalaProto = com.google.protobuf.descriptor.FileDescriptorProto.parseFrom(ProtoBytes)
    _root_.scalapb.descriptors.FileDescriptor.buildFrom(scalaProto, dependencies.map(_.scalaDescriptor))
  }
  lazy val javaDescriptor: com.google.protobuf.Descriptors.FileDescriptor = {
    val javaProto = com.google.protobuf.DescriptorProtos.FileDescriptorProto.parseFrom(ProtoBytes)
    com.google.protobuf.Descriptors.FileDescriptor.buildFrom(javaProto, Array(
    ))
  }
  @deprecated("Use javaDescriptor instead. In a future version this will refer to scalaDescriptor.", "ScalaPB 0.5.47")
  def descriptor: com.google.protobuf.Descriptors.FileDescriptor = javaDescriptor
}
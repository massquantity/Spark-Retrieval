package com.mass.sparkdl.nn.abstractnn

import scala.reflect.{classTag, ClassTag}

import com.mass.sparkdl.tensor.{Tensor, TensorNumeric}
import com.mass.sparkdl.utils.{T, Table}

trait Activity {

  def toTensor[D](implicit ev: TensorNumeric[D]): Tensor[D]

  def toTable: Table

  def isTensor: Boolean

  def isTable: Boolean
}

object Activity {

  def allocate[D <: Activity: ClassTag, T: ClassTag](): D = {
    val buffer = if (classTag[D] == classTag[Table]) {
      T()
    } else if (classTag[D] == classTag[Tensor[_]]) {
       if (classTag[Int] == classTag[T]) {
         import com.mass.sparkdl.tensor.TensorNumeric.NumericInt
         Tensor[Int]()
      } else if (classTag[Long] == classTag[T]) {
         import com.mass.sparkdl.tensor.TensorNumeric.NumericLong
         Tensor[Long]()
      } else if (classTag[Float] == classTag[T]) {
         import com.mass.sparkdl.tensor.TensorNumeric.NumericFloat
         Tensor[Float]()
      } else if (classTag[Double] == classTag[T]) {
         import com.mass.sparkdl.tensor.TensorNumeric.NumericDouble
         Tensor[Double]()
      } else {
        throw new IllegalArgumentException("Type T activity is not supported")
      }
    } else {
      null
    }
    buffer.asInstanceOf[D]
  }
}

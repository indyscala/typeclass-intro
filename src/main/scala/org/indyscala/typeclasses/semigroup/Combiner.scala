package org.indyscala.typeclasses.semigroup

import simulacrum._

// okay to use implicit conversion for `toCombinerOps`
import scala.language.implicitConversions

@typeclass trait Combiner[A] {
  def combine(x: A, y: A): A
  def |+|(x: A, y: A): A = combine(x, y)
}

object DemoAdd extends App {
  import Combiner.ops._

  implicit val intAddCombiner: Combiner[Int] = new Combiner[Int] {
    def combine(x: Int, y: Int): Int = x + y
  }

  println(s"intAddCombiner.combine(1, 2) = ${intAddCombiner.combine(1, 2)}")
  println(s"1 combine 2 = ${1 combine 2}")
  println(s"1 |+| 2 = ${1 |+| 2}")
}

object DemoMultiply extends App {
  import Combiner.ops._

  implicit val intMultCombiner: Combiner[Int] = new Combiner[Int] {
    def combine(x: Int, y: Int): Int = x * y
  }

  println(s"4 |+| 5 = ${4 |+| 5}")
}

object DemoMean extends App {
  import Combiner.ops._

  implicit val intMeanCombiner: Combiner[Double] = new Combiner[Double] {
    def combine(x: Double, y: Double): Double = (x + y) / 2
  }

  println(s"2.0 |+| 3.0 = ${2.0 |+| 3.0}")
}

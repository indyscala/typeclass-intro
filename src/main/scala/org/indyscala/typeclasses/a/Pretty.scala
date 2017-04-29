package org.indyscala.typeclasses.a

trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  val intPrinter: Pretty[Int] = new Pretty[Int] {
    def pp(i: Int): String = s"int $i"
  }
}

object Demo extends App {
  import Pretty._
  println(intPrinter.pp(111))
}

package org.indyscala.typeclasses.a

/*
  Looks more like a type class, but still really naive.
  Calling `intPrinter.pp(111)` is pretty rotten.
*/

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

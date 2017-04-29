package org.indyscala.typeclasses.c

trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  // context bound on `A` and implicitly sugar
  def pp[A: Pretty](a: A) = implicitly[Pretty[A]].pp(a)

  implicit val intPrinter: Pretty[Int] = new Pretty[Int] {
    def pp(i: Int): String = s"int $i"
  }

  implicit val strPrinter: Pretty[String] = new Pretty[String] {
    def pp(s: String): String = s"str $s"
  }
}

object Demo extends App {
  import Pretty._
  println(pp(333))
  println(pp("ccc"))
}

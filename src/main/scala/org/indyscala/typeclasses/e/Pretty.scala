package org.indyscala.typeclasses.e

/*
  Common to support infix notation like `123.pp` or `"abc".pp`.
  Add implicit "Ops" class to the companion object for that.
  (Less efficient version.)
*/

trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  def apply[A](implicit pretty: Pretty[A]): Pretty[A] = pretty

  def pp[A: Pretty](a: A) = Pretty[A].pp(a)

  // add operations, e.g. "Ops", so `.pp` can be called on our instance
  implicit class PrettyOps[A: Pretty](a: A) {
    def pp = Pretty[A].pp(a)
  }

  implicit val intPrinter: Pretty[Int] = new Pretty[Int] {
    def pp(i: Int): String = s"int $i"
  }

  implicit val strPrinter: Pretty[String] = new Pretty[String] {
    def pp(s: String): String = s"str $s"
  }
}

object Demo extends App {
  import Pretty._
  println(555.pp)
  println("eee".pp)
}

package org.indyscala.typeclasses.c

/*
  When there is only one type parameter, we can also use context bounds.

  `A: Pretty` is the context bound.  It's a way to say `Pretty[A]`
  must be available.  `implicitly[Pretty[A]]` provides access to it.

  Only works when there's just a single type parameter.
*/

trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
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

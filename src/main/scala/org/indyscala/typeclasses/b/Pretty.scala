package org.indyscala.typeclasses.b

trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  def pp[A](a: A)(implicit pretty: Pretty[A]) = pretty.pp(a)

  implicit val intPrinter: Pretty[Int] = new Pretty[Int] {
    def pp(i: Int): String = s"int $i"
  }

  implicit val strPrinter: Pretty[String] = new Pretty[String] {
    def pp(s: String): String = s"str $s"
  }
}

object Demo extends App {
  import Pretty._
  println(pp(222))
  println(pp("bbb"))
}

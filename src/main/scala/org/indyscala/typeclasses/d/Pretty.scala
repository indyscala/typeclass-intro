package org.indyscala.typeclasses.d

trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  // with conventional `apply()` instead of `implicitly`
  def apply[A](implicit pretty: Pretty[A]): Pretty[A] = pretty

  def pp[A: Pretty](a: A) = Pretty[A].pp(a)

  implicit val intPrinter: Pretty[Int] = new Pretty[Int] {
    def pp(i: Int): String = s"int $i"
  }

  implicit val strPrinter: Pretty[String] = new Pretty[String] {
    def pp(s: String): String = s"str $s"
  }
}

object Demo extends App {
  import Pretty._
  println(pp(444))
  println(pp("ddd"))
}

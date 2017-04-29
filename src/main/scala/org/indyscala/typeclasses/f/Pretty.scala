package org.indyscala.typeclasses.f

trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  def apply[A](implicit pretty: Pretty[A]): Pretty[A] = pretty

  def pp[A: Pretty](a: A) = Pretty[A].pp(a)

  // more efficient Ops using value class to avoid runtime overhead
  implicit class PrettyOps[A](val a: A) extends AnyVal {
    def pp(implicit pretty: Pretty[A]) = pretty.pp(a)
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
  println(666.pp)
  println("fff".pp)
}

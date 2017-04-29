package org.indyscala.typeclasses.g

trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  def apply[A](implicit pretty: Pretty[A]): Pretty[A] = pretty

  def pp[A: Pretty](a: A) = Pretty[A].pp(a)

  implicit class PrettyOps[A](val a: A) extends AnyVal {
    def pp(implicit pretty: Pretty[A]) = pretty.pp(a)
  }

  // abstract over converting from instance of A to a String

  // in 2.12, we can use Single Abstract Methods:
  implicit val intPrinter: Pretty[Int] = 
    i => s"int $i"

  implicit val strPrinter: Pretty[String] =
    s => s"str $s"

/*
  Before 2.12, we would define `instance` that takes function from A to String:
  def instance[A](func: A => String): Pretty[A] =
    new Pretty[A] {
      def pp(a: A): String = func(a)
    }

  implicit val intPrinter: Pretty[Int] =
    instance(i => s"int $i")

  implicit val strPrinter: Pretty[String] =
    instance(s => s"int $s")
*/
}

object Demo extends App {
  import Pretty._
  println(777.pp)
  println("ggg".pp)

  // and we can add pretty printers for abitrary types...
  case class Person(name: String, age: Int)

  implicit val personPrinter: Pretty[Person] = p => s"${p.name} is ${p.age}"

  println(Person("Brad", 29).pp)
}

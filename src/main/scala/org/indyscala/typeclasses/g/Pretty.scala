package org.indyscala.typeclasses.g

/*
  All our type class instances, Pretty[Int], Pretty[String], etc.,
  take an `A` and return a `String`.  Let's abstract that out too.
*/

trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  def apply[A](implicit pretty: Pretty[A]): Pretty[A] = pretty

  def pp[A: Pretty](a: A) = Pretty[A].pp(a)

  implicit class PrettyOps[A](val a: A) extends AnyVal {
    def pp(implicit pretty: Pretty[A]) = pretty.pp(a)
  }

  // `instance(func)` returns an instance of the type class
  def instance[A](func: A => String): Pretty[A] =
    new Pretty[A] {
      def pp(a: A): String = func(a)
    }

  implicit val intPrinter: Pretty[Int] =
    instance(i => s"int $i")

  implicit val strPrinter: Pretty[String] =
    instance(s => s"int $s")

/*
  In 2.12 and later, there's less boilerplate with Single Abstract
  Methods.  `instance()` is not required and we can create type class
  instances with:

  implicit val intPrinter: Pretty[Int] =
    i => s"int $i"

  implicit val strPrinter: Pretty[String] =
    s => s"str $s"
*/
}

object Demo extends App {
  import Pretty._
  println(777.pp)
  println("ggg".pp)

  // and we can add pretty printers for arbitrary types...
  case class Person(name: String, age: Int)

  implicit val personPrinter: Pretty[Person] = p => s"${p.name} is ${p.age}"

  println(Person("Brad", 29).pp)
}

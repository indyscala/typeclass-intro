package org.indyscala.typeclasses.h

// now with less boilerplate (and more compile-time magic)

import simulacrum._


@typeclass trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  implicit val intPrinter: Pretty[Int] = 
    i => s"int $i"

  implicit val strPrinter: Pretty[String] =
    s => s"str $s"
}

object Demo extends App {
  import Pretty.ops._
  println(888.pp)
  println("hhh".pp)
}

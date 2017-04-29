package org.indyscala.typeclasses.h

// now with less boilerplate (but more compile-time magic)

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
  import Pretty._
  /* no longer able to compile simultaneously
  println(888.pp)
  println("hhh".pp)
  */
}

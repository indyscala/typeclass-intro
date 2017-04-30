package org.indyscala.typeclasses.h

/*
  Type classes require a lot of boilerplate code in Scala.
  Can we avoid it?

  That's what the Simulacrum compiler plugin does.  It uses
  macros to write the boilerplate.
*/

import simulacrum._

// now with less boilerplate...and more compile-time magic
@typeclass trait Pretty[A] {
  def pp(a: A): String
}

object Pretty {
  // Yes, scalac, we want implicit conversion for `toPrettyOps`.
  import scala.language.implicitConversions

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

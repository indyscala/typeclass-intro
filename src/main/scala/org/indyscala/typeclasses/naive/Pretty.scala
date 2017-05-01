package org.indyscala.typeclasses.naive

object Pretty {
  def pp(i: Int): String = s"int $i"
  def pp(s: String): String = s"str $s"
}

object Demo extends App {
  import Pretty._
  println(pp(123))
  println(pp("abc"))
}

/*
  Problems:
   * difficult to extend
   * cumbersome to use
*/

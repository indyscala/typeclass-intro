organization := "org.indyscala.typeclasses"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.2"

homepage := Some(url("https://github.com/indyscala/typeclass-intro"))
licenses := Seq(
  "MIT" -> url("http://opensource.org/licenses/MIT")
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.10.0" % "compile"

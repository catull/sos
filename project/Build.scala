import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtScalariform._

object Build extends Build {

  lazy val sos = Project(
    "sos",
    file("."),
    settings =
      Defaults.defaultSettings ++ 
      scalariformSettings ++
      Seq(
        organization := "name.heikoseeberger",
        version in ThisBuild := "1.0.0",
        scalaVersion := Version.scala,
        scalacOptions ++= Seq(
          "-unchecked",
          "-deprecation",
          "-Xlint",
          "-language:_", 
          "-target:jvm-1.7",
          "-encoding", "UTF-8"
        ),
        libraryDependencies ++= Seq(
          Dependency.Test.scalaTest,
          Dependency.Test.scalaCheck,
          Dependency.Test.scalaMock
        ),
        initialCommands in console := "import name.heikoseeberger.sos._"
      )
  )

  object Version {
    val scala = "2.10.0"
  }

  object Dependency {

    object Compile {
    }

    object Test {
      val scalaTest = "org.scalatest" %% "scalatest" % "2.0.M6-SNAP8" % "test"
      val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
      val scalaMock = "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test"
    }
  }
}

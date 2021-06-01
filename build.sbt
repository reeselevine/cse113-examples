name := "lecture"

version := "0.1"

scalaVersion := "2.13.6"

val AkkaVersion = "2.6.14"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test
)
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime

trapExit := false
val scala3Version = "3.2.0"

///////////////////////////////////////////////////////
lazy val `akka-client` = project
  .in(file("."))
  .settings(
    name := "akka-remote-modules-client",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "com.typesafe.akka" %% "akka-actor" % vAkkaActorClient
    )
  )

val vAkkaActorClient = "2.6.20"
///////////////////////////////////////////////////////

lazy val `serverScala2_12` = project
  .in(file("module-scala2_12"))
  .settings(
    name := "module-scala2_12",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.12.15",

    libraryDependencies ++= Seq(
//      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "com.typesafe.akka" %% "akka-actor" % vAkkaActorModuleScala2_12,
      "com.typesafe.akka" %% "akka-remote" % vAkkaActorModuleScala2_12
    )
  )

val vAkkaActorModuleScala2_12 = "2.6.18"

///////////////////////////////////////////////////////

///////////////////////////////////////////////////////

lazy val `serverScala2_11` = project
  .in(file("module-scala2_11"))
  .settings(
    name := "module-scala2_11",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.11.12",

    libraryDependencies ++= Seq(
//      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "com.typesafe.akka" %% "akka-actor" % vAkkaActorModuleScala2_11,
      "com.typesafe.akka" %% "akka-remote" % vAkkaActorModuleScala2_11
    )
  )

val vAkkaActorModuleScala2_11 = "2.5.23"

///////////////////////////////////////////////////////



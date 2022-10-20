val scala3Version = "3.2.0"

///////////////////////////////////////////////////////
lazy val `akka-client` = project
  .in(file("."))
  .enablePlugins(JavaAppPackaging)
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
  .enablePlugins(JavaAppPackaging)
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
  .enablePlugins(JavaAppPackaging)
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

lazy val stageAll = taskKey[Unit]("Stage all projects")

val projects_stage = ScopeFilter(inProjects(
  `akka-client`,`serverScala2_11`,`serverScala2_12`), inConfigurations(Universal))

stageAll := {
  stage.all(projects_stage).value
}



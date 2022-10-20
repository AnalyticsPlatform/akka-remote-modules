import com.typesafe.config._
import akka.actor._

@main def hello: Unit =
  val config = ConfigFactory.load()
  val system = ActorSystem("client-akka", config)
  val pathScala2_11 = "akka.tcp://backendScalaTwoEleven@127.0.0.1:25510/user/simple-scala-2-11"
  val pathScala2_12 = "akka.tcp://backendScalaTwotwelf@127.0.0.1:25520/user/simple-scala-2-12"
  val simple2_11 = system.actorSelection(pathScala2_11)
  val simple2_12 = system.actorSelection(pathScala2_12)
  simple2_11 ! "Hello scala 2.11"
  simple2_12 ! "Hello scala 2.12"
  simple2_11 ! List("hello", "scala", "2.11")
  simple2_12 ! List("hello", "scala", "2.12")
  simple2_11 ! shared.Shutdown()
  simple2_12 ! shared.Shutdown()
  //TO-DO Add shutdown command



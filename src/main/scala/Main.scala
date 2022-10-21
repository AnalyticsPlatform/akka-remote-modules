import TestMsgs.{AkkaMsgTest1, AkkaMsgTestActorRef}
import com.typesafe.config.*
import akka.actor.*

object ClientApp{

  val config = ConfigFactory.load()
  val system: ActorSystem = ActorSystem("client-akka", config)
  def main(args: Array[String]): Unit =

    val pathScala2_11 = "akka.tcp://backendScalaTwoEleven@0.0.0.0:25510/user/simple-scala-2-11"
    val pathScala2_12 = "akka.tcp://backendScalaTwotwelf@0.0.0.0:25520/user/simple-scala-2-12"
    val pathScala3 = "akka.tcp://backendScalaThree@0.0.0.0:25523/user/simpleScalaThree"
    val simple2_11 = system.actorSelection(pathScala2_11)
    val simple2_12 = system.actorSelection(pathScala2_12)
    val simple3 = system.actorSelection(pathScala3)
    simple2_11 ! "Hello scala 2.11"
    simple2_12 ! "Hello scala 2.12"
    simple3 ! "Hello scala 3"
    simple2_11 ! AkkaMsgTest1("hello", "scala", "2.11")
    simple2_12 ! AkkaMsgTest1("hello", "scala", "2.12")
    simple3 ! AkkaMsgTest1("hello", "scala", "3")
    simple2_11 ! shared.Shutdown()
    simple2_12 ! shared.Shutdown()
    simple3 ! shared.Shutdown()
//    simple2_11 ! AkkaMsgTestActorRef("test", "actorref", "on scala 2.11")
}



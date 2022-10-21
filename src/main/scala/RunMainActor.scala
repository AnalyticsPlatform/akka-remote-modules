import TestMsgs.{AkkaMsgTest1, AkkaMsgTestActorRef}
import akka.actor.{Actor, ActorSelection, ActorSystem, Props}

import scala.sys.exit

object RunMainActor:
  def props(): Props = Props(new RunMainActor())
  case class StartWork()
  case class StartTest1()
  case class StartTest2()
  case class WorkDone()

class RunMainActor() extends Actor:
  import RunMainActor._
  override def preStart(): Unit =
//    self ! StartWork()
    super.preStart()

  var simple2_11: ActorSelection = null
  var simple2_12: ActorSelection = null
  var simple3: ActorSelection = null

  override def receive: Receive = {
    case StartWork() =>
      val pathScala2_11 = "akka.tcp://backendScalaTwoEleven@0.0.0.0:25510/user/simple-scala-2-11"
      val pathScala2_12 = "akka.tcp://backendScalaTwotwelf@0.0.0.0:25520/user/simple-scala-2-12"
      val pathScala3 = "akka.tcp://backendScalaThree@0.0.0.0:25523/user/simpleScalaThree"
      simple2_11 = context.system.actorSelection(pathScala2_11)
      simple2_12 = context.system.actorSelection(pathScala2_12)
      simple3 = context.system.actorSelection(pathScala3)
      self ! StartTest1()
    case StartTest1() =>
      println(s"Started Test1: ")
      simple2_11 ! "Hello scala 2.11"
      simple2_12 ! "Hello scala 2.12"
      simple3 ! "Hello scala 3"
      simple2_11 ! AkkaMsgTest1("hello", "scala", "2.11")
      simple2_12 ! AkkaMsgTest1("hello", "scala", "2.12")
      simple3 ! AkkaMsgTest1("hello", "scala", "3")
      self ! StartTest2()
    case  StartTest2() =>
      println(s"Started Test2 Where we wait for response: ")
      simple2_11 ! AkkaMsgTestActorRef("test", "actorref", "on scala 2.11", Some(self))
    case AkkaMsgTest1(msg, msg1, msg3) =>
      println(s"Received msg from scala 2.11 module: Response:  $msg $msg1 $msg3")
      println("Sending shutdown commands to modules and shutdown yourself")
      simple2_11 ! shared.Shutdown()
      simple2_12 ! shared.Shutdown()
      simple3 ! shared.Shutdown()
      self ! WorkDone()
    case WorkDone() =>
      shutdownAkkaSystem(context.system)
  }

  def shutdownAkkaSystem(system: ActorSystem, isFailed: Boolean = false) = {
    implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
    system.terminate().map(
      _ => {
        println(s"Successfully terminated ${system.name} actor system")
        if (isFailed) exit(1)
      }
    )
  }

import RunMainActor.StartWork
import TestMsgs.{AkkaMsgTest1, AkkaMsgTestActorRef}
import com.typesafe.config.*
import akka.actor.*

import scala.sys.exit

object ClientApp{
  val config = ConfigFactory.load()
  val system: ActorSystem = ActorSystem("client-akka", config)
  def main(args: Array[String]): Unit =
    system.actorOf(RunMainActor.props(), "RunMainActor") ! StartWork()
}




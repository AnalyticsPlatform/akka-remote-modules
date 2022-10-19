import akka.actor._

object SimpleActorScalaTwoEleven{
  def apply(): Props = Props(new SimpleActorScalaTwoEleven())
}

class SimpleActorScalaTwoEleven extends Actor {
  override def receive: Receive = {
    case msg: Any => println(s"[${self.path.toString}] received msg: " + msg.toString)
  }
}

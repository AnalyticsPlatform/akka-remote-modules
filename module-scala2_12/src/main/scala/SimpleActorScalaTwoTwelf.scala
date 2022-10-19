import akka.actor._

object SimpleActorScalaTwoTwelf{
  def apply(): Props = Props(new SimpleActorScalaTwoTwelf())
}

class SimpleActorScalaTwoTwelf extends Actor {
  override def receive: Receive = {
    case msg: Any => println(s"[${self.path.toString}] received msg: " + msg.toString)
  }
}

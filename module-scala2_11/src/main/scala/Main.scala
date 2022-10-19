import com.typesafe.config._
import akka.actor._
object ModuleScala2_11Run {
  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()
    val backend = ActorSystem("backendScalaTwoEleven", config)
    backend.actorOf(SimpleActorScalaTwoEleven.apply(), "simple-scala-2-11")
  }
}

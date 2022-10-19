import com.typesafe.config._
import akka.actor._
object ModuleScala2_12Run {
  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()
    val backend = ActorSystem("backendScalaTwotwelf", config)
    backend.actorOf(SimpleActorScalaTwoTwelf.apply(), "simple-scala-2-12")
  }
}

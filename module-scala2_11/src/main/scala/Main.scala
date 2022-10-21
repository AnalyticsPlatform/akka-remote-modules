import com.typesafe.config._
import akka.actor._

object ModuleScala2_11Run {

  val config = ConfigFactory.load()
  val backend = ActorSystem("backendScalaTwoEleven", config)

  def main(args: Array[String]): Unit = {
    println("Starting akka module scala 2_11")

    val ref = backend.actorOf(SimpleActorScalaTwoEleven.apply(), "simple-scala-2-11")
    println("Path of simple actor: " + ref.path.toString)
    println(s"Successfully started akka ${backend.name} module scala 2_11")
  }
}

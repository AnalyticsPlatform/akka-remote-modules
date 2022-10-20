import com.typesafe.config._
import akka.actor._
object ModuleScala2_12Run {
  def main(args: Array[String]): Unit = {
    println("Starting akka module scala 2_12")
    val config = ConfigFactory.load()
    val backend = ActorSystem("backendScalaTwotwelf", config)
    val ref = backend.actorOf(SimpleActorScalaTwoTwelf.apply(), "simple-scala-2-12")
    println("Path of simple actor: " + ref.path.toString)
    println(s"Successfully started akkasystem ${backend.name} module scala 2_12")
  }
}

import com.typesafe.config._
import akka.actor._
object ModuleScalaThree {
  val config = ConfigFactory.load()
  val backend = ActorSystem("backendScalaThree", config)
  def main(args: Array[String]): Unit = {
    println("Starting akka module scala 3")
    
    val ref = backend.actorOf(SimpleActorScalaThree.apply(), "simpleScalaThree")
    println("Path of simple actor: " + ref.path.toString)
    println(s"Successfully started akkasystem ${backend.name} module scala 3")
  }
}

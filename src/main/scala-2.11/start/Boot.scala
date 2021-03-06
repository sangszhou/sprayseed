package start

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import com.typesafe.config.ConfigFactory
import kamon.Kamon
import route.ServiceActor
import spray.can.Http

import scala.concurrent.duration._

/**
  * Created by xinszhou on 3/30/16.
  */
object Boot {

  implicit val timeout = new Timeout(10 second)

  val config = ConfigFactory.load()

  implicit val system = ActorSystem("sprayseed", config)

  val service = system.actorOf(Props[ServiceActor], "service")

  def main(args: Array[String]): Unit = {

//    Kamon.start()

    IO(Http) ? Http.Bind(service, interface = "localhost", port = config.getString("server.port").toInt)

  }

}

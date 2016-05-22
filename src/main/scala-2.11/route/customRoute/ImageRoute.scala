package route.customRoute

import java.io.File
import java.nio.file.Files

import org.slf4j.LoggerFactory
import route.RootRoute
import spray.client.pipelining.SendReceive
import spray.http.HttpData
import spray.routing.{RequestContext, Route}
import spray.httpx.RequestBuilding.Get
import util.{Dispatchers, NetUtil}

import scala.util.{Failure, Success}

/**
  * Created by xinszhou on 5/21/16.
  */
trait ImageRoute extends RootRoute {

  val Imagelog = LoggerFactory.getLogger(getClass)

  implicit val dispatcher = Dispatchers.netdispatcher

  def imageRoute: Route = (get & parameters("type", "zoom" ?)) {
    fetchImage
  }

  def httpRequest: SendReceive = {
    spray.client.pipelining.sendReceive
  }

  def fetchImage(typ: String, zoom: Option[String])(requestContext: RequestContext) = {
    val validHttpImage = "http://a4cwsn.com/wp-content/uploads/2012/04/Fun-with-Directions-512-icon.png"
    val invalidHttpImage = "http://a4cw3sn.com/wp-content/uploads/2012/04/Fun-with-Directions-512-icon.png"


    //cannot handle https image
    httpRequest {
      Get(validHttpImage)
    } onComplete {
      case Success(res) => requestContext.complete(res)
      case Failure(exp) =>
        Imagelog.error("failed to download image, use default one")

        val defaultImageFilePath = System.getProperty("user.dir") + s"/config/resource/fun.png"
        val file = new File(defaultImageFilePath)
        val data = Files.readAllBytes(file.toPath)
        requestContext.complete(HttpData(data))
    }
  }
}

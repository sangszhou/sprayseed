package route.customRoute

import java.io.File
import java.nio.file.Files

import route.RootRoute
import spray.client.pipelining.SendReceive
import spray.http.HttpData
import spray.routing.{RequestContext, Route}
import spray.httpx.RequestBuilding.Get

import scala.util.{Failure, Success}

/**
  * Created by xinszhou on 5/21/16.
  */
trait ImageRoute extends RootRoute {

  def imageRoute: Route = (get & path("/image") & parameters("user", "age" ?)) {
    fetchImage
  }

  def httpRequest: SendReceive = {
    spray.client.pipelining.sendReceive
  }

  def fetchImage(userId: String, age: Option[String])(requestContext: RequestContext) = {

    httpRequest {
      Get("default url")
    } onComplete {
      case Success(res) => requestContext.complete(res)
      case Failure(exp) =>
        val defaultImageFilePath = System.getProperty("user.dir") + s"/config/resource/box"
        val file = new File(defaultImageFilePath)
        val data = Files.readAllBytes(file.toPath)
        requestContext.complete(HttpData(data))
    }
  }
}

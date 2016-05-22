package route.customRoute

import akka.actor.{Actor, ActorRefFactory}
import com.gettyimages.spray.swagger.SwaggerHttpService
import com.sun.tools.javac.code.TypeTag
import route.RootRoute
import spray.http.MediaTypes._
import spray.http.StatusCodes

import scala.reflect.runtime.universe._


/**
  * Created by xinszhou on 5/22/16.
  */
trait SwaggerRoute extends RootRoute with Actor {

  val swaggerHttpService: SwaggerHttpService = new SwaggerHttpService {

    override def apiTypes = Seq(typeOf[StdRoute], typeOf[ImageRoute])

    override def apiVersion: String = "1.0"

    override def baseUrl: String = "/"

    override def docsPath = "docs-raw"

    override implicit def actorRefFactory: ActorRefFactory = context
  }

  override def routes =
    super.routes ~
      pathPrefix("docs") {
        pathSingleSlash {
          getFromResource("swagger/index.html")
        } ~
          getFromResourceDirectory("swagger")
      } ~ path("docs") {
      redirect("docs/", StatusCodes.PermanentRedirect)
    } ~ swaggerHttpService.routes


}

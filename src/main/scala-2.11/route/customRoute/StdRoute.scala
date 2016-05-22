package route.customRoute

import route.RootRoute
import spray.http.MediaTypes._
import spray.routing.Route

/**
  * Created by xinszhou on 5/21/16.
  */
trait StdRoute extends RootRoute {

  override def routes = super.routes ~ pathPrefix("std") {
    getRoute ~ postRoute
  }

  def getRoute: Route = (path("get") & get) {
    respondWithMediaType(`text/html`) {
      complete {
        "stardard route"
      }
    }
  }

  def postRoute: Route = (post & path("post") & entity(as[String]) & headerValueByName("user")) {
    postRouteImpl
  }

  def postRouteImpl(entity: String, userId: String): Route = {
    val result = entity + userId
    complete {
      result
    }
  }


}

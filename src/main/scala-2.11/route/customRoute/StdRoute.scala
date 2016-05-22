package route.customRoute

import com.wordnik.swagger.annotations._
import route.RootRoute
import spray.http.MediaTypes._
import spray.routing.Route

/**
  * Created by xinszhou on 5/21/16.
  */
@Api(value = "/std", description = "Operations about pets")
trait StdRoute extends RootRoute {

  override def routes = super.routes ~ pathPrefix("std") {
    getRoute ~ postRoute
  }


  @ApiOperation(
    value = "example route, get method without parameter",
    httpMethod = "GET"
  )
  @ApiResponses(Array(
    new ApiResponse (code= 400, message = "Resource not found")
  ))
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

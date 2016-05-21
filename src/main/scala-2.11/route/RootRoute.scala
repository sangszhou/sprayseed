package route

import akka.util.Timeout
import kamon.spray.KamonTraceDirectives
import spray.routing.{HttpService, Route}
import spray.http.StatusCodes._
import spray.http._
import MediaTypes._
import util.{AllEncodedGzip, Dispatchers}

import scala.concurrent.Future
import spray.routing._

import scala.concurrent.duration._
import scala.util.Failure
import kamon.spray.KamonTraceDirectives._
import route.customRoute.ImageRoute
/**
 * Created by xinszhou on 3/30/16.
 */
trait RootRoute extends HttpService {

  val timeout: Timeout = (10 second)

  def routes: Route =
    path("") {
      traceName("welcome") {
        dynamic {
          respondWithMediaType(`text/html`) {
            complete {
              <h1>It works.</h1>
            }
          }
        }
      }
    } ~ path("cal") {
      dynamic {
        respondWithMediaType(`text/html`) {
          complete {

            Future {
              Thread.sleep(5000)
              "future response"
            }(Dispatchers.netdispatcher)

            <h1>cal.</h1>
          }
        }
      }
    }


  def divide(a: Int, b: Int): Future[Int] = Future {
    a / b
  }(Dispatchers.netdispatcher)

}

trait ServiceRoute extends RootRoute
  with ImageRoute {
  override def routes = {
    path("image") {
      (compressResponse(AllEncodedGzip) & respondWithMediaType(`image/jpeg`)) {
        imageRoute
      }

    } ~ (compressResponse(AllEncodedGzip) & respondWithMediaType(`application/json`)) {
      super.routes
    }
  }
}

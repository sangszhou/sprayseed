package route.security

import org.slf4j.LoggerFactory
import spray.http.HttpRequest
import spray.routing.{Directive0, RequestContext}
import spray.routing.Directives._

/**
  * Created by xinszhou on 3/30/16.
  */

object UtilDirectives {

  val log = LoggerFactory.getLogger(getClass)

  def logRequestInfo: Directive0 =
    mapRequest { request =>

      log.info("log request info")

      request
    }

  def authorizeApiPattern: Directive0 =
    mapRequest { request: HttpRequest =>
      val uri = request.uri

      request
    }

}

package route

import spray.routing.{ExceptionHandler, RejectionHandler, RoutingSettings}
import akka.actor.{Actor, ActorLogging, ActorRefFactory}
import spray.util.LoggingContext

/**
  * Created by xinszhou on 3/30/16.
  */
class ServiceActor extends Actor with IndexRoute with ActorLogging {

  def actorRefFactory: ActorRefFactory = context

  def receive = runRoute(routes)

}

package actor

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorLogging, ReceiveTimeout}

import scala.concurrent.duration._
/**
  * Created by xinszhou on 4/5/16.
  */
class TimeoutActor extends Actor with ActorLogging {

  log.info("time out actor created")

  context.setReceiveTimeout(10 second)

  override def receive: Receive = {
    case ReceiveTimeout =>
      context.stop(self)

    case "" =>
  }

  override def postStop = {
    log.info("timeout actor killed self")
    super.postStop
  }

}

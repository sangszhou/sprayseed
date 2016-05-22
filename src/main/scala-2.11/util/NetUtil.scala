package util

import akka.actor.{ActorSystem, Address, ExtendedActorSystem}

/**
  * Created by xinszhou on 5/21/16.
  */
object NetUtil {

  def actorSystemAddress(system: ActorSystem): Address = {
    system.asInstanceOf[ExtendedActorSystem].provider.getDefaultAddress
  }

}

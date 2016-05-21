package util

import start.Boot

/**
 * Created by xinszhou on 4/26/16.
 */
object Dispatchers {

  def findByName(name: String) = Boot.system.dispatchers.lookup(name)

  lazy val netdispatcher = findByName("net-dispatcher")

  lazy val esDispatcher = findByName("es-dispatcher")

}

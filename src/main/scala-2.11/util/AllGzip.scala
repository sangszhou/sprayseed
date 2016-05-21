package util

import spray.http.MessagePredicate
import spray.http.MessagePredicate._
import spray.httpx.encoding.Gzip

/**
  * Created by xinszhou on 5/21/16.
  */
object AllGzip {
  import MessagePredicate._
  val DefaultFilter = isCompressible
}

object AllEncodedGzip extends Gzip(AllGzip.DefaultFilter) {
  def apply(messageFilter: MessagePredicate) = new Gzip(messageFilter)
}
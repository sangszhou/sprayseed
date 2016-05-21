package service.authorization

/**
  * Created by xinszhou on 3/31/16.
  */
trait UserDetailsService {
  def loaduserByName(name: String): Option[UserDetails]
}

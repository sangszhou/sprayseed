/**
  * Created by xinszhou on 5/21/16.
  */
object Pattern extends App {


  Invoker.invoke(println("foo"))

  Invoker.invoke {
    println("bar 1")
    println("bar 2")
  }

}

object Invoker {
  private var history: Seq[() => Unit] = Seq.empty

  def invoke(command: => Unit) { // by-name parameter
    command
    history :+= command _
  }
}

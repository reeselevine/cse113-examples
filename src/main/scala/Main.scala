import akka.actor.ActorSystem

object Main {

  implicit val system = ActorSystem()

  def main(args: Array[String]):Unit = {
    args.headOption match {
      case Some(op) => op match {
        case "basic" =>
          Examples.basicFuture()
          Thread.sleep(500)
        case "blocking" =>
          RLP.blocking(args(1).toInt)
        case "non-blocking" =>
          RLP.nonBlocking(args(1).toInt)
      }
      case None => println("No argument passed!")
    }
    Service.terminate()
    sys.exit(0)
  }
}

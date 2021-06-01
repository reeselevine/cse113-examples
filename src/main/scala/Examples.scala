import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Examples {

  def basicFuture(): Unit = {
    Future {
      println("I'm finished!")
    }
    Future {
      println("So am I")
    }
  }
}

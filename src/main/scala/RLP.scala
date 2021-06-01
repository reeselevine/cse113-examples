import akka.actor.ActorSystem

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}

object RLP {

  def blocking(numFutures: Int): Unit = withTiming(numFutures) {
    (0 until numFutures).map { _ =>
      Service.blockingCall()
    }
  }

  def nonBlocking(numFutures: Int): Unit = withTiming(numFutures) {
    (0 until numFutures).map { _ =>
      Service.nonBlockingCall()
    }
  }

  def withTiming(numFutures: Int)(doServiceCalls: => Seq[Future[Unit]]): Unit = {
    val startTime = System.currentTimeMillis()
    Await.result(Future.sequence(doServiceCalls), Duration.Inf)
    val timeTaken = System.currentTimeMillis() - startTime
    println(s"Time taken to do $numFutures operations: $timeTaken ms")
  }

}

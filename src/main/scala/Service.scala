import akka.actor.ActorSystem

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, DurationInt}

object Service {

  val callDurationMs = 1000

  val system = ActorSystem()

  def blockingCall(): Future[Unit] = {
    Future {
      Thread.sleep(callDurationMs)
    }
  }

  def nonBlockingCall(): Future[Unit] = {
    val promise = Promise[Unit]()
    system.scheduler.scheduleOnce(callDurationMs.millis)(promise.success({}))
    promise.future
  }

  def terminate(): Unit = Await.result(system.terminate(), Duration.Inf)
}

import scala.concurrent.duration.{DurationInt, FiniteDuration}

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
  }
}

object ControlledStream {

  def apply[F[_] : Async : StructuredLogger, A](
                                                 stream: fs2.Stream[F, A],
                                                 eval: Chunk[A] => F[Unit],
                                                 pause: SignallingRef[F, Boolean],
                                                 maxRate: FiniteDuration = 10.seconds,
                                                 batchSize: Int 30
  )
}
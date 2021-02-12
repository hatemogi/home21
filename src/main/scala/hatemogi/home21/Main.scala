package hatemogi.home21

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    Home21Server.stream[IO].compile.drain.as(ExitCode.Success)
}

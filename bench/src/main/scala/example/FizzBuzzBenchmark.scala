package example

import org.openjdk.jmh.annotations._

class FizzBuzzBenchmark {
  
  @Benchmark
  def run(): Unit = new FizzBuzz().run { _ =>
    () // ignore value instead of e.g. printing
  }
}

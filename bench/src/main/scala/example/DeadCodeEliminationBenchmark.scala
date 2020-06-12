package example

import org.openjdk.jmh.annotations._

class DeadCodeEliminationBenchmark {
  
  @Benchmark
  def testNoop() = new DeadCodeElimination().noopMe()
}

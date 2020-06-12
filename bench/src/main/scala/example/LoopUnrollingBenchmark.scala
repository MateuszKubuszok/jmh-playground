package example

import org.openjdk.jmh.annotations._

class LoopUnrollingBenchmark {
  
  @Benchmark
  def testUnrolling() = new LoopUnrolling().unrollMe()
}

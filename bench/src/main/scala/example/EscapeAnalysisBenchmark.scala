package example

import org.openjdk.jmh.annotations._

class EscapeAnalysisBenchmark {
  
  @Benchmark
  def removeAllocation() = new EscapeAnalysis().print2(
    scala.util.Random.nextString(5),
    scala.util.Random.nextString(5),
    scala.util.Random.nextString(5),
    scala.util.Random.nextString(5)
  )
}

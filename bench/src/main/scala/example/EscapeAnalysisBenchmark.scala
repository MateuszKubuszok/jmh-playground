package example

import org.openjdk.jmh.annotations._
import scala.util.Random

object EscapeAnalysisBenchmark {

  @State(Scope.Thread)
  class Seed {
    var name1: String = ""
    var surname1: String = ""
    var name2: String = ""
    var surname2: String = ""

    @Setup(Level.Iteration)
    def setup(): Unit = {
      name1 = Random.nextString(5)
      surname1 = Random.nextString(5)
      name2 = Random.nextString(5)
      surname2 = Random.nextString(5)
    }
  }
}

class EscapeAnalysisBenchmark {

  import EscapeAnalysisBenchmark._
  
  @Benchmark
  def removeAllocation(seed: Seed) = new EscapeAnalysis().print2(
    seed.name1,
    seed.surname1,
    seed.name2,
    seed.surname2
  )
}

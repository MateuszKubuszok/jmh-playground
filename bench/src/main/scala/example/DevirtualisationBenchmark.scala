package example

import org.openjdk.jmh.annotations._
import scala.util.Random

object DevirtualisationBenchmark {

  trait DevirtualisationState {

    var valueProvider: ValueProvider = ValueProvider.Empty

    def newRandomValueProvider(maxValue: Int): Unit = Random.nextInt(maxValue + 1) match {
      case 0 => valueProvider = ValueProvider.Empty
      case 1 => valueProvider = ValueProvider.Unit
      case i => valueProvider = ValueProvider.Positive(i)
    }
  }

  @State(Scope.Thread)
  class MonoState extends DevirtualisationState {
    @Setup(Level.Iteration) def setup() = newRandomValueProvider(0)
  }

  @State(Scope.Thread)
  class BiState extends DevirtualisationState {
    @Setup(Level.Iteration) def setup() = newRandomValueProvider(1)
  }

  @State(Scope.Thread)
  class MegaState extends DevirtualisationState {
    @Setup(Level.Iteration) def setup() = newRandomValueProvider(2)
  }
}

class DevirtualisationBenchmark {

  import DevirtualisationBenchmark._
  
  @Benchmark
  def shouldBeMono(state: MonoState) = state.valueProvider.value

  @Benchmark
  def shouldBeBi(state: BiState) = state.valueProvider.value

  @Benchmark
  def shouldBeMega(state: MegaState) = state.valueProvider.value
}

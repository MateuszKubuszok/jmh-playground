package example

import org.openjdk.jmh.annotations._
import scala.util.Random

object BranchPredictionBenchmark {

  @State(Scope.Benchmark)
  class ArrayToTraverse {

    val unsorted = new Array[Int](1000)
    (0 until unsorted.length).foreach { i =>
      unsorted(i) = Random.nextInt(1000)
    }
    val sorted = unsorted.sorted
  }
}

class BranchPredictionBenchmark {

  import BranchPredictionBenchmark._
  
  @Benchmark
  def traverseUnsorted(toTraverse: ArrayToTraverse) = traverse(toTraverse.unsorted)

  @Benchmark
  def traverseSorted(toTraverse: ArrayToTraverse) = traverse(toTraverse.sorted)

  private def traverse(arr: Array[Int]): Int = {
    var result = 0
    var i = 0
    while (i < arr.length) {
      if (arr(i) >= 500) result += 1
      else result -= 1
      i += 1
    }
    result
  }
}

package example

import org.openjdk.jmh.annotations._

class InliningBenchmark {
  
  @Benchmark
  def forManuallyInlined = new Inlining().manuallyInlined()

  @Benchmark
  def forJVMInlined = new Inlining().jvmInlined()
}

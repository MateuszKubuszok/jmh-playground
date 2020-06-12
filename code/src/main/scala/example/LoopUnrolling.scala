package example

class LoopUnrolling {
  
  def unrollMe(): Array[Int] = {
    val result = new Array[Int](100)
    var i = 0
    while (i < result.length) {
      result(i) = 1
      i += 1
    }
    result
  }  
}

package example

class DeadCodeElimination {
  
  def noopMe(): Unit = {
    val compared = 1 + 2
    def isNull(any: Any): Boolean = any == null
    def isNegative(value: Int): Boolean = value < 0
    if (isNull(this) || isNegative(compared)) {
      println("The end is nigh!")
    }
  }
}

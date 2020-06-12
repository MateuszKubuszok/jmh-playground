package example

class Inlining {
  
  def manuallyInlined(): Int = {
    var i = 0
    var result = 0
    while (i < 100) {
      if (i % 2 == 0) result += i
      else result -= i
      i += 2
    }
    result
  }

  def jvmInlined(): Int = {
    var result = 0

    def isEven(j: Int): Boolean = j % 2 == 0
    def notFinished(j: Int): Boolean = j < 100
    def updateResult(j: Int): Unit =
      if (isEven(j)) result += j
      else result -= j
    
    locally {
      var i = 0
      while (notFinished(i)) {
        updateResult(i)
        i += 2
      }
    }

    result
  }
}

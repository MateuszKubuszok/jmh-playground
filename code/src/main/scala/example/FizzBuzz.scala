package example

class FizzBuzz {

  def run(f: String => Unit = println(_)): Unit = Stream.from(1)
    .take(1000000)
    .map { i =>
      (i % 3 == 0, i % 5 == 0) match {
        case (true, true) => "FizzBuzz"
        case (true, _)    => "Fizz"
        case (_, true)    => "Buzz"
        case _            => i.toString
      }
    }
    .foreach(f)
}

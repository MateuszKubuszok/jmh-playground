package example

sealed trait ValueProvider {
  def value: Int
}
object ValueProvider {
  case object Empty extends ValueProvider { val value = 0 }
  case object Unit extends ValueProvider { val value = 1 }
  case class Positive(val value: Int) extends ValueProvider
}

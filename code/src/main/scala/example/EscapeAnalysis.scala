package example

class User(name: String, surname: String) {
  def printableName: String = s"$name $surname"
}

class EscapeAnalysis {
  
  def print2(name1: String, surname1: String,
             name2: String, surname2: String): String = {
    new User(name1, surname1).printableName + "\n" +
    new User(name2, surname2).printableName
  }
}

package lectures.part1basics

object StringOperations extends App {

  val str: String = "Hello, I'm learning Scala! :P"

  // Java methods
  println(str.charAt(2))
  println(str(4))
  println(str.substring(7, 10))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "42";
  val convertedToIntString = aNumberString.toInt
  println('a' +: aNumberString :+ 'b')
  println(str.reverse)
  println(str.take(2)) // take two chars from the beginning of the string


  // Scala-specific methods

}

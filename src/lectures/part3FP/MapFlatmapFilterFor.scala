package lectures.part3FP

object MapFlatmapFilterFor extends App {
  val list = List(1, 2, 3, 4, 5)
  println(list ++ List(5, 6))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  numbers.zip(chars)
}

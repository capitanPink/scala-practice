package lectures.part2oop

object MethodNotations extends App {

  val mary = new Person("Mary")
  val maryTheRockstar = mary + "The rockstar"
  println(maryTheRockstar.name)

  val olderMary = +mary
  println(olderMary.age)

  println(mary learnsScala)
  println(mary(4))
}

class Person(val name: String, favoriteMovie: String = "Inception", val age: Int = 0) {

  def +(nick: String): Person = new Person(s"$name ($nick)")
  def unary_+ : Person = new Person(name, age = age + 1)
  def learns(something: String): String = s"$name learns $something"
  def learnsScala: String = learns("Scala")

  def apply(i: Int): String = s"Mary has watched her favorite movie $favoriteMovie $i times"
}
package lectures.part2oop

object AnonymousClasses extends App {

  trait Animal {
    def eat: Unit
  }

  val cat = new Animal {
    override def eat: Unit = println("I'm pretty cat!!!")
  }

  println(cat.eat)
}

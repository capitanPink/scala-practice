package lectures.part3FP

object AnonymousFunctions extends App {

  val specialFunc = new Function1[Int, Int => Int] {
    override def apply(v1: Int): Int => Int =
      new Function1[Int, Int] {
        override def apply(v2: Int): Int = v2 + v1
      }
  }

  val newSpecialFunc: Int => Int => Int = v1 => v2 => v1 + v2
  println(newSpecialFunc(4)(5))
}

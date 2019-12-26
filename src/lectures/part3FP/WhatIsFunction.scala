package lectures.part3FP

object WhatIsFunction extends App {

  val concatenate = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatenate("hello, ", "world"))

  val specialFunc = new Function1[Int, Int => Int] {
    override def apply(v1: Int): Int => Int =
      new Function1[Int, Int] {
        override def apply(v2: Int): Int = v2 + v1
      }
  }

  println(specialFunc(5)(10))
}

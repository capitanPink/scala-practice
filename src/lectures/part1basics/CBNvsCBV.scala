package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println(s"By value: $x")
    println(s"By value: $x")
  }

  def calledByName(x: => Long): Unit = {
    println(s"By name: $x")
    println(s"By name: $x")
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())
}

package lectures.part3FP

object HOFSandCurries extends App {

  val nTimes: (Int => Int, Int, Int) => Int = (f, n, x) => if (n > 0) nTimes(f, n - 1, f(x)) else x

  println(nTimes(_ * 2, 3, 2))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n > 0) x => nTimesBetter(f, n - 1)(f(x)) else x => x

  println(nTimesBetter(_ + 1 , 10)(1))

  // HOfs
  // toCarry
  // fromCarry
  // compose
  // andThen
  def toCarry(f: (Int, Int) => Int): Int => Int => Int = x => y => f(x, y)
  def fromCarry(f: (Int => Int => Int)): (Int, Int) => Int = (x, y) => f(x)(y)
  def compose[A, B, T](f: A => B, g: T => A): T => B = x => f(g(x))
  def andThen[A, B, T](f: A => B, g: B => T): A => T = x => g(f(x))

//  println(compose(_ + 1, _ * 2)(10))
//  println(andThen(_ + 1, _ * 2)(10))
}

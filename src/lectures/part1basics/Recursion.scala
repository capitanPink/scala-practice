package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def anotherFactorial(n: Int): BigInt = {
    @tailrec // Can be added to say the compiler that function is tail recursive
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // Tail Recursive
    }
    factorialHelper(n, 1)
  }

  //  println(anotherFactorial(5000))

  //  1. Concatenation function tail rec
  @tailrec
  def concatenateString(str: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenateString(str, n - 1, accumulator + str)
  }

  println(concatenateString("Hello", 5, ""))

  // 2. isPrime function
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(12))
  // 3. Fibonaci tail recursive
  def tailFibonaci(n: Int): Int = {
    def fiboHelper(t: Int, last: Int, nextToLast: Int): Int =
      if (t >= n) last
      else fiboHelper(t + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboHelper(3, 1, 1)
  }


}

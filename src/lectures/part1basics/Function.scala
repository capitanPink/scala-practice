package lectures.part1basics

object Function extends App {

  def aFunction(a: String, b: Int) = a + " " + b
  println(aFunction("hello", 22))

  def aRepeatedFunction(a: String, n: Int): String = a * n

  println(aRepeatedFunction("Hello", 5))

  //  Exercises
  //  1.
  def greetingFunction(name: String, age: Int) = s"Hello, my name is $name and I'm $age years old."
  println(greetingFunction("Seva", 26))
  def factorialFunction(n: Int): Int = if (n == 1 || n == 0) n else n * factorialFunction(n - 1)
  println(factorialFunction(6))
  def fibonaciFunction(n: Int): Int = if (n == 1 || n == 2) 1 else fibonaciFunction(n - 1) + fibonaciFunction(n - 2)
  println(fibonaciFunction(7))
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(13))
}

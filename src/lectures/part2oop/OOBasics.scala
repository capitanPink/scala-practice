package lectures.part2oop

object OOBasics extends App {

}






// 2. Counter class
class Counter(n: Int) {
  def currentCount() = n
  def increment: Counter = new Counter(n + 1)
  def increment(t: Int): Counter = new Counter(n + t)
  def decrement: Counter = new Counter(n - 1)
  def decrement(t: Int): Counter = new Counter(n - t)
}

// 1. Novel and Writer
class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = s"$surname $firstName"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int = yearOfRelease - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

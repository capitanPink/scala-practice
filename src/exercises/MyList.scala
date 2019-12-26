package exercises

object Run extends App {
  val listOfIntegers: MyList[Int] = new Cons(3, new Cons(2, new Cons(1, EmptyList)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, EmptyList))
  println(listOfIntegers.tail.head)
  println(listOfIntegers.toString)
  val listOfStrings: MyList[String] = new Cons("3", new Cons("2", EmptyList))


  println("hello" + listOfIntegers.filter(new Function[Int, Boolean] {
    override def apply(v1: Int): Boolean = v1 % 2 == 0
  }).toString)

  println(listOfIntegers ++ anotherListOfIntegers)


}


trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](i: B): MyList[B]
  def printElements: String
  override def toString: String = s"[$printElements]"

  def ++[B >: A](list: MyList[B]): MyList[B]
  def map[B](transformer: A => B): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
}

case object EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](i: B): MyList[B] = new Cons(i, tail)
  def printElements: String = ""

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  def map[B](transformer: Nothing => B): MyList[B] = EmptyList
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = EmptyList
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = EmptyList
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](i:  B): MyList[B] = new Cons(i, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)
  def map[B](transformer: A => B): MyList[B] = new Cons(transformer(h), t.map(transformer))
  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
}
package lectures.part3FP

object Run extends App {
  val listOfIntegers: MyList[Int] = new Cons(3, new Cons(2, new Cons(10, EmptyList)))
  val anotherListOfIntegers: MyList[Int] = new Cons(2, new Cons(4, new Cons(5, EmptyList)))
  val listOfStrings: MyList[String] = new Cons("3", new Cons("2", EmptyList))

  listOfIntegers.foreach(println(_))
  println(listOfIntegers.sort(_ - _).toString)
  println(listOfIntegers.zipWith[Int, Int](anotherListOfIntegers, _ + _))
  println(listOfIntegers.fold[Int](0)(_ + _))

  val result = for {
    x <- listOfIntegers
    n <- listOfStrings
  } yield n + "-" + x
  println(s"This is result: $result")

//  println(listOfIntegers.tail.head)
//  println(listOfIntegers.toString)
//  println("hello" + listOfIntegers.filter(new Function[Int, Boolean] {
//    override def apply(v1: Int): Boolean = v1 % 2 == 0
//  }).toString)
//  println("hello2" + listOfIntegers.filter(_ % 2 == 0).toString)
//  println(listOfIntegers ++ anotherListOfIntegers)


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

  // Hofs
  def foreach(f: A => Unit): Unit
  def sort(f: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
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

  //Hofs
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(f: (Nothing, Nothing) => Int): MyList[Nothing] = EmptyList
  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists lenght is mismatch!!")
    else EmptyList
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
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

  // Hofs
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }
  def sort(f: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x, EmptyList)
      else if (f(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(f)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists lenght is mismatch!!")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }
  def fold[B](start: B)(operator: (B, A) => B): B =
    t.fold(operator(start, h))(operator)
}
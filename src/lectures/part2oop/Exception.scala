//package lectures.part2oop
//
//object Exception extends App {
//
//  //  throw new OutOfMemoryError("Your memory is out :(")
//
//  //  throw new StackOverflowError("Maximum stack size exceeded")
//
//
//}
//
//class OverFlowException extends Exception
//class UnderFlowException extends Exception
//class MathCalculationException extends Exception
//
//abstract class PocketCalculator[A] {
//  def resultOrError(condition: Boolean, result: A, error: Throwable)
//  def add(x: A, y: A): A
//  def subtract(x: A, y: A): A
//  def multiply(x: A, y: A): A
//  def divide(x: A, y: A): A
//}
//
//class IntPocketCalculator[A] extends PocketCalculator[A] {
//  override def resultOrError(condition: Boolean, result: A, error: Throwable) =
//    if (!condition) result
//    else throw error
//
//  override def add(x: A, y: A): A = {
//    val result = x + y
//    if (result > Int.MaxValue) throw new OverFlowException
//    else result
//  }
//
//  override def subtract(x: Int, y: Int): Int = {
//    val result = x - y
//    if (result < Int.MinValue) throw new UnderFlowException
//    else result
//  }
//
//  override def multiply(x: Int, y: Int): Int = {
//    val result = x * y
//    if (result > Int.MaxValue) throw new OverFlowException
//    else result
//  }
//  override def divide(x: Int, y: Int): Int = {
//
//  }
//}
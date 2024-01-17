package lectures.part2oop

/**
 * @author Sergei Aleshchenko
 */
object Exceptions extends App {


  val x: String = null
  //  println(x.length)


  // 1. Throwing exceptions

  //  val aWeirdValue: String = throw new NullPointerException()

  // Throwable classes axtend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. How to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    getInt(true)
  } catch {
    //    case e: NullPointerException => println("caught a Runtime exception")
    case e: RuntimeException => 43
  } finally {
    // code that will get executed NO MATTER WHAT
    println("finally")
  }

  println(potentialFail)


  // 3. How to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  //  throw exception

  class OverflowException extends RuntimeException("result is too big!")
  class UnderflowException extends RuntimeException("result is too small!")
  class MathCalculationException extends RuntimeException("division by zero!")


  //  throw new OutOfMemoryError
  //  throw new StackOverflowError("Bugagaggagagagaga")

  // OM
  //  val array = Array.ofDim(Int.MaxValue)


//  def infinite: Int = 1 + infinite
//  val noLimit = infinite


  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x >= 0 && y >= 0 && result < 0) throw new OverflowException
      else if (x <= 0 && y <= 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y

      if (x <= 0 && y >= 0 && result > 0) throw new UnderflowException
      else if (x >= 0 && y <= 0 && result < 0) throw new OverflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def division(x: Int, y: Int): Long = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  println(PocketCalculator.add(5, 23))
  println(PocketCalculator.subtract(100, 345))
  println(PocketCalculator.multiply(5, 7))
  println(PocketCalculator.division(100, 1))

}


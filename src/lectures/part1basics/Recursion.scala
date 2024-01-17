package lectures.part1basics

import scala.annotation.tailrec

/**
 * @author Sergei Aleshchenko
 */
object Recursion extends App {

  def factorial(n: Int): BigInt = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }

//  println(factorial(10))
//  println(factorial(20000))


  def tailRecursiveFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }
    factHelper(n ,1)
  }

//  println(tailRecursiveFactorial(20000))

  @tailrec
  def recursiveConcat(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else recursiveConcat(aString, n - 1, aString + accumulator)
  }
  println(recursiveConcat("asdf", 5, ""))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailrec(n / 2, true)
  }

  println("is prime: " + isPrime(12))
  println("is prime: " + isPrime(2003))

  // 3. A Fibonacci function: f(1) = 1, f(2) = 1, f(n) = f(n-1) + f(n-2)
  // 1, 1, 2, 3, 5, 8, 13, 21, 34
  def fibonacciTailRecursive(n: BigInt): BigInt = {
    def fiboTailrec(i: Int, lastAcc: Int, nextToLastAcc: Int): Int = {
      if (i >= n) lastAcc
      else fiboTailrec(i + 1, lastAcc + nextToLastAcc, lastAcc)
    }

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println("fibonacci: " + fibonacciTailRecursive(8))

}

package lectures.part1basics

/**
 * @author Sergei Aleshchenko
 */
object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  println(aFunctionWithSideEffects("Sergei"))

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n , n - 1)
  }

  println(aBigFunction(5))


  // 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
  def greetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

  println(greetingFunction("Sergei", 34))


  // 2. Factorial function: 1 * 2 * 3 * ... * n
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println("factorial: " + factorial(5))


  // 3. A Fibonacci function: f(1) = 1, f(2) = 1, f(n) = f(n-1) + f(n-2)
  // 1, 1, 2, 3, 5, 8, 13, 21, 34

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println("fibonacci: " + fibonacci(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println("is prime: " + isPrime(13))
  println("is prime: " + isPrime(2003))

  def isPrime2(num:Int): Boolean =
    (num > 1) && !(2 to num / 2).exists(x => num % x == 0)

  println("is prime2: " + isPrime2(7))


}

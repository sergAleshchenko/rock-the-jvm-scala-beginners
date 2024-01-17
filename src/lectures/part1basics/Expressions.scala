package lectures.part1basics

/**
 * @author Sergei Aleshchenko
 */
object Expressions extends App {
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>>

  println(1 == x)
  println(x >= 2)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= (side effects)
  println(aVariable)


  // Instructions (TO DO) vs Expressions (VALUE)


  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  // This is expression (not instruction)

  println("aConditionedValue: " + aConditionedValue)
  println(if(aCondition) 7 else 88)

  var i = 0
  val aWhile: Unit = while (i < 10) {
    println(i)
    i += 1
  }

  // Never write while again

  // Everything in Scala is an Expression!

  val aWeirdValue: Unit = (aVariable = 3) // Unit === void
  println(aWeirdValue)
  println(aWhile)

  // side effects: println(), whiles, reassigning

  // Code blocks


  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  println(aCodeBlock)

  // 1. Difference between "hello wold" vs println("hello world")?
  // 2.

  val someValue = {
    2 < 3
  }
  println("someValue: " + someValue)

  val someOtherValue = {
    if(someValue) 239 else 987
  }
  println(someOtherValue)
}

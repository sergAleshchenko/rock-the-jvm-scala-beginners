package lectures.part1basics

/**
 * @author Sergei Aleshchenko
 */
object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  // VALS are immutable
  // Compiler can infer types

  val aString: String = "hello"
  val anotherString = "goodbye"


  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 1234
  val aLong: Long = 12341234112342134L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effects


}

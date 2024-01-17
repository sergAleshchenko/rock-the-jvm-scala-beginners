package lectures.part2oop

/**
 * @author Sergei Aleshchenko
 */
object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    def +(person: Person): String =
      s"$name is hanging out with ${person.name}"



    def +(nickname: String): Person =
      new Person(s"$name ($nickname)", favoriteMovie)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learns(subject: String): String = s"$name learns $subject"

    def learnsScala : String = this learns "Scala"

    def apply(number: Int): String =
      s"$name watched $favoriteMovie $number times"

  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))

  // infix notation = operator notation
  println(mary likes "Inception")

  // "operators" in Scala
  val tom = new Person("Tom", "Matrix")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // All operators are methods

  // prefix notation
  val x = -1
  val y = 1.unary_-

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())
  println(mary apply)

  println("--------------------")


  println((mary + "the rockstar").apply())
  println("mary.age: " + mary.age)
  println("+mary.age: " + (+ mary).age)
  println(mary learns "Something")
  println(mary learnsScala)
  println(mary(4))

}

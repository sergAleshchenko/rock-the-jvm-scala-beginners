package lectures.part2oop

/**
 * @author Sergei Aleshchenko
 */
object OOBasics extends App {
  val person = new Person("John", 26)
  val person1 = new Person()
  val person2 = new Person("NoAgeName")

  println("person.age: " + person.age)
  println("person.x: " + person.x)

  person.greet("Daniel")
  person.greet()
  person1.greet("Daniel1")
  person2.greet("Daniel2")
  person2.greet()


  println("------------------------")
  println("person1.name: " + person1.name)
  println("person1.age: " + person1.age)
  println("person2.age: " + person2.age)
}

class Person(val name: String = "John Doe", val age: Int = 0) {
  // body
  val x = 2;

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am ${this.name}")


  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}



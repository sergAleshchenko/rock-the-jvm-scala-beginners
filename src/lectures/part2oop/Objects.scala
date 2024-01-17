package lectures.part2oop

/**
 * @author Sergei Aleshchenko
 */
object Objects extends App {

  // Scala does not have class-level functionality ("static")

  object Person { // type + its only instance
    // "static"/"class" level functionality

    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // companions

    println (Person.N_EYES)
    println (Person.canFly)

    // Scala object = singleton instance
    val mary = Person // this is instance of Person type
    val john = Person
    println (mary == john)

    val maryNew = new Person ("Mary") // this is different instances
    val johnNew = new Person ("John")
    println (maryNew == johnNew)

    val person1 = Person
    val person2 = Person
    println (person1 == person2)

    val bobbie = Person (maryNew, johnNew)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit


}

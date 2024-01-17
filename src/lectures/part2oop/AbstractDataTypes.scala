package lectures.part2oop

/**
 * @author Sergei Aleshchenko
 */
object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit =
      println(s"I'm a croc and i'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)

  // traits vs abstract class
  // both allow abstract and non-abstract methods and fields
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits (but single class) may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"

  AnyRef

}

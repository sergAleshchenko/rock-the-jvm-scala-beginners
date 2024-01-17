package lectures.part2oop

/**
 * @author Sergei Aleshchenko
 */
object OOExercisesCounter extends App {
  val counter = new Counter

  counter.print

  counter.inc.print
  counter.inc.inc.inc.print
  counter.dec.print

  println("---------------------")

  counter.inc(3).print
  counter.dec(5).print
}

class Counter(val count: Int = 0) {

  def print = println(count)

  def inc = {
    println("incrementing")
    new Counter(count + 1)
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }
}

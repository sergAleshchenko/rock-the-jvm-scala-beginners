package lectures.part1basics

/**
 * @author Sergei Aleshchenko
 */
object DefaultArgs extends App {


  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  }

  val fact10 = trFact(10, 2)

  println(fact10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println("saving picture")

  savePicture(width = 800, format = "bmp")

}

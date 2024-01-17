package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => SqlDate}
/**
 * @author Sergei Aleshchenko
 */
object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess

  // packages are in hierarchy
  // matching folder structure

  sayHello
  println(SPEED_OF_LIGHT)

  val prince = new PrinceCharming

  // 1. Use FQ name
  val date = new Date
  val sqlDate = new java.sql.Date(2018, 5, 4)


  // 2. Use aliasing
  val sqlDate2 = new SqlDate(2018, 5, 4)

  // default imports
  // java.lang - String, Object, Exception
  // scala = Int, Nothing, Function
  // scala.Predef = println, ???

}

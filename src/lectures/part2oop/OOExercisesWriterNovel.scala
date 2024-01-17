package lectures.part2oop

/**
 * @author Sergei Aleshchenko
 */
object OOExercisesWriterNovel extends App {
  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println("author.fullName(): " + author.fullName())

  println("novel.authorAge(): " + novel.authorAge())
  println("novel.isWrittenBy(author): " +novel.isWrittenBy(author))


  val copyNovel = novel.copy(2005)
  println(copyNovel.name + ", " + copyNovel.author.fullName() + ", "
    + copyNovel.yearOfRelease)
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = firstName + " " + surname
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def authorAge() = yearOfRelease - author.year

  def isWrittenBy(author: Writer) = this.author == author

  def copy(newYear: Int) = new Novel(name, newYear, author)
}




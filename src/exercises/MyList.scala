package exercises

/**
 * @author Sergei Aleshchenko
 */
abstract class MyList[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
   */

  def head(): A
  def tail(): MyList[A]
  def isEmpty(): Boolean
  def add[B >: A](element: B): MyList[B]

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  def printElements: String
  override def toString = "[" + printElements + "]"
}

case object Empty extends MyList[Nothing] {
  override def head(): Nothing = throw new NoSuchElementException()
  override def tail(): MyList[Nothing] = throw new NoSuchElementException()
  override def isEmpty(): Boolean = true
  override def add[B >: Nothing](element: B): MyList[B] = Cons(element, Empty)
  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head(): A = h
  override def tail(): MyList[A] = t
  override def isEmpty(): Boolean = false
  override def add[B >: A](element: B): MyList[B] = Cons(element, this)

  override def printElements: String =
    if(t.isEmpty()) "" + h
    else h + " " + t.printElements


  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    Cons(transformer.transform(h), t.map(transformer))
  }

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  override def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)
}

case class EvenPredicate() extends MyPredicate[Int] {
  override def test(t: Int): Boolean = ???
}

case class StringToIntTransformer() extends MyTransformer[String, Int] {
  override def transform(a: String): Int = ???
}


trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}


object ListTest extends App {

  val listOfIntegers: MyList[Int] =
    new Cons[Int](1,
      new Cons[Int](2,
        new Cons[Int](3,
          new Cons[Int](4,
            new Cons[Int](5,
              new Cons[Int](6, Empty))))))

  val clonelistOfIntegers: MyList[Int] =
    new Cons[Int](1,
      new Cons[Int](2,
        new Cons[Int](3,
          new Cons[Int](4,
            new Cons[Int](5,
              new Cons[Int](6, Empty))))))


  val anotherListOfIntegers: MyList[Int] =
    new Cons[Int](7,
      new Cons[Int](8,
        new Cons[Int](9, Empty)))

  println(listOfIntegers)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }))

    val listOfStrings: MyList[String] =
      new Cons[String]("111",
        new Cons[String]("222",
          new Cons[String]("333", Empty)))

    println(listOfStrings.map(new MyTransformer[String, Int] {
      override def transform(elem: String): Int = elem.toInt
    }))

  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = Cons(elem, new Cons[Int](elem + 1, Empty))
  }))

  println(clonelistOfIntegers == listOfIntegers)
}


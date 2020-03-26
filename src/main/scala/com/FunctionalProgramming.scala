package com

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as function === bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pas functions as args
    - return functions as results

    Conclusion: FunctionX
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  stringConcatenator("I like ", "Scala") // "I like Scala"

  // syntax sugars
  val doubler: Function1[Int, Int] = (x:Int) => 2 * x
  val doubler2: Int => Int = (x:Int) => 2 * x // equivalent
  doubler(4) // 8

  // Higher-order functions: take functions as args/return functions as results
  val aMappedList: List[Int] = List(1,2,3).map(x => x + 1) // List(2,3,4)
  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x)) // List(1,2,2,4,3,6)
  /* alternative

      List(1,2,3).flatMap {
        x => List(x, 2 * x)
      }
      
   */

  val filteredList = List(1,2,3,4,5).filter(_<= 3) // equivalent x => x <= 3

  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter")) // List(1-a,1-b,1-c,2-a,2-b,2-c,3-a,3-b,3-c)

  //for comprehensions // equivalent to the map/flatMap chain above
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a','b','c')
  } yield s"$number-$letter"

  // Collections

  // Lists
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  var rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
  val aExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // equivalent Seq.apply(1,2,3)
  val accessedElement = aSequence(1) // the element at index 1 (2)

  // vectors: fast Seq implementation
  val aVector = Vector(1,2,3,4,5)

  // sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val aAddedSet = aSet + 5 // Set(1,2,3,4,5)
  val aRemovedSet = aSet -3 // Set(1,2,4)

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList // List (2,4,6,8...,2000)

  // tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Name1", 341323),
    "Name2" -> 3123123 // equivalent of ("Name2", 341323)
  )

}

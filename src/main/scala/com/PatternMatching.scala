package com

object PatternMatching extends App {

  // switch expression
  val aInteger = 55
  val order = aInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => aInteger + "th" // _ default
  }

  // pattern match is an expresion

  // Case class decomposition
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43) // Person.apply("Bob",43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "Something else"
  }

  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you're talking about"
  }

  // decomposing lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "Uknown list"
  }

  //if pattern match doesn't match anything, it wil throw MatchError
  // pattern match will try all cases in sequence

}

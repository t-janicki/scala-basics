package com

object ObjectOrientation extends App {

  // class and instance
  class Animal {
    val age: Int = 0
    def eat() = print("I'm eating")
  }
  val anAnimal = new Animal

  class Dog(val name: String) extends Animal { //constructor definition
    val aDog = new Dog("Dog")
    // constructor arguments are NOT fields: need to put a val before the constructor argument
    aDog.name

    // subtype polymorphism
    val aDeclareAnimal: Animal = new Dog("Dog")
    aDeclareAnimal.eat() // the most derived method will be called at runtime

    // abstract class
    abstract class WalkingAnimal {
      protected val hasLegs = true // by default public, can restrict by private or protected like in Java
      def walk(): Unit
    }

    // declare "interface"
    trait Carnivore {
      def eat(animal: Animal): Unit
    }

    trait Philosopher {
      def ?!(though: String): Unit // valid method name
    }

    // single-class inheritance and multi-trait "mixing"
    class Crocodile extends Animal with Carnivore with Philosopher {
      override def eat(animal: Animal): Unit = println("Implemented eat")

      override def ?!(though: String): Unit = println(s"I was thinking: $though")
    }

    val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat aDog // infix notation = object method argument, only available for methods with  ONE argument
    aCroc ?! "What if we could fly?" // also valid method call

    // operators in Scala are actually methods
    val basicMath: Int = 1 + 2
    val anotherBasicMath: Int = 1.+(2) //equivalent

    // anonymous classes
    val dinosaur = new Carnivore {
      override def eat(animal: Animal): Unit = print("I am dinosaur so I can eat pretty much anything")
    }
    val dinosaur2: Carnivore = (_: Animal) => print("I am dinosaur so I can eat pretty much anything") // equivalent

    // singleton object
    object MySingleton { // the only instance of the MySingleton type
      val MySpecialValue = 3123
      def mySpecialMethod(): Int = 423123
      def apply(x: Int): Int = x +1
    }

    MySingleton.mySpecialMethod()
    MySingleton.apply(65)
    MySingleton(65) // equivalent to MySingleton.apply(65)

    object Animal {// companions = companion object above is class Animal
        // companions can access each other's private fields/methods
        // singleton Animal and instances of Animal are different things
      val canLiveIndefinitely = false
    }

    val animalsCanLiveForever = Animal.canLiveIndefinitely // 'static' fields/methods like in Java

    /*
    case classes = lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
     */
    case class Person(name: String, age: Int)
    // may be constructed without new
    val bob = Person("Bob", 54) //Person.apply("Bob",54)

    // exceptions
    try {
      // code than can throw
      val x: String = null
//      x.lenght
    } catch { // in Java catch(Exception e) {..}
      case e: Exception => "some error"
    } finally {
      // execute some code no matter what
    }
  }

  // Generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // int
  val rest = aList.tail
  val aStringList = List("Hello", "Scala")
  val firstString = aStringList.head // string

  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER value/object
  /*
    Benefits:
    1) Works miracles in multithreaded/distributed env
    2) Helps making sense of the code ("reasoning about")
   */

  val reversedList = aList.reverse // return a NEW list

  // Point #2: Scala is closest to the OO ideal

}

package com

import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Advanced extends App {

  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1

  // useful in infinite collections

  // pseudo collection: Option, Try
  def methodWhichCanReturnNull(): String = "Hello, Scala"

  val anOption = Option(methodWhichCanReturnNull())  // Some("Hello, Scala)
  // option = 'collection' which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  // map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException
  val aTry = Try(methodWhichCanThrowException()) // 'collection' with either a value if the code wen well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(value) => s"I have obtained a valid string: $value"
    case Failure(exception) => s"I have obtained an exception: $exception"
  }

  /*
    Evaluate something on another thread
    (asynchronous programming)
   */
  // Future is a 'collection' which contains a value when it's evaluated
  // Future is composable with map, flatMap, and filter
  val aFuture = Future({
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  })

  Thread.sleep(2000)

  // Implicits basics
  // #1: implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // #2: implicit conversion
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // new MyRichInteger(23).isEvent()
}

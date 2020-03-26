package com

object Basics extends App {

  // defining int value
  val intValue: Int = 42 // // const int

  // boolean
  val aBoolean = false // type is optional

  // string
  val aString = "Example string"
  val aComposedString = "Example" + " string" // Example string
  val anInterpolatedString = s"Is $aComposedString" // Is Example string

  // expression
  val anExpression = 2 + 3 // 5

  // if-expresion
  val ifExpression = if (intValue > 43) 56 else 600 // in other languages intValue > 43 ? 56 : 600
  val chainedExpression =
    if (intValue > 40) 56
    else if (intValue < 0) 2
    else 0

  val aCodeBlock = {
    val aLocalVal = 67

    // value of block is the value of the last expression
      aLocalVal + 3
  }

  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n -1)

  //In Scala we don't use loops or iteration, we use RECURSION

  // the Unit type = in other languages "void"
  println("Scala") // System.out.println, console.log

  def myUnitReturningFunction(): Unit = {
    print("Void return")
  }
}

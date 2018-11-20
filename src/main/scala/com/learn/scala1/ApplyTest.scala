package com.learn.scala1

object ApplyTest {
  def apply() = {
    println("I  am into Scala so much")
    new ApplyTest
  }
}

class ApplyOperation {
}

class ApplyTest{
  def apply() = println("I am into spark so much!!!")
  def haveATry: Unit ={
    println("have a try on apply")
  }
}

object ApplyOperation{
  def main (args: Array[String]) {
    val array= Array(1,2,3,4)
    val a = ApplyTest() //这里就是使用object 的使用

    a.haveATry
    a() // 这里就是 class 中 apply使用
  }
}
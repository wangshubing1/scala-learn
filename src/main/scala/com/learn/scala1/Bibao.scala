package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object Bibao {
  def main(args: Array[String]): Unit = {
    //闭包最简洁的解释：函数在变量不处于其有效作用域时，还能够对变量进行访问，即为闭包
    def getGreetingFunc(msg:String)=(name:String)=>println(msg+","+name)
    val greetingFuncHello=getGreetingFunc("hello")
    val greetingFuncHi=getGreetingFunc("hi")
    greetingFuncHello("leo")
    greetingFuncHi("leo")
    //两次调用getGreetingFunc函数，传入不停msg，并创建不同函数返回
    //然而，msg只是一个局部变量，却在getGreetingFunc执行完之后，还可以继续存在创建的函数中；
    //greetingFuncHello("leo")调用时，值为“hello”的msg被保留在函数体内部，可以反复使用
    //这种变量超出了其作用域，还可以使用的情况，即为闭包

    //scala通过为每个函数创建对象实现闭包，实际上对于getGreetingFunc函数创建的函数，
    // msg是作为函数对象的变量存在的，因此每个函数才可以拥有不同的msg
  }
}

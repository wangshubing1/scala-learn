package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object Return {
  def main(args: Array[String]):Unit = {
    //scala中，不需要使用return 来返回函数的值，函数最后一行语句的值，就是函数的返回值，
    // 在scala中，return用于在匿名函数中返回值给包含匿名函数的带名函数，并作为带名函数的返回值
    //使用return 的匿名函数，是必须给出返回类型的，否则无法通过编译
    def greeting(name:String)={
      def sayHello(name:String):String={
        return "Hello,"+name
      }
      sayHello(name)
    }
    println(greeting("leo"))
  }

}

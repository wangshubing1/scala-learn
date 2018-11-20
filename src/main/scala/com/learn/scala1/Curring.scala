package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object Curring {
  def main(args: Array[String]): Unit = {
    //Curring函数，指的是将原来接收两个参数的一个函数，转换为两个函数，第一个函数接收原来的第一个参数，然后返回接收原来的第二个参数的第二个函数。
    //在函数调用的过程中，就变为了两个函数连续调用的形式
    def sum(a:Int,b:Int)= a + b
    sum(1,1)
    //这就是颗粒函数
    def sum2(a:Int)=(b:Int)=>a+b
    sum2(1)(1)
    //颗粒函数的简单写法
    def sum3(a:Int)(b:Int)=a+b
    println(sum3(1)(3))
  }
}

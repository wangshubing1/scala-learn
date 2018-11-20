package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
//将函数赋给变量
object MainTest {
  def main(args: Array[String]): Unit = {
    val sayHelloFunc =sayHello _
    sayHelloFunc("leo")
    //将匿名函数赋给变量
    //scala定义匿名函数的语法规则就是，(参数名:参数类型)=>函数体
    val shf =(name:String)=>println("hello,"+name)
    shf("jack")
    //scala中，函数是一等公民，因此可以直接将某个函数传入其他函数，作为参数。java不具备此功能
    //接受其他函数作为参数的函数，也被称为高阶函数
    def greeting(func:(String)=>Unit,name:String){func(name)}
    greeting(shf,"wang")
    Array(1,3,5,7,9).map((num:Int)=>print(num*num+"\t"))
    //高阶函数的另外一个功能将函数作为返回值
    def getGreetingFunc(msg:String)=(name:String)=>println(msg+","+name)
    val greetingFunc=getGreetingFunc("hello")
    greetingFunc("leo")
    //高阶函数可以自动推断出参数类型，而不需要写明类型；而且对于只有一个参数的函数，还可以省略其小括号；
    // 如果仅有的一个参数在右侧的函数体内只使用一次，则可以将接收参数省略，并且将参数用_来替代
    def greeting1(func:(String)=>Unit,name:String){func(name)}
    greeting1((name:String)=>println("hello,"+name),"leo")
    greeting1((name)=>println("hello,"+name),"leo")
    greeting1(name=>println("hello,"+name),"leo")

    def triple(func:(Int)=>Int)={println(func(3))}
    triple(6*_)
    //scala的常用高阶函数
    //map：对传入的每个元素都进行映射，返回一个处理后的元素
    Array(1,3,5,7,9).map(2*_)
    //foreach:对传入的每个元素都进行处理，但是没有返回值
    (1 to 9).map("*"*_).foreach(println _)
    //filter:对传入的每个元素进行条件判断，如果对元素返回true，则保留元素，否则过滤掉该元素
    println((1 to 20).filter(_ %2==0))
    //reduceLeft:从左侧元素开始，进行reduce操作，即先对元素1和元素2进行处理，然后将结果与元素3处理，
    // 再将结果与元素4处理，依次类推即为reduce
    //1*2*3*4*5*6*7*8*9
    println((1 to 9).reduceLeft(_ * _))
    //sortWith:对元素进行两两相比，进行排序
    Array(5,9,3,8,2,9,10,56,32).sortWith(_ < _)
  }
  def sayHello(name:String ): Unit ={
    println("hello, "+name )
  }

}

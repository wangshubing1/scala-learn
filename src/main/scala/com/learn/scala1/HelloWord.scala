package com.learn.scala1

object HelloWord {
  //定义类，包含filed和方法
  private val eyeNum =2
  def getEyeNum =eyeNum
  class Hello {
    private val name ="sb"
    def sayHello(){println("Hello "+name)}
    def getName=name
  }
  class Student{
    private var myName="wang"
    def name ="your name is "+myName
    def name_=(newName:String){
      println("you cant edit your name")
    }
  }
 /* class Ages{
    private var age =0
    def age_=(newAge:Int)={
      if(newAge>0)age=newAge
      else println("illegal age!")
    }
    def ages =age
    def older(s:Ages)={
      age>s.age
    }

  }*/

  /*class Ages1{
    private[this] var age1 =0
    def age_=(newAge:Int)={
      if(newAge>0)age1=newAge
      else println("illegal age!")
    }
    def ages =age1
  }*/

  def main(args: Array[String]): Unit = {
    val helloWord =new Hello
    helloWord.sayHello()
    println(helloWord.getName)
    val s =new Student
    println(s.name)
    s.name = "shu"
  }

}
class HelloWord(val name:String,val age:Int){
  def sayHello=println("hi"+name+HelloWord.eyeNum)
}

//object的功能其实和class类似，除了不能定义接受参数的constructor之外
//object也可以继承抽象类，并覆盖抽象类中方法
abstract class Hello(var message:String){
  def sayHello(name:String):Unit
}
object HelloImpl extends Hello("hello"){
  override def sayHello(name: String): Unit = {
    println(message+","+name)
  }
}




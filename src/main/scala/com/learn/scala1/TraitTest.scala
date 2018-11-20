package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object TraitTest {
  def main(args: Array[String]): Unit = {
    //将Trait作为接口来使用
    val p =new Person("leo")
    val p2 =new Person("jack")
    p.sayHello("jack")
    p.makeFriends(p2)
    //在Trait定义自己的具体方法
    val p3 =new Person1("wang")
    val p4 =new Person1("test")
    p3.sayHello
    p4.makeFriends(p3)
    //在Trait定义自己的具体字段
    val p5 =new Stu("王树兵")
    p5.sayHello
    //在Trait定义自己的抽象字段
    val p6=new Person3("leo")
    //p6.sayHello("leo")
    val p7 =new Person3("jack")
    p6.makeFriends(p7)
    //为实例混入trait
    val p8 = new Person4("leo")
    p8.sayHello
    val p9 =new Person4("jack")with MyLogger
    p9.sayHello
    //trait调用链
    val p10 =new Person5("leo")
    p10.sayHello
    val p11 =new Person6("leo")
    p11.getName
    //trait构造机制
    val s1 =new Student1
    println(s1)
    //trait继承类
    val p12=new Person8("leo")
    p12.sayHello

}
  trait MakeFriendsTrait {
    def makeFriends(p:Person)
  }
  trait HelloTrait {
    def sayHello(name:String)
  }
  class Person(val name:String)extends HelloTrait with MakeFriendsTrait{
    def sayHello(name: String) = println("hello "+name)
    def makeFriends(p: Person) = println("hello my name is "+name +"your name is "+p.name)
  }
  //在Trait定义自己的具体方法
  trait Logger{
    def log(message:String)=println(message)
  }
  class Person1(val name:String)extends Logger{
    def sayHello{println("hello ,I'm "+name)
      log("sayHello is invoked ")

    }
    def makeFriends(p:Person1){
      println("hi I'm "+name+",I'm want to make friends with you ,"+p.name)
      log("makeFriends methdo is invoked with parameter Person[name ="+p.name+"]")
    }
  }
  //在Trait定义自己的具体字段
  trait Person2{
    val eyeNum:Int=2
  }
  class Stu(val name:String )extends Person2{
    def sayHello=println("hi ,我是 "+name+",我有 "+eyeNum+"个眼睛")
  }
  //在Trait定义自己的抽象字段
  trait SayHello{
    val msg:String
    def sayHello(name:String)=println(msg+","+name)

  }
  class Person3(val name:String)extends SayHello{

    val msg:String ="hello"
    def makeFriends(p: Person3){
      sayHello(p.name)
      println("hello my name is "+name +"我想和你做朋友！")
    }
  }
  //为实例混入trait
  trait Logged{
    def log(msg:String){}
  }
  trait MyLogger extends Logged{
    override def log(msg: String){println("log:"+msg)}
  }
  class Person4(val name:String)extends Logged{
    def sayHello{println("hi I'm "+name);log("sayHello is invoked!")}
  }
  //trait调用链
  trait Handler{
    def handle(data:String){}
  }
  trait DataValidHandler extends Handler{
    override def handle(data: String): Unit ={
      println("check data："+data)
      super.handle(data)
    }
  }
  trait SignatureValidHandler extends Handler{
    override def handle(data: String): Unit ={
      println("check signature:"+data)
      super.handle(data)
    }
  }
  class Person5(val name:String)extends SignatureValidHandler with DataValidHandler{
    def sayHello={println("Hello ,"+name);handle(name)}
  }
//在trait里面覆盖抽象方法
  trait Logger1{
  def log(msg:String)
}
  trait MyLogger1 extends Logger1{
   abstract override def log(msg: String): Unit ={
     super.log(msg)
   }
  }
  //混合使用trait具体方法与抽象方法
  trait Valid{
    def getName:String
    def valid:Boolean={
      getName=="leo"
    }
  }
  class Person6(val name:String)extends Valid{
    println(valid)

    def getName=name
  }
  //trait构造机制
  class Person7{println("Person's construtor!")}
  trait Logger2{println("Logger's construtor! ")}
  trait MyLogger2 extends Logger2{println("MyLogger's construtor! ")}
  trait TimeLogger extends Logger2{println("TimeLogger's construtor! ")}
  class Student1 extends Person7 with MyLogger2 with TimeLogger{println("Student1's construtor! ")}
  //trait继承类
  class MyUtil{
    def printMsg(msg:String)=println(msg)
  }
  trait Logger3 extends MyUtil{
    def log(msg:String)=printMsg("log:"+msg)
  }
  class Person8(val name:String)extends Logger3{
    def sayHello: Unit ={
      log("hi ,I'm "+name)
      printMsg("hi ,I'm "+name)
    }
  }
}

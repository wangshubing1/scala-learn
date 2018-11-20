package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object LeiXingCanShu {
  //泛型类
  class Student[T](val localId: T) {
    def getSchoolId(hukouId: T) = "S-" + hukouId + "-" + localId
  }

  //泛型函数
  def getCard[T](content: T) {
    if (content.isInstanceOf[Int]) println("card:001," + content)
    else if (content.isInstanceOf[String]) println("card:this is your card," + content)
    else println("card:" + content)

  }

  //上边界Bounds
  class Person(val name: String) {
    def sayHello = println("hello ,I'm " + name)
    def makeFriens(p: Person) {
      sayHello
      p.sayHello
    }
  }

  class Students(name: String) extends Person(name)

  //T<:Person意思就是泛型要求必须是Person的子类
  class Party[T <: Person](p1: T, p2: T) {
    def play = p1.makeFriens(p2)
  }
  class Party1[T <% Person](p1: T, p2: T) {
    def play = p1.makeFriens(p2)
  }

  class Worker(name: String)

  //view Bounds
  class Dog(val name: String) {
    def sayHello = println("嗷呜！嗷呜！嗷呜 " + name)
  }

  implicit def dog2person(obj: Object): Person ={if (obj.isInstanceOf[Dog]) {
    val dog = obj.asInstanceOf[Dog]
    new Person(dog.name)
  } else null
  }

  //下边界Bounds
  class Father(name: String)

  class Child(name: String) extends Father(name)

  def getIDCard[R >: Child](p: R): Unit = {
    if (p.getClass == classOf[Child]) println("please tell us your prents")
    else if (p.getClass == classOf[Father]) println("***** ***")
    else println("sorry ,you are +++++")
  }
  //context Bounds
  class Calculator[T:Ordering](val num1:T,num2:T){
    def max(implicit order:Ordering[T])=if(order.compare(num1,num2)>0)num1 else num2
  }
  //Manifest Context Bounds
  class Meat(val name:String)
  class Vegetable(val name:String)
  def packgeFood[T:Manifest](food:T*)={
    val foodPackge =new Array[T](food.length)
    for (i<-0 until food.length)foodPackge(i)=food(i)
    foodPackge
  }
  //协变和逆变
  class Master
  class Professional extends Master
  //大师以及大师级别以下的都可以进入会场
  //协变
  class Card[+T](val name: String)
    def enterMeet(card:Card[Master]): Unit ={
      println("welcome to have this meeting!")
    }


  //只要专家级别的名片就可以进入会场
  class Cards[-T](val name: String)
    def enterMeets(card:Card[Professional]): Unit ={
      println("welcome to have this meeting!")
    }



  def main(args: Array[String]): Unit = {
    //泛型类
    val leo = new Student[Int](522)
    val leo1 = new Student(522) //val jack =new Student[String]("789")
    //true
    leo.getSchoolId(411)
    println(leo1.getSchoolId(411)) //flase
    //leo.getSchoolId("456")
    //泛型函数
    val card = 123456
    getCard(card)
    //上边界Bounds
    val jen = new Students("jen")
    val jack = new Students("jack")
    val marry = new Person("marry")
    //flase
    val tom = new Worker("tom")
    //val party1 =new Party(jen,tom)
    val party = new Party(jen, jack)
    val party2 = new Party(jen, marry)
    party.play
    party2.play
    //下边界Bounds
    val jen1 = new Father("jen")
    val jack1 = new Child("jack")
    getIDCard(tom)
    getIDCard(jen1)
    getIDCard(jack1)
    //view Bounds
    /*val dog5 = new Dog("erha")
    val party3 = new Party1(jen, dog5)
    party3.play*/
    //context Bounds
    val cal =new Calculator(3,5)
    println(cal.max)
    //Manifest Context Bounds
    val gongbaojiding =new Meat("gongbaojiding")
    val yuxxiangrousi =new Meat("yuxxiangrousi")
    val shousiyangpai =new Meat("shousiyangpai")
    val meatPackge =packgeFood(gongbaojiding,shousiyangpai,yuxxiangrousi)

    //协变和逆变
    //协变
    val sb =new Card[Master]("sb")
    val nb =new Card[Professional]("nb")
    enterMeet(sb)
    enterMeet(nb)

  }
}

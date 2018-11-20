package com.learn.scala1

import java.io.{FileNotFoundException, IOException}

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object Match {
  //Match case最基本的用法就是对变量的值进行模式匹配
  def judgeGrade(name:String,grade:String){
    grade match{
      case "A"=>println("you got A grade ,Excellent!")
      case "B"=>println("you got B grade ,Good!")
      case "C"=>println("you got c grade ,Just so so!")
      //case _=>println("you need work harder")
        //在模式匹配中使用if守卫
      /*case _ if name=="leo"=>println(name+ ",you are a good boy,come on")
      case _=>println("you need work harder")*/
      case badGrade =>println("you got " + badGrade +" grade ,I hope that you can get C grade next time!")
    }
  }
//对类型进行模式匹配
  def processException(e:Exception): Unit ={
    e match {
      case e1:IllegalArgumentException =>println("you have Illegal argument exception is:"+e1)
      case e2:FileNotFoundException =>println("cannot find the need read or write,exception is:"+e2)
      case e3:IOException =>println("you got an error while you were doing IO operation!excption is:"+e3)
      case _:Exception =>println("cannot konw which excption you have")
    }
  }
  //对Array进行模式匹配
  def greeting(array: Array[String]): Unit ={
    array match{
      case Array("leo")=>println("hi ,leo")
      case Array(gril1,gril2,gril3)=>println("hi ,grils!nice to meet you."+gril1 +","+gril2+"and "+gril3)
      case Array("leo",_*)=>println("hi! leo,please introduce your friends to me.")
      case _=>println("hey! who are you?")
    }
  }
  //对list进行模式匹配，与Array类似，但是需要使用list特有的::操作符
  def gretList(list: List[String]): Unit ={
    list match {
      case "leo"::Nil=>println("hey ,leo")
      case gril1::gril2::gril3::Nil=>println("hi ,grils!nice to meet you."+gril1 +","+gril2+"and "+gril3)
      case "leo"::tail =>println("hi! leo,please introduce your friends to me.")
      case _=>println("hey! who are you?")
    }
  }
//case class与模式匹配
  class Person
  case class Teacher(name: String,subject:String)extends Person
  case class Student(name: String,classroom:String)extends Person
  case class Worker(name:String)extends Person
  val leo:Person=Student("leo","class1")
  val tom:Person=Teacher("tom","Math")
  val jack:Person=Worker("jack")
  def judgeldentify(p:Person): Unit ={
    p match {
      case Teacher(name,subject)=>println("The teacher name is "+name+",subject is "+subject)
      case Student(name,classroom)=>println("The student name is "+name+",classroom is "+classroom)
      case _=>println("Illegal access ,please go out of the school!")
    }
  }
  //Option与模式匹配
  //scala一种特殊类型，Option，一种是some，表示有值，一种是none 表示没有值
  //Option通常用在模式匹配中，用来判断变量是否有值 例如：
  val grades =Map("leo"->"A","tom"->"B","jen"->"C")
  def getGrade(name:String): Unit ={
    val grade =grades.get(name)
    grade match {
      case Some(grade)=>println("your grade is "+grade)
      case None=>println("Sorry, your grade is null")
    }
  }
  def main(args: Array[String]): Unit = {
    judgeGrade("leo","D")
    processException(new IllegalArgumentException("expect tow arguments,but found one argument "))
    greeting(Array("leo"))
    greeting(Array("迪丽热巴","杨幂","王珞丹"))
    greeting(Array("leo","迪丽热巴","杨幂","王珞丹"))
    gretList(List("leo"))
    gretList(List("迪丽热巴","杨幂","王珞丹"))
    gretList(List("leo","王珞丹"))
    judgeldentify(leo)
    judgeldentify(tom)
    judgeldentify(jack)
    getGrade("Leo")
    getGrade("tom")
  }

}

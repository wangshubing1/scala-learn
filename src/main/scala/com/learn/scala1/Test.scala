package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object Test {
  def main(args: Array[String]): Unit = {
    class Person
    class Student extends Person
    val p:Person =new Student
    var s:Student =null
    if(p.isInstanceOf[Student])s=p.asInstanceOf[Student]
    p.isInstanceOf[Person]
    p.getClass()==classOf[Person]
    p.getClass()==classOf[Student]
    p match {
      case per:Person=>println("it's Person's object")
      case _=>println("unknown type")
    }
  }
}

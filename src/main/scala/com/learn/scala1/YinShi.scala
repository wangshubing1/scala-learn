package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object YinShi {

  class SpecialPerson(val name :String)
  class Student(val name :String)
  class Olderman(val name :String)
  implicit def object2SpecialPerson(obj:Object):SpecialPerson={
    if(obj.getClass==classOf[Student]){
      val stu=obj.asInstanceOf[Student]
      new SpecialPerson(stu.name)
    }else if (obj.getClass==classOf[Olderman]){
      val old=obj.asInstanceOf[Olderman]
      new SpecialPerson(old.name)
    }else null
  }

  var ticketNumber = 0
  def buySpecialTicket(p:SpecialPerson)={
    ticketNumber += 1
    println("T-"+ticketNumber)
  }

  class TicketHouse{
    var ticketNum =0
    def buyTicke(p:SpecialPerson)={
      ticketNum += 1
      println("tt-"+ticketNum)
    }
  }
  //使用隐式转换加强现有类型
  class Man(val name :String)
  class SuperMan(val name :String){
    def emitLaser=println("emit a laster!")
  }

  implicit def man2superman(man: Man):SuperMan=new SuperMan(man.name)

  //隐式参数
  class SignPen{
    def write(content:String)=println("content is: "+content)
  }
  implicit val signPen= new SignPen
  def signForExam(name:String)(implicit signPen: SignPen): Unit ={
    signPen.write(name +" come to exam in time")
  }


  def main(args: Array[String]): Unit = {
    val leo =new Student("leo")
    val jcak =new Olderman("jcak")
    buySpecialTicket(leo)
    buySpecialTicket(jcak)
    //使用隐式转换加强现有类型
    val jen =new Man("leo")
    jen.emitLaser

    val ticketHouse =new TicketHouse
    ticketHouse.buyTicke(leo)

    signForExam("sb")
  }

}

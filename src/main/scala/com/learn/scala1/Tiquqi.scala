package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *  提取器就是一个包含unapply方法的对象，与apply相反
  *  apply:接收一堆参数构造出来的对象
  *  unapply:接收一个字符串，解析出对象的属性值
  *
  */
object Tiquqi {
  class Person(val name:String,val age:Int)

  object Person{
    def unapply(str:String)={
      val splitIndex =str.indexOf("")
      if(splitIndex == -1) None
      else Some((str.substring(0,splitIndex),str.substring(splitIndex +1)))
    }
  }
  val Person(name,age) = "leo 25"
  //name
  //age
}

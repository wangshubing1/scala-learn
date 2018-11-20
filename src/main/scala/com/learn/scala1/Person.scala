package com.learn.scala1

//scala中子类可以覆盖父类的val field，而且子类的val field还可以覆盖父类的val field的getter方法;只要在子类中使用override关键字即可
class Person {
  val name :String ="person"
  def age:Int=0
}

class Student extends Person{
  override val name:String="wang"
  override val age:Int=20
}

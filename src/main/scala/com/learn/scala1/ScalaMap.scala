package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object ScalaMap {
  def main(args: Array[String]): Unit = {
    //创建一个不可变的Map
    val ages =Map("sb"->24,"db"->25,"cb"->26)
    print(ages("sb"))
    //创建一个可变的Map
    val age =scala.collection.mutable.Map("sb"->14,"db"->15,"cb"->16)
    age("sb") = 18
    //使用另外一种方式定义Map元素
    val ages1=Map(("sb",24),("db",25),("cb",16))
    //创建一个空的HashMap
    val ages2 = new scala.collection.mutable.HashMap()
    //为list中每一个元素添加一个前缀
    val list1 =List("leo","jen","peter","jack")
    val list2= list1.map("name is ："+_)
    //faltMap:将List中多行句子拆分为单词
    val list3 =List("hello world","I'm wangshubing ","you are sb")
    val list4= list3.flatMap(_.split(" "))
    println(list4)
    //foreach:打印List中每个单词
    list1.foreach(println(_))
    //zip:对学生姓名和学生成绩进行关联
    val list5 =List(110,120,95,86)
    val list6=list1.zip(list5)
    println(list6)
  }

}

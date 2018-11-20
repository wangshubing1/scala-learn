package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object ListTest {
  def main(args: Array[String]): Unit = {
    //List代表一个不可变的列表
    //创建一个List
    val list =List(1,2,3,4)

    //List 有head和tail，head代表List第一个元素，tail代表第一个元素之后的所有元素
    println(list.head)
    println(list.tail)
    //List有特殊的::操作符，可以用于将head和tail合并成一个List，0::list
    val list2=0::list
    decorator(list2,"#")
    //用递归函数来给List中每个元素都加上指定前缀并打印
    //如果一个list只有一个元素那么他的head就是这个元素，他的tail是nil nil相当于java中null
    def decorator(l:List[Int],prefix:String): Unit ={
      if(l!=Nil){
        println(prefix+l.head)
        decorator(l.tail,prefix)
      }
    }
  }
}

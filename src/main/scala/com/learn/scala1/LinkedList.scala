package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object LinkedList {
  def main(args: Array[String]): Unit = {
    //LinkedList代表一个可变的列表,使用elem可以引用其头部，使用next可以引用其尾部
    val ll =scala.collection.mutable.LinkedList(1,2,3,4,5,6,7,8,9,10)
    println(ll.elem)
    println(ll.next)
    //使用while循环将列表中每个元素都乘以2
    var currentList =ll

    while(currentList!=Nil){
      currentList.elem=currentList.elem*2
      currentList=currentList.next
    }

    //使用while循环将列表中每隔一个元素都乘以2
    var first=true
    while(currentList!=Nil&&currentList.next!=Nil){
      if(first){currentList.elem=currentList.elem*2
      first=false
      }
      currentList=currentList.next.next
      if(currentList!=Nil)currentList.elem=currentList.elem*2
    }
  }
}

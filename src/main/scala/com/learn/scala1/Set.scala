package com.learn.scala1

import scala.collection.mutable

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object Set {
  def main(args: Array[String]): Unit = {
    //set代表一个没有重复元素的集合
    //将重复元素加入set是没用的，比如 val s= Set(1,2,3);s+1;s+4
    //而且set是不保证插入顺序的，也就是说set是无序的
    val s = new mutable.HashSet[Int]();
    s+=1;s+=2;s+=5
    //LinkedHashSet会用一个链表维护插入顺序
    val i = new mutable.HashSet[Int]();
    i+=1;i+=2;i+=5
    //SortedSet会自动根据key来进行排序
    val s1 = mutable.SortedSet("orange","apple","banana");
  }
}

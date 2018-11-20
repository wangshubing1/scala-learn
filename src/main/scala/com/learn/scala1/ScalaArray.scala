package com.learn.scala1

import scala.collection.mutable.ArrayBuffer

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object ScalaArray {
  def main(args: Array[String]): Unit = {
    val a =Array(1,7,45,56,32,15,6,9,5)
    val b =ArrayBuffer("ni","shi","shui","name","age")
    a.update(3,72)
    b +="scala"
    b +=("studay","test")
    b ++=Array("db","cb")
    for(i<-0 until a.length)
      print(a(i)+"\t")
    println()
    b.insert(2,"sb")
    //增强for循环遍历
    for(e<-b)
      print(e+"\t")
    println()
    //a.toBuffer
    //b.toArray
    for(i<-0 until (a.length,2))
      print(a(i)+"\t")
    println()
    val sum=a.sum
    print(sum+"\n")
    println()
    val max=a.max
    print(max+"\n")
    scala.util.Sorting.quickSort(a)
    print(a.mkString(" ")+"\n")
    print(a.mkString("("," ",")")+"\n")
    for(ele<-a)yield  ele*ele

    val c =ArrayBuffer[Int]()
    c += (1,5,-1,-6,6,-3,-9,3,7,-8)
    var foundFirstNegative = false
//    var arrayLength = c.length
//    var index = 0
//    while(index < arrayLength){
//      if(c(index) >= 0){
//        index += 1
//      }else{
//        if(!foundFirstNegative){foundFirstNegative = true;index += 1}
//        else{c.remove(index); arrayLength -= 1}
//      }
//    }
//    println("????"+c)
  val keepindex =for(i<- 0 until c.length if !foundFirstNegative|| c(i)>=0)yield {
    if (c(i)<0)foundFirstNegative=true;i

  }
    println(keepindex)
    for (i <- 0 until keepindex.length) {
      c(i) = c(keepindex(i))
    }
    println(c.length)
    println(keepindex.length)
    println(c)
    c.trimEnd(c.length - keepindex.length)
    println(c)
  }
}

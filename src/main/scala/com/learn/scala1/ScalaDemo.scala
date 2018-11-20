package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object ScalaDemo {
  def main(args: Array[String]): Unit = {
    /*printf("hello, my name is %s\nI'm %d years old", "wangshubing", 26)
    val n = 6;
    for (i <- 1 to n) print(i + " ")*/
    /*
    * 打印九九乘法表
    */
//    for(i<-1 to 9;j<-1 to i){
//      print(j+ " x "+i+" = "+(i*j) + "\t")
//      if(i==j)println()
//    }
    var i =1
    while (i<=9){
      var j = 1; while(j<=i){
        print(j+ " x "+i+" = "+(i*j) + "\t");j+=1
      }
      println()
      i+=1
    }
    //取20以内的偶数
    for(i<-1 to 20 if i % 2==0)print(" "+i)
    //取20以内的奇数
    for(i<-1 to 20 if i % 2==1)print(" "+i)
    //for推导式：构造集合
    for(i<-1 to 10) yield i
  }
}

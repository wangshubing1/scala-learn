package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object AutomaticLicensing {

  def pukepai(): Unit ={
    val huase =Array("♠", "♦", "♣", "♥")
    val dianshu=Array("2", "3", "4", "5", "6", "7", "8", "9", "10", "J","Q","K", "A")
    val pai = scala.collection.mutable.ArrayBuffer[String]()
    for (i <- 0 to huase.length-1) {
      for ( j <- 0 to dianshu.length-1) {
        pai+=(huase(i)+dianshu(j))
      }
    }
    println("生成扑克：")
    for (i <- 0 to pai.length-1) {
      print(" "+pai(i))
      //print()
    }
    println()
    //生成发牌随机数
    val shu = scala.collection.mutable.ArrayBuffer[Int]()
    var mm=(new scala.util.Random).nextInt(pai.length)
    shu+=mm
    while (shu.length<pai.length){
      var mm1=(new scala.util.Random).nextInt(pai.length)
      var a=0
      for (i <- shu){
        if (i==mm1){
          a=a+1
        }
      }
      if (a==0) shu+=mm1
    }
    println("发牌随机数索引：")
    for (i <- shu) {
      print(" " + i)
    }
    println()
    println("甲：")
    for (i <- 0 to pai.length){
      if (i<=12) print(pai(shu(i)))
    }
    println()
    println("乙：")
    for (i <- 0 to pai.length){
      if (i<=25 && i>12) print(pai(shu(i)))
    }
    println()
    println("丙：")
    for (i <- 0 to pai.length){
      if (i<=38 && i>25) print(pai(shu(i)))
    }
    println()
    println("丁：")
    for (i <- 0 to pai.length){
      if (i<=51 && i>38) print( pai(shu(i)))
    }
  }

  def main(args: Array[String]): Unit = {
    pukepai()
  }



}

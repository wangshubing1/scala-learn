package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object scalaMain {
  def sayHello(name:String,age:Int): Unit ={
    println("def：关键字\nsayHello：函数名\nname：参数名\nString：参数类型\nUnit：函数返回类型\n{}：函数体")
  }
  //斐波那契数列
  def fab(n:Int):Int = {
    if(n <= 1)1
    else fab(n-1)+fab(n-2)
  }

  def main(args: Array[String]): Unit = {
    sayHello("wang",26)
    println(fab(10))
    println(sum(1,2,3,4,5,6))
    println(sum2(1,2,3,4,5))
    for(i<-1 to 3;from =4-i;j<-from to 3) print((10*i+j)+" ")
    import scala.util.control.Breaks._
    breakable{
      var n=10
      for (c<-"Hello World"){
        if(n==5)break;
        print(c)
        n-=1
      }
    }
  }
  //变长参数
  def sum(nums:Int*):Int={
    var result =0
    for(num<- nums){
      result +=num
    }
    result
  }
  def sum2(nums:Int*):Int ={
    if (nums.length == 0)0
    else nums.head+sum2(nums.tail:_*)
  }
  def sayHello(firstName:String,middleName:String="sb",lastName:String="db")=firstName+" "+middleName+" "+lastName

}

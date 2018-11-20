package com.learn.scala1

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object Tongji {
  def main(args: Array[String]): Unit = {
    //使用scala的IO包将文本文件的数据读取出来
    val line1=scala.io.Source.fromFile("C://Users//zy//Desktop//c.txt").mkString//文件路径d

    val line2=scala.io.Source.fromFile("C://Users//zy//Desktop//d.txt").mkString
    //使用List的伴生对象，将多个文件内的内容创建一个List
    val lines =List(line1,line2)
    //读取出来应该是一个List比如List("gfhdf gh yut dgfh","et6 fegf fds dfsa")

    println(lines.flatMap(_.split(" ")).map((_,1)).map(_._2).reduceLeft(_+_))
    //将List按照空格切割就会形成一个新的list比如：list(gfhd hfkj asdh hdgk sdbhk 766 hfk)
    //.map((_,1))意思就是形成一个个Tuple格式比如（sghd,1）(gdfhj,1)
    //.map(_._2)意思就是将前面的Tuple中后面的元素提取出来比如形成(1)(1)(1)
    //reduceLeft(_+_)意思就是从左边加起，第一个1加上第二个1之后再与第三个相加依次类推
  }
}

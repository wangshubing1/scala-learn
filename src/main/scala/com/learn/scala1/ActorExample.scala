package com.learn.scala1

import scala.actors.Actor

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object ActorExample {
  class HelloActor extends Actor{
    def act(): Unit ={
      while (true){
        receive{
          case name:String=>println("hello,"+name)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val helloActor =new HelloActor
    helloActor.start()
    helloActor ! "wangshubing"
  }
}

package com.learn.scala1

import scala.actors.Actor

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object Telephone {
  case class Message (content:String,sender:Actor)
  class LeoActor extends Actor {
    def act(): Unit ={
      while (true){
        receive{
          case Message(content,sender)=>{println("leo: "+content)
            sender ! "I'm jack,please call me after 10 minutes."}

        }
      }
    }
  }
  class JackActor(val leoActor: Actor) extends Actor {
    def act(): Unit ={
      //"!"固定写法，Actor中发消息时使用
     leoActor ! Message("Hello, jack ,I'm leo.",this)
      while (true){
        receive {
          case response: String =>
            println("jack: " + response)

        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val leo =new LeoActor
    val jack=new JackActor(leo)
    leo.start()
    jack.start()
  }
}

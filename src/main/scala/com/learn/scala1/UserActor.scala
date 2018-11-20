package com.learn.scala1

import scala.actors.Actor
object Actor1{
  case class Login (username:String,password:String)
  case class Register (username:String,password:String)
  class UserActor extends Actor {

    def act(): Unit ={
      while (true){
        receive{
          case Login(username,password)=>println("login,"+username +" : "+password )
          case Register(username,password)=>println("register,"+username +" : "+password )
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val userActor =new UserActor
    userActor.start()
    userActor ! Register("LEO","123")
    userActor ! Login("leo","123")
  }
}




package com.learn.scala1

import java.awt.event.{ActionEvent, ActionListener}

import javax.swing.{JButton, JFrame}

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object Sam {

  /**
    * 在Scala中，要某个函数做某件事时，会传一个函数参数给它。
    * 而在Java中，并不支持传送参数。通常Java的实现方式是将动作放在一个实现某接口的类中，
    * 然后将该类的一个实例传递给另一个方法。很多时候，这些接口只有单个抽象方法（single abstract method），
    * 在Java中被称为SAM类型。
    * @param args
    */
  def main(args: Array[String]): Unit = {
    var count = 0


    val frame = new JFrame("SAM Testing")
    val button = new JButton("Increment")
    //java方式
    //    button.addActionListener(new ActionListener {
    //      override def actionPerformed(event: ActionEvent) {
    //        count += 1
    //        println(count)
    //      }
    //    })

    /**
      * scala方式: 隐式转换,将一种类型自动转换成另外一种类型，是个函数。
      * 因为在Scala中，函数是头等公民，所以隐式转换的作用也大大放大了。
      * 将这个函数和界面代码放在一起，就可以在所有预期ActionListener对象的地方，传入(ActionEvent)=>Unit函数参数。
      * @param action
      * @return
      */
    implicit def makeAction(action: (ActionEvent) => Unit) =
      new ActionListener {
        override def actionPerformed(event: ActionEvent) { action(event) }
      }

    button.addActionListener((event: ActionEvent) => {count += 1; println(count)})

    frame.setContentPane(button)
    frame.pack()
    frame.setVisible(true)
  }
}

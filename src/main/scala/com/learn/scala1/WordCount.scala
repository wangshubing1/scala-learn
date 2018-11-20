package com.learn.scala1

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Author: king
  * @Datetime: 2018/11/2 
  * @Desc: TODO
  *
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("WordCount")
    conf.setMaster("local")
    val sc = new SparkContext(conf)
    //将文件中的数据加载到linesRDD中
    val linesRDD = sc.textFile("wc", 3);
    //每一行数据根据空格来分割单词，使用map flatMap
    val wordsRDD = linesRDD.flatMap { line => line.split(" ") }
    /**
      * 要将每一个单词计数为1
      * wordsRDD是个非kv格式的RDD，需要变成一个KV格式的RDD
      * 在javaAPI中返回kv格式的RDD 必须使用mapToppair
      *
      * pairRDD<String,Integer> K:每一个单词，V：1
      */
    val pairRDD = wordsRDD.map { word => (word, 1) }
    /**
      * 使用reduceByKey进行聚合操作
      * groupByKey将相同的key分到一个组里面去，然后通过传入的函数对组内的数据进行聚合
      */
    val resultRDD = pairRDD.reduceByKey(_ + _)
    val switch1 = resultRDD.map(v => (v._2, v._1))
    val sort = switch1.sortByKey()
    val switch2 = sort.map(v => (v._2, v._1))
    switch2.foreach(wordNumberPair => println(wordNumberPair._1 + ":" + wordNumberPair._2))
    sc.stop()
  }
}

package com.sparkdemo.rdd

import org.apache.spark.{SparkConf, SparkContext}

object RDDDemo {
  def main(args: Array[String]): Unit = {
    var input = "src/resources/posts.csv"
    var output = "src/resources/rdd_result.csv"
    var master = "local[*]"

    if (args.length >= 2) {
      master = "yarn"
      input = args(0)
      output = args(1)
    }

    val conf = new SparkConf()
      .setMaster(master)
      .setAppName("Spark Demo")
      .set("spark.hadoop.validateOutputSpecs", "False")

    val sc = new SparkContext(conf)

    val data = sc.textFile(input)

    val head = data.first()

    val results = data
      .filter(line => line != head)
      .map(line => {
        val col = line.split("\t")
        val date = col(3).substring(0, 10)
        (date, 1)
      })
      .reduceByKey(_ + _)

    results.saveAsTextFile(output)
  }
}

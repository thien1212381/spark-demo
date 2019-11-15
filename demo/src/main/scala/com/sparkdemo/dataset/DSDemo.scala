package com.sparkdemo.dataset

import org.apache.spark.sql.{SaveMode, SparkSession}

object DSDemo {
  case class Post(id: String, userId: String, title: String, date: String)

  def main(args: Array[String]): Unit = {
    var input = "src/resources/posts.csv"
    var output = "src/resources/ds_result.csv"
    var master = "local[*]"

    if (args.length >= 2) {
      master = "yarn"
      input = args(0)
      output = args(1)
    }

    val spark = SparkSession
      .builder()
      .appName("Spark Data Set Demo")
      .master(master)
      .getOrCreate()

    import spark.implicits._

    val ds = spark.read
      .option("header", "true")
      .option("delimiter", "\t")
      .csv(input)
      .toDF("id", "userId", "title", "date")
      .as[Post]

    ds.groupByKey(post => post.date.substring(0, 10)).mapGroups {
      case (date, values) => {

        val count = values.length

        (date, count)
      }
    }
      .toDF("date", "count")
      .repartition(1)
      .write.option("header", "true").mode(SaveMode.Overwrite).csv(output)
  }
}

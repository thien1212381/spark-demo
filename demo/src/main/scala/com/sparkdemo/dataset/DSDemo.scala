package com.sparkdemo.dataset

import org.apache.spark.sql.{SaveMode, SparkSession}

object DSDemo {
  case class Post(id: String, userId: String, content: String, date: String)

  def main(args: Array[String]): Unit = {
    var input = "src/resources/posts.csv"
    var output = "src/resources/ds_result.csv"

    if (args.length == 3) {
      input = args(1)
      output = args(2)
    }

    val spark = SparkSession
      .builder()
      .appName("Spark Data Set Demo")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    val ds = spark.read
      .option("header", "true")
      .csv(input)
      .toDF("id", "userId", "content", "date")
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

package com.sparkdemo.dataframe

import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.functions._

object DFDemo {
  def main(args: Array[String]): Unit = {
    var input = "src/resources/posts.csv"
    var output = "src/resources/df_result.csv"
    var master = "local[*]"

    if (args.length >= 2) {
      master = "yarn"
      input = args(0)
      output = args(1)
    }

    val spark = SparkSession
      .builder()
      .appName("Spark Data Frame Demo")
      .master(master)
      .getOrCreate()

    spark.read
      .option("header", "true")
      .option("delimiter", "\t")
      .csv(input)
      .toDF("id", "user_id", "title", "created_at")
      .withColumn("date", substring(col("created_at"), 0, 10))
      .groupBy(col("date"))
      .count()
      .repartition(1)
      .write.mode(SaveMode.Overwrite).option("header", "true").csv(output)
  }
}

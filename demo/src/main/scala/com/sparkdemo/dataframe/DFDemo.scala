package com.sparkdemo.dataframe

import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.functions._

object DFDemo {
  def main(args: Array[String]): Unit = {
    var input = "src/resources/posts.csv"
    var output = "src/resources/df_result.csv"

    if (args.length == 3) {
      input = args(1)
      output = args(2)
    }

    val spark = SparkSession
      .builder()
      .appName("Spark Data Frame Demo")
      .master("local[*]")
      .getOrCreate()

    spark.read
      .option("header", "true")
      .option("delimiter", "\t")
      .csv(input)
      .withColumn("date", substring(col("created_at"), 0, 10))
      .groupBy(col("date"))
      .count()
      .repartition(1)
      .write.mode(SaveMode.Overwrite).option("header", "true").csv(output)
  }
}

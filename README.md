
# Spark Hands-On 
## Objectives
- Understand about how to execute one spark job
- Using Spark RDD, DF, DS to solve problem
- Run one spark application in local machine, in yarn mode.

## Problem
- We have a table contains post informations of Stackoverflow's users
- Count number of posts each day
- Input:

| id |owner_id  |title|created_at
|--|--|--|--
| 57743415 | 11435841 |How to play one mp4 video in MacOs|2019-09-01T05:23:51.327
|57743416|4687359|Copy Bower components' css, js and scss into another directory with Gulp|2019-09-01T05:23:41.240
|57743417|5935710|Excel VBA QueryTable for new connection to Access db|2019-09-02T07:12:40.345

- Expected Output:
 
| date |count
|--|--
| 2019-09-01 | 2
| 2019-09-02 | 1

## Requirements
- Install [Java 8 & IntelliJ](https://github.com/TranHuuBao/mapreduce-demo/blob/master/setup-env.md)
- Install [Scala + Sbt](https://github.com/thien1212381/spark-demo/blob/master/scala_sbt_installation.md)
- Install [Spark](https://github.com/thien1212381/spark-demo/blob/master/spark_installation.md)
- Install [Hadoop - Yarn](https://github.com/vinhdangphuc/hands-on/blob/master/hands-on/hadoop.md) (for yarn mode)


## Source
- We was develop a simple project spark application for demo. You need to clone it and build for your exercise.
``` git clone https://github.com/thien1212381/spark-demo.git ```
- In folder demo
``` cd demo ```
- We have :
    - **build.sbt**: It contains dependencies for this project
    - **src/main/scala/com/sparkdemo/rdd/RDDDemo.scala**:  Spark rdd demo
    - **src/main/scala/com/sparkdemo/dataframe/DFDemo.scala**:  Spark data frame demo
    - **src/main/scala/com/sparkdemo/dataset/DSDemo**:  Spark data set demo
    - **src/resources/posts.csv**: sample posts data

## Run application
### Run on IntelliJ IDE 
In IntelliJ IDE, on toolbar click ```File -> Open -> $path-to-project/demo```

**Wait some minutes for sbt sync external libraries**

In order to execute the application, right-click on the script and choose run

### Run with spark submit
#### Build excutable jar
- Open terminal and run below command 
```> cd $path-to-project/demo```
```> sbt```
*sbt*: will download dependencies was configured in build.sbt
```> package```
*package*:  build excutable jar

#### Copy excutable jar file to server
- After export jar file we need to copy it to server for run example
- In ubunu or Mac OS you  can use *scp* with command
	``` >	scp $path-to-project/demo/target/scala-2.11/spark-demo_2.11-0.1.jar user@ip-server: $path-folder-on-server ```

- In windows you can follow [link](https://success.tanaza.com/s/article/How-to-use-SCP-command-on-Windows)

#### Run on server
- connect to server: run command:
	```> ssh user@ip-server```
- Check input data:
``` > hdfs dfs -ls /data/spark-demo/input ```
- Submit job by command in server with [spark-submit](https://spark.apache.org/docs/latest/running-on-yarn.html) command
- Example:
  
```
$SPARK_HOME/bin/spark-submit \
    --class com.sparkdemo.df.RDDDemo \
    --master yarn \
    --deploy-mode cluster \
    spark-demo_2.11-0.1.jar /data/spark-demo/input/posts.csv /data/spark-demo/output/rdd_result
```

**--master yarn** : run spark application in yarn mode

**--deploy-mode cluster** : run spark application in cluster deploy mode

**--class com.sparkdemo.rdd.RDDDemo** : is class we want to run

**spark-demo_2.11-0.1.jar** : is excutation jar

**/data/spark-demo/input/posts.csv** and **/data/spark-demo/output/df_result** : args of a spark application, here are input and output.

## Result
- Check result : 
	```
	> /data/spark-demo/output/df_result/*
	 ```
- Expect result example:
    ```
    2019-09-01  2
    2019-09-02  1 
    ```

## Exercise


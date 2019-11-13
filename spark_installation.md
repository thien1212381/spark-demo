# Apache Spark - installation

## Requirement

- [Install Java](https://github.com/vinhdangphuc/hands-on/blob/master/hands-on/java.md)
- [Install Scala](https://github.com/thien1212381/spark-demo/blob/master/scala_installation.md)

## Install
### MacOS
- Install by Homebrew
```
brew update
brew install apache-spark
```
- The installation directory would be **/usr/local/Cellar/apache-spark**
- Verify by command: **spark-shell**
### Windows
- Download Apache Spark package in [homepage](https://spark.apache.org/downloads.html), with package type is "Pre-built for Apache Hadoop"
- Once the download is completed unzip the file to directory
```
C:\Users\<USER>\Spark
```
- In this directory, go to **conf** folder, rename .template extension of all .template files.
- Configure path: 
    - Control panel -> System and Security -> System -> Advanced Settings -> Environment Variables
    - Add below new user variable, with Variable name is **SPARK_HOME**, and Variable value is **C:\Users\<USER>\Spark**
    - Edit **path** variable, add **%SPARK_HOME%\bin**
- To verify installation: Open command line and type **spark-shell**
### Linux systems
- Download the Apache Spark [package](https://spark.apache.org/downloads.html) to machine
```
cd /opt
wget https://www.apache.org/dyn/closer.lua/spark/spark-2.4.4/spark-2.4.4-bin-hadoop2.7.tgz
```
- Unzip
```
tar -xvzf spark-2.4.4-bin-hadoop2.7.tgz
```
- Setup environment
```
echo "export PATH=$PATH:/opt/spark-2.4.4-bin-hadoop2.7/bin" >> ~/.bashrc
echo "export SPARK_HOME=/opt/spark-2.4.4-bin-hadoop2.7" >> ~/.bashrc
source ~/.bashrc
```
- Start a standalone master server. You can browse to http://127.0.0.1:8080/ to view status screen
```
$SPARK_HOME/sbin/start-master.sh
```
- Type **spark-shell** to test installation
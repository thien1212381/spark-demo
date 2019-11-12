# Scala installation

## Requirement

- [Install Java](https://github.com/vinhdangphuc/hands-on/blob/master/hands-on/java.md)

## Install
### MacOS
- Install by Homebrew
```
brew update
brew install scala
```
- Install by SDKMan
```
sdk install scala
```
### Ubuntu
```
sudo apt-get update
sudo apt-get install scala
```
### Centos
- Update yum
```
sudo yum update -y
```
- Install scala
```
cd ~
wget http://downloads.lightbend.com/scala/2.11.8/scala-2.11.8.rpm
sudo yum install scala-2.11.8.rpm
```
### Windows
- Download Scala Binaries from https://www.scala-lang.org/download/, The Scala installer file will be downloaded with .msi extension
- Double Click or Open scala-2.11.8.msi file and select Run. The Setup Wizard appears, click on Next and complete the installation process. Scala installer will set the Path environment variable too, so that you can run it from anywhere.
- Check scala shell with **scala -version** in the command prompt.
### Linux systems
- Download the Scala binaries to machine
```
cd /opt
wget https://downloads.lightbend.com/scala/2.11.8/scala-2.11.8.tgz
```
- Unzip
```
tar -xvzf scala-2.11.8.tgz
```
- Setup environment
```
echo "export PATH=$PATH:/opt/scala-2.11.8/bin" >> ~/.bashrc
source ~/.bashrc
```
- Check Scala version
```
scala -version
```

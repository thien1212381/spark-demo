# Sbt installation

## What is sbt
sbt is an open-source, cross-platform build tool for Scala and Java projects. 
[More information](https://www.scala-sbt.org)

## Requirement

- [Install Java](https://github.com/vinhdangphuc/hands-on/blob/master/hands-on/java.md)

## Install
### MacOS
- Install by Homebrew
```
brew update
brew install sbt
```
- Install by SDKMan
```
sdk install sbt
```
### Ubuntu
```
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
sudo apt-get update
sudo apt-get install scala
```
### Centos
```
curl https://bintray.com/sbt/rpm/rpm | sudo tee /etc/yum.repos.d/bintray-sbt-rpm.repo
sudo yum update -y
sudo yum install sbt
```
### Windows
- Download [msi installer](https://piccolo.link/sbt-1.3.3.msi) and install it
### Linux systems
- Download the sbt package to machine
```
cd /opt
wget https://piccolo.link/sbt-1.3.3.tgz
```
- Unzip
```
tar -xvzf sbt-1.3.3.tgz
```
- Setup environment
```
echo "export PATH=$PATH:/opt/sbt-1.3.3/bin" >> ~/.bashrc
source ~/.bashrc
```
- Run sbt shell
```
sbt
```
- Exit sbt shell
```
sbt> exit
```
### Intellij IDE
- In IntelliJ IDE, Reference -> Plugins. Install Scala plugin. It contains also sbt.
- File -> New Project -> Scala -> SBT based. IntelliJ will generate basic build.sbt, download necessary dependencies and open project.

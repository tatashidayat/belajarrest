# Cara Install Java 8 di Ubuntu

## Buka Terminal, ketik :
```sh
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
sudo apt-get install oracle-java8-set-default
```
Ketik ini, untuk mengecek versi java
```sh
java -version
```

Berikut hasilnya:
```sh
java version "1.8.0_171"
Java(TM) SE Runtime Environment (build 1.8.0_171-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.171-b11, mixed mode)
```
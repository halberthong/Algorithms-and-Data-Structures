#!/bin/bash
javac AvlTree.java
javac -cp .:../JAR/junit-4.12.jar JunitTest.java
java -cp .:../JAR/junit-4.12.jar:../JAR/hamcrest-core-1.3.jar org.junit.runner.JUnitCore JunitTest

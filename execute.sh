#!/bin/bash

javac -cp .:JAR/junit-4.10.jar JunitTest.java
java Arrays_and_Strings
java -cp .:JAR/junit-4.10.jar:JAR/hamcrest-core-1.3.jar org.junit.runner.JUnitCore JunitTest

#!/bin/bash


javac -d "../../classes" -cp "../../classes" Parameter.java
javac -d "../../classes" -cp "../../classes" Function.java
javac -d "../../classes" -cp "../../classes" Symbol.java
javac -d "../../classes" -cp "../../classes" Data.java
javac -d "../../classes" -cp "../../classes" AlphaVantageAPIConnector.java
javac -d "../../classes" -cp "../../classes:../../lib/gson-2.8.6.jar" GlobalQuote.java
javac -d "../../classes" -cp "../../classes" QuoteEndpoint.java
javac -d "../../classes" -cp "../../classes" App.java


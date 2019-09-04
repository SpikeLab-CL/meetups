#!/bin/bash
mvn -f demo/pom.xml clean
mvn -f demo/pom.xml package
docker build -t demo-app-h2o .
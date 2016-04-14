#!/bin/bash

pushd jacoco
javac -classpath jacoco-core.jar:jacoco-report.jar org/jacoco/examples/ReportGenerator.java

java -classpath .:jacoco-report.jar:jacoco-core.jar:asm-all-4.0.jar org.jacoco.examples.ReportGenerator ../build/
popd

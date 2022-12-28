#!/bin/bash

touch rfc4180ParserA10.csv
touch rfc4180ParserA50.csv
touch rfc4180ParserS10.csv
touch rfc4180ParserS50.csv
touch csvParserA10.csv
touch csvParserA50.csv
touch csvParserS10.csv
touch csvParserS50.csv

MEMORY_OPTS="-Xms256m -Xmx512m -XX:MaxMetaspaceSize=256m"

GC_OPTS="-XX:+UseG1GC -Xlog:gc:target/gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=target/java_pid<pid>.hprof -XX:+UseGCOverheadLimit"

JAR_NAME="target/csv-performance-0.5-SNAPSHOT.jar"

java -jar $MEMORY_OPTS $GC_OPTS $JAR_NAME

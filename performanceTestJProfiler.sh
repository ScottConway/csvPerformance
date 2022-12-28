#!/bin/bash

MEMORY_OPTS="-Xms384m -Xmx768m -XX:MaxMetaspaceSize=256m"

GC_OPTS="-XX:+UseG1GC -Xlog:gc:target/gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=target/java_pid<pid>.hprof -XX:+UseGCOverheadLimit"

JAR_NAME="target/csv-performance-0.5-SNAPSHOT.jar"

JPROFILER_OPTS="-Xshare:off"

java -jar $MEMORY_OPTS $GC_OPTS $JPROFILER_OPTS $JAR_NAME

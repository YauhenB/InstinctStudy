#/bin/sh

java  -Xms2M -Xmx18M -XX:+UseConcMarkSweepGC -XX:ParallelGCThreads=2 -XX:NewSize=1M -XX:PermSize=24M -XX:MaxPermSize=36M $1

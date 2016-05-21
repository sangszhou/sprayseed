#!/usr/bin/env bash

for host in bgl-fb{01,02,03,04,05,06,07,08,09,10}
do
    ssh vdeadmin@$host '
        echo "$host"
        echo `java -version`
        echo `/sbin/ifconfig eth0 | grep "inet addr" | sed 's/^.*addr://g'| sed 's/Bcast.*//g'`
    '
done
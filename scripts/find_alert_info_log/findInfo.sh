#!/usr/bin/env bash

#SOAHOST={1..4}

for host in icam-dev-soa-0{1..4}
do
    echo $host

    ssh -q vdeadmin@icam-dev-app1 "
        echo $host
    "
done

#Bash 变量替换

#for i in icam-dev-soa-0{1..3};do
#    ssh -q $i " grep -i $error /apps/icam/soa/soa-current/logs/err:
#done
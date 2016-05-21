#!/usr/bin/env bash

for host in bgl-fb{01,02,03,04,05,06,07,08}
do
    ssh vdeadmin@$host '
        echo `hostname`
        ps -ef | grep jmeter
    '
done
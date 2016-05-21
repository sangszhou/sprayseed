#!/usr/bin/env bash

for host in bgl-fb{01,02}
#,{03,04,05,06,07,08}
do
    echo "$host"
#    scp ~/Downloads/apache-jmeter-2.13.zip vdeadmin@$host:/home/vdeadmin

    ssh vdeadmin@$host '
        cd /home/vdeadmin
#        unzip apache-jmeter-2.13.zip
        cd apache-jmeter-2.13/bin

        chmod 777 *
        ./jmeter-server 1>/dev/null 2>/dev/null &
'
done
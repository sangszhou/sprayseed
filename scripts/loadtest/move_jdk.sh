#!/usr/bin/env bash

for host in bgl-fb{03,04,05,06,07,08,09,10}
do
    echo "$host"

    scp ~/Downloads/jdk-8u77-linux-x64.tar.gz vdeadmin@$host:/home/vdeadmin

    ssh vdeadmin@$host '
        cd /home/vdeadmin
        tar zxvf jdk-8u77-linux-x64.tar.gz
        JAVA_HOME_DIR=/home/vdeadmin/jdk1.8.0_77
        PATH_DIR=/home/vdeadmin/jdk1.8.0_77/bin:$PATH

        BASH_PATH=/home/vdeadmin/.bashrc

        echo "JAVA_HOME=$JAVA_HOME_DIR" >> $BASH_PATH
        echo "PATH=$PATH_DIR" >> $BASH_PATH

        source $BASH_PATH
'

done

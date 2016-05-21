#!/usr/bin/env bash


while true; do
    curl localhost:9000/cal | gunzip  1>&/dev/null 2>&1
    sleep 1
done
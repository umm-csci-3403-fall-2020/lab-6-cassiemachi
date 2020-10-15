#!/bin/bash

numCalls=$1
bigFile=$2
cd src 

for((i=0; i<$numCalls; i++))
do 
   echo "Doing run $i"
   java echoserver.EchoClient <  ../$bigFile > /dev/null &

done
echo "Now waiting for all the processes to terminate"


date
wait
echo "DOne waiting. :) "
date



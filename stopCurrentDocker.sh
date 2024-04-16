#!/bin/sh
value=`cat containerhash.txt`
echo "$value"
# This will stop a runner docker container
docker stop "$value"
# This will remove the docker image
docker container rm "$value"
rm containerhash.txt
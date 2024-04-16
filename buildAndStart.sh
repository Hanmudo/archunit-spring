#!/bin/sh
# This will build a docker image
docker build -t "archunit:1.0" .
# This will run the image
docker run -p 8080:8080 -d "archunit:1.0" > containerhash.txt
value=`cat containerhash.txt`
echo "$value"
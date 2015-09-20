#! /bin/bash -e

rm -fr build
mkdir build
cp ../build/libs/arduino-0.0.1-SNAPSHOT.jar build

docker build -t iot_rest_ms .

#!/usr/bin/env bash
CURDIR=${pwd}

cd ../docker-env
docker build -t mysql-perfdb .

cd $CURDIR
#!/usr/bin/env bash

docker run --name local-mysql -p 9501:3306 -d mysql-perfdb

echo "Created mySQL database container"
echo "Container name: local-mysql - Port 9501"
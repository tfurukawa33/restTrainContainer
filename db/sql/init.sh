#!/usr/bin/env bash

#run the setup script to create the DB and the schema in the DB
mysql -u docker -pdocker sakila < "/docker-entrypoint-initdb.d/sakila-schema.sql"
mysql -u docker -pdocker sakila < "/docker-entrypoint-initdb.d/sakila-data.sql"
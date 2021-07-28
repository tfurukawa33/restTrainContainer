#!/usr/bin/env bash

#run the setup script to create the DB and the schema in the DB
mysql -u docker -pdocker sakila_test < "/docker-entrypoint-initdb.d/sakila_test-schema.sql"

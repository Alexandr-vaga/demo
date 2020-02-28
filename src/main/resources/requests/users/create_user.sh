#!/usr/bin/env bash

curl -X POST "localhost:8080/users/" \
-H "Content-Type: application/json" \
-d '{
      "username": "ololo",
      "password": "111",
      "age": 17
    }'
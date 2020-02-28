#!/usr/bin/env bash

curl -v -X POST "localhost:8080/roles/" \
-H "Content-Type: application/json" \
-d '{
      "roleRight": "READ",
      "roleType": "CUSTOMER"
    }'
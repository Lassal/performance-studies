#!/usr/bin/env bash
# Inicia servico Web que sera utilizado como server pela app perf-demo

java -jar $(ls ./perf-web-rest-api/target/perf-web-rest-api*.jar)

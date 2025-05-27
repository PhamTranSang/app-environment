#!/usr/bin/env bash
set -euo pipefail

SCRIPT_PATH="$( cd "$(dirname "$0" )" ; pwd -P)"
REPO_ROOT="$SCRIPT_PATH/.."

BUILD_DIR=".tmp.build/target"

# Ensure the ROOT_FOLDER variable exists.
if [ -z "${ROOT_FOLDER+x}" ]; then
    echo "ROOT_FOLDER variable is not set"
    exit 1
fi

# Ensure the ROOT_FOLDER folder exists.
if [ ! -d "$ROOT_FOLDER" ]; then
    echo "The ROOT_FOLDER directory '$ROOT_FOLDER' does not exist"
    exit 1
fi

echo "ROOT_FOLDER exists and points to: $ROOT_FOLDER"

# Transform to absolute path.
ROOT_FOLDER=$(cd "$ROOT_FOLDER"; pwd)

# General config.
export MAVEN_OPTS="-Xmx1g -XX:MinHeapFreeRatio=3 -XX:MaxHeapFreeRatio=5 -XX:+UseG1GC "

start_spring_boot_exec() {
    PROJECT_NAME="$1"
    DEBUG_PORT="$2"
    echo "Starting $PROJECT_NAME project"
    cd "$REPO_ROOT"
    exec "$REPO_ROOT/mvnw" --threads 1C --fail-fast -DskipTests -DbuildDir="$BUILD_DIR" -Dapp.debug.port="$DEBUG_PORT" "clean" "install" "exec:exec@start-${PROJECT_NAME}"
}

start_spring_boot_exec "environment" "8180"
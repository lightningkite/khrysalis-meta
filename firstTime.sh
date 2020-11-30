#!/bin/bash

./gradlew --configure-on-demand kotlin-compiler-plugin-common:publishToMavenLocal
./gradlew --configure-on-demand kotlin-compiler-plugin-typescript:publishToMavenLocal
./gradlew --configure-on-demand kotlin-compiler-plugin-swift:publishToMavenLocal
./gradlew --configure-on-demand plugin:publishToMavenLocal
./gradlew publishToMavenLocal

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
if [ "$KHRYSALIS_META_LOCATION" != "$DIR" ]; then
  echo "We need to set up an environment variable - KHRYSALIS_META_LOCATION - to this directory.  It will be added to ~/.profile."
  echo "export KHRYSALIS_META_LOCATION=$DIR" | tee -a ~/.profile
  source ~/.profile
fi
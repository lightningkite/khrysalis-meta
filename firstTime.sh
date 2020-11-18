#!/bin/bash

git submodule update

cd butterfly-android || exit
git checkout master
cd ..

cd butterfly-bluetooth-android || exit
git checkout master
cd ..

cd butterfly-bluetooth-ios || exit
git checkout master
cd ..

cd butterfly-fcm-android || exit
git checkout master
cd ..

cd butterfly-fcm-ios || exit
git checkout master
cd ..

cd butterfly-fcm-web || exit
git checkout master
cd ..

cd butterfly-ios || exit
git checkout master
cd ..

cd butterfly-maps-android || exit
git checkout master
cd ..

cd butterfly-maps-ios || exit
git checkout master
cd ..

cd butterfly-maps-ios-google || exit
git checkout master
cd ..

cd butterfly-maps-web-google || exit
git checkout master
cd ..

cd butterfly-maps-web-leaflet || exit
git checkout master
cd ..

cd butterfly-qr-android || exit
git checkout master
cd ..

cd butterfly-qr-ios || exit
git checkout master
cd ..

cd butterfly-web || exit
git checkout master
cd ..

cd khrysalis || exit
git checkout master
cd ..

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
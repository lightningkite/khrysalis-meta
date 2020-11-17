git submodule update


cd butterfly-android
git checkout master
cd ..

cd butterfly-bluetooth-android
git checkout master
cd ..

cd butterfly-bluetooth-ios
git checkout master
cd ..

cd butterfly-fcm-android
git checkout master
cd ..

cd butterfly-fcm-ios
git checkout master
cd ..

cd butterfly-fcm-web
git checkout master
cd ..

cd butterfly-ios
git checkout master
cd ..

cd butterfly-maps-android
git checkout master
cd ..

cd butterfly-maps-ios
git checkout master
cd ..

cd butterfly-maps-ios-google
git checkout master
cd ..

cd butterfly-maps-web-google
git checkout master
cd ..

cd butterfly-maps-web-leaflet
git checkout master
cd ..

cd butterfly-qr-android
git checkout master
cd ..

cd butterfly-qr-ios
git checkout master
cd ..

cd butterfly-web
git checkout master
cd ..

cd khrysalis
git checkout master
cd ..

./gradlew --configure-on-demand kotlin-compiler-plugin-common:publishToMavenLocal
./gradlew --configure-on-demand kotlin-compiler-plugin-typescript:publishToMavenLocal
./gradlew --configure-on-demand kotlin-compiler-plugin-swift:publishToMavenLocal
./gradlew --configure-on-demand plugin:publishToMavenLocal
./gradlew publishToMavenLocal

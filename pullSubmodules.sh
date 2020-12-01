

git submodule init
git submodule update

cd butterfly-android || exit
git checkout master
git pull
cd ..

cd butterfly-bluetooth-android || exit
git checkout master
git pull
cd ..

cd butterfly-bluetooth-ios || exit
git checkout master
git pull
cd ..

cd butterfly-fcm-android || exit
git checkout master
git pull
cd ..

cd butterfly-fcm-ios || exit
git checkout master
git pull
cd ..

cd butterfly-fcm-web || exit
git checkout master
git pull
cd ..

cd butterfly-ios || exit
git checkout master
git pull
cd ..

cd butterfly-maps-android || exit
git checkout master
git pull
cd ..

cd butterfly-maps-ios || exit
git checkout master
git pull
cd ..

cd butterfly-maps-ios-google || exit
git checkout master
git pull
cd ..

cd butterfly-maps-web-google || exit
git checkout master
git pull
cd ..

cd butterfly-maps-web-leaflet || exit
git checkout master
git pull
cd ..

cd butterfly-qr-android || exit
git checkout master
git pull
cd ..

cd butterfly-qr-ios || exit
git checkout master
git pull
cd ..

cd butterfly-web || exit
git checkout master
git pull
cd ..

cd khrysalis || exit
git checkout master
git pull
cd ..
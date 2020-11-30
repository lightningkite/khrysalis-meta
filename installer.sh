#!/bin/bash

# This installer is a quick way to get Khrysalis up and running on your computer.
# It will skip entirely if KHRYSALIS_META_LOCATION is already set.

#if [ -z "$KHRYSALIS_META_LOCATION" ]; then
  echo "Installing Khryalis and Butterfly..."
  git clone https://github.com/lightningkite/khrysalis-meta.git ~/khrysalis-meta
  echo "Clone complete."
  cd ~/khrysalis-meta || exit
  ~/khrysalis-meta/pullSubmodules.sh
  ~/khrysalis-meta/firstTime.sh
#else
#  cd $KHRYSALIS_META_LOCATION || exit
#  git checkout master
#  ./firstTime.sh
#fi
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
if [ "$KHRYSALIS_META_LOCATION" != "$DIR" ]; then
  echo "We need to set up an environment variable - KHRYSALIS_META_LOCATION - to this directory.  It will be added to ~/.profile."
  echo "export KHRYSALIS_META_LOCATION=$DIR" | tee -a ~/.profile
  source ~/.profile
fi
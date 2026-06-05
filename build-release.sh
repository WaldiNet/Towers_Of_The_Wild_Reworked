#!/bin/bash
set -euo pipefail

VERSION="${1:-X.Y.Z}"

TYPES=(derelict derelict_grass ice jungle ocean ocean_warm regular)
TOWER_DIR="data/totw_reworked/worldgen/template_pool"

VARIANTS=(
  "regular|"
  "fwaystones|fwaystones_"
  "waystones|waystone_"
)

cleanup() {
  for type in "${TYPES[@]}"; do
    if [ -f "$TOWER_DIR/$type/top.json.bak" ]; then
      mv "$TOWER_DIR/$type/top.json.bak" "$TOWER_DIR/$type/top.json"
    fi
  done
}

trap cleanup EXIT

for type in "${TYPES[@]}"; do
  cp "$TOWER_DIR/$type/top.json" "$TOWER_DIR/$type/top.json.bak"
done

for entry in "${VARIANTS[@]}"; do
  NAME="${entry%%|*}"
  PREFIX="${entry##*|}"

  echo "=== Building variant: $NAME (prefix: '$PREFIX') ==="

  for type in "${TYPES[@]}"; do
    file="$TOWER_DIR/$type/top.json"
    sed -i "s|\"totw_reworked:$type/[^\"]*\"|\"totw_reworked:$type/${PREFIX}${type}_tower_top\"|" "$file"
  done

  ARCHIVE="Towers_Of_The_Wild_Reworked-${NAME}-${VERSION}.zip"
  python3 -c "
import zipfile, os, glob

with zipfile.ZipFile('$ARCHIVE', 'w', zipfile.ZIP_DEFLATED) as zf:
    for path in ['data', 'LICENSE', 'pack.mcmeta', 'pack.png', 'README.md']:
        if not os.path.exists(path):
            continue
        if os.path.isdir(path):
            for root, dirs, files in os.walk(path):
                for f in files:
                    fp = os.path.join(root, f)
                    zf.write(fp, fp)
        else:
            zf.write(path, path)
"

  echo "Created: $ARCHIVE"
  echo "Entries: $(python3 -c "import zipfile; print(len(zipfile.ZipFile('$ARCHIVE').namelist()))")"
  echo ""

  for type in "${TYPES[@]}"; do
    mv "$TOWER_DIR/$type/top.json.bak" "$TOWER_DIR/$type/top.json"
    cp "$TOWER_DIR/$type/top.json" "$TOWER_DIR/$type/top.json.bak"
  done
done

echo "=== Done. Archives for version $VERSION ==="
python3 -c "
import os

for f in sorted(os.listdir('.')):
    if f.startswith('Towers_Of_The_Wild_Reworked-') and f.endswith('.zip'):
        size_mb = os.path.getsize(f) / (1024 * 1024)
        print(f'  {f}  ({size_mb:.2f} MB)')
"

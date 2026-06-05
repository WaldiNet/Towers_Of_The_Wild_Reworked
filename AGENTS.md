# AGENTS.md

## Project type

Minecraft Java Edition datapack (namespace `totw_reworked`). No build system, no tests, no linting.

## pack.mcmeta

`pack_format: 57` = Minecraft 1.21.2 – 1.21.3. For each new pack format, create a sub-release
rather than using overlays. Once reaching format 88.0 (1.21.9+), switch to using
`min_format`/`max_format` arrays instead of sub-releases.

## Build and release

### `build-release.sh`

Automates building all 3 variants as `.zip` archives for distribution:

```
./build-release.sh X.Y.Z
```

Iterates over all 7 tower types × 3 waystone variants, runs `sed` to swap the
`"location"` in each `top.json`, and produces 3 archives:

The `sed` call on macOS requires `-i ''` (empty backup extension); the CI workflow
(`release.yml`) runs on Linux and uses `-i` without the extra argument.
- `Towers_Of_The_Wild_Reworked-Regular-X.Y.Z.zip`
- `Towers_Of_The_Wild_Reworked-Fabric_Waystones-X.Y.Z.zip`
- `Towers_Of_The_Wild_Reworked-Waystones-X.Y.Z.zip`

Uses `python3 -c` with `zipfile` to create ZIPs from `data/`, `LICENSE`, `pack.mcmeta`,
`pack.png`, and `README.md`. Built archives are gitignored (`*.zip` in `.gitignore`).

### CI (`.github/workflows/release.yml`)

Triggered on tag push. Builds all 3 variants via a matrix strategy, uploads artifacts,
and creates a GitHub Release with `softprops/action-gh-release@v3`.

## Tower structure

7 tower types share identical file layouts. When adding/removing a tower type, touch all of these:

```
data/totw_reworked/
├── structure/<type>/                 # 4 .nbt files per type (binary — edit in-game or with NBT editor)
├── worldgen/template_pool/<type>/    # top.json, bottom.json
├── worldgen/structure/<type>.json
├── worldgen/structure_set/<type>.json
├── tags/worldgen/biome/has_structure/<type>_tower.json
├── advancement/<type>_tower.json
└── loot_table/                       # tower_chest.json (land), ocean_tower_chest.json (ocean)
```

Each `structure/<type>/` directory contains 4 NBT files:
- `{type}_tower_top.nbt` — standard waystone top
- `{type}_tower_bottom.nbt` — bottom (same for all variants)
- `fwaystones_{type}_tower_top.nbt` — Fabric Waystones variant top
- `waystone_{type}_tower_top.nbt` — Waystones mod variant top

The `top.json` `"location"` field references the `.nbt` structure file in `data/totw_reworked/structure/<type>/`. This is what `build-release.sh` edits to swap between waystone variants.

Land towers (`regular`, `derelict`, `derelict_grass`, `ice`, `jungle`) use
`"step": "surface_structures"` and `"project_start_to_heightmap": "WORLD_SURFACE_WG"`.
Ocean towers (`ocean`, `ocean_warm`) use `"step": "underground_structures"` and
`"project_start_to_heightmap": "OCEAN_FLOOR_WG"`. When adding a new tower type,
determine whether it's land or ocean and copy the appropriate pair of fields.

## NBT files

`.nbt` files in `data/totw_reworked/structure/` are Minecraft's binary NBT format. They are not human-readable JSON. Structure edits must be done in-game (structure block export) or with an external NBT editor.

When exporting structures from in-game, ensure chests do not contain a `Lock: ""` NBT tag — even an empty `Lock` value causes the chest to display "Chest is locked!" and become unopenable. All `*_tower_top.nbt` files had this issue and were fixed in commit history; re-exports may reintroduce it.

## Loot tables

Two loot tables: `tower_chest.json` (land towers) and `ocean_tower_chest.json` (ocean towers). Each tower's structure config references one of these.

## Branches

- `main` — current (1.21+)
- `1.17.x` — legacy 1.17.x
- `fabric-1.18.1` — legacy Fabric mod (pre-datapack)

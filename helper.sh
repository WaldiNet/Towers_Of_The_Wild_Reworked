#!/bin/bash

red=`tput setaf 1`
green=`tput setaf 2`
reset=`tput sgr0`

# SELECTION
#####################################
echo ""
echo "[${green}1${reset}] Change towers to 'regular'"
echo "[${green}2${reset}] Change towers to 'fwaystones'"
echo "[${green}3${reset}] Change towers to 'waystones'"

echo ""
read -p "Select your option [${green}1${reset}/${green}2${reset}/${green}3${reset}]: " input

# VARIABLES
#####################################
templatePool="data/totw_reworked/worldgen/template_pool"

derelict="derelict"
derelictGrass="derelict_grass"
ice="ice"
jungle="jungle"
ocean="ocean"
oceanWarm="ocean_warm"
regular="regular"

topFileName="top.json"

intendation="                "
regularPrefix=""
fabricWaystonesPrefix="fwaystones_"
waystonesPrefix="waystone_"

function replaceLocation() {
    fileName="data/totw_reworked/worldgen/template_pool/$2/$topFileName"

    oldLocation="\"location\": "
    newLocation="$intendation\"location\": \"totw_reworked:$2/$1$2_tower_top\","

    #sed -i '/"location"/c\\t\t\t\t"location": "totw_reworked:derelict\/fwaystones_derelict_tower_top",' data/totw_reworked/worldgen/template_pool/derelict/top.json
    sed -i "/$oldLocation/c\\$newLocation" $fileName
}

# REGULAR TOWERS
#####################################
if [ $input -eq 1 ]; then
    replaceLocation "$regularPrefix" "$derelict"
    replaceLocation "$regularPrefix" "$derelictGrass"
    replaceLocation "$regularPrefix" "$ice"
    replaceLocation "$regularPrefix" "$jungle"
    replaceLocation "$regularPrefix" "$ocean"
    replaceLocation "$regularPrefix" "$oceanWarm"
    replaceLocation "$regularPrefix" "$regular"
fi

# FABRIC WAYSTONES TOWERS
#####################################
if [ $input -eq 2 ]; then
    replaceLocation "$fabricWaystonesPrefix" "$derelict"
    replaceLocation "$fabricWaystonesPrefix" "$derelictGrass"
    replaceLocation "$fabricWaystonesPrefix" "$ice"
    replaceLocation "$fabricWaystonesPrefix" "$jungle"
    replaceLocation "$fabricWaystonesPrefix" "$ocean"
    replaceLocation "$fabricWaystonesPrefix" "$oceanWarm"
    replaceLocation "$fabricWaystonesPrefix" "$regular"
fi

# WAYSTONES TOWERS
#####################################
if [ $input -eq 3 ]; then
    replaceLocation "$waystonesPrefix" "$derelict"
    replaceLocation "$waystonesPrefix" "$derelictGrass"
    replaceLocation "$waystonesPrefix" "$ice"
    replaceLocation "$waystonesPrefix" "$jungle"
    replaceLocation "$waystonesPrefix" "$ocean"
    replaceLocation "$waystonesPrefix" "$oceanWarm"
    replaceLocation "$waystonesPrefix" "$regular"
fi
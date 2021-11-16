package waldinet.towers_of_the_wild_reworked.utils;

import net.minecraft.util.Identifier;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;
import waldinet.towers_of_the_wild_reworked.generator.RegularTowerGenerator;

/**
 * Helper class to move all the IDs from former Structure classes
 */
public class StructUtils
{
    //#region Identifier
    public static final Identifier DERELICT_TOWER = TowersOfTheWildReworked.id("derelict_tower");
    public static final Identifier DERELICT_GRASS_TOWER = TowersOfTheWildReworked.id("derelict_grass_tower");
    public static final Identifier ICE_TOWER = TowersOfTheWildReworked.id("ice_tower");
    public static final Identifier JUNGLE_TOWER = TowersOfTheWildReworked.id("jungle_tower");
    public static final Identifier OCEAN_TOWER = TowersOfTheWildReworked.id("ocean_tower");
    public static final Identifier OCEAN_WARM_TOWER = TowersOfTheWildReworked.id("ocean_warm_tower");
    public static final Identifier REGULAR_TOWER = TowersOfTheWildReworked.id("regular_tower");
    //#endregion

    /**
     * Makes sure pools are registered.
     */
    public static void initPools()
    {
        RegularTowerGenerator.init();
    }
}

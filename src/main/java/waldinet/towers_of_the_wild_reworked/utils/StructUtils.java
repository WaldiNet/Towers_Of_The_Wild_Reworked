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

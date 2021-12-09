package waldinet.towers_of_the_wild_reworked.generator;

import waldinet.towers_of_the_wild_reworked.utils.ModUtils;

public abstract class AbstractTowerGenerator
{
    public static void init()
    {
        // nth
    }

    /**
     * @internal
     */
    protected static String getTopStructureName()
    {
        if (ModUtils.waystonesInstalled()) {
            return "waystone_";
        }

        if (ModUtils.fabricWaystonesInstalled()) {
            return "fabric_waystone_";
        }

        return "";
    }
}

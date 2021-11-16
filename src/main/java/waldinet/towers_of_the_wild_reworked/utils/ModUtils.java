package waldinet.towers_of_the_wild_reworked.utils;

import net.fabricmc.loader.api.FabricLoader;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;

public class ModUtils
{
	public static boolean waystonesInstalled()
	{
		return FabricLoader.getInstance().isModLoaded(TowersOfTheWildReworked.WAYSTONE_MOD_ID);
	}
}

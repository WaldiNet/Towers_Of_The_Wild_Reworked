package waldinet.towers_of_the_wild_reworked.utils;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.Person;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;

public class ModUtils
{
	/**
	 * The modId "waystones" is used by both, ModdingForBlockheads/Waystones and LordDeatHunter/FabricWaystones.
	 * Make sure only one waystone-mod is installed!
	 * 
	 * @see https://github.com/ModdingForBlockheads/Waystones
	 */
	public static boolean waystonesInstalled()
	{
		return isModLoaded(TowersOfTheWildReworked.WAYSTONE_MOD_ID)
			&& isOwner("BlayTheNinth", TowersOfTheWildReworked.WAYSTONE_MOD_ID);
	}
		
	/**
	 * The modId "waystones" is used by both, ModdingForBlockheads/Waystones and LordDeatHunter/FabricWaystones.
	 * Make sure only one waystone-mod is installed!
	 * 
	 * @see https://github.com/LordDeatHunter/FabricWaystones
	 */
	public static boolean fabricWaystonesInstalled()
	{
		return isModLoaded(TowersOfTheWildReworked.WAYSTONE_MOD_ID)
			&& isOwner("LordDeatHunter", TowersOfTheWildReworked.WAYSTONE_MOD_ID);
	}

	/**
	 * @internal
	 */
	private static boolean isModLoaded(String modId)
	{
		return FabricLoader.getInstance().isModLoaded(modId);
	}

	/**
	 * @internal
	 */
	private static boolean isOwner(String owner, String modId)
	{
		ModContainer modContainer = FabricLoader.getInstance().getModContainer(modId).get();
		Person author = modContainer.getMetadata().getAuthors().iterator().next();

		return author.getName().contains(owner);
	}
}

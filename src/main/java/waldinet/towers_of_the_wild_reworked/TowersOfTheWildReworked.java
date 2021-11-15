package waldinet.towers_of_the_wild_reworked;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import waldinet.towers_of_the_wild_reworked.structure.TowerStructure;
import waldinet.towers_of_the_wild_reworked.utils.RegUtils;
import waldinet.towers_of_the_wild_reworked.utils.StructUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TowersOfTheWildReworked implements ModInitializer
{
	public static final Logger LOGGER = LogManager.getLogger("towers_of_the_wild_reworked");

	public static final String MOD_NAME = "Towers of the Wild: Reworked";
	public static final String MOD_ID = "towers_of_the_wild_reworked";
	public static final String ORIGINAL_MOD_ID = "towers_of_the_wild";
	public static final String WAYSTONE_MOD_ID = "waystones";

	//#region Structures
	public static final StructureFeature<StructurePoolFeatureConfig> REGULAR_TOWER = new TowerStructure();
	//#endregion

	@Override
	public void onInitialize()
	{
		LOGGER.info("Initializing...");

		// Loading config
		

		// Registering Structures and Features
		registerStructures();
		ConfiguredFeatures.registerConfiguredFeatures();

		// Adding to biomes
		putStructures();

		LOGGER.info("Initializing finished!");
	}

	public static Identifier id(String name)
	{
		return new Identifier(MOD_ID, name);
	}

	public static boolean waystonesInstalled()
	{
		return FabricLoader.getInstance().isModLoaded(WAYSTONE_MOD_ID);
	}

	private void registerStructures()
	{
		// https://github.dev/frqnny/mostructures
		RegUtils.registerStructure(StructUtils.REGULAR_TOWER, REGULAR_TOWER, ConfiguredFeatures.REGULAR_TOWER);
	}

	private static void putStructures()
	{
		RegUtils.addToBiome(
			StructUtils.REGULAR_TOWER,
			BiomeSelectors.categories(Biome.Category.PLAINS).and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.REGULAR_TOWER)
		);
		LOGGER.info("Registered structure: 'regular_tower'");
	}
}

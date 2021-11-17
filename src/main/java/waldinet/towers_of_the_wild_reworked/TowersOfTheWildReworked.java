package waldinet.towers_of_the_wild_reworked;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import waldinet.towers_of_the_wild_reworked.config.ConfigManager;
import waldinet.towers_of_the_wild_reworked.structure.*;
import waldinet.towers_of_the_wild_reworked.utils.RegUtils;
import waldinet.towers_of_the_wild_reworked.utils.StructUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TowersOfTheWildReworked implements ModInitializer
{	
	public static final TranslatableText MOD_NAME = new TranslatableText("Towers of the Wild: Reworked");
	public static final String MOD_ID = "towers_of_the_wild_reworked";
	public static final String ORIGINAL_MOD_ID = "towers_of_the_wild";
	public static final String WAYSTONE_MOD_ID = "waystones";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	//#region Structures
	public static final StructureFeature<StructurePoolFeatureConfig> DERELICT_TOWER = new TowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> DERELICT_GRASS_TOWER = new TowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> ICE_TOWER = new TowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> JUNGLE_TOWER = new TowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> OCEAN_TOWER = new OceanTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> OCEAN_WARM_TOWER = new OceanTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> REGULAR_TOWER = new TowerStructure();
	//#endregion

	@Override
	public void onInitialize()
	{
		LOGGER.info("Initializing...");

		// Loading config
		ConfigManager.getInstance().getConfig();
		

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

	private void registerStructures()
	{
		LOGGER.info("Registering structures...");

		// https://github.dev/frqnny/mostructures
		RegUtils.registerStructure(StructUtils.DERELICT_TOWER, DERELICT_TOWER, ConfiguredFeatures.DERELICT_TOWER);
		RegUtils.registerStructure(StructUtils.DERELICT_GRASS_TOWER, DERELICT_GRASS_TOWER, ConfiguredFeatures.DERELICT_GRASS_TOWER);
		RegUtils.registerStructure(StructUtils.ICE_TOWER, ICE_TOWER, ConfiguredFeatures.ICE_TOWER);
		RegUtils.registerStructure(StructUtils.JUNGLE_TOWER, JUNGLE_TOWER, ConfiguredFeatures.JUNGLE_TOWER);
		RegUtils.registerStructure(StructUtils.OCEAN_TOWER, OCEAN_TOWER, ConfiguredFeatures.OCEAN_TOWER);
		RegUtils.registerStructure(StructUtils.OCEAN_WARM_TOWER, OCEAN_WARM_TOWER, ConfiguredFeatures.OCEAN_WARM_TOWER);
		RegUtils.registerStructure(StructUtils.REGULAR_TOWER, REGULAR_TOWER, ConfiguredFeatures.REGULAR_TOWER);

		LOGGER.info("Registration finished!");
	}

	private static void putStructures()
	{
		LOGGER.info("Loading structures into world gen...");

		// Derelict
		RegUtils.addToBiome(
			StructUtils.DERELICT_TOWER,
			BiomeSelectors
				.categories(Category.MESA, Category.DESERT)
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.DERELICT_TOWER)
		);

		// Derelict Grass
		// Lower position
		RegUtils.addToBiome(
			StructUtils.DERELICT_GRASS_TOWER,
			BiomeSelectors
				.categories(Category.TAIGA, Category.EXTREME_HILLS, Category.PLAINS, Category.SAVANNA, Category.FOREST, Category.SWAMP, Category.MUSHROOM)
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.DERELICT_GRASS_TOWER)
		);

		// Ice
		RegUtils.addToBiome(
			StructUtils.ICE_TOWER,
			BiomeSelectors
				.categories(Category.ICY)
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.ICE_TOWER)
		);

		// Jungle
		RegUtils.addToBiome(
			StructUtils.JUNGLE_TOWER,
			BiomeSelectors
				.categories(Category.JUNGLE)
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.JUNGLE_TOWER)
		);

		// Ocean
		// Lower by 21
		RegUtils.addToBiome(
			StructUtils.OCEAN_TOWER,
			BiomeSelectors
				.categories(Category.OCEAN)
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.OCEAN_TOWER)
		);

		// Ocean Warm
		// RegUtils.addToBiome(
		// 	StructUtils.OCEAN_WARM_TOWER,
		// 	BiomeSelectors.categories(Category.OCEAN).and(BiomeSelectors.foundInOverworld()),
		// 	(context) -> RegUtils.addStructure(context, ConfiguredFeatures.OCEAN_WARM_TOWER)
		// );

		// Regular
		// Coliding with derelict
		RegUtils.addToBiome(
			StructUtils.REGULAR_TOWER,
			BiomeSelectors
				.categories(Category.TAIGA, Category.EXTREME_HILLS, Category.MESA, Category.PLAINS, Category.SAVANNA, Category.FOREST, Category.DESERT, Category.SWAMP, Category.MUSHROOM)
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.REGULAR_TOWER)
		);
		
		LOGGER.info("Loading structures into world gen finished!");
	}
}

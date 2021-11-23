package waldinet.towers_of_the_wild_reworked;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import waldinet.towers_of_the_wild_reworked.config.ConfigManager;
import waldinet.towers_of_the_wild_reworked.config.TowersOfTheWildReworkedConfig;
import waldinet.towers_of_the_wild_reworked.structure.*;
import waldinet.towers_of_the_wild_reworked.utils.RegUtils;
import waldinet.towers_of_the_wild_reworked.utils.StructUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TowersOfTheWildReworked implements ModInitializer
{	
	public static final TranslatableText MOD_NAME = new TranslatableText("mod.towers_of_the_wild_reworked.name");
	public static final String MOD_ID = "towers_of_the_wild_reworked";
	public static final String ORIGINAL_MOD_ID = "towers_of_the_wild";
	public static final String WAYSTONE_MOD_ID = "waystones";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	//#region Structures
	public static final StructureFeature<StructurePoolFeatureConfig> DERELICT_TOWER = new DerelictTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> DERELICT_GRASS_TOWER = new DerelictTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> ICE_TOWER = new TowerStructure(9);
	public static final StructureFeature<StructurePoolFeatureConfig> JUNGLE_TOWER = new TowerStructure(7);
	public static final StructureFeature<StructurePoolFeatureConfig> OCEAN_TOWER = new OceanTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> OCEAN_WARM_TOWER = new OceanTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> REGULAR_TOWER = new TowerStructure(5);
	//#endregion

	private TowersOfTheWildReworkedConfig _config;

	@Override
	public void onInitialize()
	{
		LOGGER.info("Initializing...");

		// Loading config
		_config = ConfigManager.getInstance().getConfig();

		// Registering Structures and Features
		registerStructures();
		ConfiguredFeatures.registerConfiguredFeatures();
		
		// Adding to biomes
		putStructures();

		LOGGER.info("Initializing finished!");
	}

	public static Identifier id(String name)
	{
		return new Identifier(ORIGINAL_MOD_ID, name);
	}

	private void registerStructures()
	{
		LOGGER.info("Registering structures...");

		// https://github.dev/frqnny/mostructures
		RegUtils.registerStructure(StructUtils.DERELICT_TOWER, DERELICT_TOWER, ConfiguredFeatures.DERELICT_TOWER, _config.derelictTower.spacing, 8, 1689780);
		RegUtils.registerStructure(StructUtils.DERELICT_GRASS_TOWER, DERELICT_GRASS_TOWER, ConfiguredFeatures.DERELICT_GRASS_TOWER, _config.derelictGrassTower.spacing, 8, 1689781);
		RegUtils.registerStructure(StructUtils.ICE_TOWER, ICE_TOWER, ConfiguredFeatures.ICE_TOWER, _config.iceTower.spacing, 8, 1689779);
		RegUtils.registerStructure(StructUtils.JUNGLE_TOWER, JUNGLE_TOWER, ConfiguredFeatures.JUNGLE_TOWER, _config.jungleTower.spacing, 8, 1689778);
		RegUtils.registerStructure(StructUtils.OCEAN_TOWER, OCEAN_TOWER, ConfiguredFeatures.OCEAN_TOWER, _config.oceanTower.spacing, 8, 1689782);
		RegUtils.registerStructure(StructUtils.OCEAN_WARM_TOWER, OCEAN_WARM_TOWER, ConfiguredFeatures.OCEAN_WARM_TOWER, _config.oceanWarmTower.spacing, 8, 1689782);
		RegUtils.registerStructure(StructUtils.REGULAR_TOWER, REGULAR_TOWER, ConfiguredFeatures.REGULAR_TOWER, _config.regularTower.spacing, 8, 1689777);

		LOGGER.info("Registration finished!");
	}

	private void putStructures()
	{
		LOGGER.info("Loading active structures...");

		// Derelict Grass
		RegUtils.addToBiome(
			StructUtils.DERELICT_GRASS_TOWER,
			BiomeSelectors
			.categories(Category.TAIGA, Category.EXTREME_HILLS, Category.PLAINS, Category.SAVANNA, Category.FOREST, Category.SWAMP, Category.MUSHROOM)
			.and(RegUtils.booleanToPredicate(_config.derelictGrassTower.active))
			.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.DERELICT_GRASS_TOWER)
		);

		// Derelict
		// TODO: Not spawning
		// RegUtils.addToBiome(
		// 	StructUtils.DERELICT_TOWER,
		// 	BiomeSelectors
		// 		.categories(Category.MESA, Category.DESERT, Category.ICY)
		// 		.and(RegUtils.booleanToPredicate(_config.derelictTower.active))
		// 		.and(BiomeSelectors.foundInOverworld()),
		// 	(context) -> RegUtils.addStructure(context, ConfiguredFeatures.DERELICT_TOWER)
		// );

		// Ice
		RegUtils.addToBiome(
			StructUtils.ICE_TOWER,
			BiomeSelectors
				.categories(Category.ICY)
				.and(RegUtils.booleanToPredicate(_config.iceTower.active))
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.ICE_TOWER)
		);

		// Jungle
		RegUtils.addToBiome(
			StructUtils.JUNGLE_TOWER,
			BiomeSelectors
				.categories(Category.JUNGLE)
				.and(RegUtils.booleanToPredicate(_config.jungleTower.active))
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.JUNGLE_TOWER)
		);

		// Ocean
		RegUtils.addToBiome(
			StructUtils.OCEAN_TOWER,
			BiomeSelectors
				.categories(Category.OCEAN)
				.and((context) -> {
					String string = context.getBiomeKey().getValue().toString();
                    return !string.contains("deep") && !string.contains("frozen");
				})
				.and(RegUtils.booleanToPredicate(_config.oceanTower.active))
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.OCEAN_TOWER)
		);

		// Ocean Warm
		RegUtils.addToBiome(
			StructUtils.OCEAN_WARM_TOWER,
			BiomeSelectors
				.foundInOverworld()
				.and((context) -> {
					String string = context.getBiomeKey().getValue().toString();
                    return string.equals("minecraft:warm_ocean");
				})
				.and(RegUtils.booleanToPredicate(_config.oceanWarmTower.active)),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.OCEAN_WARM_TOWER)
		);

		// Regular
		RegUtils.addToBiome(
			StructUtils.REGULAR_TOWER,
			BiomeSelectors
				.categories(Category.TAIGA, Category.EXTREME_HILLS, Category.MESA, Category.PLAINS, Category.SAVANNA, Category.FOREST, Category.DESERT, Category.SWAMP, Category.MUSHROOM)
				.and(RegUtils.booleanToPredicate(_config.regularTower.active))
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.REGULAR_TOWER)
		);
		
		LOGGER.info("Loading active structures finished!");
	}
}

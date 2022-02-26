package waldinet.towers_of_the_wild_reworked;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import waldinet.towers_of_the_wild_reworked.config.TowersOfTheWildReworkedConfig;
import waldinet.towers_of_the_wild_reworked.generator.DerelictGrassTowerGenerator;
import waldinet.towers_of_the_wild_reworked.generator.DerelictTowerGenerator;
import waldinet.towers_of_the_wild_reworked.generator.IceTowerGenerator;
import waldinet.towers_of_the_wild_reworked.generator.JungleTowerGenerator;
import waldinet.towers_of_the_wild_reworked.generator.RegularTowerGenerator;
import waldinet.towers_of_the_wild_reworked.structure.*;
import waldinet.towers_of_the_wild_reworked.utils.ConfigUtils;
import waldinet.towers_of_the_wild_reworked.utils.RegUtils;
import waldinet.towers_of_the_wild_reworked.utils.StructUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class TowersOfTheWildReworked implements ModInitializer
{	
	public static final TranslatableText MOD_NAME = new TranslatableText("mod.towers_of_the_wild_reworked.name");
	public static final String MOD_ID = "towers_of_the_wild_reworked";
	public static final String ORIGINAL_MOD_ID = "towers_of_the_wild";
	/**
	 * The modId "waystones" is used by both, ModdingForBlockheads/Waystones and LordDeatHunter/FabricWaystones.
	 * Make sure only one waystone-mod is installed!
	 */
	public static final String WAYSTONE_MOD_ID = "waystones";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static TowersOfTheWildReworkedConfig CONFIG;

	//#region Structures
	public static final StructureFeature<StructurePoolFeatureConfig> DERELICT_GRASS_TOWER = new DerelictTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> DERELICT_TOWER = new DerelictTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> ICE_TOWER = new TowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> JUNGLE_TOWER = new TowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> OCEAN_TOWER = new OceanTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> OCEAN_WARM_TOWER = new OceanTowerStructure();
	public static final StructureFeature<StructurePoolFeatureConfig> REGULAR_TOWER = new TowerStructure();
	//#endregion

	// private TowersOfTheWildReworkedConfig _config;

	@Override
	public void onInitialize()
	{
		// Loading Config
		AutoConfig.register(TowersOfTheWildReworkedConfig.class, GsonConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(TowersOfTheWildReworkedConfig.class).getConfig();
		ConfigUtils.Log("Config read successfully!");

		if (CONFIG.debugging.logConfig) {
			ConfigUtils.logConfig();
		}

		// Registering Structures and Features
		registerStructures();
		ConfiguredFeatures.registerConfiguredFeatures();
		
		// Adding to biomes
		putStructures();

		ConfigUtils.Log("Initializing finished!");
	}

	public static Identifier id(String name)
	{
		return new Identifier(ORIGINAL_MOD_ID, name);
	}

	private void registerStructures()
	{
		ConfigUtils.Log("Registering structures...");

		// https://github.dev/frqnny/mostructures
		RegUtils.registerStructure(
			StructUtils.DERELICT_GRASS_TOWER,
			DERELICT_GRASS_TOWER,
			CONFIG.derelictGrassTower.spacing,
			CONFIG.derelictGrassTower.separation,
			1689781
		);

		RegUtils.registerStructure(
			StructUtils.DERELICT_TOWER,
			DERELICT_TOWER,
			CONFIG.derelictTower.spacing,
			CONFIG.derelictTower.separation,
			1689780
		);

		RegUtils.registerStructure(
			StructUtils.ICE_TOWER,
			ICE_TOWER,
			CONFIG.iceTower.spacing,
			CONFIG.iceTower.separation,
			1689779
		);

		RegUtils.registerStructure(
			StructUtils.JUNGLE_TOWER,
			JUNGLE_TOWER,
			CONFIG.jungleTower.spacing,
			CONFIG.jungleTower.separation,
			1689778
		);

		RegUtils.registerStructure(
			StructUtils.OCEAN_TOWER,
			OCEAN_TOWER,
			CONFIG.oceanTower.spacing,
			CONFIG.oceanTower.separation,
			1689782
		);

		RegUtils.registerStructure(
			StructUtils.OCEAN_WARM_TOWER,
			OCEAN_WARM_TOWER,
			CONFIG.oceanWarmTower.spacing,
			CONFIG.oceanWarmTower.separation,
			1689782
		);

		RegUtils.registerStructure(
			StructUtils.REGULAR_TOWER,
			REGULAR_TOWER,
			CONFIG.regularTower.spacing,
			CONFIG.regularTower.separation,
			1689777
		);

		ConfigUtils.Log("Registration finished!");
	}

	private void putStructures()
	{
		ConfigUtils.Log("Loading active structures...");

		// Derelict Grass
		RegUtils.addToBiome(
			StructUtils.DERELICT_GRASS_TOWER,
			BiomeSelectors
				.categories(DerelictGrassTowerGenerator.BIOME_CATEGORIES)
				.and(RegUtils.booleanToPredicate(CONFIG.derelictGrassTower.active))
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.DERELICT_GRASS_TOWER)
		);

		// Derelict
		RegUtils.addToBiome(
			StructUtils.DERELICT_TOWER,
			BiomeSelectors
				.categories(DerelictTowerGenerator.BIOME_CATEGORIES)
				.and(RegUtils.booleanToPredicate(CONFIG.derelictTower.active))
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.DERELICT_TOWER)
		);

		// Ice
		RegUtils.addToBiome(
			StructUtils.ICE_TOWER,
			BiomeSelectors
				.categories(IceTowerGenerator.BIOME_CATEGORIES)
				.and(RegUtils.booleanToPredicate(CONFIG.iceTower.active))
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.ICE_TOWER)
		);

		// Jungle
		RegUtils.addToBiome(
			StructUtils.JUNGLE_TOWER,
			BiomeSelectors
				.categories(JungleTowerGenerator.BIOME_CATEGORIES)
				.and(RegUtils.booleanToPredicate(CONFIG.jungleTower.active))
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
				.and(RegUtils.booleanToPredicate(CONFIG.oceanTower.active))
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
				.and(RegUtils.booleanToPredicate(CONFIG.oceanWarmTower.active)),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.OCEAN_WARM_TOWER)
		);

		// Regular
		RegUtils.addToBiome(
			StructUtils.REGULAR_TOWER,
			BiomeSelectors
				.categories(RegularTowerGenerator.BIOME_CATEGORIES)
				.and(RegUtils.booleanToPredicate(CONFIG.regularTower.active))
				.and(BiomeSelectors.foundInOverworld()),
			(context) -> RegUtils.addStructure(context, ConfiguredFeatures.REGULAR_TOWER)
		);
		
		ConfigUtils.Log("Loading active structures finished!");
	}
}

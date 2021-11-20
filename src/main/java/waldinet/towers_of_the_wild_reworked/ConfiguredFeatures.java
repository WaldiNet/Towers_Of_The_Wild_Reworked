package waldinet.towers_of_the_wild_reworked;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import waldinet.towers_of_the_wild_reworked.generator.*;
import waldinet.towers_of_the_wild_reworked.utils.RegUtils;

public class ConfiguredFeatures
{
    //#region Configured Structures
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> DERELICT_GRASS_TOWER = RegUtils.config(TowersOfTheWildReworked.DERELICT_GRASS_TOWER, DerelictGrassTowerGenerator.STARTING_POOL);
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> DERELICT_TOWER = RegUtils.config(TowersOfTheWildReworked.DERELICT_TOWER, DerelictTowerGenerator.STARTING_POOL);
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> ICE_TOWER = RegUtils.config(TowersOfTheWildReworked.ICE_TOWER, IceTowerGenerator.STARTING_POOL);
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> JUNGLE_TOWER = RegUtils.config(TowersOfTheWildReworked.JUNGLE_TOWER, JungleTowerGenerator.STARTING_POOL);
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> OCEAN_TOWER = RegUtils.config(TowersOfTheWildReworked.OCEAN_TOWER, OceanTowerGenerator.STARTING_POOL);
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> OCEAN_WARM_TOWER = RegUtils.config(TowersOfTheWildReworked.OCEAN_WARM_TOWER, OceanWarmTowerGenerator.STARTING_POOL);
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> REGULAR_TOWER = RegUtils.config(TowersOfTheWildReworked.REGULAR_TOWER, RegularTowerGenerator.STARTING_POOL);
    //#endregion

    public static void registerConfiguredFeatures()
    {
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, TowersOfTheWildReworked.id("configured_derelict_tower"), DERELICT_TOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, TowersOfTheWildReworked.id("configured_derelict_grass_tower"), DERELICT_GRASS_TOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, TowersOfTheWildReworked.id("configured_ice_tower"), ICE_TOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, TowersOfTheWildReworked.id("configured_jungle_tower"), JUNGLE_TOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, TowersOfTheWildReworked.id("configured_ocean_tower"), OCEAN_TOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, TowersOfTheWildReworked.id("configured_ocean_warm_tower"), OCEAN_WARM_TOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, TowersOfTheWildReworked.id("configured_regular_tower"), REGULAR_TOWER);
    }
}

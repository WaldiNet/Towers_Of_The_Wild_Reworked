package waldinet.towers_of_the_wild_reworked;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import waldinet.towers_of_the_wild_reworked.generator.RegularTowerGenerator;
import waldinet.towers_of_the_wild_reworked.utils.RegUtils;

public class ConfiguredFeatures
{
    //#region Configured Structures
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> REGULAR_TOWER = RegUtils.config(TowersOfTheWildReworked.REGULAR_TOWER, RegularTowerGenerator.STARTING_POOL);
    //#endregion

    public static void registerConfiguredFeatures()
    {
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, TowersOfTheWildReworked.id("configured_regular_tower"), REGULAR_TOWER);
    }
}

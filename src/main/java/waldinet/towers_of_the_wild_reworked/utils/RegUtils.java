package waldinet.towers_of_the_wild_reworked.utils;

import java.util.function.Consumer;
import java.util.function.Predicate;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class RegUtils
{
    public static ConfiguredStructureFeature<StructurePoolFeatureConfig, ? extends StructureFeature<StructurePoolFeatureConfig>> config(
        StructureFeature<StructurePoolFeatureConfig> structureFeature,
        StructurePool structurePool
    ) {
        return structureFeature.configure(
            new StructurePoolFeatureConfig(() -> structurePool, 2)
        );
    }

    public static void addToBiome(Identifier id, Predicate<BiomeSelectionContext> selectorPredicate, Consumer<BiomeModificationContext> biomeAdditionConsumer)
    {
        BiomeModifications.create(id).add(
            ModificationPhase.ADDITIONS,
            selectorPredicate,
            biomeAdditionConsumer
        );
    }

    public static void addStructure(BiomeModificationContext context, ConfiguredStructureFeature<?, ?> feature)
    {
        context.getGenerationSettings().addBuiltInStructure(feature);
    }

    public static <FC extends FeatureConfig, S extends StructureFeature<FC>> void registerStructure(
        Identifier id,
        S f,
        ConfiguredStructureFeature<FC, ? extends StructureFeature<FC>> feature
    ) {
        FabricStructureBuilder<FC, S> builder = FabricStructureBuilder.create(id, f)
            .step(GenerationStep.Feature.SURFACE_STRUCTURES)
            .defaultConfig(32, 8, 12345)
            .superflatFeature(feature);

        builder.register();
    }
}

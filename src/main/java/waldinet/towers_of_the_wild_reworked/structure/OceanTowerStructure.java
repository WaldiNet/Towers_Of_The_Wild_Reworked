package waldinet.towers_of_the_wild_reworked.structure;

import com.mojang.serialization.Codec;

import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import waldinet.towers_of_the_wild_reworked.utils.StructUtils;

/**
 * Helper class to move all the IDs from former Structure classes
 */
public class OceanTowerStructure extends StructureFeature<StructurePoolFeatureConfig>
{
    public OceanTowerStructure()
    {
        super(StructurePoolFeatureConfig.CODEC);
    }

    @Override
    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory()
    {
        return OceanTowerStructure.Start::new;
    }

    @SuppressWarnings("ObjectAllocationInLoop")
    @Override
    protected boolean shouldStartAt(
        ChunkGenerator chunkGenerator,
        BiomeSource biomeSource,
        long worldSeed,
        ChunkRandom random,
        ChunkPos pos,
        Biome biome,
        ChunkPos chunkPos,
        StructurePoolFeatureConfig config,
        HeightLimitView world
    ) {
        int x = pos.x * 16;
        int z = pos.z * 16 ;

        int oceanFloor = chunkGenerator.getHeight(x, z, Heightmap.Type.OCEAN_FLOOR_WG, world);

        return oceanFloor <= 38;
    }

    public static class Start extends MarginedStructureStart<StructurePoolFeatureConfig>
    {
        //#region Constructor
        public Start(StructureFeature<StructurePoolFeatureConfig> structureFeature, ChunkPos chunkPos, int i, long l)
        {
            super(structureFeature, chunkPos, i, l);
        }
        //#endregion

        @Override
        public void init(
            DynamicRegistryManager registryManager,
            ChunkGenerator chunkGenerator,
            StructureManager manager,
            ChunkPos pos,
            Biome biome,
            StructurePoolFeatureConfig config,
            HeightLimitView world
        ) {
            int x = pos.x * 16;
            int z = pos.z * 16 ;

            BlockPos blockPos = new BlockPos(
                x,
                chunkGenerator.getHeight(x, z, Heightmap.Type.OCEAN_FLOOR_WG, world) - chunkGenerator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG, world),
                z
            );

            StructUtils.initPools();
            StructurePoolBasedGenerator.generate(
                registryManager,
                config,
                PoolStructurePiece::new,
                chunkGenerator,
                manager,
                blockPos, // new BlockPos(pos.x << 4, structure.structureStartY, pos.z << 4),
                this,
                this.random,
                true,
                true,
                world
            );
            this.setBoundingBoxFromChildren();
        }
    }
}

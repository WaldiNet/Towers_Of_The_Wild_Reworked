package waldinet.towers_of_the_wild_reworked.structure;

import java.util.Optional;

import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureGeneratorFactory.Context;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.world.gen.random.AtomicSimpleRandom;
import net.minecraft.world.gen.random.ChunkRandom;
import waldinet.towers_of_the_wild_reworked.utils.StructUtils;

/**
 * Helper class to move all the IDs from former Structure classes
 */
public class TowerStructure extends StructureFeature<StructurePoolFeatureConfig>
{
    public TowerStructure()
    {
        super(StructurePoolFeatureConfig.CODEC, context -> {
            if (! TowerStructure.isFlatTerrain(context.chunkGenerator(), context.chunkPos(), context.world())) {
                return Optional.empty();
            }

            StructUtils.initPools();

            return TowerStructure.generate(context);
        });
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> generate(Context<StructurePoolFeatureConfig> context)
    {
        return generate(context, 0);
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> generate(Context<StructurePoolFeatureConfig> context, int blockPosY)
    {
        long seed = context.seed();
        ChunkPos chunkPos = context.chunkPos();

        ChunkRandom chunkRandom = new ChunkRandom(new AtomicSimpleRandom(0L));
        chunkRandom.setCarverSeed(seed, chunkPos.x, chunkPos.z);

        int x = chunkPos.x * 16;
        int y = blockPosY;
        int z = chunkPos.z * 16;

        BlockPos blockPos = new BlockPos(x, y, z);

        return StructurePoolBasedGenerator.generate(
            context,
            PoolStructurePiece::new,
            blockPos,
            true,
            true
        );
    }

    /**
     * @internal
     */
    private static boolean isFlatTerrain(ChunkGenerator chunkGenerator, ChunkPos chunkPos, HeightLimitView world)
    {
        int offset = 0;
        int xStart = chunkPos.x * 16;
        int zStart = chunkPos.z * 16;

        Heightmap.Type type = Heightmap.Type.WORLD_SURFACE_WG;

        int i1 = chunkGenerator.getHeight(xStart, zStart, type, world);
        int j1 = chunkGenerator.getHeight(xStart, zStart + offset, type, world);
        int k1 = chunkGenerator.getHeight(xStart + offset, zStart, type, world);
        int l1 = chunkGenerator.getHeight(xStart + offset, zStart + offset, type, world);
        int minHeight = Math.min(Math.min(i1, j1), Math.min(k1, l1));
        int maxHeight = Math.max(Math.max(i1, j1), Math.max(k1, l1));

        return Math.abs(maxHeight - minHeight) <= 4;
    }
}

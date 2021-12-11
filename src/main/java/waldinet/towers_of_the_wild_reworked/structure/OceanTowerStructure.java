package waldinet.towers_of_the_wild_reworked.structure;

import java.util.Optional;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
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
        super(StructurePoolFeatureConfig.CODEC, context -> {
            if (! OceanTowerStructure.oceanIsDeepEnough(context.chunkGenerator(), context.chunkPos(), context.world())) {
                return Optional.empty();
            }

            StructUtils.initPools();

            ChunkPos chunkPos = context.chunkPos();
            int x = chunkPos.x * 16;
            int z = chunkPos.z * 16;
            int oceanFloor = context.chunkGenerator().getHeight(x, z, Heightmap.Type.OCEAN_FLOOR_WG, context.world());
            int surfaceFloor = context.chunkGenerator().getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG, context.world());
            int y = oceanFloor - surfaceFloor;

            return TowerStructure.generate(context, y);
        });
    }

    /**
     * @internal
     */
    private static boolean oceanIsDeepEnough(ChunkGenerator chunkGenerator, ChunkPos chunkPos, HeightLimitView world)
    {
        int x = chunkPos.x * 16;
        int z = chunkPos.z * 16;
        int oceanFloor = chunkGenerator.getHeight(x, z, Heightmap.Type.OCEAN_FLOOR_WG, world);

        return oceanFloor <= 38;
    }
}

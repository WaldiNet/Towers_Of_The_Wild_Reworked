package waldinet.towers_of_the_wild_reworked.structure;

import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import waldinet.towers_of_the_wild_reworked.utils.StructUtils;

/**
 * Helper class to move all the IDs from former Structure classes
 */
public class TowerStructure extends StructureFeature<StructurePoolFeatureConfig>
{
    private final boolean modifyBoundingBox;
    private final boolean surface;
    private final int structureStartY;

    //#region Constructor
    public TowerStructure()
    {
        this(1);
    }

    public TowerStructure(int structureStartY)
    {
        this(structureStartY, true, true);
    }

    public TowerStructure(int structureStartY, boolean modifyBoundingBox, boolean surface)
    {
        super(StructurePoolFeatureConfig.CODEC);
        this.structureStartY = structureStartY;
        this.modifyBoundingBox = modifyBoundingBox;
        this.surface = surface;
    }
    //#endregion

    @Override
    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory()
    {
        return TowerStructure.Start::new;
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
            TowerStructure structure = (TowerStructure) this.getFeature();
            StructUtils.initPools();
            StructurePoolBasedGenerator.generate(
                registryManager,
                config,
                PoolStructurePiece::new,
                chunkGenerator,
                manager,
                new BlockPos(pos.x << 4, structure.structureStartY, pos.z << 4),
                this,
                this.random,
                structure.modifyBoundingBox,
                structure.surface,
                world
            );
            this.setBoundingBoxFromChildren();
        }
    }
}

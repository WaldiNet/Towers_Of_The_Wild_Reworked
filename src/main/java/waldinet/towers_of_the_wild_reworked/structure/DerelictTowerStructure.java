package waldinet.towers_of_the_wild_reworked.structure;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class DerelictTowerStructure extends TowerStructure
{
    public DerelictTowerStructure()
    {
        super(18);
    }

    @Override
    protected boolean isFlatTerrain(ChunkGenerator chunkGenerator, ChunkPos chunkPos, HeightLimitView world)
    {
        int offset = 18;
        int xStart = chunkPos.x * 16;
        int zStart = chunkPos.z * 16;

        Heightmap.Type type = Heightmap.Type.WORLD_SURFACE_WG;

        int i1 = chunkGenerator.getHeight(xStart, zStart, type, world);
        int j1 = chunkGenerator.getHeight(xStart, zStart + offset, type, world);
        int k1 = chunkGenerator.getHeight(xStart + offset, zStart, type, world);
        int l1 = chunkGenerator.getHeight(xStart + offset, zStart + offset, type, world);
        int m1 = chunkGenerator.getHeight(xStart + offset / 2, zStart + offset / 2, type, world);
        int minHeight = Math.min(Math.min(Math.min(i1, j1), Math.min(k1, l1)), m1);
        int maxHeight = Math.max(Math.max(Math.max(i1, j1), Math.max(k1, l1)), m1);

        return Math.abs(maxHeight - minHeight) <= 4;
    }
}

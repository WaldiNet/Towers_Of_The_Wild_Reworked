package waldinet.towers_of_the_wild_reworked.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;
import waldinet.towers_of_the_wild_reworked.utils.ModUtils;

public class OceanTowerGenerator extends AbstractTowerGenerator
{
    public static final StructurePool STARTING_POOL;
    
    static {
        STARTING_POOL = StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.MOD_ID, "ocean_bottom"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":ocean/ocean_tower_bottom"), 1)
                ),
                StructurePool.Projection.RIGID
            )  
        );

        StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.MOD_ID, "ocean_top"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(
                        ModUtils.waystonesInstalled()
                        ? StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":ocean/waystone_ocean_tower_top")
                        : StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":ocean/ocean_tower_top")
                    , 1)
                ),
                StructurePool.Projection.RIGID
            )  
        );
    }
}

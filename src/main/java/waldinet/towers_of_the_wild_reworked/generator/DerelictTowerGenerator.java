package waldinet.towers_of_the_wild_reworked.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;
import waldinet.towers_of_the_wild_reworked.utils.ModUtils;

public class DerelictTowerGenerator
{
    public static final StructurePool STARTING_POOL;
    
    static {
        STARTING_POOL = StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.ORIGINAL_MOD_ID, "derelict_bottom"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofSingle(TowersOfTheWildReworked.ORIGINAL_MOD_ID + ":derelict/derelict_tower_bottom"), 1)
                ),
                StructurePool.Projection.TERRAIN_MATCHING
            )  
        );

        StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.ORIGINAL_MOD_ID, "derelict_top"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(
                        ModUtils.waystonesInstalled()
                        ? StructurePoolElement.ofSingle(TowersOfTheWildReworked.ORIGINAL_MOD_ID + ":derelict/waystone_derelict_tower_top")
                        : StructurePoolElement.ofSingle(TowersOfTheWildReworked.ORIGINAL_MOD_ID + ":derelict/derelict_tower_top")
                    , 1)
                ),
                StructurePool.Projection.RIGID
            )  
        );
    }

    public static void init()
    {
        // nth
    }
}

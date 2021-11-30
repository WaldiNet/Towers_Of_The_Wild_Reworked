package waldinet.towers_of_the_wild_reworked.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;
import waldinet.towers_of_the_wild_reworked.utils.ModUtils;

public class DerelictTowerGenerator extends AbstractTowerGenerator
{
    public static final StructurePool STARTING_POOL;

    public static Biome.Category[] BIOME_CATEGORIES = new Biome.Category[]{
        Biome.Category.MESA,  
        Biome.Category.DESERT,  
        Biome.Category.ICY,  
    };
    
    static {
        STARTING_POOL = StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.MOD_ID, "derelict_bottom"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":derelict/derelict_tower_bottom"), 1)
                ),
                StructurePool.Projection.RIGID
            )  
        );

        StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.MOD_ID, "derelict_top"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(
                        ModUtils.waystonesInstalled()
                        ? StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":derelict/waystone_derelict_tower_top")
                        : StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":derelict/derelict_tower_top")
                    , 1)
                ),
                StructurePool.Projection.RIGID
            )  
        );
    }
}

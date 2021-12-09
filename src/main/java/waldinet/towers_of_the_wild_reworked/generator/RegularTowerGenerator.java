package waldinet.towers_of_the_wild_reworked.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;

public class RegularTowerGenerator extends AbstractTowerGenerator
{
    public static final StructurePool STARTING_POOL;

    public static Biome.Category[] BIOME_CATEGORIES = new Biome.Category[]{
        Biome.Category.TAIGA,
        Biome.Category.EXTREME_HILLS,
        Biome.Category.MESA,
        Biome.Category.PLAINS,
        Biome.Category.SAVANNA,
        Biome.Category.FOREST,
        Biome.Category.DESERT,
        Biome.Category.SWAMP,
        Biome.Category.MUSHROOM
    };
    
    static {
        STARTING_POOL = StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.MOD_ID, "regular_bottom"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":regular/tower_bottom"), 1)
                ),
                StructurePool.Projection.RIGID
            )  
        );

        StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.MOD_ID, "regular_top"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":regular/"+getTopStructureName()+"tower_top"), 1)
                ),
                StructurePool.Projection.RIGID
            )  
        );
    }
}

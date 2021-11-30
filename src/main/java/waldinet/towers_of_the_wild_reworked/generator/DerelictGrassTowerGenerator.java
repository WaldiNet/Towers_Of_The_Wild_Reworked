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

public class DerelictGrassTowerGenerator extends AbstractTowerGenerator
{
    public static final StructurePool STARTING_POOL;

    public static Biome.Category[] BIOME_CATEGORIES = new Biome.Category[]{
        Biome.Category.TAIGA,
        Biome.Category.EXTREME_HILLS,
        Biome.Category.PLAINS,
        Biome.Category.SAVANNA,
        Biome.Category.FOREST,
        Biome.Category.SWAMP,
        Biome.Category.MUSHROOM,
    };
    
    static {
        STARTING_POOL = StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.MOD_ID, "derelict_grass_bottom"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":derelict_grass/derelict_grass_tower_bottom"), 1)
                ),
                StructurePool.Projection.RIGID
            )  
        );

        StructurePools.register(
            new StructurePool(
                new Identifier(TowersOfTheWildReworked.MOD_ID, "derelict_grass_top"),
                new Identifier("empty"),
                ImmutableList.of(
                    new Pair<>(
                        ModUtils.waystonesInstalled()
                        ? StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":derelict_grass/waystone_derelict_grass_tower_top")
                        : StructurePoolElement.ofLegacySingle(TowersOfTheWildReworked.MOD_ID + ":derelict_grass/derelict_grass_tower_top")
                    , 1)
                ),
                StructurePool.Projection.RIGID
            )  
        );
    }
}

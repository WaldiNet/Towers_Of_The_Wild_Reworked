package waldinet.towers_of_the_wild_reworked.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePools;
import waldinet.towers_of_the_wild_reworked.utils.StructUtils;

@Mixin(StructurePools.class)
public class StructurePoolsMixin
{
    @Inject(at = @At("TAIL"), method = "initDefaultPools", cancellable = true)
    private static void initModPools(CallbackInfoReturnable<StructurePool> info)
    {
        StructUtils.initPools();
    }    
}

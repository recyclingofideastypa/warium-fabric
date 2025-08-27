package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SmokeStackSmokeWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

         world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_(), 0.0D, 1.0D, 0.0D);
         CrustyChunksMod.queueServerWork(1, () -> {
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }

         });
      }
   }
}

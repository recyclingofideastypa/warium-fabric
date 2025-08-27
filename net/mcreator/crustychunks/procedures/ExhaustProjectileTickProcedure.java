package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ExhaustProjectileTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         CrustyChunksMod.queueServerWork(9, () -> {
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }

         });
         immediatesourceentity.m_6842_(true);
         immediatesourceentity.m_20242_(true);
         if (immediatesourceentity.getPersistentData().m_128459_("T") == 1.0D) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x - immediatesourceentity.m_20184_().m_7096_() * 4.0D, y - immediatesourceentity.m_20184_().m_7098_() * 4.0D, z - immediatesourceentity.m_20184_().m_7094_() * 4.0D, immediatesourceentity.m_20184_().m_7096_() / 2.0D, immediatesourceentity.m_20184_().m_7098_() / 2.0D, immediatesourceentity.m_20184_().m_7094_() / 2.0D);
         }

         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
         if (immediatesourceentity.getPersistentData().m_128459_("T") > 8.0D) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.PUFF.get(), x, y, z, immediatesourceentity.m_20184_().m_7096_() * 6.0D, immediatesourceentity.m_20184_().m_7098_() * 6.0D, immediatesourceentity.m_20184_().m_7094_() * 6.0D);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

      }
   }
}

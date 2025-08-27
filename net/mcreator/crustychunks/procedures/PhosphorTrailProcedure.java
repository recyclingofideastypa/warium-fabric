package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class PhosphorTrailProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (40.0D >= immediatesourceentity.getPersistentData().m_128459_("T")) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, 0.0D, 0.0D, 0.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.AERIAL_SPARKS.get(), x, y, z, immediatesourceentity.m_20184_().m_7096_() + Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), immediatesourceentity.m_20184_().m_7098_() + Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), immediatesourceentity.m_20184_().m_7094_() + Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D));
         } else if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
      }
   }
}

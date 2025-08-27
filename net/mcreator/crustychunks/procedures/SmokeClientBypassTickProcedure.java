package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SmokeClientBypassTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double particleAmount = 0.0D;
         if (!immediatesourceentity.getPersistentData().m_128471_("Used")) {
            for(int index0 = 0; index0 < 60; ++index0) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE_SCREEN.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -6.5D, 7.5D), y + 1.0D, z + Mth.m_216263_(RandomSource.m_216327_(), -6.5D, 7.5D), Mth.m_216263_(RandomSource.m_216327_(), -0.5D, 0.5D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.3D), Mth.m_216263_(RandomSource.m_216327_(), -0.5D, 0.5D));
            }

            immediatesourceentity.getPersistentData().m_128379_("Used", true);
         } else if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

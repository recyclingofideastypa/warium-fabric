package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class FireClientEffectTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double particleAmount = 0.0D;
         if (!immediatesourceentity.getPersistentData().m_128471_("Used")) {
            int index1;
            for(index1 = 0; index1 < 35; ++index1) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.FIREBALL.get(), x, y, z, Mth.m_216263_(RandomSource.m_216327_(), -3.0D, 3.0D), Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 1.0D), Mth.m_216263_(RandomSource.m_216327_(), -3.0D, 3.0D));
            }

            for(index1 = 0; index1 < 35; ++index1) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_SMOKE.get(), x, y, z, Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), Mth.m_216263_(RandomSource.m_216327_(), -0.5D, 0.5D), Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D));
            }

            immediatesourceentity.getPersistentData().m_128379_("Used", true);
         } else if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

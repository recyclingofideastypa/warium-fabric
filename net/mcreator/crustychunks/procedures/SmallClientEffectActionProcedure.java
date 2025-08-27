package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SmallClientEffectActionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double particleAmount = 0.0D;
         if (!immediatesourceentity.getPersistentData().m_128471_("Used")) {
            for(int index0 = 0; index0 < 25; ++index0) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_SMOKE.get(), x, y, z, Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), Mth.m_216263_(RandomSource.m_216327_(), 0.0D, 0.5D), Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D));
            }

            world.m_7106_(ParticleTypes.f_123747_, x, y + 1.0D, z, 0.0D, 0.1D, 0.0D);
            immediatesourceentity.getPersistentData().m_128379_("Used", true);
         } else if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

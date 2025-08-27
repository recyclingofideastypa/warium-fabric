package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;

public class NuclearSecondEffectRenderProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean found = false;
         double particleRadius = 0.0D;
         double particleAmount = 0.0D;
         double sx = 0.0D;
         double sy = 0.0D;
         double sz = 0.0D;
         immediatesourceentity.m_20242_(true);
         immediatesourceentity.f_19794_ = true;
         immediatesourceentity.m_20256_(new Vec3(0.0D, 0.0D, 0.0D));
         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
         int index5;
         if (0.0D <= immediatesourceentity.getPersistentData().m_128459_("T") && 20.0D >= immediatesourceentity.getPersistentData().m_128459_("T")) {
            for(index5 = 0; index5 < 5; ++index5) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_FIREBALL.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), y - 7.0D + Mth.m_216263_(RandomSource.m_216327_(), -40.0D, 15.0D), z + Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), 0.0D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
            }

            for(index5 = 0; index5 < 7; ++index5) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_STATIC_FIREBALL.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -6.0D, 6.0D), y - 7.0D + Mth.m_216263_(RandomSource.m_216327_(), 7.0D, 15.0D), z + Mth.m_216263_(RandomSource.m_216327_(), -6.0D, 6.0D), Mth.m_216263_(RandomSource.m_216327_(), -0.6D, 0.6D), Mth.m_216263_(RandomSource.m_216327_(), -0.7D, 0.25D), Mth.m_216263_(RandomSource.m_216327_(), -0.6D, 0.6D));
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_FIREBALL.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -11.0D, 11.0D), y - 7.0D + Mth.m_216263_(RandomSource.m_216327_(), 9.0D, 25.0D), z + Mth.m_216263_(RandomSource.m_216327_(), -11.0D, 11.0D), Mth.m_216263_(RandomSource.m_216327_(), -1.25D, 1.25D), Mth.m_216263_(RandomSource.m_216327_(), 0.25D, 1.25D), Mth.m_216263_(RandomSource.m_216327_(), -1.25D, 1.25D));
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_FIREBALL.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -9.0D, 9.0D), y - 7.0D + Mth.m_216263_(RandomSource.m_216327_(), 9.0D, 30.0D), z + Mth.m_216263_(RandomSource.m_216327_(), -10.0D, 10.0D), Mth.m_216263_(RandomSource.m_216327_(), -1.25D, 1.25D), Mth.m_216263_(RandomSource.m_216327_(), 0.25D, 1.25D), Mth.m_216263_(RandomSource.m_216327_(), -1.25D, 1.25D));
            }
         }

         if (40.0D == immediatesourceentity.getPersistentData().m_128459_("T")) {
            sx = -80.0D;

            for(index5 = 0; index5 < 160; ++index5) {
               sz = -80.0D;

               for(int index3 = 0; index3 < 160; ++index3) {
                  if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 1600) && Math.sqrt(Math.pow(sz, 2.0D) + Math.pow(sx, 2.0D)) < 80.0D) {
                     world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.GROUND_HUGE_SMOKE.get(), x + sx, (double)world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)x, (int)z) + Mth.m_216263_(RandomSource.m_216327_(), 8.0D, 17.0D), z + sz, Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
                  }

                  ++sz;
               }

               ++sx;
            }
         }

         if (400.0D <= immediatesourceentity.getPersistentData().m_128459_("T") && 410.0D >= immediatesourceentity.getPersistentData().m_128459_("T")) {
            for(index5 = 0; index5 < 25; ++index5) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SMOKE.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), y + Mth.m_216263_(RandomSource.m_216327_(), -80.0D, 55.0D) - 1.0D, z + Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), 0.0D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
            }

            for(index5 = 0; index5 < 35; ++index5) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SMOKE.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -15.0D, 15.0D), y + Mth.m_216263_(RandomSource.m_216327_(), 55.0D, 65.0D) - 1.0D, z + Mth.m_216263_(RandomSource.m_216327_(), -15.0D, 15.0D), Mth.m_216263_(RandomSource.m_216327_(), -0.6D, 0.6D), Mth.m_216263_(RandomSource.m_216327_(), -0.5D, 0.8D), Mth.m_216263_(RandomSource.m_216327_(), -0.6D, 0.6D));
            }

            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

      }
   }
}

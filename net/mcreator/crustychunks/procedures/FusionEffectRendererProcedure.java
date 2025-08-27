package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;

public class FusionEffectRendererProcedure {
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
         int index6;
         if (0.0D <= immediatesourceentity.getPersistentData().m_128459_("T") && 17.0D >= immediatesourceentity.getPersistentData().m_128459_("T")) {
            for(index6 = 0; index6 < 7; ++index6) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_FIREBALL.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), y - 14.0D + Mth.m_216263_(RandomSource.m_216327_(), -80.0D, 15.0D), z + Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), 0.0D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
            }

            for(index6 = 0; index6 < 7; ++index6) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_STATIC_FIREBALL.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -8.0D, 8.0D), y - 14.0D + Mth.m_216263_(RandomSource.m_216327_(), 7.0D, 24.0D), z + Mth.m_216263_(RandomSource.m_216327_(), -8.0D, 8.0D), Mth.m_216263_(RandomSource.m_216327_(), -0.8D, 0.8D), Mth.m_216263_(RandomSource.m_216327_(), -0.7D, 0.25D), Mth.m_216263_(RandomSource.m_216327_(), -0.8D, 0.8D));
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_FIREBALL.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -19.0D, 19.0D), y - 14.0D + Mth.m_216263_(RandomSource.m_216327_(), 12.0D, 35.0D), z + Mth.m_216263_(RandomSource.m_216327_(), -19.0D, 19.0D), Mth.m_216263_(RandomSource.m_216327_(), -1.7D, 1.7D), Mth.m_216263_(RandomSource.m_216327_(), 0.25D, 1.5D), Mth.m_216263_(RandomSource.m_216327_(), -1.7D, 1.7D));
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_FIREBALL.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -12.0D, 12.0D), y - 14.0D + Mth.m_216263_(RandomSource.m_216327_(), 14.0D, 44.0D), z + Mth.m_216263_(RandomSource.m_216327_(), -12.0D, 12.0D), Mth.m_216263_(RandomSource.m_216327_(), -1.7D, 1.7D), Mth.m_216263_(RandomSource.m_216327_(), 0.25D, 1.5D), Mth.m_216263_(RandomSource.m_216327_(), -1.7D, 1.7D));
            }
         }

         if (40.0D == immediatesourceentity.getPersistentData().m_128459_("T")) {
            sx = -80.0D;

            for(index6 = 0; index6 < 160; ++index6) {
               sz = -80.0D;

               for(int index3 = 0; index3 < 160; ++index3) {
                  if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 1200) && Math.sqrt(Math.pow(sz, 2.0D) + Math.pow(sx, 2.0D)) < 200.0D) {
                     world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.GROUND_HUGE_SMOKE.get(), x + sx, (double)world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)x, (int)z) + Mth.m_216263_(RandomSource.m_216327_(), 8.0D, 17.0D), z + sz, Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
                  }

                  ++sz;
               }

               ++sx;
            }
         }

         if (700.0D <= immediatesourceentity.getPersistentData().m_128459_("T") && 710.0D >= immediatesourceentity.getPersistentData().m_128459_("T")) {
            for(index6 = 0; index6 < 30; ++index6) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_SMOKE.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), y - 7.0D + Mth.m_216263_(RandomSource.m_216327_(), -335.0D, 55.0D) + 40.0D, z + Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), Mth.m_216263_(RandomSource.m_216327_(), -0.15D, 0.15D), Mth.m_216263_(RandomSource.m_216327_(), 0.0D, 0.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.15D, 0.15D));
            }

            for(index6 = 0; index6 < 40; ++index6) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_SMOKE.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -35.0D, 35.0D), y - 7.0D + Mth.m_216263_(RandomSource.m_216327_(), 52.0D, 80.0D) + 40.0D, z + Mth.m_216263_(RandomSource.m_216327_(), -35.0D, 35.0D), Mth.m_216263_(RandomSource.m_216327_(), -1.2D, 1.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.5D, 1.3D), Mth.m_216263_(RandomSource.m_216327_(), -1.2D, 1.2D));
            }

            for(index6 = 0; index6 < 20; ++index6) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_SMOKE.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -15.0D, 15.0D), y - 7.0D + Mth.m_216263_(RandomSource.m_216327_(), 60.0D, 87.0D) + 40.0D, z + Mth.m_216263_(RandomSource.m_216327_(), -15.0D, 15.0D), Mth.m_216263_(RandomSource.m_216327_(), -1.1D, 1.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.5D, 1.3D), Mth.m_216263_(RandomSource.m_216327_(), -1.1D, 1.1D));
            }

            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

      }
   }
}

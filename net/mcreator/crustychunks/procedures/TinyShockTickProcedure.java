package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;

public class TinyShockTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.m_6842_(true);
         immediatesourceentity.m_20256_(new Vec3(immediatesourceentity.m_20154_().f_82479_ * -1.5D, 0.0D, immediatesourceentity.m_20154_().f_82481_ * 1.5D));
         immediatesourceentity.m_20242_(true);
         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
         if (immediatesourceentity.getPersistentData().m_128459_("T") >= 10.0D) {
            if (immediatesourceentity.getPersistentData().m_128459_("T") / 5.0D == (double)Math.round(immediatesourceentity.getPersistentData().m_128459_("T") / 5.0D) && Mth.m_216271_(RandomSource.m_216327_(), 1, 5) == 1) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SHOCK_WAVE.get(), x + immediatesourceentity.m_20154_().f_82479_ * 5.0D, y + Mth.m_216263_(RandomSource.m_216327_(), 5.0D, 6.0D), z - immediatesourceentity.m_20154_().f_82481_ * 5.0D, immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_());
            }

            if (Mth.m_216271_(RandomSource.m_216327_(), 1, 4) == 1) {
               Level _level;
               if ((double)world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + immediatesourceentity.m_20154_().f_82479_ * 5.0D), (int)(z - immediatesourceentity.m_20154_().f_82481_ * 5.0D)) <= y - 30.0D) {
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x + immediatesourceentity.m_20154_().f_82479_ * 5.0D, y - 15.0D, z - immediatesourceentity.m_20154_().f_82481_ * 5.0D, 1.0F, ExplosionInteraction.NONE);
                     }
                  }
               } else if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x + immediatesourceentity.m_20154_().f_82479_ * 5.0D, (double)(world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + immediatesourceentity.m_20154_().f_82479_ * 5.0D), (int)(z - immediatesourceentity.m_20154_().f_82481_ * 5.0D)) + 1), z - immediatesourceentity.m_20154_().f_82481_ * 5.0D, 1.5F, ExplosionInteraction.NONE);
                  }
               }
            }
         }

         if (immediatesourceentity.getPersistentData().m_128459_("T") >= 50.0D && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class VehicleFlareTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.FLARE.get(), x, y, z, 0.0D, 1.0D, 0.0D);
         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
         if (immediatesourceentity.getPersistentData().m_128459_("T") >= 20.0D) {
            immediatesourceentity.m_20256_(new Vec3(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_() + 0.049D, immediatesourceentity.m_20184_().m_7094_()));
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 0.9D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
         } else {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
         }

         if (immediatesourceentity.getPersistentData().m_128459_("T") >= 100.0D && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

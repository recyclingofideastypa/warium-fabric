package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class DebrisTrailProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (100.0D <= immediatesourceentity.getPersistentData().m_128459_("T") && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

         if (40.0D >= immediatesourceentity.getPersistentData().m_128459_("T")) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, 0.0D, 0.0D, 0.0D);
         }

         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
      }
   }
}

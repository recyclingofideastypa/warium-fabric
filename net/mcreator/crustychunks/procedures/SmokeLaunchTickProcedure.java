package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SmokeLaunchTickProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double RocketVelocity = 0.0D;
         if (immediatesourceentity.m_5842_() || immediatesourceentity.getPersistentData().m_128459_("T") >= 25.0D) {
            SmokeMortarHitProcedure.execute(world, immediatesourceentity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
      }
   }
}

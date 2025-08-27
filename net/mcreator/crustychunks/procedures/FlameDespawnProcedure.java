package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;

public class FlameDespawnProcedure {
   public static void execute(Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (immediatesourceentity.m_5842_() && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class MediumBombTickProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (immediatesourceentity.m_5842_()) {
            MediumBombProjectileHitsBlockProcedure.execute(world, immediatesourceentity);
         }

      }
   }
}

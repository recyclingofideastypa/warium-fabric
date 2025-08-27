package net.mcreator.crustychunks.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BunkerBusterTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (immediatesourceentity.m_5842_() && 1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
            SuperLargeBombProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class SmokeBombDetonateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double particleRadius = 0.0D;
      double particleAmount = 0.0D;
      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.SMOKE_BOMB.get()) {
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
      }

      SmokeExplosionProcedure.execute(world, x, y, z);
   }
}

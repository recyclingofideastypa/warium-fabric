package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class RawLithiumBlockNeighbourBlockChangesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() == Blocks.f_49990_ || world.m_8055_(BlockPos.m_274561_(x + 1.0D, y, z)).m_60734_() == Blocks.f_49990_ || world.m_8055_(BlockPos.m_274561_(x, y, z + 1.0D)).m_60734_() == Blocks.f_49990_ || world.m_8055_(BlockPos.m_274561_(x - 1.0D, y, z)).m_60734_() == Blocks.f_49990_ || world.m_8055_(BlockPos.m_274561_(x, y, z - 1.0D)).m_60734_() == Blocks.f_49990_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50016_.m_49966_(), 3);
         SmallExplosionProcedure.execute(world, x, y, z);
      }

   }
}

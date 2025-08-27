package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class WorkerLandmineDeployProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.m_8055_(BlockPos.m_274561_(x, y - 1.0D, z)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60815_()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.AI_MINE.get()).m_49966_(), 3);
         world.m_46796_(2001, BlockPos.m_274561_(x, y - 1.0D, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y - 1.0D, z))));
      }

   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class ConcreteDamage0Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.REENFORCED_CONCRETE.get()).m_49966_(), 3);
      world.m_46796_(2001, BlockPos.m_274561_(x, y, z), Block.m_49956_(((Block)CrustyChunksModBlocks.STEEL_BLOCK.get()).m_49966_()));
   }
}

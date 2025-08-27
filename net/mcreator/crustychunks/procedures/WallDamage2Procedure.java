package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class WallDamage2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.FRACTURED_CONCRETE_WALL.get()).m_49966_(), 3);
      world.m_46796_(2001, BlockPos.m_274561_(x, y, z), Block.m_49956_(Blocks.f_50652_.m_49966_()));
   }
}

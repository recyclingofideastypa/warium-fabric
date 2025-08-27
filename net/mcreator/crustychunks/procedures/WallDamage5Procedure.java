package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class WallDamage5Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (Mth.m_216271_(RandomSource.m_216327_(), 1, 2) == 2) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_49994_.m_49966_(), 3);
      }

      world.m_46796_(2001, BlockPos.m_274561_(x, y, z), Block.m_49956_(Blocks.f_49994_.m_49966_()));
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ScorchDirtOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.m_8055_(BlockPos.m_274561_(x, y - 1.0D, z)).m_60734_() == CrustyChunksModBlocks.SCORCH_DIRT.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y - 1.0D, z), ((Block)CrustyChunksModBlocks.HARDDIRT.get()).m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() == Blocks.f_50016_ && 1 != Mth.m_216271_(RandomSource.m_216327_(), 1, 35)) {
         if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 5) && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 3.0D, z, 1, 1.0D, 3.0D, 1.0D, 0.01D);
         }
      } else {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.HARDDIRT.get()).m_49966_(), 3);
      }

   }
}

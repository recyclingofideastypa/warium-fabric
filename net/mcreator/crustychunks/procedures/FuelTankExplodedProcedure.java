package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class FuelTankExplodedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.DAMAGEDFUELTANK.get()).m_49966_(), 3);
      if (world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.m_8767_(ParticleTypes.f_123744_, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.25D, 0.25D, 0.25D, 0.1D);
      }

   }
}

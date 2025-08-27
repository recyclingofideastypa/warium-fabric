package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class FuelRodsDepleteProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (CrustyChunksModBlocks.FUEL_RODS_1.get() == world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.EMPTY_FUEL_RODS.get()).m_49966_(), 3);
      }

      if (CrustyChunksModBlocks.FUEL_RODS_2.get() == world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.FUEL_RODS_1.get()).m_49966_(), 3);
      }

      if (CrustyChunksModBlocks.FUEL_RODS_3.get() == world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.FUEL_RODS_2.get()).m_49966_(), 3);
      }

      if (CrustyChunksModBlocks.FUEL_RODS_4.get() == world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.FUEL_RODS_3.get()).m_49966_(), 3);
      }

   }
}

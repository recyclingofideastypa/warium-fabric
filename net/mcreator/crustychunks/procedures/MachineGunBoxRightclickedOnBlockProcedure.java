package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class MachineGunBoxRightclickedOnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() != CrustyChunksModBlocks.MACHINE_GUN.get()) {
            MGBoxScriptProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}

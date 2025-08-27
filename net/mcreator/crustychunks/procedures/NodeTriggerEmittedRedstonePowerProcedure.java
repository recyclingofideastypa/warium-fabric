package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class NodeTriggerEmittedRedstonePowerProcedure {
   public static double execute(LevelAccessor world, double x, double y, double z) {
      boolean logic = false;
      double number = 0.0D;
      if (0.0D < ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Trigger")) {
         number = 15.0D;
      } else {
         number = 0.0D;
      }

      return number;
   }
}

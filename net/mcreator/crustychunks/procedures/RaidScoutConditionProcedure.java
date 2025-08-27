package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class RaidScoutConditionProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      boolean logic = false;
      if (world.m_6106_().m_5470_().m_46207_(CrustyChunksModGameRules.APOCALYPSE_MODE) && world.m_46861_(BlockPos.m_274561_(x, y, z))) {
         logic = true;
      } else {
         logic = false;
      }

      return logic;
   }
}

package net.mcreator.crustychunks.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class ManualAimerEmittedRedstonePowerProcedure {
   public static double execute(BlockState blockstate) {
      double returnvalue = 0.0D;
      Property var4 = blockstate.m_60734_().m_49965_().m_61081_("firing");
      int var10001;
      if (var4 instanceof IntegerProperty) {
         IntegerProperty _getip1 = (IntegerProperty)var4;
         var10001 = (Integer)blockstate.m_61143_(_getip1);
      } else {
         var10001 = -1;
      }

      if (0 < var10001) {
         returnvalue = 15.0D;
      } else {
         returnvalue = 0.0D;
      }

      return returnvalue;
   }
}

package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class ExplosiveBarrelTriggerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      world.m_46961_(BlockPos.m_274561_(x, y, z), false);
      SmallExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
   }
}

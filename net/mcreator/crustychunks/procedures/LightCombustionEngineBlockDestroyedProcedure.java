package net.mcreator.crustychunks.procedures;

import net.minecraft.world.level.LevelAccessor;

public class LightCombustionEngineBlockDestroyedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      GasolineExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
   }
}

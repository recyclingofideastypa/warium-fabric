package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class CharredBlockOnRandomClientDisplayTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (5 == Mth.m_216271_(RandomSource.m_216327_(), 1, 5)) {
         world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + Mth.m_216263_(RandomSource.m_216327_(), 0.2D, 0.8D), y + Mth.m_216263_(RandomSource.m_216327_(), 0.2D, 0.8D), z + Mth.m_216263_(RandomSource.m_216327_(), 0.2D, 0.8D), 0.0D, 1.0D, 0.0D);
      }

   }
}

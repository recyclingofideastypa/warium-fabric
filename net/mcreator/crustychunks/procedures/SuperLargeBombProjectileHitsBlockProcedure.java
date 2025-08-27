package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SuperLargeBombProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         HugeExplosionProcedure.execute(world, x + immediatesourceentity.m_20154_().f_82479_ * 2.0D, y + immediatesourceentity.m_20154_().f_82480_ * 2.0D, z - immediatesourceentity.m_20154_().f_82481_ * 2.0D);
         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

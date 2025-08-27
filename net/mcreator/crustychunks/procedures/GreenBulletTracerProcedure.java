package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class GreenBulletTracerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.BULLET_TRAIL.get(), immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_(), 0.0D, 0.0D, 0.0D);
         double var10000;
         Projectile _projEnt;
         if (immediatesourceentity instanceof Projectile) {
            _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.m_20184_().m_82553_();
         } else {
            var10000 = 0.0D;
         }

         if (var10000 >= 2.0D && !immediatesourceentity.m_20068_()) {
            immediatesourceentity.m_20256_(new Vec3(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_() + 0.04D, immediatesourceentity.m_20184_().m_7094_()));
         }

         if (immediatesourceentity instanceof Projectile) {
            _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.m_20184_().m_82553_();
         } else {
            var10000 = 0.0D;
         }

         if (var10000 <= 0.75D && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

         ForceChunksProcedure.execute(world, x, y, z);
      }
   }
}

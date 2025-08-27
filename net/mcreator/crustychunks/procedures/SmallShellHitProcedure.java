package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class SmallShellHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double Power = 0.0D;

         for(int index0 = 0; index0 < 5; ++index0) {
            if (world instanceof ServerLevel) {
               ServerLevel projectileLevel = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36762_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, 5.0F, 1);
               _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
               _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), 5.0F, 20.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }
         }

         DamagesProcedure.execute(world, x, y, z);
         HeavyCrackProcedureProcedure.execute(world, x, y, z);
         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

         MicroExplosionProcedure.execute(world, immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
      }
   }
}

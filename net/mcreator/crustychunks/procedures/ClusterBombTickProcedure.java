package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.SmallBombProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ClusterBombTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean Trigger = false;
         immediatesourceentity.getPersistentData().m_128347_("Time", immediatesourceentity.getPersistentData().m_128459_("Time") + 1.0D);
         if (!(immediatesourceentity.getPersistentData().m_128459_("Time") <= 30.0D)) {
            for(int index0 = 0; index0 < 4; ++index0) {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new SmallBombProjectileEntity((EntityType)CrustyChunksModEntities.SMALL_BOMB_PROJECTILE.get(), level);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 5.0F, 1);
                  _entityToSpawn.m_6034_(x, y, z);
                  double var10001 = immediatesourceentity.m_20184_().m_7096_();
                  double var10002 = immediatesourceentity.m_20184_().m_7098_();
                  double var10003 = immediatesourceentity.m_20184_().m_7094_();
                  double var10004;
                  if (immediatesourceentity instanceof Projectile) {
                     Projectile _projEnt = (Projectile)immediatesourceentity;
                     var10004 = _projEnt.m_20184_().m_82553_();
                  } else {
                     var10004 = 0.0D;
                  }

                  _entityToSpawn.m_6686_(var10001, var10002, var10003, (float)var10004, 12.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            }

            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

         if (immediatesourceentity.m_5842_()) {
            ClusterRocketHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

      }
   }
}

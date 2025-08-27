package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.HugeFragmentEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class WariumSpallProcedureProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double Power = 0.0D;
         if (world instanceof ServerLevel) {
            ServerLevel projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new HugeFragmentEntity((EntityType)CrustyChunksModEntities.HUGE_FRAGMENT.get(), level);
                  entityToSpawn.m_5602_(shooter);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36762_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, immediatesourceentity, 3.0F, 1);
            _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
            _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), 3.0F, 8.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

      }
   }
}

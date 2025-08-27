package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.FusionBlastEntityEntity;
import net.mcreator.crustychunks.entity.FusionEffectProjectileEntity;
import net.mcreator.crustychunks.entity.FusionHeatWaveEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.fml.ModList;

public class FusionExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double xRadius = 0.0D;
      double loop = 0.0D;
      double zRadius = 0.0D;
      double particleAmount = 0.0D;
      if (!world.m_8055_(BlockPos.m_274561_(x, y + 15.0D, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:immortal")))) {
         world.m_46961_(BlockPos.m_274561_(x, y + 15.0D, z), false);
      } else if (world.m_8055_(BlockPos.m_274561_(x, y + 7.0D, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:immortal")))) {
         world.m_46961_(BlockPos.m_274561_(x, y + 7.0D, z), false);
      }

      ServerLevel projectileLevel;
      Projectile _entityToSpawn;
      if (world instanceof ServerLevel) {
         projectileLevel = (ServerLevel)world;
         _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new FusionHeatWaveEntity((EntityType)CrustyChunksModEntities.FUSION_HEAT_WAVE.get(), level);
               entityToSpawn.m_36781_((double)damage);
               entityToSpawn.m_36735_(knockback);
               entityToSpawn.m_20225_(true);
               return entityToSpawn;
            }
         })).getArrow(projectileLevel, 5.0F, 1);
         _entityToSpawn.m_6034_(x, y + 7.0D, z);
         _entityToSpawn.m_6686_(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
         projectileLevel.m_7967_(_entityToSpawn);
      }

      if (world instanceof ServerLevel) {
         projectileLevel = (ServerLevel)world;
         _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new FusionBlastEntityEntity((EntityType)CrustyChunksModEntities.FUSION_BLAST_ENTITY.get(), level);
               entityToSpawn.m_36781_((double)damage);
               entityToSpawn.m_36735_(knockback);
               entityToSpawn.m_20225_(true);
               return entityToSpawn;
            }
         })).getArrow(projectileLevel, 5.0F, 1);
         _entityToSpawn.m_6034_(x, y + 15.0D, z);
         _entityToSpawn.m_6686_(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
         projectileLevel.m_7967_(_entityToSpawn);
      }

      Level _level;
      if (ModList.get().isLoaded("explosionoverhaul")) {
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_254849_((Entity)null, x, y + 4.0D, z, 200.0F, ExplosionInteraction.BLOCK);
            }
         }
      } else {
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_254849_((Entity)null, x, y + 4.0D, z, 30.0F, ExplosionInteraction.BLOCK);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_254849_((Entity)null, x, y + 4.0D, z, 40.0F, ExplosionInteraction.NONE);
            }
         }
      }

      if (world instanceof ServerLevel) {
         projectileLevel = (ServerLevel)world;
         _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new FusionEffectProjectileEntity((EntityType)CrustyChunksModEntities.FUSION_EFFECT_PROJECTILE.get(), level);
               entityToSpawn.m_36781_((double)damage);
               entityToSpawn.m_36735_(knockback);
               entityToSpawn.m_20225_(true);
               return entityToSpawn;
            }
         })).getArrow(projectileLevel, 5.0F, 1);
         _entityToSpawn.m_6034_(x, y + 7.0D, z);
         _entityToSpawn.m_6686_(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
         projectileLevel.m_7967_(_entityToSpawn);
      }

   }
}

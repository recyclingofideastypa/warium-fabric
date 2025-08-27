package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.NuclearBlastEntityEntity;
import net.mcreator.crustychunks.entity.NuclearSecondaryEffectEntity;
import net.mcreator.crustychunks.entity.NuclearThermalRadEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.fml.ModList;

public class FissionExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double xRadius = 0.0D;
      double loop = 0.0D;
      double zRadius = 0.0D;
      double particleAmount = 0.0D;
      boolean found = false;
      boolean space = false;
      ResourceKey var10000;
      Level _level;
      if (world instanceof Level) {
         _level = (Level)world;
         var10000 = _level.m_46472_();
      } else if (world instanceof WorldGenLevel) {
         WorldGenLevel _wgl = (WorldGenLevel)world;
         var10000 = _wgl.m_6018_().m_46472_();
      } else {
         var10000 = Level.f_46428_;
      }

      label88: {
         if (!("D:" + var10000).contains("orbit")) {
            if (world instanceof Level) {
               Level _lvl = (Level)world;
               var10000 = _lvl.m_46472_();
            } else if (world instanceof WorldGenLevel) {
               WorldGenLevel _wgl = (WorldGenLevel)world;
               var10000 = _wgl.m_6018_().m_46472_();
            } else {
               var10000 = Level.f_46428_;
            }

            if (!("D:" + var10000).contains("solar_system")) {
               if (world instanceof Level) {
                  Level _lvl = (Level)world;
                  var10000 = _lvl.m_46472_();
               } else if (world instanceof WorldGenLevel) {
                  WorldGenLevel _wgl = (WorldGenLevel)world;
                  var10000 = _wgl.m_6018_().m_46472_();
               } else {
                  var10000 = Level.f_46428_;
               }

               if (!("D:" + var10000).contains("orbit")) {
                  if (world instanceof Level) {
                     Level _lvl = (Level)world;
                     var10000 = _lvl.m_46472_();
                  } else if (world instanceof WorldGenLevel) {
                     WorldGenLevel _wgl = (WorldGenLevel)world;
                     var10000 = _wgl.m_6018_().m_46472_();
                  } else {
                     var10000 = Level.f_46428_;
                  }

                  if (!("D:" + var10000).contains("alpha_system")) {
                     break label88;
                  }
               }
            }
         }

         space = true;
      }

      if (space) {
         SpaceFissionExplosionProcedure.execute(world, x, y, z);
      } else {
         if (!world.m_8055_(BlockPos.m_274561_(x, y + 15.0D, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:immortal")))) {
            world.m_46961_(BlockPos.m_274561_(x, y + 15.0D, z), false);
         } else if (world.m_8055_(BlockPos.m_274561_(x, y + 7.0D, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:immortal")))) {
            world.m_46961_(BlockPos.m_274561_(x, y + 7.0D, z), false);
         }

         Projectile _entityToSpawn;
         ServerLevel projectileLevel;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new NuclearThermalRadEntity((EntityType)CrustyChunksModEntities.NUCLEAR_THERMAL_RAD.get(), level);
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
                  AbstractArrow entityToSpawn = new NuclearBlastEntityEntity((EntityType)CrustyChunksModEntities.NUCLEAR_BLAST_ENTITY.get(), level);
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

         if (ModList.get().isLoaded("explosionoverhaul")) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_254849_((Entity)null, x, y + 4.0D, z, 127.0F, ExplosionInteraction.BLOCK);
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
                  AbstractArrow entityToSpawn = new NuclearSecondaryEffectEntity((EntityType)CrustyChunksModEntities.NUCLEAR_SECONDARY_EFFECT.get(), level);
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
}

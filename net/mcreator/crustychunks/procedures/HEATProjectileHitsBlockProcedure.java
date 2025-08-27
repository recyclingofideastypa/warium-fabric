package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
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
import net.minecraft.world.level.block.entity.BlockEntity;

public class HEATProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.BATTLE_CANNON_BREECH.get() && ((<undefinedtype>)(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Loaded")) {
            SmallExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.ARTILLERYBREECH.get() && ((<undefinedtype>)(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Loaded")) {
            MediumExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }

         DamagesProcedure.execute(world, x, y, z);
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:pennable"))) || world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60800_(world, BlockPos.m_274561_(x, y, z)) < 15.0F && world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60800_(world, BlockPos.m_274561_(x, y, z)) >= 0.0F && !world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:dirts"))) && !world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:sands")))) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);

            int index1;
            ServerLevel projectileLevel;
            Projectile _entityToSpawn;
            for(index1 = 0; index1 < 35; ++index1) {
               if (world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36762_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, immediatesourceentity, 5.0F, 1);
                  _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
                  _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), 2.5F, 37.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            }

            for(index1 = 0; index1 < 10; ++index1) {
               if (world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_20254_(100);
                        entityToSpawn.m_36762_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, immediatesourceentity, 5.0F, 1);
                  _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
                  _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), 5.0F, 2.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            }
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.ArtillerySolidProjectileEntity;
import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.entity.HugeFragmentEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.registries.ForgeRegistries;

public class SolidArtilleryHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double Power = 0.0D;
         CrustyChunksMod.queueServerWork(3, () -> {
            TinyExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_254849_((Entity)null, x + 0.5D, y + 0.5D, z + 0.5D, 3.0F, ExplosionInteraction.NONE);
               }
            }

         });
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
         double var10000;
         if (immediatesourceentity instanceof Projectile) {
            Projectile _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.m_20184_().m_82553_();
         } else {
            var10000 = 0.0D;
         }

         Power = var10000;
         ServerLevel projectileLevel;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            projectileLevel.m_8767_(ParticleTypes.f_123747_, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.5D, 0.5D, 0.5D, 0.05D);
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            projectileLevel.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x + 0.5D, y + 0.5D, z + 0.5D, 40, 0.6D, 0.6D, 0.6D, 1.2D);
         }

         HugeBulletHitProcedure.execute(world, x, y, z, immediatesourceentity);
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:pennable"))) || world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60800_(world, BlockPos.m_274561_(x, y, z)) < 5.0F && world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60800_(world, BlockPos.m_274561_(x, y, z)) >= 0.0F) {
            if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:metal"))) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 4.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.5D, 0.7D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 4.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.5D, 0.7D), false);
               }
            }

            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
            if (Power >= 4.0D && world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new ArtillerySolidProjectileEntity((EntityType)CrustyChunksModEntities.ARTILLERY_SOLID_PROJECTILE.get(), level);
                     entityToSpawn.m_5602_(shooter);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36767_(piercing);
                     entityToSpawn.m_20254_(100);
                     entityToSpawn.m_36762_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, immediatesourceentity, 10.0F, 1, (byte)50);
               _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
               _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), (float)(Power - 2.0D), 4.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }

            Projectile _entityToSpawn;
            ServerLevel projectileLevel;
            int index1;
            for(index1 = 0; index1 < 15; ++index1) {
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
                  })).getArrow(projectileLevel, immediatesourceentity, 0.5F, 1);
                  _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
                  _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), 3.0F, 20.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            }

            for(index1 = 0; index1 < 35; ++index1) {
               if (world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  _entityToSpawn = ((<undefinedtype>)(new Object() {
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
                  _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), 3.0F, 14.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            }
         }

         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

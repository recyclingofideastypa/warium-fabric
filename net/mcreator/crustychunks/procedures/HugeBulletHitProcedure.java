package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.entity.HugeBulletFireEntity;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class HugeBulletHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double Power = 0.0D;
         DamagesProcedure.execute(world, x, y, z);
         int index3;
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:dirts")))) {
            for(index3 = 0; index3 < 10; ++index3) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_() + 1.0D, immediatesourceentity.m_20189_(), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D));
            }
         }

         ServerLevel projectileLevel;
         Projectile _entityToSpawn;
         Projectile _projEnt;
         double var10000;
         double var10001;
         Level _level;
         double var10002;
         Projectile _projEnt;
         double var10003;
         double var10004;
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:chippable")))) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10000 = _projEnt.m_20184_().m_82553_();
            } else {
               var10000 = 0.0D;
            }

            if (var10000 > 2.0D && world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new HugeBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_BULLET_FIRE.get(), level);
                     entityToSpawn.m_5602_(shooter);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36767_(piercing);
                     entityToSpawn.m_36762_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, immediatesourceentity, 2.0F, 1, (byte)50);
               _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
               var10001 = immediatesourceentity.m_20184_().m_7096_();
               var10002 = immediatesourceentity.m_20184_().m_7098_();
               var10003 = immediatesourceentity.m_20184_().m_7094_();
               if (immediatesourceentity instanceof Projectile) {
                  _projEnt = (Projectile)immediatesourceentity;
                  var10004 = _projEnt.m_20184_().m_82553_();
               } else {
                  var10004 = 0.0D;
               }

               _entityToSpawn.m_6686_(var10001, var10002, var10003, (float)(var10004 - 0.1D), 0.8F);
               projectileLevel.m_7967_(_entityToSpawn);
            }
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:breakable_metal")))) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:shatterable")))) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10000 = _projEnt.m_20184_().m_82553_();
            } else {
               var10000 = 0.0D;
            }

            if (var10000 > 2.0D && world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new HugeBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_BULLET_FIRE.get(), level);
                     entityToSpawn.m_5602_(shooter);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36767_(piercing);
                     entityToSpawn.m_36762_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, immediatesourceentity, 2.0F, 1, (byte)50);
               _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
               var10001 = immediatesourceentity.m_20184_().m_7096_();
               var10002 = immediatesourceentity.m_20184_().m_7098_();
               var10003 = immediatesourceentity.m_20184_().m_7094_();
               if (immediatesourceentity instanceof Projectile) {
                  _projEnt = (Projectile)immediatesourceentity;
                  var10004 = _projEnt.m_20184_().m_82553_();
               } else {
                  var10004 = 0.0D;
               }

               _entityToSpawn.m_6686_(var10001, var10002, var10003, (float)(var10004 - 0.1D), 0.8F);
               projectileLevel.m_7967_(_entityToSpawn);
            }
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:splinterable")))) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10000 = _projEnt.m_20184_().m_82553_();
            } else {
               var10000 = 0.0D;
            }

            if (var10000 > 2.0D && world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new HugeBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_BULLET_FIRE.get(), level);
                     entityToSpawn.m_5602_(shooter);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36767_(piercing);
                     entityToSpawn.m_36762_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, immediatesourceentity, 2.0F, 1, (byte)50);
               _entityToSpawn.m_6034_(immediatesourceentity.m_20185_() - immediatesourceentity.m_20154_().f_82479_ * 1.0D, immediatesourceentity.m_20186_() - immediatesourceentity.m_20154_().f_82480_ * 1.0D, immediatesourceentity.m_20189_() + immediatesourceentity.m_20154_().f_82481_ * 1.0D);
               var10001 = immediatesourceentity.m_20184_().m_7096_();
               var10002 = immediatesourceentity.m_20184_().m_7098_();
               var10003 = immediatesourceentity.m_20184_().m_7094_();
               if (immediatesourceentity instanceof Projectile) {
                  _projEnt = (Projectile)immediatesourceentity;
                  var10004 = _projEnt.m_20184_().m_82553_();
               } else {
                  var10004 = 0.0D;
               }

               _entityToSpawn.m_6686_(var10001, var10002, var10003, (float)(var10004 - 0.1D), 0.8F);
               projectileLevel.m_7967_(_entityToSpawn);
            }
         }

         ServerLevel _level;
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:resistant")))) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 0.5F, (float)(1.0D + Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.4D)));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 0.5F, (float)(1.0D + Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.4D)), false);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123759_, x + 0.5D, y + 0.5D, z + 0.5D, 7, 0.7D, 0.7D, 0.7D, 0.2D);
            }
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:crushable")))) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 2.0F, (float)(1.0D + Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.4D)));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 2.0F, (float)(1.0D + Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.4D)), false);
               }
            }

            BlockPos _bp = BlockPos.m_274561_(x, y, z);
            BlockState _bs = Blocks.f_49994_.m_49966_();
            BlockState _bso = world.m_8055_(_bp);
            UnmodifiableIterator var24 = _bso.m_61148_().entrySet().iterator();

            while(var24.hasNext()) {
               Entry<Property<?>, Comparable<?>> entry = (Entry)var24.next();
               Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
               if (_property != null && _bs.m_61143_(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                  } catch (Exception var17) {
                  }
               }
            }

            world.m_7731_(_bp, _bs, 3);

            for(index3 = 0; index3 < 10; ++index3) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.WHITE_DUST.get(), immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_() + 1.0D, immediatesourceentity.m_20189_(), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D));
            }
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50440_) {
            world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50493_.m_49966_(), 3);
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:sands")))) {
            for(index3 = 0; index3 < 10; ++index3) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SAND.get(), immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_() + 1.0D, immediatesourceentity.m_20189_(), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D));
            }
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:dusts")))) {
            for(index3 = 0; index3 < 10; ++index3) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.WHITE_DUST.get(), immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_() + 1.0D, immediatesourceentity.m_20189_(), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D), Mth.m_216263_(RandomSource.m_216327_(), -0.2D, 0.2D));
            }
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:metals")))) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.5F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x + 0.5D, y + 1.0D, z + 0.5D, 35, 0.3D, 0.3D, 3.0D, 1.0D);
            }
         }

         world.m_46796_(2001, BlockPos.m_274561_(x, y + 1.0D, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y, z))));
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 6.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 1.0D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 6.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 1.0D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:small_expllosion_distant")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:small_expllosion_distant")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D), false);
            }
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60800_(world, BlockPos.m_274561_(x, y, z)) < 5.0F && world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60800_(world, BlockPos.m_274561_(x, y, z)) >= 0.0F && !world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:dirts"))) && !world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:sands"))) && !world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:concrete")))) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }

         HeavyCrackProcedureProcedure.execute(world, x, y, z);
         CrustyChunksMod.queueServerWork(1, () -> {
            if (world instanceof ServerLevel) {
               ServerLevel projectileLevelx = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                     entityToSpawn.m_5602_(shooter);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36767_(piercing);
                     entityToSpawn.m_36762_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevelx, immediatesourceentity, 3.0F, 1, (byte)50);
               _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
               _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), 5.0F, 0.0F);
               projectileLevelx.m_7967_(_entityToSpawn);
            }

            for(int index4 = 0; index4 < Mth.m_216271_(RandomSource.m_216327_(), 4, 6); ++index4) {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawnx = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36767_(piercing);
                        entityToSpawn.m_36762_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, immediatesourceentity, 3.0F, 1, (byte)50);
                  _entityToSpawnx.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
                  _entityToSpawnx.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), 5.0F, 15.0F);
                  projectileLevel.m_7967_(_entityToSpawnx);
               }
            }

            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }

         });
      }
   }
}

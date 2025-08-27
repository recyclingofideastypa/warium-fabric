package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.ArtilleryWarningMarkerEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MortarerAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rev = 0.0D;
         double targetrange = 0.0D;
         if (entity.getPersistentData().m_128459_("T") > -1.0D) {
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") - 1.0D);
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 != null) {
            AlivecheckProcedure.execute(entity);
            Mob _mobEnt;
            LivingEntity var10001;
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var25 = Math.pow(Math.abs(y - var10001.m_20186_()), 2.0D);
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            var25 += Math.pow(Math.abs(z - var10002.m_20189_()), 2.0D);
            Mob _mobEnt;
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            targetrange = Math.sqrt(var25 + Math.pow(Math.abs(x - var10002.m_20185_()), 2.0D));
            Anchor var26 = Anchor.EYES;
            Vec3 var30 = new Vec3;
            LivingEntity var10006;
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10006 = _mobEnt.m_5448_();
            } else {
               var10006 = null;
            }

            double var10004 = x - (x - var10006.m_20185_()) / 2.0D;
            double var10005 = y + 186.0D - targetrange / 2.0D;
            LivingEntity var10008;
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10008 = _mobEnt.m_5448_();
            } else {
               var10008 = null;
            }

            var30.<init>(var10004, var10005, z - (z - var10008.m_20189_()) / 2.0D);
            entity.m_7618_(var26, var30);
            if (entity.getPersistentData().m_128459_("T") <= -1.0D && 200.0D > targetrange && 25.0D < targetrange) {
               MortarerCannonProcedure.execute(world, x, y, z, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new ArtilleryWarningMarkerEntity((EntityType)CrustyChunksModEntities.ARTILLERY_WARNING_MARKER.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, 0.0F, 0);
                  if (entity instanceof Mob) {
                     _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  double var28 = var10001.m_20185_();
                  if (entity instanceof Mob) {
                     _mobEnt = (Mob)entity;
                     var10002 = _mobEnt.m_5448_();
                  } else {
                     var10002 = null;
                  }

                  double var31 = var10002.m_20186_() + 2.0D;
                  LivingEntity var10003;
                  if (entity instanceof Mob) {
                     _mobEnt = (Mob)entity;
                     var10003 = _mobEnt.m_5448_();
                  } else {
                     var10003 = null;
                  }

                  _entityToSpawn.m_6034_(var28, var31, var10003.m_20189_());
                  _entityToSpawn.m_6686_(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               for(int index0 = 0; index0 < 15; ++index0) {
                  world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.PUFF.get(), x + entity.m_20154_().f_82479_, y + 1.0D + entity.m_20154_().f_82480_, z + entity.m_20154_().f_82481_, entity.m_20154_().f_82479_ * 2.0D + Mth.m_216263_(RandomSource.m_216327_(), -0.4D, 0.4D), entity.m_20154_().f_82480_ * 2.0D + Mth.m_216263_(RandomSource.m_216327_(), -0.4D, 0.4D), entity.m_20154_().f_82481_ * 2.0D + Mth.m_216263_(RandomSource.m_216327_(), -0.4D, 0.4D));
               }
            }

            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:robot"))) && entity instanceof Mob) {
               try {
                  ((Mob)entity).m_6710_((LivingEntity)null);
               } catch (Exception var16) {
                  var16.printStackTrace();
               }
            }
         }

         LivingEntity _entity;
         float var27;
         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            var27 = _entity.m_21223_();
         } else {
            var27 = -1.0F;
         }

         LivingEntity _livEnt;
         float var29;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var29 = _livEnt.m_21233_();
         } else {
            var29 = -1.0F;
         }

         if (var27 < var29 / 2.0F && 10 == Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 4.0D, z, 0.0D, 1.0D, 0.0D);
         }

         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            var27 = _entity.m_21223_();
         } else {
            var27 = -1.0F;
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var29 = _livEnt.m_21233_();
         } else {
            var29 = -1.0F;
         }

         if (var27 < var29 / 4.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x, y + 2.0D, z, 2, 1.0D, 1.0D, 1.0D, 1.0D);
            }

            if (10 == Mth.m_216271_(RandomSource.m_216327_(), 1, 80) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 4.0F, 0.7F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 4.0F, 0.7F, false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("T") > 0.0D) {
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") - 1.0D);
         }

         if (entity.getPersistentData().m_128459_("T2") > 0.0D) {
            entity.getPersistentData().m_128347_("T2", entity.getPersistentData().m_128459_("T2") - 1.0D);
         }

         if (!entity.m_20069_() && !entity.m_20068_() && !world.m_46861_(BlockPos.m_274561_(x, y - 200.0D, z)) && world.m_46861_(BlockPos.m_274561_(x, y - 10.0D, z))) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.m_20184_().m_7096_() * 2.0D + 1.0D, entity.m_20184_().m_7098_() * 3.0D, entity.m_20184_().m_7094_() * 2.0D + 1.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.m_20184_().m_7096_() * 2.0D - 1.0D, entity.m_20184_().m_7098_() * 3.0D, entity.m_20184_().m_7094_() * 2.0D + 1.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.m_20184_().m_7096_() * 2.0D + 1.0D, entity.m_20184_().m_7098_() * 3.0D, entity.m_20184_().m_7094_() * 2.0D - 1.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.m_20184_().m_7096_() * 2.0D - 1.0D, entity.m_20184_().m_7098_() * 3.0D, entity.m_20184_().m_7094_() * 2.0D - 1.0D);
            Level _level;
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 7.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 7.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetfar")), SoundSource.NEUTRAL, 20.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetfar")), SoundSource.NEUTRAL, 20.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D), false);
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 20, 0));
               }
            }
         }

      }
   }
}

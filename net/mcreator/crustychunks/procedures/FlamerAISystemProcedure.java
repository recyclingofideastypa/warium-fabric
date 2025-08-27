package net.mcreator.crustychunks.procedures;

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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class FlamerAISystemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rev = 0.0D;
         if (entity.getPersistentData().m_128459_("T") > 0.0D) {
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") - 1.0D);
         }

         if (entity.getPersistentData().m_128459_("T2") > 0.0D) {
            entity.getPersistentData().m_128347_("T2", entity.getPersistentData().m_128459_("T2") - 1.0D);
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         LivingEntity _livEnt;
         float var23;
         float var24;
         if (var10000 != null) {
            Mob _mobEnt;
            if (Mth.m_216271_(RandomSource.m_216327_(), 1, 5) == 1) {
               AlivecheckProcedure.execute(entity);
               Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var25 = var10004.m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var26 = var10005.m_20186_() + 3.0D;
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var25, var26, var10006.m_20189_());
               entity.m_7618_(var10001, var10002);
            }

            if (entity.getPersistentData().m_128459_("T") <= 0.0D) {
               DecimatorFlameThrowerProcedure.execute(world, x, y, z, entity);
            }

            if (Mth.m_216271_(RandomSource.m_216327_(), 1, 100) == 1) {
               DecimatorMeleeProcedure.execute(world, x, y, z, entity);
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
               } catch (Exception var15) {
                  var15.printStackTrace();
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var24 = _livEnt.m_21223_();
            } else {
               var24 = -1.0F;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var23 = _livEnt.m_21233_();
            } else {
               var23 = -1.0F;
            }

            if (var24 < var23 && 1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sparks")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sparks")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var23 = _livEnt.m_21223_();
                  } else {
                     var23 = -1.0F;
                  }

                  _entity.m_21153_(var23 + 1.0F);
               }
            }
         }

         Level _level;
         if (entity.getPersistentData().m_128459_("Cycle") > 0.0D) {
            entity.getPersistentData().m_128347_("Cycle", entity.getPersistentData().m_128459_("Cycle") - 1.0D);
         } else {
            if (entity.m_20184_().m_7096_() != 0.0D && entity.m_20184_().m_7094_() != 0.0D) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mechstep")), SoundSource.NEUTRAL, 2.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 1.1D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mechstep")), SoundSource.NEUTRAL, 2.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 1.1D), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x, y + 0.5D, z, 7, 3.0D, 0.0D, 3.0D, 0.1D);
               }

               rev = 2.0D;
            } else {
               rev = 0.0D;
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:engine")), SoundSource.NEUTRAL, (float)(2.0D + rev), (float)(Mth.m_216263_(RandomSource.m_216327_(), 0.5D, 0.6D) + rev));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:engine")), SoundSource.NEUTRAL, (float)(2.0D + rev), (float)(Mth.m_216263_(RandomSource.m_216327_(), 0.5D, 0.6D) + rev), false);
               }
            }

            entity.getPersistentData().m_128347_("Cycle", 10.0D);
         }

         LivingEntity _entity;
         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            var24 = _entity.m_21223_();
         } else {
            var24 = -1.0F;
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var23 = _livEnt.m_21233_();
         } else {
            var23 = -1.0F;
         }

         if (var24 < var23 / 2.0F && 10 == Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 4.0D, z, 0.0D, 1.0D, 0.0D);
         }

         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            var24 = _entity.m_21223_();
         } else {
            var24 = -1.0F;
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var23 = _livEnt.m_21233_();
         } else {
            var23 = -1.0F;
         }

         if (var24 < var23 / 4.0F) {
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

         if (entity.m_20069_()) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.6D, 0.8D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.6D, 0.8D), false);
               }
            }

            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), x, y, z, 0.0D, -1.0D, 0.0D);
            entity.m_5997_(entity.m_20154_().f_82479_ / 20.0D, 0.0D, entity.m_20154_().f_82481_ / 20.0D);
         } else if (!entity.m_20068_() && !entity.m_20096_() && !world.m_46861_(BlockPos.m_274561_(x, y - 200.0D, z)) && world.m_46861_(BlockPos.m_274561_(x, y - 10.0D, z))) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.m_20184_().m_7096_() * 2.0D + 1.0D, entity.m_20184_().m_7098_() * 3.0D, entity.m_20184_().m_7094_() * 2.0D + 1.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.m_20184_().m_7096_() * 2.0D - 1.0D, entity.m_20184_().m_7098_() * 3.0D, entity.m_20184_().m_7094_() * 2.0D + 1.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.m_20184_().m_7096_() * 2.0D + 1.0D, entity.m_20184_().m_7098_() * 3.0D, entity.m_20184_().m_7094_() * 2.0D - 1.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.m_20184_().m_7096_() * 2.0D - 1.0D, entity.m_20184_().m_7098_() * 3.0D, entity.m_20184_().m_7094_() * 2.0D - 1.0D);
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

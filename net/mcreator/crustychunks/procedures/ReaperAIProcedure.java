package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ReaperAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         boolean schedoodlemode = false;
         boolean Trigger = false;
         boolean detonate = false;
         double distancetotarget = 0.0D;
         double buddydistance = 0.0D;
         double distancefromhome = 0.0D;
         double leadvariable = 0.0D;
         double mx = 0.0D;
         double my = 0.0D;
         double mz = 0.0D;
         double speed = 0.0D;
         double Limiter = 0.0D;
         double rev = 0.0D;
         LivingEntity var10000;
         Mob _entity;
         if (entity instanceof Mob) {
            _entity = (Mob)entity;
            var10000 = _entity.m_5448_();
         } else {
            var10000 = null;
         }

         Mob _mobEnt;
         Mob _mobEnt;
         if (var10000 != null) {
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000.m_6084_()) {
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               target = var10000;
            }
         }

         if (0.0D == entity.getPersistentData().m_128459_("Direction")) {
            entity.getPersistentData().m_128347_("Direction", 1.0D);
         }

         if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 400)) {
            entity.getPersistentData().m_128347_("Direction", entity.getPersistentData().m_128459_("Direction") * -1.0D);
         }

         if (0.0D == entity.getPersistentData().m_128459_("X")) {
            entity.getPersistentData().m_128347_("X", x);
         }

         if (0.0D == entity.getPersistentData().m_128459_("Z")) {
            entity.getPersistentData().m_128347_("Z", z);
         }

         distancefromhome = Math.sqrt(Math.pow(Math.abs(entity.getPersistentData().m_128459_("X") - x), 2.0D) + Math.pow(Math.abs(entity.getPersistentData().m_128459_("Z") - z), 2.0D));
         if (entity.getPersistentData().m_128459_("T") > 0.0D) {
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") - 1.0D);
         }

         if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 160) && (target == null || !((Entity)target).m_6084_())) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(256.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.m_20238_(_center);
            })).toList();
            Iterator var44 = _entfound.iterator();

            label186:
            while(true) {
               Entity entityiterator;
               do {
                  do {
                     if (!var44.hasNext()) {
                        break label186;
                     }

                     entityiterator = (Entity)var44.next();
                  } while(!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:robotarget"))) && (!(entityiterator instanceof Player) || !((<undefinedtype>)(new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                           return _serverPlayer.f_8941_.m_9290_() == GameType.SURVIVAL;
                        } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player) {
                           Player _player = (Player)_ent;
                           return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SURVIVAL;
                        } else {
                           return false;
                        }
                     }
                  })).checkGamemode(entityiterator)));
               } while((target == null || !((Entity)target).m_6084_()) && target != null);

               target = entityiterator;
            }
         }

         label166: {
            if (target != null) {
               if (entity instanceof Mob) {
                  _entity = (Mob)entity;
                  var10000 = _entity.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 != null && Math.sqrt(Math.pow(((Entity)target).m_20186_() - y, 2.0D) + Math.pow(((Entity)target).m_20185_() - x, 2.0D) + Math.pow(((Entity)target).m_20189_() - z, 2.0D)) - Math.sqrt(Math.pow(((Entity)target).m_20186_() - (y + entity.m_20184_().m_7098_()), 2.0D) + Math.pow(((Entity)target).m_20185_() - (x + (entity.m_20154_().f_82479_ + entity.m_20184_().m_7096_()) / 2.0D), 2.0D) + Math.pow(((Entity)target).m_20189_() - (z + (entity.m_20154_().f_82481_ + entity.m_20184_().m_7094_()) / 2.0D), 2.0D)) > 1.15D) {
                  distancetotarget = Math.sqrt(Math.pow(Math.abs(((Entity)target).m_20185_() - x), 2.0D) + Math.pow(Math.abs(((Entity)target).m_20189_() - z), 2.0D));
                  entity.getPersistentData().m_128347_("TargetRange", distancetotarget);
                  if (entity instanceof Mob) {
                     _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 != null) {
                     Anchor var10001 = Anchor.EYES;
                     Vec3 var10002 = new Vec3;
                     LivingEntity var10004;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10004 = _mobEnt.m_5448_();
                     } else {
                        var10004 = null;
                     }

                     double var37 = var10004.m_20185_();
                     LivingEntity var10005;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10005 = _mobEnt.m_5448_();
                     } else {
                        var10005 = null;
                     }

                     double var38 = var10005.m_20186_() + 1.0D;
                     LivingEntity var10006;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10006 = _mobEnt.m_5448_();
                     } else {
                        var10006 = null;
                     }

                     var10002.<init>(var37, var38, var10006.m_20189_());
                     entity.m_7618_(var10001, var10002);
                  }

                  if (entity instanceof Mob) {
                     _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  label155: {
                     if (!var10000.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:bulletproof")))) {
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (Math.abs(var10000.m_20186_() - y) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123342_() - y) + 0.5D) <= 0.0D) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (Math.abs(var10000.m_20185_() - x) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123341_() - x) + 0.5D) <= 0.0D) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (Math.abs(var10000.m_20189_() - z) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123343_() - z) + 0.5D) <= 0.0D) {
                                 break label155;
                              }
                           }
                        }
                     }

                     if (entity.getPersistentData().m_128459_("Rocket") < 28.0D) {
                        CrustyChunksMod.queueServerWork(1, () -> {
                           LivingEntity var10000;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (var10000 != null) {
                              Anchor var10001 = Anchor.EYES;
                              Vec3 var10002 = new Vec3;
                              Mob _mobEntx;
                              LivingEntity var10004;
                              if (entity instanceof Mob) {
                                 _mobEntx = (Mob)entity;
                                 var10004 = _mobEntx.m_5448_();
                              } else {
                                 var10004 = null;
                              }

                              double var10 = var10004.m_20185_();
                              LivingEntity var10005;
                              if (entity instanceof Mob) {
                                 _mobEntx = (Mob)entity;
                                 var10005 = _mobEntx.m_5448_();
                              } else {
                                 var10005 = null;
                              }

                              double var11 = var10005.m_20186_() + Math.pow(entity.getPersistentData().m_128459_("TargetRange") / 35.0D, 2.0D);
                              LivingEntity var10006;
                              if (entity instanceof Mob) {
                                 _mobEntx = (Mob)entity;
                                 var10006 = _mobEntx.m_5448_();
                              } else {
                                 var10006 = null;
                              }

                              var10002.<init>(var10, var11, var10006.m_20189_());
                              entity.m_7618_(var10001, var10002);
                              if (entity.getPersistentData().m_128459_("T") <= 0.0D) {
                                 ReaperPeelerProcedure.execute(world, x, y, z, entity);
                              }
                           }

                        });
                        break label166;
                     }
                  }

                  CrustyChunksMod.queueServerWork(1, () -> {
                     LivingEntity var10000;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 != null) {
                        Anchor var10001 = Anchor.EYES;
                        Vec3 var10002 = new Vec3;
                        Mob _mobEntx;
                        LivingEntity var10004;
                        if (entity instanceof Mob) {
                           _mobEntx = (Mob)entity;
                           var10004 = _mobEntx.m_5448_();
                        } else {
                           var10004 = null;
                        }

                        double var10 = var10004.m_20185_();
                        LivingEntity var10006;
                        if (entity instanceof Mob) {
                           _mobEntx = (Mob)entity;
                           var10006 = _mobEntx.m_5448_();
                        } else {
                           var10006 = null;
                        }

                        double var10005 = 2.0D + var10006.m_20186_() + Math.pow(entity.getPersistentData().m_128459_("TargetRange") / 75.0D, 2.0D);
                        if (entity instanceof Mob) {
                           _mobEntx = (Mob)entity;
                           var10006 = _mobEntx.m_5448_();
                        } else {
                           var10006 = null;
                        }

                        var10002.<init>(var10, var10005, var10006.m_20189_());
                        entity.m_7618_(var10001, var10002);
                        if (entity.getPersistentData().m_128459_("T") <= 0.0D) {
                           ReaperCannonProcedure.execute(world, x, y, z, entity);
                        }
                     }

                  });
                  break label166;
               }
            }

            CrustyChunksMod.queueServerWork(1, () -> {
               entity.m_146922_((float)((double)entity.m_146908_() - entity.getPersistentData().m_128459_("Direction")));
               entity.m_146926_(entity.m_146909_());
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

            });
         }

         if (entity.getPersistentData().m_128459_("Cycle") > 0.0D) {
            entity.getPersistentData().m_128347_("Cycle", entity.getPersistentData().m_128459_("Cycle") - 1.0D);
         } else {
            entity.getPersistentData().m_128347_("Cycle", 15.0D);
            Level _level;
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetidle")), SoundSource.HOSTILE, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetidle")), SoundSource.HOSTILE, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetfar")), SoundSource.HOSTILE, 30.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.25D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetfar")), SoundSource.HOSTILE, 30.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.25D), false);
               }
            }
         }

         if (entity.m_20186_() < (double)(world.m_6924_(Types.MOTION_BLOCKING, Mth.m_14107_(x), Mth.m_14107_(z)) + 45)) {
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() + 0.04D, entity.m_20184_().m_7094_()));
         } else if (entity.m_20186_() > (double)(world.m_6924_(Types.MOTION_BLOCKING, Mth.m_14107_(x), Mth.m_14107_(z)) + 55)) {
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() - 0.005D, entity.m_20184_().m_7094_()));
         }

         entity.m_20256_(new Vec3(entity.m_20184_().m_7096_() * 0.995D + entity.m_20154_().f_82479_ / 5.0D + (entity.getPersistentData().m_128459_("X") - x) / 2500.0D, entity.m_20184_().m_7098_() * 0.995D + entity.m_20154_().f_82480_ / 25.0D, entity.m_20184_().m_7094_() * 0.995D + entity.m_20154_().f_82481_ / 5.0D + (entity.getPersistentData().m_128459_("Z") - z) / 2500.0D));
         world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x - entity.m_20154_().f_82479_ * 4.0D, y + 1.25D - entity.m_20154_().f_82480_, z - entity.m_20154_().f_82481_ * 4.0D, entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_(), entity.m_20184_().m_7094_());
         float var39;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var39 = _livEnt.m_21223_();
         } else {
            var39 = -1.0F;
         }

         if (var39 > 20.0F) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x - entity.m_20154_().f_82479_ * 7.0D, y + 1.25D, z - entity.m_20154_().f_82481_ * 7.0D, 0.0D, 0.0D, 0.0D);
         } else {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x - entity.m_20154_().f_82479_ * 7.0D, y + 1.25D, z - entity.m_20154_().f_82481_ * 7.0D, 0.0D, 0.0D, 0.0D);
         }

         if (target != null && entity instanceof Mob) {
            _entity = (Mob)entity;
            if (target instanceof LivingEntity) {
               LivingEntity _ent = (LivingEntity)target;
               _entity.m_6710_(_ent);
            }
         }

      }
   }
}

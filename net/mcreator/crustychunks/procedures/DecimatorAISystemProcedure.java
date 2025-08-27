package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.ClusterRocketEntity;
import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.entity.IRMissileEntity;
import net.mcreator.crustychunks.entity.IncindiaryRocketProjectileEntity;
import net.mcreator.crustychunks.entity.LargeRocketEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DecimatorAISystemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean Trigger = false;
         boolean hottarget = false;
         Entity target = null;
         double rev = 0.0D;
         double LeadRange = 0.0D;
         double leady = 0.0D;
         double leadx = 0.0D;
         double leadz = 0.0D;
         double targetrange = 0.0D;
         if (entity.getPersistentData().m_128459_("T") > 0.0D) {
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") - 1.0D);
         }

         if (entity.getPersistentData().m_128459_("T2") > 0.0D) {
            entity.getPersistentData().m_128347_("T2", entity.getPersistentData().m_128459_("T2") - 1.0D);
         }

         Mob _mobEnt;
         if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 20)) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(128.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.m_20238_(_center);
            })).toList();
            Iterator var25 = _entfound.iterator();

            label389:
            while(true) {
               Entity entityiterator;
               do {
                  do {
                     if (!var25.hasNext()) {
                        break label389;
                     }

                     entityiterator = (Entity)var25.next();
                  } while(!(entityiterator.m_20186_() > y + 25.0D));
               } while((!((<undefinedtype>)(new Object() {
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
               })).checkGamemode(entityiterator) || !(entityiterator instanceof Player)) && !(entityiterator instanceof LargeRocketEntity) && !(entityiterator instanceof IncindiaryRocketProjectileEntity) && !(entityiterator instanceof ClusterRocketEntity) && !(entityiterator instanceof IRMissileEntity));

               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _ent = (LivingEntity)entityiterator;
                     _mobEnt.m_6710_(_ent);
                  }
               }
            }
         }

         LivingEntity var10000;
         Mob _mobEnt;
         if (entity instanceof Mob) {
            _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         LivingEntity var10004;
         Mob _mobEnt;
         if (var10000 != null) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            target = var10000;
            hottarget = false;
            Vec3 var54 = new Vec3;
            LivingEntity var10002;
            Mob _mobEnt;
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            double var55 = var10002.m_20185_();
            LivingEntity var10003;
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10003 = _mobEnt.m_5448_();
            } else {
               var10003 = null;
            }

            double var57 = var10003.m_20186_();
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10004 = _mobEnt.m_5448_();
            } else {
               var10004 = null;
            }

            var54.<init>(var55, var57, var10004.m_20189_());
            Vec3 _center = var54;
            List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(25.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.m_20238_(_center);
            })).toList();
            Iterator var41 = _entfound.iterator();

            label364:
            while(true) {
               while(true) {
                  if (!var41.hasNext()) {
                     break label364;
                  }

                  Entity entityiterator = (Entity)var41.next();
                  if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:warm"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:robot"))) && entityiterator.m_20186_() > y + 25.0D) {
                     leadx = entityiterator.getPersistentData().m_128459_("Mx");
                     leady = entityiterator.getPersistentData().m_128459_("My");
                     leadz = entityiterator.getPersistentData().m_128459_("Mz");
                     hottarget = true;
                  } else {
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     leadx = var10000.m_20184_().m_7096_();
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     leady = var10000.m_20184_().m_7098_();
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     leadz = var10000.m_20184_().m_7094_();
                  }
               }
            }
         }

         if (entity instanceof Mob) {
            _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         LivingEntity _livEnt;
         float var53;
         float var60;
         if (var10000 != null) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000.m_6084_()) {
               if (hottarget) {
                  if (target.m_20186_() > y + 25.0D) {
                     targetrange = Math.sqrt(Math.pow(Math.abs(y - target.m_20186_()), 2.0D) + Math.pow(Math.abs(z - target.m_20189_()), 2.0D) + Math.pow(Math.abs(x - target.m_20185_()), 2.0D));
                     entity.getPersistentData().m_128347_("TargetX", target.m_20185_() + leadx * 1.5D * targetrange * 0.09D);
                     entity.getPersistentData().m_128347_("TargetY", Math.max(y + 30.0D, target.m_20186_() + 3.0D + leady * 1.5D * targetrange * 0.09D + Math.pow(targetrange / 50.0D, 2.0D)));
                     entity.getPersistentData().m_128347_("TargetZ", target.m_20189_() + leadz * 1.5D * targetrange * 0.09D);
                     entity.getPersistentData().m_128347_("Range", targetrange);
                     if (50.0D < targetrange) {
                        CrustyChunksMod.queueServerWork(1, () -> {
                           if (entity.getPersistentData().m_128459_("T") <= 1.0D) {
                              entity.m_7618_(Anchor.EYES, new Vec3(entity.getPersistentData().m_128459_("TargetX"), entity.getPersistentData().m_128459_("TargetY"), entity.getPersistentData().m_128459_("TargetZ")));
                              DecimatorFlakProcedure.execute(world, x, y, z, entity);
                           }

                        });
                     }
                  }
               } else {
                  if (Mth.m_216271_(RandomSource.m_216327_(), 1, 5) == 1) {
                     Anchor var10001 = Anchor.EYES;
                     Vec3 var56 = new Vec3;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10004 = _mobEnt.m_5448_();
                     } else {
                        var10004 = null;
                     }

                     double var58 = var10004.m_20185_();
                     LivingEntity var10005;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10005 = _mobEnt.m_5448_();
                     } else {
                        var10005 = null;
                     }

                     double var59 = var10005.m_20186_() + 1.0D;
                     LivingEntity var10006;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10006 = _mobEnt.m_5448_();
                     } else {
                        var10006 = null;
                     }

                     var56.<init>(var58, var59, var10006.m_20189_());
                     entity.m_7618_(var10001, var56);
                  }

                  if (entity.getPersistentData().m_128459_("T") <= 0.0D) {
                     label410: {
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

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
                                    CrustyChunksMod.queueServerWork(20, () -> {
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

                                          double var11 = var10005.m_20186_() + 1.0D;
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
                                             DecimatorCoaxSprayProcedure.execute(world, x, y, z, entity);
                                          }
                                       }

                                    });
                                    break label410;
                                 }
                              }
                           }
                        }

                        if (entity.getPersistentData().m_128471_("Cannon")) {
                           CrustyChunksMod.queueServerWork(20, () -> {
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

                                 double var11 = var10005.m_20186_() + 1.0D;
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
                                    DecimatorCannonFireProcedure.execute(world, x, y, z, entity);
                                 }
                              }

                           });
                        } else {
                           CrustyChunksMod.queueServerWork(20, () -> {
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

                                 double var11 = var10005.m_20186_() + 1.0D;
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
                                    DecimatorPeelerProcedure.execute(world, x, y, z, entity);
                                 }
                              }

                           });
                        }
                     }
                  }

                  if (Mth.m_216271_(RandomSource.m_216327_(), 1, 100) == 1) {
                     DecimatorMeleeProcedure.execute(world, x, y, z, entity);
                  }

                  if (Mth.m_216271_(RandomSource.m_216327_(), 1, 200) == 1 && entity.getPersistentData().m_128459_("I") <= 6.0D) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)CrustyChunksModEntities.STRIKER.get()).m_262496_(_level, BlockPos.m_274561_(x, y + 1.0D, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
                        }
                     }

                     entity.getPersistentData().m_128347_("I", entity.getPersistentData().m_128459_("I") + 1.0D);
                     if (entity instanceof DecimatorEntity) {
                        ((DecimatorEntity)entity).setAnimation("SmokeDeploy");
                     }

                     entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") + 80.0D);
                  }

                  if (Mth.m_216271_(RandomSource.m_216327_(), 1, 200) == 1) {
                     if (entity.getPersistentData().m_128471_("Cannon")) {
                        entity.getPersistentData().m_128379_("Cannon", false);
                     } else {
                        entity.getPersistentData().m_128379_("Cannon", true);
                     }
                  }

                  if (4.0D <= entity.getPersistentData().m_128459_("Rocket")) {
                     entity.getPersistentData().m_128379_("Cannon", true);
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
                     } catch (Exception var31) {
                        var31.printStackTrace();
                     }
                  }
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var60 = _livEnt.m_21223_();
            } else {
               var60 = -1.0F;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var53 = _livEnt.m_21233_();
            } else {
               var53 = -1.0F;
            }

            if (var60 < var53 && 1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
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
                     var53 = _livEnt.m_21223_();
                  } else {
                     var53 = -1.0F;
                  }

                  _entity.m_21153_(var53 + 1.0F);
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
            var60 = _entity.m_21223_();
         } else {
            var60 = -1.0F;
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var53 = _livEnt.m_21233_();
         } else {
            var53 = -1.0F;
         }

         if (var60 < var53 / 2.0F && 10 == Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 4.0D, z, 0.0D, 1.0D, 0.0D);
         }

         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            var60 = _entity.m_21223_();
         } else {
            var60 = -1.0F;
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var53 = _livEnt.m_21233_();
         } else {
            var53 = -1.0F;
         }

         if (var60 < var53 / 4.0F) {
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

         if (Mth.m_216271_(RandomSource.m_216327_(), 1, 200) == 1 && 0.0D < entity.getPersistentData().m_128459_("Rocket")) {
            entity.getPersistentData().m_128347_("Rocket", entity.getPersistentData().m_128459_("Rocket") - 1.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.close")), SoundSource.NEUTRAL, 2.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.2D, 0.4D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.close")), SoundSource.NEUTRAL, 2.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.2D, 0.4D), false);
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
         } else if (!entity.m_20068_() && !world.m_46861_(BlockPos.m_274561_(x, y - 200.0D, z)) && world.m_46861_(BlockPos.m_274561_(x, y - 10.0D, z)) && !entity.m_20096_()) {
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

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EradicatorAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         double rev = 0.0D;
         double LeadRange = 0.0D;
         double targetrange = 0.0D;
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

         float var10001;
         float var31;
         label285: {
            if (var10000 != null) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000.m_6084_()) {
                  Vec3 var10002;
                  LivingEntity var10004;
                  LivingEntity var10005;
                  LivingEntity var10006;
                  Anchor var33;
                  Mob _mobEnt;
                  double var39;
                  double var40;
                  if (Mth.m_216271_(RandomSource.m_216327_(), 1, 5) == 1) {
                     var33 = Anchor.EYES;
                     var10002 = new Vec3;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10004 = _mobEnt.m_5448_();
                     } else {
                        var10004 = null;
                     }

                     var39 = var10004.m_20185_();
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10005 = _mobEnt.m_5448_();
                     } else {
                        var10005 = null;
                     }

                     var40 = var10005.m_20186_() + 1.0D;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10006 = _mobEnt.m_5448_();
                     } else {
                        var10006 = null;
                     }

                     var10002.<init>(var39, var40, var10006.m_20189_());
                     entity.m_7618_(var33, var10002);
                  }

                  if (entity.getPersistentData().m_128459_("T") <= 0.0D) {
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     Mob _mobEnt;
                     Mob _mobEnt;
                     Mob _mobEnt;
                     if (var10000.m_20186_() > y + 30.0D) {
                        LivingEntity var35;
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var35 = _mobEnt.m_5448_();
                        } else {
                           var35 = null;
                        }

                        double var37 = Math.pow(Math.abs(y - var35.m_20186_()), 2.0D);
                        LivingEntity var32;
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var32 = _mobEnt.m_5448_();
                        } else {
                           var32 = null;
                        }

                        var37 += Math.pow(Math.abs(z - var32.m_20189_()), 2.0D);
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var32 = _mobEnt.m_5448_();
                        } else {
                           var32 = null;
                        }

                        targetrange = Math.sqrt(var37 + Math.pow(Math.abs(x - var32.m_20185_()), 2.0D));
                        LeadRange = targetrange + Math.pow(targetrange, 2.0D) / 225.0D;
                        var33 = Anchor.EYES;
                        var10002 = new Vec3;
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10004 = _mobEnt.m_5448_();
                        } else {
                           var10004 = null;
                        }

                        var39 = var10004.m_20185_();
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10005 = _mobEnt.m_5448_();
                        } else {
                           var10005 = null;
                        }

                        var39 += var10005.m_20184_().m_7096_() * 1.25D * LeadRange * 0.09D;
                        var40 = y + 25.0D;
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10006 = _mobEnt.m_5448_();
                        } else {
                           var10006 = null;
                        }

                        double var41 = var10006.m_20186_() + 3.0D;
                        LivingEntity var10007;
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var40 = Math.max(var40, var41 + var10007.m_20184_().m_7098_() * 1.25D * LeadRange * 0.09D);
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10006 = _mobEnt.m_5448_();
                        } else {
                           var10006 = null;
                        }

                        var41 = var10006.m_20189_();
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10002.<init>(var39, var40, var41 + var10007.m_20184_().m_7094_() * 1.25D * LeadRange * 0.09D);
                        entity.m_7618_(var33, var10002);
                        CrustyChunksMod.queueServerWork(1, () -> {
                           EradicatorFlakProcedure.execute(world, x, y, z, entity);
                        });
                     } else {
                        label298: {
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (!var10000.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:bulletproof")))) {
                              label296: {
                                 if (entity instanceof Mob) {
                                    _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 label262: {
                                    if (Math.abs(var10000.m_20186_() - y) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123342_() - y) + 0.5D) <= 0.0D) {
                                       if (entity instanceof Mob) {
                                          _mobEnt = (Mob)entity;
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
                                             break label262;
                                          }
                                       }
                                    }

                                    if (world.m_8055_(new BlockPos(entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(7.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123341_(), entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(7.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123342_(), entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(7.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123343_())).m_60734_() == Blocks.f_50016_) {
                                       break label296;
                                    }
                                 }

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
                                          EradicatorMinigunProcedure.execute(world, x, y, z, entity);
                                       }
                                    }

                                 });
                                 break label298;
                              }
                           }

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

                                 double var11 = var10005.m_20186_() + 3.0D;
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
                                    EradicatorCannonProcedure.execute(world, x, y, z, entity);
                                 }
                              }

                           });
                        }
                     }

                     if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 200)) {
                        CrustyChunksMod.queueServerWork(1, () -> {
                           DroneLaunchProcedure.execute(world, x, y, z, entity);
                        });
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
                     } catch (Exception var24) {
                        var24.printStackTrace();
                     }
                  }
                  break label285;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var31 = _livEnt.m_21223_();
            } else {
               var31 = -1.0F;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21233_();
            } else {
               var10001 = -1.0F;
            }

            if (var31 < var10001 && 1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
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
                     var10001 = _livEnt.m_21223_();
                  } else {
                     var10001 = -1.0F;
                  }

                  _entity.m_21153_(var10001 + 1.0F);
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
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:megamechstep")), SoundSource.NEUTRAL, 4.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.5D, 0.6D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:megamechstep")), SoundSource.NEUTRAL, 4.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.5D, 0.6D), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x, y + 0.5D, z, 14, 5.0D, 0.0D, 5.0D, 0.1D);
               }

               rev = 1.4D;
               if (Mth.m_216271_(RandomSource.m_216327_(), 1, 3) == 1) {
                  CrustyChunksMod.queueServerWork(1, () -> {
                     EradicatorMeleeProcedure.execute(world, x, y, z);
                  });
               }
            } else {
               rev = 0.7D;
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:turbine")), SoundSource.NEUTRAL, (float)(3.0D + rev), (float)(Mth.m_216263_(RandomSource.m_216327_(), 0.6D, 0.7D) + rev));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:turbine")), SoundSource.NEUTRAL, (float)(3.0D + rev), (float)(Mth.m_216263_(RandomSource.m_216327_(), 0.6D, 0.7D) + rev), false);
               }
            }

            entity.getPersistentData().m_128347_("Cycle", 7.0D);
         }

         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var31 = _livEnt.m_21223_();
         } else {
            var31 = -1.0F;
         }

         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21233_();
         } else {
            var10001 = -1.0F;
         }

         if (var31 < var10001 / 2.0F && 10 == Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 4.0D, z, 0.0D, 1.0D, 0.0D);
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var31 = _livEnt.m_21223_();
         } else {
            var31 = -1.0F;
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21233_();
         } else {
            var10001 = -1.0F;
         }

         if (var31 < var10001 / 4.0F) {
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

            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), x, y, z, 1.0D, -1.0D, 1.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), x, y, z, -1.0D, -1.0D, -1.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), x, y, z, -1.0D, -1.0D, 1.0D);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), x, y, z, 1.0D, -1.0D, -1.0D);
            entity.m_5997_(entity.m_20154_().f_82479_ / 20.0D, 0.0D, entity.m_20154_().f_82481_ / 20.0D);
         }

      }
   }
}

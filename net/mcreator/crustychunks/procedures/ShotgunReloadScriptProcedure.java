package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.PumpActionShotgunAnimatedItem;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class ShotgunReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Rounds = 0.0D;
         double Capacity = 0.0D;
         Capacity = 8.0D;
         LivingEntity _livEnt;
         ItemStack var10001;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21205_();
         } else {
            var10001 = ItemStack.f_41583_;
         }

         LivingEntity _livEnt;
         ItemStack var10000;
         if (0.0D == var10001.m_41784_().m_128459_("Ammo")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            var10000.m_41784_().m_128359_("Type", "NULL");
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ItemCooldowns var33;
         if (var10000.m_41613_() == 0) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            if (1.0D <= var10001.m_41784_().m_128459_("Ammo")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               Rounds = var10000.m_41784_().m_128459_("Ammo") - 1.0D;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128347_("Ammo", Rounds);
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               ServerLevel _level;
               ItemEntity entityToSpawn;
               if (var10000.m_41784_().m_128461_("Type").equals("BU")) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SHOTGUN_SHELL.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41784_().m_128461_("Type").equals("AP")) {
                     if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SLUG_SHELL.get()));
                        entityToSpawn.m_32010_(10);
                        _level.m_7967_(entityToSpawn);
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41784_().m_128461_("Type").equals("BI") && world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.BIRD_SHOT.get()));
                        entityToSpawn.m_32010_(10);
                        _level.m_7967_(entityToSpawn);
                     }
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotguncycle")), SoundSource.NEUTRAL, 0.1F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotguncycle")), SoundSource.NEUTRAL, 0.1F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128379_("action", false);
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  var33 = _player.m_36335_();
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  var33.m_41524_(var10001.m_41720_(), 20);
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() instanceof PumpActionShotgunAnimatedItem) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128359_("geckoAnim", "rack");
               }
            }
         } else {
            label417: {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               Level _level;
               if (var10000.m_41720_() == CrustyChunksModItems.SHOTGUN_SHELL.get()) {
                  label415: {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (!var10000.m_41784_().m_128461_("Type").equals("NULL")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (!var10000.m_41784_().m_128461_("Type").equals("BU")) {
                           break label415;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     if (0.0D >= var10001.m_41784_().m_128459_("C")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        if (7.0D >= var10001.m_41784_().m_128459_("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41774_(1);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           Rounds = var10000.m_41784_().m_128459_("Ammo") + 1.0D;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("Ammo", Rounds);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41720_() instanceof PumpActionShotgunAnimatedItem) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.m_21205_();
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              var10000.m_41784_().m_128359_("geckoAnim", "Reload");
                           }

                           if (world instanceof Level) {
                              _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotgunreload")), SoundSource.NEUTRAL, 0.2F, 1.0F);
                              } else {
                                 _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotgunreload")), SoundSource.NEUTRAL, 0.2F, 1.0F, false);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("C", 15.0D);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128359_("Type", "BU");
                     break label417;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == CrustyChunksModItems.SLUG_SHELL.get()) {
                  label416: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (!var10000.m_41784_().m_128461_("Type").equals("NULL")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (!var10000.m_41784_().m_128461_("Type").equals("AP")) {
                           break label416;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     if (0.0D >= var10001.m_41784_().m_128459_("C")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        if (7.0D >= var10001.m_41784_().m_128459_("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41774_(1);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           Rounds = var10000.m_41784_().m_128459_("Ammo") + 1.0D;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("Ammo", Rounds);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41720_() instanceof PumpActionShotgunAnimatedItem) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.m_21205_();
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              var10000.m_41784_().m_128359_("geckoAnim", "Reload");
                           }

                           if (world instanceof Level) {
                              _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotgunreload")), SoundSource.NEUTRAL, 0.2F, 1.0F);
                              } else {
                                 _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotgunreload")), SoundSource.NEUTRAL, 0.2F, 1.0F, false);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("C", 15.0D);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128359_("Type", "AP");
                     break label417;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == CrustyChunksModItems.BIRD_SHOT.get()) {
                  label411: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (!var10000.m_41784_().m_128461_("Type").equals("NULL")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (!var10000.m_41784_().m_128461_("Type").equals("BI")) {
                           break label411;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     if (0.0D >= var10001.m_41784_().m_128459_("C")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        if (7.0D >= var10001.m_41784_().m_128459_("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41774_(1);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           Rounds = var10000.m_41784_().m_128459_("Ammo") + 1.0D;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("Ammo", Rounds);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41720_() instanceof PumpActionShotgunAnimatedItem) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.m_21205_();
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              var10000.m_41784_().m_128359_("geckoAnim", "Reload");
                           }

                           if (world instanceof Level) {
                              _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotgunreload")), SoundSource.NEUTRAL, 0.2F, 1.0F);
                              } else {
                                 _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotgunreload")), SoundSource.NEUTRAL, 0.2F, 1.0F, false);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("C", 15.0D);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128359_("Type", "BI");
                  }
               }
            }
         }

         Player _player;
         if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               DecimalFormat var34 = new DecimalFormat;
               ItemStack var10003;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10003 = _livEnt.m_21205_();
               } else {
                  var10003 = ItemStack.f_41583_;
               }

               CompoundTag var32 = var10003.m_41784_();
               var34.<init>("§4" + var32.m_128461_("Type") + "§6####§8/§6");
               ItemStack var10002;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.m_21205_();
               } else {
                  var10002 = ItemStack.f_41583_;
               }

               String var35 = var34.format(var10002.m_41784_().m_128459_("Ammo"));
               _player.m_5661_(Component.m_237113_(var35 + (new DecimalFormat("####")).format(Capacity)), true);
            }
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            var33 = _player.m_36335_();
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            var33.m_41524_(var10001.m_41720_(), 1);
         }

      }
   }
}

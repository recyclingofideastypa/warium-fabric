package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class FireSelectOnKeyPressedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         LivingEntity _livEnt;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         Level _level;
         Player _player;
         if (var10000.m_41720_() == CrustyChunksModItems.BURST_RIFLE.get()) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41784_().m_128459_("Firemode") == 0.0D) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128347_("Firemode", 1.0D);
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                  }
               }

               if (entity instanceof Player) {
                  _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("§6Burst"), true);
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41784_().m_128459_("Firemode") == 1.0D) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128347_("Firemode", 0.0D);
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_("§6Semi"), true);
                     }
                  }
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == CrustyChunksModItems.MACHINE_CARBINE.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41784_().m_128459_("Firemode") == 0.0D) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128347_("Firemode", 1.0D);
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_("§6Auto"), true);
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41784_().m_128459_("Firemode") == 1.0D) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128347_("Firemode", 0.0D);
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                        }
                     }

                     if (entity instanceof Player) {
                        _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_("§6Semi"), true);
                        }
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == CrustyChunksModItems.BATTLE_RIFLE.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41784_().m_128459_("Firemode") == 0.0D) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128347_("Firemode", 1.0D);
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                        }
                     }

                     if (entity instanceof Player) {
                        _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_("§6Auto"), true);
                        }
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41784_().m_128459_("Firemode") == 1.0D) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128347_("Firemode", 0.0D);
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                           }
                        }

                        if (entity instanceof Player) {
                           _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              _player.m_5661_(Component.m_237113_("§6Semi"), true);
                           }
                        }
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == CrustyChunksModItems.AUTOMATIC_RIFLE.get()) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41784_().m_128459_("Firemode") == 0.0D) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128347_("Firemode", 1.0D);
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                           }
                        }

                        if (entity instanceof Player) {
                           _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              _player.m_5661_(Component.m_237113_("§6Auto"), true);
                           }
                        }
                     } else {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41784_().m_128459_("Firemode") == 1.0D) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("Firemode", 0.0D);
                           if (world instanceof Level) {
                              _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                              } else {
                                 _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                              }
                           }

                           if (entity instanceof Player) {
                              _player = (Player)entity;
                              if (!_player.m_9236_().m_5776_()) {
                                 _player.m_5661_(Component.m_237113_("§6Semi"), true);
                              }
                           }
                        }
                     }
                  } else {
                     label390: {
                        IForgeRegistry var22 = ForgeRegistries.ITEMS;
                        ItemStack var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        if (!var22.getKey(var10001.m_41720_()).toString().equals("futurism:battle_rifle")) {
                           var22 = ForgeRegistries.ITEMS;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21205_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           if (!var22.getKey(var10001.m_41720_()).toString().equals("futurism:advanced_automatic_rifle")) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.m_21205_();
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              if (var10000.m_41720_() == CrustyChunksModItems.AIMER.get()) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.m_21205_();
                                 } else {
                                    var10000 = ItemStack.f_41583_;
                                 }

                                 Player _player;
                                 if (var10000.m_41784_().m_128471_("Mode")) {
                                    if (entity instanceof Player) {
                                       _player = (Player)entity;
                                       if (!_player.m_9236_().m_5776_()) {
                                          _player.m_5661_(Component.m_237113_("§6Seat Mode: Off"), true);
                                       }
                                    }

                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.m_21205_();
                                    } else {
                                       var10000 = ItemStack.f_41583_;
                                    }

                                    var10000.m_41784_().m_128379_("Mode", false);
                                 } else {
                                    if (entity instanceof Player) {
                                       _player = (Player)entity;
                                       if (!_player.m_9236_().m_5776_()) {
                                          _player.m_5661_(Component.m_237113_("§6Seat Mode: On"), true);
                                       }
                                    }

                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.m_21205_();
                                    } else {
                                       var10000 = ItemStack.f_41583_;
                                    }

                                    var10000.m_41784_().m_128379_("Mode", true);
                                 }
                              }
                              break label390;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41784_().m_128459_("Firemode") == 0.0D) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("Firemode", 1.0D);
                           if (world instanceof Level) {
                              _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                              } else {
                                 _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                              }
                           }

                           if (entity instanceof Player) {
                              _player = (Player)entity;
                              if (!_player.m_9236_().m_5776_()) {
                                 _player.m_5661_(Component.m_237113_("§6Special"), true);
                              }
                           }
                        } else {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41784_().m_128459_("Firemode") == 1.0D) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.m_21205_();
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              var10000.m_41784_().m_128347_("Firemode", 0.0D);
                              if (world instanceof Level) {
                                 _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                                 } else {
                                    _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                                 }
                              }

                              if (entity instanceof Player) {
                                 _player = (Player)entity;
                                 if (!_player.m_9236_().m_5776_()) {
                                    _player.m_5661_(Component.m_237113_("§6Standard"), true);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == CrustyChunksModItems.AIMER.get()) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            Player _player;
            if (var10000.m_41784_().m_128471_("ATGMMode")) {
               if (entity instanceof Player) {
                  _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("§6ATGM Mode: Off"), true);
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128379_("ATGMMode", false);
            } else {
               if (entity instanceof Player) {
                  _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("§6ATGM Mode: On"), true);
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128379_("ATGMMode", true);
            }
         }

      }
   }
}

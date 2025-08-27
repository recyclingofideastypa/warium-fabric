package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.RevolverAnimatedItem;
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

public class RevolverReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Rounds = 0.0D;
         double Capacity = 0.0D;
         Capacity = 8.0D;
         ItemCooldowns var10000;
         ItemStack var10001;
         if (entity instanceof Player) {
            Player _plrCldCheck1 = (Player)entity;
            var10000 = _plrCldCheck1.m_36335_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            if (var10000.m_41519_(var10001.m_41720_())) {
               return;
            }
         }

         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21205_();
         } else {
            var10001 = ItemStack.f_41583_;
         }

         LivingEntity _livEnt;
         ItemStack var35;
         if (0.0D == var10001.m_41784_().m_128459_("Ammo")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var35 = _livEnt.m_21205_();
            } else {
               var35 = ItemStack.f_41583_;
            }

            var35.m_41784_().m_128359_("Type", "NULL");
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var35 = _livEnt.m_21206_();
         } else {
            var35 = ItemStack.f_41583_;
         }

         LivingEntity _livEnt;
         ItemStack var10002;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         if (var35.m_41613_() == 0) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            if (1.0D <= var10001.m_41784_().m_128459_("Ammo")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.m_21205_();
               } else {
                  var35 = ItemStack.f_41583_;
               }

               Rounds = var35.m_41784_().m_128459_("Ammo") - 1.0D;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.m_21205_();
               } else {
                  var35 = ItemStack.f_41583_;
               }

               var35.m_41784_().m_128347_("Ammo", Rounds);
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.m_21205_();
               } else {
                  var35 = ItemStack.f_41583_;
               }

               ServerLevel _level;
               ItemEntity entityToSpawn;
               if (var35.m_41784_().m_128461_("Type").equals("HP")) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.m_21205_();
                  } else {
                     var35 = ItemStack.f_41583_;
                  }

                  if (var35.m_41784_().m_128461_("Type").equals("AP")) {
                     if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALLBULLET.get()));
                        entityToSpawn.m_32010_(10);
                        _level.m_7967_(entityToSpawn);
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     if (var35.m_41784_().m_128461_("Type").equals("ST") && world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_STEALTH_BULLET.get()));
                        entityToSpawn.m_32010_(10);
                        _level.m_7967_(entityToSpawn);
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.m_21205_();
               } else {
                  var35 = ItemStack.f_41583_;
               }

               var35.m_41784_().m_128379_("action", false);
            }
         } else {
            label567: {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.m_21206_();
               } else {
                  var35 = ItemStack.f_41583_;
               }

               LivingEntity _livEnt;
               LivingEntity _livEnt;
               LivingEntity _livEnt;
               Player _player;
               double var37;
               double var38;
               label549: {
                  if (var35.m_41720_() == CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     if (var35.m_41784_().m_128461_("Type").equals("NULL")) {
                        break label549;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     if (var35.m_41784_().m_128461_("Type").equals("HP")) {
                        break label549;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.m_21206_();
                  } else {
                     var35 = ItemStack.f_41583_;
                  }

                  label551: {
                     if (var35.m_41720_() == CrustyChunksModItems.SMALLBULLET.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21205_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        if (var35.m_41784_().m_128461_("Type").equals("NULL")) {
                           break label551;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21205_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        if (var35.m_41784_().m_128461_("Type").equals("AP")) {
                           break label551;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21206_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     if (var35.m_41720_() != CrustyChunksModItems.SMALL_STEALTH_BULLET.get()) {
                        break label567;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     if (!var35.m_41784_().m_128461_("Type").equals("NULL")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21205_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        if (!var35.m_41784_().m_128461_("Type").equals("ST")) {
                           break label567;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     if (Capacity > var10001.m_41784_().m_128459_("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21205_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        if (var35.m_41720_() instanceof RevolverAnimatedItem) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.m_21205_();
                           } else {
                              var35 = ItemStack.f_41583_;
                           }

                           var35.m_41784_().m_128359_("geckoAnim", "load");
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21206_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        var38 = (double)var35.m_41613_();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21205_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        if (var38 >= Capacity - var10002.m_41784_().m_128459_("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.m_21206_();
                           } else {
                              var35 = ItemStack.f_41583_;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.m_21205_();
                           } else {
                              var10002 = ItemStack.f_41583_;
                           }

                           var35.m_41774_((int)(Capacity - var10002.m_41784_().m_128459_("Ammo")));
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.m_21205_();
                           } else {
                              var35 = ItemStack.f_41583_;
                           }

                           var38 = var35.m_41784_().m_128459_("Ammo") + Capacity;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21205_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           Rounds = var38 - var10001.m_41784_().m_128459_("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.m_21205_();
                           } else {
                              var35 = ItemStack.f_41583_;
                           }

                           var35.m_41784_().m_128347_("Ammo", Rounds);
                        } else {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21205_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           var37 = var10001.m_41784_().m_128459_("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.m_21206_();
                           } else {
                              var10002 = ItemStack.f_41583_;
                           }

                           if (Capacity > var37 + (double)var10002.m_41613_()) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var35 = _livEnt.m_21205_();
                              } else {
                                 var35 = ItemStack.f_41583_;
                              }

                              var38 = var35.m_41784_().m_128459_("Ammo");
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.m_21206_();
                              } else {
                                 var10001 = ItemStack.f_41583_;
                              }

                              Rounds = var38 + (double)var10001.m_41613_();
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var35 = _livEnt.m_21206_();
                              } else {
                                 var35 = ItemStack.f_41583_;
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.m_21206_();
                              } else {
                                 var10001 = ItemStack.f_41583_;
                              }

                              var35.m_41774_(var10001.m_41613_());
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var35 = _livEnt.m_21205_();
                              } else {
                                 var35 = ItemStack.f_41583_;
                              }

                              var35.m_41784_().m_128347_("Ammo", Rounds);
                           }
                        }

                        if (entity instanceof Player) {
                           _player = (Player)entity;
                           var10000 = _player.m_36335_();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21205_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           var10000.m_41524_(var10001.m_41720_(), 50);
                        }

                        CrustyChunksMod.queueServerWork(1, () -> {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                              } else {
                                 _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                              }
                           }

                        });
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     var35.m_41784_().m_128359_("Type", "ST");
                     break label567;
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  if (Capacity > var10001.m_41784_().m_128459_("Ammo")) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     if (var35.m_41720_() instanceof RevolverAnimatedItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21205_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        var35.m_41784_().m_128359_("geckoAnim", "load");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21206_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     var38 = (double)var35.m_41613_();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21205_();
                     } else {
                        var10002 = ItemStack.f_41583_;
                     }

                     if (var38 >= Capacity - var10002.m_41784_().m_128459_("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21206_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21205_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        var35.m_41774_((int)(Capacity - var10002.m_41784_().m_128459_("Ammo")));
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21205_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        var38 = var35.m_41784_().m_128459_("Ammo") + Capacity;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        Rounds = var38 - var10001.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21205_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        var35.m_41784_().m_128347_("Ammo", Rounds);
                     } else {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        var37 = var10001.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21206_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        if (Capacity > var37 + (double)var10002.m_41613_()) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.m_21205_();
                           } else {
                              var35 = ItemStack.f_41583_;
                           }

                           var38 = var35.m_41784_().m_128459_("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21206_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           Rounds = var38 + (double)var10001.m_41613_();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.m_21206_();
                           } else {
                              var35 = ItemStack.f_41583_;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21206_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           var35.m_41774_(var10001.m_41613_());
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.m_21205_();
                           } else {
                              var35 = ItemStack.f_41583_;
                           }

                           var35.m_41784_().m_128347_("Ammo", Rounds);
                        }
                     }

                     if (entity instanceof Player) {
                        _player = (Player)entity;
                        var10000 = _player.m_36335_();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        var10000.m_41524_(var10001.m_41720_(), 50);
                     }

                     CrustyChunksMod.queueServerWork(1, () -> {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                     });
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.m_21205_();
                  } else {
                     var35 = ItemStack.f_41583_;
                  }

                  var35.m_41784_().m_128359_("Type", "AP");
                  break label567;
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.m_21205_();
               } else {
                  var10001 = ItemStack.f_41583_;
               }

               if (Capacity > var10001.m_41784_().m_128459_("Ammo")) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.m_21205_();
                  } else {
                     var35 = ItemStack.f_41583_;
                  }

                  if (var35.m_41720_() instanceof RevolverAnimatedItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     var35.m_41784_().m_128359_("geckoAnim", "load");
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.m_21206_();
                  } else {
                     var35 = ItemStack.f_41583_;
                  }

                  var38 = (double)var35.m_41613_();
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.m_21205_();
                  } else {
                     var10002 = ItemStack.f_41583_;
                  }

                  if (var38 >= Capacity - var10002.m_41784_().m_128459_("Ammo")) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21206_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21205_();
                     } else {
                        var10002 = ItemStack.f_41583_;
                     }

                     var35.m_41774_((int)(Capacity - var10002.m_41784_().m_128459_("Ammo")));
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     var38 = var35.m_41784_().m_128459_("Ammo") + Capacity;
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     Rounds = var38 - var10001.m_41784_().m_128459_("Ammo");
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     var35.m_41784_().m_128347_("Ammo", Rounds);
                  } else {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     var37 = var10001.m_41784_().m_128459_("Ammo");
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21206_();
                     } else {
                        var10002 = ItemStack.f_41583_;
                     }

                     if (Capacity > var37 + (double)var10002.m_41613_()) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21205_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        var38 = var35.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21206_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        Rounds = var38 + (double)var10001.m_41613_();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21206_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21206_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        var35.m_41774_(var10001.m_41613_());
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.m_21205_();
                        } else {
                           var35 = ItemStack.f_41583_;
                        }

                        var35.m_41784_().m_128347_("Ammo", Rounds);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     var10000 = _player.m_36335_();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     var10000.m_41524_(var10001.m_41720_(), 50);
                  }

                  CrustyChunksMod.queueServerWork(1, () -> {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                  });
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.m_21205_();
               } else {
                  var35 = ItemStack.f_41583_;
               }

               var35.m_41784_().m_128359_("Type", "HP");
            }
         }

         Player _player;
         if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               DecimalFormat var39 = new DecimalFormat;
               ItemStack var10003;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10003 = _livEnt.m_21205_();
               } else {
                  var10003 = ItemStack.f_41583_;
               }

               CompoundTag var36 = var10003.m_41784_();
               var39.<init>("§4" + var36.m_128461_("Type") + "§6####§8/§6");
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.m_21205_();
               } else {
                  var10002 = ItemStack.f_41583_;
               }

               String var40 = var39.format(var10002.m_41784_().m_128459_("Ammo"));
               _player.m_5661_(Component.m_237113_(var40 + (new DecimalFormat("####")).format(Capacity)), true);
            }
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            var10000 = _player.m_36335_();
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            var10000.m_41524_(var10001.m_41720_(), 5);
         }

      }
   }
}

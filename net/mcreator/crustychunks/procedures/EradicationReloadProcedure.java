package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.EradicationItem;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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

public class EradicationReloadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Rounds = 0.0D;
         double Capacity = 0.0D;
         Capacity = 200.0D;
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
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ItemEntity entityToSpawn;
         ItemStack var10002;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ServerLevel _level;
         Level _level;
         LivingEntity _livEnt;
         double var29;
         double var30;
         label569: {
            if (!var10000.m_41784_().m_128461_("Type").equals("NULL")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (!var10000.m_41784_().m_128461_("Type").equals("HP")) {
                  break label569;
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

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
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D), false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128359_("Type", "HP");
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  if (Capacity > var10001.m_41784_().m_128459_("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.15D));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.15D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() instanceof EradicationItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128359_("geckoAnim", "Reload");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var30 = (double)var10000.m_41613_();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21205_();
                     } else {
                        var10002 = ItemStack.f_41583_;
                     }

                     if (var30 >= Capacity - var10002.m_41784_().m_128459_("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21206_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21205_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        var10000.m_41774_((int)(Capacity - var10002.m_41784_().m_128459_("Ammo")));
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var30 = var10000.m_41784_().m_128459_("Ammo") + Capacity;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        Rounds = var30 - var10001.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128347_("Ammo", Rounds);
                     } else {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        var29 = var10001.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21206_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        if (Capacity > var29 + (double)var10002.m_41613_()) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var30 = var10000.m_41784_().m_128459_("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21206_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           Rounds = var30 + (double)var10001.m_41613_();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21206_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           var10000.m_41774_(var10001.m_41613_());
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("Ammo", Rounds);
                        }
                     }
                  }
               }
            }
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         label576: {
            if (!var10000.m_41784_().m_128461_("Type").equals("NULL")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (!var10000.m_41784_().m_128461_("Type").equals("AP")) {
                  break label576;
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

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
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALLBULLET.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D), false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == CrustyChunksModItems.SMALLBULLET.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128359_("Type", "AP");
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  if (Capacity > var10001.m_41784_().m_128459_("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.15D));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.15D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() instanceof EradicationItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128359_("geckoAnim", "Reload");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var30 = (double)var10000.m_41613_();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21205_();
                     } else {
                        var10002 = ItemStack.f_41583_;
                     }

                     if (var30 >= Capacity - var10002.m_41784_().m_128459_("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21206_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21205_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        var10000.m_41774_((int)(Capacity - var10002.m_41784_().m_128459_("Ammo")));
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var30 = var10000.m_41784_().m_128459_("Ammo") + Capacity;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        Rounds = var30 - var10001.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128347_("Ammo", Rounds);
                     } else {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        var29 = var10001.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21206_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        if (Capacity > var29 + (double)var10002.m_41613_()) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var30 = var10000.m_41784_().m_128459_("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21206_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           Rounds = var30 + (double)var10001.m_41613_();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21206_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           var10000.m_41774_(var10001.m_41613_());
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("Ammo", Rounds);
                        }
                     }
                  }
               }
            }
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         ItemStack var10003;
         CompoundTag var28;
         DecimalFormat var31;
         String var32;
         label583: {
            if (!var10000.m_41784_().m_128461_("Type").equals("NULL")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (!var10000.m_41784_().m_128461_("Type").equals("ST")) {
                  break label583;
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

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
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_STEALTH_BULLET.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D), false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == CrustyChunksModItems.SMALL_STEALTH_BULLET.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128359_("Type", "ST");
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  if (Capacity > var10001.m_41784_().m_128459_("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.15D));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.15D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() instanceof EradicationItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128359_("geckoAnim", "Reload");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var30 = (double)var10000.m_41613_();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21205_();
                     } else {
                        var10002 = ItemStack.f_41583_;
                     }

                     if (var30 >= Capacity - var10002.m_41784_().m_128459_("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21206_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21205_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        var10000.m_41774_((int)(Capacity - var10002.m_41784_().m_128459_("Ammo")));
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var30 = var10000.m_41784_().m_128459_("Ammo") + Capacity;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        Rounds = var30 - var10001.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128347_("Ammo", Rounds);
                     } else {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        var29 = var10001.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21206_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        if (Capacity > var29 + (double)var10002.m_41613_()) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var30 = var10000.m_41784_().m_128459_("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21206_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           Rounds = var30 + (double)var10001.m_41613_();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21206_();
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           var10000.m_41774_(var10001.m_41613_());
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("Ammo", Rounds);
                        }
                     }
                  }
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  var31 = new DecimalFormat;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10003 = _livEnt.m_21205_();
                  } else {
                     var10003 = ItemStack.f_41583_;
                  }

                  var28 = var10003.m_41784_();
                  var31.<init>("§4" + var28.m_128461_("Type") + "§6####§8/§6");
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.m_21205_();
                  } else {
                     var10002 = ItemStack.f_41583_;
                  }

                  var32 = var31.format(var10002.m_41784_().m_128459_("Ammo"));
                  _player.m_5661_(Component.m_237113_(var32 + (new DecimalFormat("####")).format(Capacity)), true);
               }
            }
         }

         Player _player;
         if (entity instanceof Player) {
            _player = (Player)entity;
            ItemCooldowns var33 = _player.m_36335_();
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            var33.m_41524_(var10001.m_41720_(), 1);
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               var31 = new DecimalFormat;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10003 = _livEnt.m_21205_();
               } else {
                  var10003 = ItemStack.f_41583_;
               }

               var28 = var10003.m_41784_();
               var31.<init>("§4" + var28.m_128461_("Type") + "§6####§8/§6");
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.m_21205_();
               } else {
                  var10002 = ItemStack.f_41583_;
               }

               var32 = var31.format(var10002.m_41784_().m_128459_("Ammo"));
               _player.m_5661_(Component.m_237113_(var32 + (new DecimalFormat("####")).format(Capacity)), true);
            }
         }

      }
   }
}

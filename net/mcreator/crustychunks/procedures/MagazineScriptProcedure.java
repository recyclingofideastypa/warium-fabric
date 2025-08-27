package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class MagazineScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Rounds = 0.0D;
         double Capacity = 0.0D;
         Capacity = 30.0D;
         if (0.0D == itemstack.m_41784_().m_128459_("Ammo")) {
            itemstack.m_41784_().m_128359_("Type", "NULL");
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ServerLevel _level;
         ItemStack var10000;
         ItemEntity entityToSpawn;
         LivingEntity _livEnt;
         double var10001;
         ItemStack var10002;
         Level _level;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ItemStack var22;
         double var23;
         if (itemstack.m_41784_().m_128461_("Type").equals("NULL") || itemstack.m_41784_().m_128461_("Type").equals("MB")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41613_() == 0) {
               if (1.0D <= itemstack.m_41784_().m_128459_("Ammo")) {
                  Rounds = itemstack.m_41784_().m_128459_("Ammo") - 1.0D;
                  itemstack.m_41784_().m_128347_("Ammo", Rounds);
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.BULLET.get()));
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

               if (var10000.m_41720_() == CrustyChunksModItems.BULLET.get()) {
                  itemstack.m_41784_().m_128359_("Type", "MB");
                  if (Capacity > itemstack.m_41784_().m_128459_("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if ((double)var10000.m_41613_() >= Capacity - itemstack.m_41784_().m_128459_("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21206_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41774_((int)(Capacity - itemstack.m_41784_().m_128459_("Ammo")));
                        Rounds = itemstack.m_41784_().m_128459_("Ammo") + Capacity - itemstack.m_41784_().m_128459_("Ammo");
                        itemstack.m_41784_().m_128347_("Ammo", Rounds);
                     } else {
                        var10001 = itemstack.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21206_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        if (Capacity > var10001 + (double)var10002.m_41613_()) {
                           var23 = itemstack.m_41784_().m_128459_("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.m_21206_();
                           } else {
                              var22 = ItemStack.f_41583_;
                           }

                           Rounds = var23 + (double)var22.m_41613_();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.m_21206_();
                           } else {
                              var22 = ItemStack.f_41583_;
                           }

                           var10000.m_41774_(var22.m_41613_());
                           itemstack.m_41784_().m_128347_("Ammo", Rounds);
                        }
                     }
                  }
               }
            }
         }

         if (itemstack.m_41784_().m_128461_("Type").equals("NULL") || itemstack.m_41784_().m_128461_("Type").equals("AP")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41613_() == 0) {
               if (1.0D <= itemstack.m_41784_().m_128459_("Ammo")) {
                  Rounds = itemstack.m_41784_().m_128459_("Ammo") - 1.0D;
                  itemstack.m_41784_().m_128347_("Ammo", Rounds);
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.MEDIUM_AP_BULLET.get()));
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

               if (var10000.m_41720_() == CrustyChunksModItems.MEDIUM_AP_BULLET.get()) {
                  itemstack.m_41784_().m_128359_("Type", "AP");
                  if (Capacity > itemstack.m_41784_().m_128459_("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if ((double)var10000.m_41613_() >= Capacity - itemstack.m_41784_().m_128459_("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21206_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41774_((int)(Capacity - itemstack.m_41784_().m_128459_("Ammo")));
                        Rounds = itemstack.m_41784_().m_128459_("Ammo") + Capacity - itemstack.m_41784_().m_128459_("Ammo");
                        itemstack.m_41784_().m_128347_("Ammo", Rounds);
                     } else {
                        var10001 = itemstack.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21206_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        if (Capacity > var10001 + (double)var10002.m_41613_()) {
                           var23 = itemstack.m_41784_().m_128459_("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.m_21206_();
                           } else {
                              var22 = ItemStack.f_41583_;
                           }

                           Rounds = var23 + (double)var22.m_41613_();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.m_21206_();
                           } else {
                              var22 = ItemStack.f_41583_;
                           }

                           var10000.m_41774_(var22.m_41613_());
                           itemstack.m_41784_().m_128347_("Ammo", Rounds);
                        }
                     }
                  }
               }
            }
         }

         Player _player;
         CompoundTag var10003;
         String var24;
         if (itemstack.m_41784_().m_128461_("Type").equals("NULL") || itemstack.m_41784_().m_128461_("Type").equals("ST")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41613_() == 0) {
               if (1.0D <= itemstack.m_41784_().m_128459_("Ammo")) {
                  Rounds = itemstack.m_41784_().m_128459_("Ammo") - 1.0D;
                  itemstack.m_41784_().m_128347_("Ammo", Rounds);
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.MEDIUM_STEALTH_BULLET.get()));
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

               if (var10000.m_41720_() == CrustyChunksModItems.MEDIUM_STEALTH_BULLET.get()) {
                  itemstack.m_41784_().m_128359_("Type", "ST");
                  if (Capacity > itemstack.m_41784_().m_128459_("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 3.0D, 3.1D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if ((double)var10000.m_41613_() >= Capacity - itemstack.m_41784_().m_128459_("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21206_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41774_((int)(Capacity - itemstack.m_41784_().m_128459_("Ammo")));
                        Rounds = itemstack.m_41784_().m_128459_("Ammo") + Capacity - itemstack.m_41784_().m_128459_("Ammo");
                        itemstack.m_41784_().m_128347_("Ammo", Rounds);
                     } else {
                        var10001 = itemstack.m_41784_().m_128459_("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21206_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        if (Capacity > var10001 + (double)var10002.m_41613_()) {
                           var23 = itemstack.m_41784_().m_128459_("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.m_21206_();
                           } else {
                              var22 = ItemStack.f_41583_;
                           }

                           Rounds = var23 + (double)var22.m_41613_();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.m_21206_();
                           } else {
                              var22 = ItemStack.f_41583_;
                           }

                           var10000.m_41774_(var22.m_41613_());
                           itemstack.m_41784_().m_128347_("Ammo", Rounds);
                        }
                     }
                  }
               }
            }

            if (entity instanceof Player) {
               _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  var10003 = itemstack.m_41784_();
                  var24 = (new DecimalFormat("§4" + var10003.m_128461_("Type") + "§6####§8/§6")).format(itemstack.m_41784_().m_128459_("Ammo"));
                  _player.m_5661_(Component.m_237113_(var24 + (new DecimalFormat("####")).format(Capacity)), true);
               }
            }
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            _player.m_36335_().m_41524_(itemstack.m_41720_(), 1);
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               var10003 = itemstack.m_41784_();
               var24 = (new DecimalFormat("§4" + var10003.m_128461_("Type") + "§6####§8/§6")).format(itemstack.m_41784_().m_128459_("Ammo"));
               _player.m_5661_(Component.m_237113_(var24 + (new DecimalFormat("####")).format(Capacity)), true);
            }
         }

      }
   }
}

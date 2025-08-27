package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class PistolReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         LivingEntity _livEnt;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _entity;
         ItemStack _setstack;
         Player _player;
         ItemStack var10001;
         ItemStack var10002;
         Level _level;
         CompoundTag var19;
         if (var10000.m_41613_() == 0) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            if (var10001.m_41784_().m_128471_("Loaded")) {
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMALLMAGAZINE.get())).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  var10000 = _entity.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var19 = var10000.m_41784_();
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  var10002 = _entity.m_21205_();
               } else {
                  var10002 = ItemStack.f_41583_;
               }

               var19.m_128347_("Ammo", var10002.m_41784_().m_128459_("Ammo"));
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  var10000 = _entity.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var19 = var10000.m_41784_();
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  var10002 = _entity.m_21205_();
               } else {
                  var10002 = ItemStack.f_41583_;
               }

               var19.m_128359_("Type", var10002.m_41784_().m_128461_("Type"));
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  var10000 = _entity.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128359_("Type", "NULL");
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  var10000 = _entity.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128379_("Loaded", false);
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  var10000 = _entity.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128347_("Ammo", 0.0D);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity var20 = new ItemEntity;
                  double var10004 = y + 1.0D;
                  ItemStack var10006;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10006 = _livEnt.m_21206_();
                  } else {
                     var10006 = ItemStack.f_41583_;
                  }

                  var20.<init>(_level, x, var10004, z, var10006);
                  ItemEntity entityToSpawn = var20;
                  entityToSpawn.m_32010_(10);
                  entityToSpawn.m_149678_();
                  _level.m_7967_(entityToSpawn);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:magazine")), SoundSource.NEUTRAL, 0.1F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:magazine")), SoundSource.NEUTRAL, 0.1F, 1.5F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMALLMAGAZINE.get())).m_41777_();
                  _setstack.m_41764_(0);
                  _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
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

            if (var10000.m_41720_() == CrustyChunksModItems.SMALLMAGAZINE.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.m_21205_();
               } else {
                  var10001 = ItemStack.f_41583_;
               }

               if (!var10001.m_41784_().m_128471_("Loaded")) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10000 = _entity.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128379_("Loaded", true);
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10000 = _entity.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128379_("action", true);
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10000 = _entity.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var19 = var10000.m_41784_();
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10002 = _entity.m_21206_();
                  } else {
                     var10002 = ItemStack.f_41583_;
                  }

                  var19.m_128347_("Ammo", var10002.m_41784_().m_128459_("Ammo"));
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10000 = _entity.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var19 = var10000.m_41784_();
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10002 = _entity.m_21206_();
                  } else {
                     var10002 = ItemStack.f_41583_;
                  }

                  var19.m_128359_("Type", var10002.m_41784_().m_128461_("Type"));
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMALLMAGAZINE.get())).m_41777_();
                     _setstack.m_41764_(0);
                     _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                     if (_entity instanceof Player) {
                        _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:magazine")), SoundSource.NEUTRAL, 0.1F, 1.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:magazine")), SoundSource.NEUTRAL, 0.1F, 1.5F, false);
                     }
                  }
               }
            }
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21205_();
         } else {
            var10001 = ItemStack.f_41583_;
         }

         if (var10001.m_41784_().m_128471_("Loaded")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == CrustyChunksModItems.SMALLMAGAZINE.get() && entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("§4Weapon still contains magazine."), true);
               }
            }
         }

      }
   }
}

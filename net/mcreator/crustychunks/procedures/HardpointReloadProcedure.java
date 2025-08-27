package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class HardpointReloadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ItemStack var10000;
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            LivingEntity _entity;
            ItemStack _setstack;
            Player _player;
            UnmodifiableIterator var15;
            Entry entry;
            Property _property;
            BlockPos _bp;
            Level _level;
            BlockState _bs;
            BlockState _bso;
            BlockEntity _be;
            CompoundTag _bnbt;
            if (var10000.m_41720_() == CrustyChunksModItems.FIRE_SPEAR_ROCKET.get()) {
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.FIRE_SPEAR_ROCKET.get())).m_41777_();
                  _setstack.m_41764_(0);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               _bp = BlockPos.m_274561_(x, y, z);
               _bs = ((Block)CrustyChunksModBlocks.FIRE_SPEAR_MISSILE_HARDPOINT.get()).m_49966_();
               _bso = world.m_8055_(_bp);
               var15 = _bso.m_61148_().entrySet().iterator();

               while(var15.hasNext()) {
                  entry = (Entry)var15.next();
                  _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                  if (_property != null && _bs.m_61143_(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                     } catch (Exception var36) {
                     }
                  }
               }

               _be = world.m_7702_(_bp);
               _bnbt = null;
               if (_be != null) {
                  _bnbt = _be.m_187480_();
                  _be.m_7651_();
               }

               world.m_7731_(_bp, _bs, 3);
               if (_bnbt != null) {
                  _be = world.m_7702_(_bp);
                  if (_be != null) {
                     try {
                        _be.m_142466_(_bnbt);
                     } catch (Exception var35) {
                     }
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == CrustyChunksModItems.SEEKER_SPEAR_ROCKET.get()) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SEEKER_SPEAR_ROCKET.get())).m_41777_();
                     _setstack.m_41764_(0);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  _bp = BlockPos.m_274561_(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.SEEKER_SPEAR_MISSILE_HARDPOINT.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var15 = _bso.m_61148_().entrySet().iterator();

                  while(var15.hasNext()) {
                     entry = (Entry)var15.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var34) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var33) {
                        }
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == CrustyChunksModItems.STRIKE_SPEAR_MISSILE.get()) {
                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.STRIKE_SPEAR_MISSILE.get())).m_41777_();
                        _setstack.m_41764_(0);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }

                     _bp = BlockPos.m_274561_(x, y, z);
                     _bs = ((Block)CrustyChunksModBlocks.STRIKE_SPEAR_MISSILE_HARDPOINT.get()).m_49966_();
                     _bso = world.m_8055_(_bp);
                     var15 = _bso.m_61148_().entrySet().iterator();

                     while(var15.hasNext()) {
                        entry = (Entry)var15.next();
                        _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                        if (_property != null && _bs.m_61143_(_property) != null) {
                           try {
                              _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                           } catch (Exception var32) {
                           }
                        }
                     }

                     _be = world.m_7702_(_bp);
                     _bnbt = null;
                     if (_be != null) {
                        _bnbt = _be.m_187480_();
                        _be.m_7651_();
                     }

                     world.m_7731_(_bp, _bs, 3);
                     if (_bnbt != null) {
                        _be = world.m_7702_(_bp);
                        if (_be != null) {
                           try {
                              _be.m_142466_(_bnbt);
                           } catch (Exception var31) {
                           }
                        }
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                        }
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() == CrustyChunksModItems.RADAR_SPEAR_MISSILE.get()) {
                        if (entity instanceof LivingEntity) {
                           _entity = (LivingEntity)entity;
                           _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.RADAR_SPEAR_MISSILE.get())).m_41777_();
                           _setstack.m_41764_(0);
                           _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              _player = (Player)_entity;
                              _player.m_150109_().m_6596_();
                           }
                        }

                        _bp = BlockPos.m_274561_(x, y, z);
                        _bs = ((Block)CrustyChunksModBlocks.RADAR_SPEAR_MISSILE_HARDPOINT.get()).m_49966_();
                        _bso = world.m_8055_(_bp);
                        var15 = _bso.m_61148_().entrySet().iterator();

                        while(var15.hasNext()) {
                           entry = (Entry)var15.next();
                           _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                           if (_property != null && _bs.m_61143_(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                              } catch (Exception var30) {
                              }
                           }
                        }

                        _be = world.m_7702_(_bp);
                        _bnbt = null;
                        if (_be != null) {
                           _bnbt = _be.m_187480_();
                           _be.m_7651_();
                        }

                        world.m_7731_(_bp, _bs, 3);
                        if (_bnbt != null) {
                           _be = world.m_7702_(_bp);
                           if (_be != null) {
                              try {
                                 _be.m_142466_(_bnbt);
                              } catch (Exception var29) {
                              }
                           }
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                           }
                        }
                     }
                  }
               }
            }
         } else {
            ServerLevel _level;
            BlockPos _bp;
            Level _level;
            ItemEntity entityToSpawn;
            BlockState _bs;
            BlockState _bso;
            UnmodifiableIterator var48;
            BlockEntity _be;
            Property _property;
            Entry entry;
            CompoundTag _bnbt;
            if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FIRE_SPEAR_MISSILE_HARDPOINT.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.FIRE_SPEAR_ROCKET.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }

                  _bp = BlockPos.m_274561_(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var48 = _bso.m_61148_().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var28) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var27) {
                        }
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }
               }
            } else if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.SEEKER_SPEAR_MISSILE_HARDPOINT.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SEEKER_SPEAR_ROCKET.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }

                  _bp = BlockPos.m_274561_(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var48 = _bso.m_61148_().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var26) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var25) {
                        }
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }
               }
            } else if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.STRIKE_SPEAR_MISSILE_HARDPOINT.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STRIKE_SPEAR_MISSILE.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }

                  _bp = BlockPos.m_274561_(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var48 = _bso.m_61148_().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var24) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var23) {
                        }
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }
               }
            } else if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.RADAR_SPEAR_MISSILE_HARDPOINT.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.RADAR_SPEAR_MISSILE.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }

                  _bp = BlockPos.m_274561_(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var48 = _bso.m_61148_().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var22) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var21) {
                        }
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }
               }
            } else if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.ORDINANCE_CONTROLLER.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ((Block)CrustyChunksModBlocks.ORDINANCE_CORE.get()).m_5456_()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41774_(1);
                  _bp = BlockPos.m_274561_(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.ORDINANCE_CORE.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var48 = _bso.m_61148_().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var20) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var19) {
                        }
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }
               }
            }
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.HugeBulletFireEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class LACFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      Direction playerdirection = Direction.NORTH;
      boolean found = false;
      boolean DetectedPlayer = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double Pitch = 0.0D;
      double Xvector = 0.0D;
      double Zvector = 0.0D;
      double Barrels = 0.0D;
      double DrumPosition = 0.0D;
      if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get()) {
         DrumPosition = 1.0D;
      } else if (world.m_8055_(BlockPos.m_274561_(x, y - 1.0D, z)).m_60734_() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get()) {
         DrumPosition = -1.0D;
      }

      if (0.0D < ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Cooldown")) {
         if (!world.m_5776_()) {
            BlockPos _bp = BlockPos.m_274561_(x, y, z);
            BlockEntity _blockEntity = world.m_7702_(_bp);
            BlockState _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Cooldown", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "Cooldown") - 1.0D);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }
      } else {
         if (1.0D > Math.abs((double)((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockState _bs) {
               Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
               if (_prop instanceof DirectionProperty) {
                  DirectionProperty _dp = (DirectionProperty)_prop;
                  return (Direction)_bs.m_61143_(_dp);
               } else {
                  _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                  Direction var10000;
                  if (_prop instanceof EnumProperty) {
                     EnumProperty _ep = (EnumProperty)_prop;
                     if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                        var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                        return var10000;
                     }
                  }

                  var10000 = Direction.NORTH;
                  return var10000;
               }
            }
         })).getDirection(blockstate).m_122429_() - ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "X")) || 0.5D > Math.abs((double)((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockState _bs) {
               Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
               if (_prop instanceof DirectionProperty) {
                  DirectionProperty _dp = (DirectionProperty)_prop;
                  return (Direction)_bs.m_61143_(_dp);
               } else {
                  _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                  Direction var10000;
                  if (_prop instanceof EnumProperty) {
                     EnumProperty _ep = (EnumProperty)_prop;
                     if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                        var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                        return var10000;
                     }
                  }

                  var10000 = Direction.NORTH;
                  return var10000;
               }
            }
         })).getDirection(blockstate).m_122431_() - ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Z"))) {
            Pitch = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Pitch");
            Xvector = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "X") + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockState _bs) {
                  Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                  if (_prop instanceof DirectionProperty) {
                     DirectionProperty _dp = (DirectionProperty)_prop;
                     return (Direction)_bs.m_61143_(_dp);
                  } else {
                     _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                     Direction var10000;
                     if (_prop instanceof EnumProperty) {
                        EnumProperty _ep = (EnumProperty)_prop;
                        if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                           var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                           return var10000;
                        }
                     }

                     var10000 = Direction.NORTH;
                     return var10000;
                  }
               }
            })).getDirection(blockstate).m_122429_();
            Zvector = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Z") + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockState _bs) {
                  Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                  if (_prop instanceof DirectionProperty) {
                     DirectionProperty _dp = (DirectionProperty)_prop;
                     return (Direction)_bs.m_61143_(_dp);
                  } else {
                     _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                     Direction var10000;
                     if (_prop instanceof EnumProperty) {
                        EnumProperty _ep = (EnumProperty)_prop;
                        if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                           var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                           return var10000;
                        }
                     }

                     var10000 = Direction.NORTH;
                     return var10000;
                  }
               }
            })).getDirection(blockstate).m_122431_();
         }

         if (0.0D == Xvector * Zvector) {
            Xvector = (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockState _bs) {
                  Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                  if (_prop instanceof DirectionProperty) {
                     DirectionProperty _dp = (DirectionProperty)_prop;
                     return (Direction)_bs.m_61143_(_dp);
                  } else {
                     _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                     Direction var10000;
                     if (_prop instanceof EnumProperty) {
                        EnumProperty _ep = (EnumProperty)_prop;
                        if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                           var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                           return var10000;
                        }
                     }

                     var10000 = Direction.NORTH;
                     return var10000;
                  }
               }
            })).getDirection(blockstate).m_122429_();
            Zvector = (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockState _bs) {
                  Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                  if (_prop instanceof DirectionProperty) {
                     DirectionProperty _dp = (DirectionProperty)_prop;
                     return (Direction)_bs.m_61143_(_dp);
                  } else {
                     _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                     Direction var10000;
                     if (_prop instanceof EnumProperty) {
                        EnumProperty _ep = (EnumProperty)_prop;
                        if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                           var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                           return var10000;
                        }
                     }

                     var10000 = Direction.NORTH;
                     return var10000;
                  }
               }
            })).getDirection(blockstate).m_122431_();
         }

         if (world instanceof Level) {
            Level _level30 = (Level)world;
            if (_level30.m_276867_(BlockPos.m_274561_(x, y, z))) {
               Level _level;
               BlockPos _bp;
               BlockEntity _blockEntity;
               BlockState _bs;
               if (((<undefinedtype>)(new Object() {
                  public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "fired") && !world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128379_("fired", false);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }

               if (0.0D < ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y + DrumPosition, z), "Ammo") && ((<undefinedtype>)(new Object() {
                  public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
                  }
               })).getValue(world, BlockPos.m_274561_(x, y + DrumPosition, z), "AmmoType").equals("Small") && !((<undefinedtype>)(new Object() {
                  public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "fired") && world.m_8055_(BlockPos.m_274561_(x + (double)(((<undefinedtype>)(new Object() {
                  public Direction getDirection(BlockState _bs) {
                     Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                     if (_prop instanceof DirectionProperty) {
                        DirectionProperty _dp = (DirectionProperty)_prop;
                        return (Direction)_bs.m_61143_(_dp);
                     } else {
                        _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                        Direction var10000;
                        if (_prop instanceof EnumProperty) {
                           EnumProperty _ep = (EnumProperty)_prop;
                           if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                              var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                              return var10000;
                           }
                        }

                        var10000 = Direction.NORTH;
                        return var10000;
                     }
                  }
               })).getDirection(blockstate).m_122429_() * 1) + 0.5D, y + (double)(((<undefinedtype>)(new Object() {
                  public Direction getDirection(BlockState _bs) {
                     Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                     if (_prop instanceof DirectionProperty) {
                        DirectionProperty _dp = (DirectionProperty)_prop;
                        return (Direction)_bs.m_61143_(_dp);
                     } else {
                        _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                        Direction var10000;
                        if (_prop instanceof EnumProperty) {
                           EnumProperty _ep = (EnumProperty)_prop;
                           if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                              var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                              return var10000;
                           }
                        }

                        var10000 = Direction.NORTH;
                        return var10000;
                     }
                  }
               })).getDirection(blockstate).m_122430_() * 1) + 0.5D, z + (double)(((<undefinedtype>)(new Object() {
                  public Direction getDirection(BlockState _bs) {
                     Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                     if (_prop instanceof DirectionProperty) {
                        DirectionProperty _dp = (DirectionProperty)_prop;
                        return (Direction)_bs.m_61143_(_dp);
                     } else {
                        _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                        Direction var10000;
                        if (_prop instanceof EnumProperty) {
                           EnumProperty _ep = (EnumProperty)_prop;
                           if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                              var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                              return var10000;
                           }
                        }

                        var10000 = Direction.NORTH;
                        return var10000;
                     }
                  }
               })).getDirection(blockstate).m_122431_() * 1) + 0.5D)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:acbarrel")))) {
                  Barrels = 1.0D;

                  for(int index0 = 0; index0 < 5; ++index0) {
                     if (world.m_8055_(BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122429_() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122430_() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122431_() * (1.0D + Barrels) + 0.5D)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:acbarrel")))) {
                        ++Barrels;
                     }
                  }

                  if (!world.m_5776_()) {
                     _bp = BlockPos.m_274561_(x, y, z);
                     _blockEntity = world.m_7702_(_bp);
                     _bs = world.m_8055_(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().m_128347_("Barrels", Barrels);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.m_7260_(_bp, _bs, _bs, 3);
                     }
                  }

                  Level _level;
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122429_() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122430_() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122431_() * (1.0D + Barrels) + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.BLOCKS, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                     } else {
                        _level.m_7785_(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122429_() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122430_() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122431_() * (1.0D + Barrels) + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.BLOCKS, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122429_() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122430_() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122431_() * (1.0D + Barrels) + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.BLOCKS, 20.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                     } else {
                        _level.m_7785_(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122429_() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122430_() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.m_61143_(_dp);
                              } else {
                                 _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).m_122431_() * (1.0D + Barrels) + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.BLOCKS, 20.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                     }
                  }

                  ServerLevel _level;
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123777_, x + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122429_() * (2.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122430_() * (2.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122431_() * (2.0D + Barrels) + 0.5D, 4, 0.2D, 0.2D, 0.2D, 0.03D);
                  }

                  MuzzleFlashProcedure.execute(world, x + (double)((<undefinedtype>)(new Object() {
                     public Direction getDirection(BlockState _bs) {
                        Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                        if (_prop instanceof DirectionProperty) {
                           DirectionProperty _dp = (DirectionProperty)_prop;
                           return (Direction)_bs.m_61143_(_dp);
                        } else {
                           _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                           Direction var10000;
                           if (_prop instanceof EnumProperty) {
                              EnumProperty _ep = (EnumProperty)_prop;
                              if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                 var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                 return var10000;
                              }
                           }

                           var10000 = Direction.NORTH;
                           return var10000;
                        }
                     }
                  })).getDirection(blockstate).m_122429_() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                     public Direction getDirection(BlockState _bs) {
                        Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                        if (_prop instanceof DirectionProperty) {
                           DirectionProperty _dp = (DirectionProperty)_prop;
                           return (Direction)_bs.m_61143_(_dp);
                        } else {
                           _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                           Direction var10000;
                           if (_prop instanceof EnumProperty) {
                              EnumProperty _ep = (EnumProperty)_prop;
                              if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                 var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                 return var10000;
                              }
                           }

                           var10000 = Direction.NORTH;
                           return var10000;
                        }
                     }
                  })).getDirection(blockstate).m_122430_() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                     public Direction getDirection(BlockState _bs) {
                        Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                        if (_prop instanceof DirectionProperty) {
                           DirectionProperty _dp = (DirectionProperty)_prop;
                           return (Direction)_bs.m_61143_(_dp);
                        } else {
                           _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                           Direction var10000;
                           if (_prop instanceof EnumProperty) {
                              EnumProperty _ep = (EnumProperty)_prop;
                              if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                 var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                 return var10000;
                              }
                           }

                           var10000 = Direction.NORTH;
                           return var10000;
                        }
                     }
                  })).getDirection(blockstate).m_122431_() * (1.0D + Barrels) + 0.5D);
                  if (!world.m_5776_()) {
                     _bp = BlockPos.m_274561_(x, y + DrumPosition, z);
                     _blockEntity = world.m_7702_(_bp);
                     _bs = world.m_8055_(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().m_128347_("Ammo", ((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.m_7702_(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.m_274561_(x, y + DrumPosition, z), "Ammo") - 1.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.m_7260_(_bp, _bs, _bs, 3);
                     }
                  }

                  if (!world.m_5776_()) {
                     _bp = BlockPos.m_274561_(x, y, z);
                     _blockEntity = world.m_7702_(_bp);
                     _bs = world.m_8055_(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().m_128379_("fired", true);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.m_7260_(_bp, _bs, _bs, 3);
                     }
                  }

                  if (!world.m_5776_()) {
                     _bp = BlockPos.m_274561_(x, y, z);
                     _blockEntity = world.m_7702_(_bp);
                     _bs = world.m_8055_(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().m_128347_("Cooldown", 2.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.m_7260_(_bp, _bs, _bs, 3);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new HugeBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_BULLET_FIRE.get(), level);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           return entityToSpawn;
                        }
                     })).getArrow(_level, 2.5F, 1);
                     _entityToSpawn.m_6034_(x + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122429_() * (1.5D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122430_() * (1.5D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122431_() * (1.5D + Barrels) + 0.5D);
                     _entityToSpawn.m_6686_(Xvector, Pitch, Zvector, (float)(5.0D + Barrels / 1.5D), (float)(8.0D / (Barrels * 2.0D)));
                     _level.m_7967_(_entityToSpawn);
                  }

                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5D - (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122429_(), y, z + 0.5D - (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.m_61143_(_dp);
                           } else {
                              _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).m_122431_(), new ItemStack((ItemLike)CrustyChunksModItems.HUGE_CASING.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }

                  CasingDropProcedure.execute(world, x, y, z);
               }
            }
         }
      }

   }
}

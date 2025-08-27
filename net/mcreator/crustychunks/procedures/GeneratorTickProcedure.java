package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class GeneratorTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      double Kinetic = 0.0D;
      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      if (!world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _blockEntity = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128347_("Capacity", 5.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

      if (((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate) == ((<undefinedtype>)(new Object() {
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
      })).getDirection(world.m_8055_(BlockPos.m_274561_(x - (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).m_122429_(), y - (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).m_122430_(), z - (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).m_122431_())))) {
         if (0.0D < ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x - (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(blockstate).m_122429_(), y - (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(blockstate).m_122430_(), z - (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(blockstate).m_122431_()), "KineticPower")) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x + 0.5D, y + 0.5D, z + 0.5D, 2, 0.3D, 0.3D, 0.3D, 1.0D);
            }

            ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x - (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122429_(), y - (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122430_(), z - (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122431_()), "KineticPower");
         } else {
            Kinetic = 0.0D;
         }
      } else {
         Kinetic = 0.0D;
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Energy") < ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Capacity") && !world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _blockEntity = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128347_("Energy", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Energy") + (double)Math.round(0.9D * (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x - (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122429_(), y - (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122430_(), z - (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122431_()), "KineticPower") / 50.0D)));
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

   }
}

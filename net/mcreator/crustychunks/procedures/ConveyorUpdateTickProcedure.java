package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

public class ConveyorUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      if (0 != ((<undefinedtype>)(new Object() {
         public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicInteger _retval = new AtomicInteger(0);
            BlockEntity _ent = world.m_7702_(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getStackInSlot(slotid).m_41613_());
               });
            }

            return _retval.get();
         }
      })).getAmount(world, BlockPos.m_274561_(x, y, z), 0)) {
         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128379_("Greenlight", false);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }
      } else if (0 == ((<undefinedtype>)(new Object() {
         public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicInteger _retval = new AtomicInteger(0);
            BlockEntity _ent = world.m_7702_(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getStackInSlot(slotid).m_41613_());
               });
            }

            return _retval.get();
         }
      })).getAmount(world, BlockPos.m_274561_(x, y, z), 0) && !world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _blockEntity = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128379_("Greenlight", true);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).m_122429_(), y, z + (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).m_122431_()), "Greenlight") && 0 == ((<undefinedtype>)(new Object() {
         public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicInteger _retval = new AtomicInteger(0);
            BlockEntity _ent = world.m_7702_(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getStackInSlot(slotid).m_41613_());
               });
            }

            return _retval.get();
         }
      })).getAmount(world, BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).m_122429_(), y, z + (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).m_122431_()), 0) && ((<undefinedtype>)(new Object() {
         public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
            BlockEntity _ent = world.m_7702_(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getStackInSlot(slotid).m_41777_());
               });
            }

            return (ItemStack)_retval.get();
         }
      })).getItemStack(world, BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).m_122429_(), y, z + (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).m_122431_()), 0).m_41720_() == ItemStack.f_41583_.m_41720_()) {
         BlockEntity _ent;
         boolean _slotid;
         ItemStack _setstack;
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
         })).getDirection(blockstate).m_122429_(), y, z + (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(blockstate).m_122431_())).m_60734_() != CrustyChunksModBlocks.CONVEYOR.get() && world.m_8055_(BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(blockstate).m_122429_(), y, z + (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(blockstate).m_122431_())).m_60734_() != CrustyChunksModBlocks.CONVEYOR_DROPOFF.get() && world.m_8055_(BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(blockstate).m_122429_(), y, z + (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(blockstate).m_122431_())).m_60734_() != CrustyChunksModBlocks.CONVEYOR_LIFT.get()) {
            _ent = world.m_7702_(BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122429_(), y, z + (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122431_()));
            if (_ent != null) {
               _slotid = false;
               _setstack = ((<undefinedtype>)(new Object() {
                  public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                     AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                     BlockEntity _ent = world.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getStackInSlot(slotid).m_41777_());
                        });
                     }

                     return (ItemStack)_retval.get();
                  }
               })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41777_();
               _setstack.m_41764_(1);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                  }

               });
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _setstack = ((<undefinedtype>)(new Object() {
                  public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                     AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                     BlockEntity _ent = world.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getStackInSlot(slotid).m_41777_());
                        });
                     }

                     return (ItemStack)_retval.get();
                  }
               })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41777_();
               _setstack.m_41764_(((<undefinedtype>)(new Object() {
                  public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                     AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                     BlockEntity _ent = world.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getStackInSlot(slotid).m_41777_());
                        });
                     }

                     return (ItemStack)_retval.get();
                  }
               })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41613_() - 1);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                  }

               });
            }
         } else {
            _ent = world.m_7702_(BlockPos.m_274561_(x + (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122429_(), y, z + (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).m_122431_()));
            if (_ent != null) {
               _slotid = false;
               _setstack = ((<undefinedtype>)(new Object() {
                  public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                     AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                     BlockEntity _ent = world.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getStackInSlot(slotid).m_41777_());
                        });
                     }

                     return (ItemStack)_retval.get();
                  }
               })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41777_();
               _setstack.m_41764_(((<undefinedtype>)(new Object() {
                  public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                     AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                     BlockEntity _ent = world.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getStackInSlot(slotid).m_41777_());
                        });
                     }

                     return (ItemStack)_retval.get();
                  }
               })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41613_());
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                  }

               });
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _setstack = ((<undefinedtype>)(new Object() {
                  public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                     AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                     BlockEntity _ent = world.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getStackInSlot(slotid).m_41777_());
                        });
                     }

                     return (ItemStack)_retval.get();
                  }
               })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41777_();
               _setstack.m_41764_(0);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                  }

               });
            }
         }
      }

   }
}

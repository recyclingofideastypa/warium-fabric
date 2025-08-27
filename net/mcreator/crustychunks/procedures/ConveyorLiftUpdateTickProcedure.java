package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

public class ConveyorLiftUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.m_5776_()) {
         BlockPos _bp = BlockPos.m_274561_(x, y, z);
         BlockEntity _blockEntity = world.m_7702_(_bp);
         BlockState _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128379_("Greenlight", true);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x, y + 1.0D, z), "Greenlight") && 0 == ((<undefinedtype>)(new Object() {
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
      })).getAmount(world, BlockPos.m_274561_(x, y + 1.0D, z), 0) && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y + 1.0D, z), 0).m_41720_() == ItemStack.f_41583_.m_41720_()) {
         BlockEntity _ent;
         boolean _slotid;
         ItemStack _setstack;
         if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() != CrustyChunksModBlocks.CONVEYOR.get() && world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() != CrustyChunksModBlocks.CONVEYOR_DROPOFF.get() && world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() != CrustyChunksModBlocks.CONVEYOR_LIFT.get()) {
            _ent = world.m_7702_(BlockPos.m_274561_(x, y + 1.0D, z));
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
               int _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).m_41777_();
                     _stk.m_41774_(1);
                     ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                  }

               });
            }
         } else {
            _ent = world.m_7702_(BlockPos.m_274561_(x, y + 1.0D, z));
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

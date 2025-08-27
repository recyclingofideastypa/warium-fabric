package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

public class FissionBombRedstoneOnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.FISSION_CORE.get() && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 1).m_41720_() == CrustyChunksModItems.IMPLOSION_LENS.get() && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 2).m_41720_() == CrustyChunksModItems.IMPLOSION_LENS.get() && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 3).m_41720_() == CrustyChunksModItems.IMPLOSION_LENS.get() && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 4).m_41720_() == CrustyChunksModItems.IMPLOSION_LENS.get() && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 5).m_41720_() == CrustyChunksModItems.IMPLOSION_LENS.get() && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 6).m_41720_() == CrustyChunksModItems.IMPLOSION_LENS.get()) {
         if (((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.m_274561_(x, y, z), 7).m_41720_() == CrustyChunksModItems.IMPACT_FUZE.get() && world.m_6106_().m_5470_().m_46207_(CrustyChunksModGameRules.ALLOW_IMPACT_FUZE)) {
            BlockEntity _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            boolean _slotid;
            ItemStack _setstack;
            if (_ent != null) {
               _slotid = false;
               _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(0);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                  }

               });
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(0);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(1, _setstack);
                  }

               });
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(0);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(2, _setstack);
                  }

               });
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(0);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(3, _setstack);
                  }

               });
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(0);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(4, _setstack);
                  }

               });
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(0);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(5, _setstack);
                  }

               });
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(0);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(6, _setstack);
                  }

               });
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(0);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(7, _setstack);
                  }

               });
            }

            world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50016_.m_49966_(), 3);
            FissionExplosionProcedure.execute(world, x, y, z);
         } else if (((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.m_274561_(x, y, z), 7).m_41720_() == CrustyChunksModItems.TIMED_FUZE.get() && !world.m_5776_()) {
            BlockPos _bp = BlockPos.m_274561_(x, y, z);
            BlockEntity _blockEntity = world.m_7702_(_bp);
            BlockState _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128379_("Triggered", true);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }
      }

   }
}

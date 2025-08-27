package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class DamagesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.LIGHT_COMBUSTION_ENGINE.get() || world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.JET_TURBINE.get()) {
         LightCombustionEngineBlockDestroyedProcedure.execute(world, x, y, z);
         execute(world, x, y + 1.0D, z);
         execute(world, x, y - 1.0D, z);
         execute(world, x + 1.0D, y, z);
         execute(world, x - 1.0D, y, z);
         execute(world, x, y, z + 1.0D);
         execute(world, x, y, z - 1.0D);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FUEL_TANK_INPUT.get() || world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FUEL_TANK.get() || world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FUEL_TANK_MODULE.get()) {
         FuelTankDamagedProcedure.execute(world, x, y, z);
      }

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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.LARGE_SHELL.get() || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.HEAT_SHELL.get() || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.AP_SHELL.get() || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.SOLID_SHELL.get() || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.FLAK_SHELL.get() || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.POWDER_CHARGE.get()) {
         CrustyChunksMod.queueServerWork(1, () -> {
            SmallFraglessProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
         });
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         execute(world, x, y + 1.0D, z);
         execute(world, x, y - 1.0D, z);
         execute(world, x + 1.0D, y, z);
         execute(world, x - 1.0D, y, z);
         execute(world, x, y, z + 1.0D);
         execute(world, x, y, z - 1.0D);
      }

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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.ARTILLERY_SHELL.get()) {
         CrustyChunksMod.queueServerWork(1, () -> {
            MediumFraglessProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
         });
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         execute(world, x, y + 1.0D, z);
         execute(world, x, y - 1.0D, z);
         execute(world, x + 1.0D, y, z);
         execute(world, x - 1.0D, y, z);
         execute(world, x, y, z + 1.0D);
         execute(world, x, y, z - 1.0D);
      }

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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.ARTILLERY_SHELL.get() || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.POWDER_CHARGE.get()) {
         CrustyChunksMod.queueServerWork(1, () -> {
            MediumFraglessProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
         });
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         execute(world, x, y + 1.0D, z);
         execute(world, x, y - 1.0D, z);
         execute(world, x + 1.0D, y, z);
         execute(world, x - 1.0D, y, z);
         execute(world, x, y, z + 1.0D);
         execute(world, x, y, z - 1.0D);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get() && ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Ammo") > 3.0D) {
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         CrustyChunksMod.queueServerWork(20, () -> {
            MicroExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
            execute(world, x, y + 1.0D, z);
            execute(world, x, y - 1.0D, z);
            execute(world, x + 1.0D, y, z);
            execute(world, x - 1.0D, y, z);
            execute(world, x, y, z + 1.0D);
            execute(world, x, y, z - 1.0D);
            MicroExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
         });
         CrustyChunksMod.queueServerWork(40, () -> {
            MicroExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
         });
         CrustyChunksMod.queueServerWork(50, () -> {
            MicroExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
         });
      }

   }
}

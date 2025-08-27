package net.mcreator.crustychunks.block.entity;

import java.util.Iterator;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.init.CrustyChunksModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class LargeElectricMotorBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
   private NonNullList<ItemStack> stacks;
   private final LazyOptional<? extends IItemHandler>[] handlers;
   private final EnergyStorage energyStorage;

   public LargeElectricMotorBlockEntity(BlockPos position, BlockState state) {
      super((BlockEntityType)CrustyChunksModBlockEntities.LARGE_ELECTRIC_MOTOR.get(), position, state);
      this.stacks = NonNullList.m_122780_(9, ItemStack.f_41583_);
      this.handlers = SidedInvWrapper.create(this, Direction.values());
      this.energyStorage = new EnergyStorage(400000, 200, 200, 0) {
         public int receiveEnergy(int maxReceive, boolean simulate) {
            int retval = super.receiveEnergy(maxReceive, simulate);
            if (!simulate) {
               LargeElectricMotorBlockEntity.this.m_6596_();
               LargeElectricMotorBlockEntity.this.f_58857_.m_7260_(LargeElectricMotorBlockEntity.this.f_58858_, LargeElectricMotorBlockEntity.this.f_58857_.m_8055_(LargeElectricMotorBlockEntity.this.f_58858_), LargeElectricMotorBlockEntity.this.f_58857_.m_8055_(LargeElectricMotorBlockEntity.this.f_58858_), 2);
            }

            return retval;
         }

         public int extractEnergy(int maxExtract, boolean simulate) {
            int retval = super.extractEnergy(maxExtract, simulate);
            if (!simulate) {
               LargeElectricMotorBlockEntity.this.m_6596_();
               LargeElectricMotorBlockEntity.this.f_58857_.m_7260_(LargeElectricMotorBlockEntity.this.f_58858_, LargeElectricMotorBlockEntity.this.f_58857_.m_8055_(LargeElectricMotorBlockEntity.this.f_58858_), LargeElectricMotorBlockEntity.this.f_58857_.m_8055_(LargeElectricMotorBlockEntity.this.f_58858_), 2);
            }

            return retval;
         }
      };
   }

   public void m_142466_(CompoundTag compound) {
      super.m_142466_(compound);
      if (!this.m_59631_(compound)) {
         this.stacks = NonNullList.m_122780_(this.m_6643_(), ItemStack.f_41583_);
      }

      ContainerHelper.m_18980_(compound, this.stacks);
      Tag var3 = compound.m_128423_("energyStorage");
      if (var3 instanceof IntTag) {
         IntTag intTag = (IntTag)var3;
         this.energyStorage.deserializeNBT(intTag);
      }

   }

   public void m_183515_(CompoundTag compound) {
      super.m_183515_(compound);
      if (!this.m_59634_(compound)) {
         ContainerHelper.m_18973_(compound, this.stacks);
      }

      compound.m_128365_("energyStorage", this.energyStorage.serializeNBT());
   }

   public ClientboundBlockEntityDataPacket getUpdatePacket() {
      return ClientboundBlockEntityDataPacket.m_195640_(this);
   }

   public CompoundTag m_5995_() {
      return this.m_187480_();
   }

   public int m_6643_() {
      return this.stacks.size();
   }

   public boolean m_7983_() {
      Iterator var1 = this.stacks.iterator();

      ItemStack itemstack;
      do {
         if (!var1.hasNext()) {
            return true;
         }

         itemstack = (ItemStack)var1.next();
      } while(itemstack.m_41619_());

      return false;
   }

   public Component m_6820_() {
      return Component.m_237113_("large_electric_motor");
   }

   public int m_6893_() {
      return 64;
   }

   public AbstractContainerMenu m_6555_(int id, Inventory inventory) {
      return ChestMenu.m_39255_(id, inventory);
   }

   public Component m_5446_() {
      return Component.m_237113_("Electric Motor");
   }

   protected NonNullList<ItemStack> m_7086_() {
      return this.stacks;
   }

   protected void m_6520_(NonNullList<ItemStack> stacks) {
      this.stacks = stacks;
   }

   public boolean m_7013_(int index, ItemStack stack) {
      return true;
   }

   public int[] m_7071_(Direction side) {
      return IntStream.range(0, this.m_6643_()).toArray();
   }

   public boolean m_7155_(int index, ItemStack stack, @Nullable Direction direction) {
      return this.m_7013_(index, stack);
   }

   public boolean m_7157_(int index, ItemStack stack, Direction direction) {
      return true;
   }

   public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
      if (!this.f_58859_ && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
         return this.handlers[facing.ordinal()].cast();
      } else {
         return !this.f_58859_ && capability == ForgeCapabilities.ENERGY ? LazyOptional.of(() -> {
            return this.energyStorage;
         }).cast() : super.getCapability(capability, facing);
      }
   }

   public void m_7651_() {
      super.m_7651_();
      LazyOptional[] var1 = this.handlers;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         LazyOptional<? extends IItemHandler> handler = var1[var3];
         handler.invalidate();
      }

   }
}

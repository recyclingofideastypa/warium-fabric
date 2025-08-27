package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class FireboxUpdateTickProcedure {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == Items.f_42413_ || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == Items.f_42414_) {
         BlockEntity _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
         if (_ent != null) {
            int _slotid = false;
            int _amount = true;
            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ItemStack _stk = capability.getStackInSlot(0).m_41777_();
                  _stk.m_41774_(1);
                  ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
               }

            });
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
         }

         Level _level;
         BlockPos _bp;
         BlockEntity _blockEntity;
         BlockState _bs;
         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x + 1.0D, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x + 1.0D, y, z), "Heat") + 40.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x - 1.0D, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x - 1.0D, y, z), "Heat") + 40.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z + 1.0D);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z + 1.0D), "Heat") + 40.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z - 1.0D);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z - 1.0D), "Heat") + 40.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y + 1.0D, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y + 1.0D, z), "Heat") + 40.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123744_, x + 0.5D, y + 0.5D, z + 0.5D, 10, 1.0D, 1.0D, 1.0D, 0.01D);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123777_, x + 0.5D, y + 0.5D, z + 0.5D, 10, 1.0D, 1.0D, 1.0D, 0.01D);
         }
      }

   }
}

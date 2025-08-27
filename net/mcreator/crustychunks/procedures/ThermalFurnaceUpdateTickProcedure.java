package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class ThermalFurnaceUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockEntity _ent;
      if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() == CrustyChunksModBlocks.BLAST_FUNNEL.get() && world.m_8055_(BlockPos.m_274561_(x, y + 2.0D, z)).m_60734_() == CrustyChunksModBlocks.BLAST_FUNNEL.get() && world.m_8055_(BlockPos.m_274561_(x, y + 3.0D, z)).m_60734_() == CrustyChunksModBlocks.BLAST_FUNNEL.get() && ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Heat") >= 200.0D && ((<undefinedtype>)(new Object() {
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
      })).getAmount(world, BlockPos.m_274561_(x, y, z), 1) < 64 && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() != ItemStack.f_41583_.m_41720_()) {
         label91: {
            label81: {
               if (((<undefinedtype>)(new Object() {
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
               })).getAmount(world, BlockPos.m_274561_(x, y, z), 1) <= 63) {
                  Item var10000 = ((<undefinedtype>)(new Object() {
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
                  })).getItemStack(world, BlockPos.m_274561_(x, y, z), 1).m_41720_();
                  ItemStack var10001;
                  if (world instanceof Level) {
                     Level _lvlSmeltResult = (Level)world;
                     var10001 = (ItemStack)_lvlSmeltResult.m_7465_().m_44015_(RecipeType.f_44108_, new SimpleContainer(new ItemStack[]{((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0)}), _lvlSmeltResult).map((recipe) -> {
                        return recipe.m_8043_(_lvlSmeltResult.m_9598_()).m_41777_();
                     }).orElse(ItemStack.f_41583_);
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  if (var10000 == var10001.m_41720_()) {
                     break label81;
                  }
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
               })).getItemStack(world, BlockPos.m_274561_(x, y, z), 1).m_41720_() != ItemStack.f_41583_.m_41720_()) {
                  break label91;
               }
            }

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            boolean _slotid;
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

            _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            Level _level;
            if (_ent != null) {
               _slotid = true;
               ItemStack var21;
               if (world instanceof Level) {
                  _level = (Level)world;
                  var21 = (ItemStack)_level.m_7465_().m_44015_(RecipeType.f_44108_, new SimpleContainer(new ItemStack[]{((<undefinedtype>)(new Object() {
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
                  })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0)}), _level).map((recipe) -> {
                     return recipe.m_8043_(_level.m_9598_()).m_41777_();
                  }).orElse(ItemStack.f_41583_);
               } else {
                  var21 = ItemStack.f_41583_;
               }

               ItemStack _setstack = var21.m_41777_();
               _setstack.m_41764_(((<undefinedtype>)(new Object() {
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
               })).getAmount(world, BlockPos.m_274561_(x, y, z), 1) + 1);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(1, _setstack);
                  }

               });
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 5.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 5.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123777_, x + 0.5D, y + 6.0D, z + 0.5D, 5, 0.0D, 3.0D, 0.0D, 0.01D);
            }

            if (!world.m_5776_()) {
               BlockPos _bp = BlockPos.m_274561_(x, y, z);
               BlockEntity _blockEntity = world.m_7702_(_bp);
               BlockState _bs = world.m_8055_(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().m_128347_("Heat", ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.m_7702_(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.m_274561_(x, y, z), "Heat") - 40.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.m_7260_(_bp, _bs, _bs, 3);
               }
            }
         }
      }

      BlockPos _bp;
      BlockState _bs;
      Level _level;
      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Heat") >= 5.0D && !world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _ent = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_ent != null) {
            _ent.getPersistentData().m_128347_("Heat", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Heat") - 1.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Heat") >= 1500.0D && !world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _ent = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_ent != null) {
            _ent.getPersistentData().m_128347_("Heat", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Heat") - 10.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

   }
}

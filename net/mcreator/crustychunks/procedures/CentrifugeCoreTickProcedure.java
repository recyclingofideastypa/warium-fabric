package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class CentrifugeCoreTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() == CrustyChunksModBlocks.CENTRIFUGE_TOP.get() && world.m_8055_(BlockPos.m_274561_(x, y - 1.0D, z)).m_60734_() == CrustyChunksModBlocks.CENTRIFUGE_BOTTOM.get() && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x, y + 1.0D, z), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x, y - 1.0D, z), "Ready")) {
         BlockPos _bp;
         BlockEntity _blockEntity;
         BlockState _bs;
         Level _level;
         BlockEntity _ent;
         boolean _slotid;
         ServerLevel _level;
         Level _level;
         ItemStack _setstack;
         boolean _amount;
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
         })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.URANIUM_NEUTRAL_DUST.get() && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.m_274561_(x, y + 1.0D, z), 0) < 64 && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.m_274561_(x, y - 1.0D, z), 0) < 64) {
            if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "T") >= (double)world.m_6106_().m_5470_().m_46215_(CrustyChunksModGameRules.ENRICHMENT_TIME)) {
               if (!world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128347_("T", 0.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }

               _ent = world.m_7702_(BlockPos.m_274561_(x, y + 1.0D, z));
               if (_ent != null) {
                  _slotid = false;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.URANIUM_ENRICHED_TINY_DUST.get())).m_41777_();
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
                  })).getAmount(world, BlockPos.m_274561_(x, y + 1.0D, z), 0) + 1);
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                     }

                  });
               }

               _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
               if (_ent != null) {
                  _slotid = false;
                  _amount = true;
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ItemStack _stk = capability.getStackInSlot(0).m_41777_();
                        _stk.m_41774_(1);
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                     }

                  });
               }

               _ent = world.m_7702_(BlockPos.m_274561_(x, y - 1.0D, z));
               if (_ent != null) {
                  _slotid = false;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.URANIUM_DEPLETED_DUST.get())).m_41777_();
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
                  })).getAmount(world, BlockPos.m_274561_(x, y - 1.0D, z), 0) + 1);
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                     }

                  });
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123745_, x + 0.5D, y + 0.5D, z + 0.5D, 10, 0.6D, 0.6D, 0.6D, 0.1D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                  }
               }
            } else {
               if (!world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128347_("T", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "T") + 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123815_, x + 0.5D, y + 0.5D, z + 0.5D, 10, 0.6D, 0.6D, 0.6D, 0.1D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "T") / (double)world.m_6106_().m_5470_().m_46215_(CrustyChunksModGameRules.ENRICHMENT_TIME) * 3.0D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "T") / (double)world.m_6106_().m_5470_().m_46215_(CrustyChunksModGameRules.ENRICHMENT_TIME) * 3.0D), false);
                  }
               }
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
         })).getItemStack(world, BlockPos.m_274561_(x, y, z), 0).m_41720_() == CrustyChunksModItems.LITHIUM_DUST.get() && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.m_274561_(x, y + 1.0D, z), 0) < 64 && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.m_274561_(x, y - 1.0D, z), 0) < 64) {
            if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "T") >= (double)world.m_6106_().m_5470_().m_46215_(CrustyChunksModGameRules.ENRICHMENT_TIME)) {
               if (!world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128347_("T", 0.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }

               _ent = world.m_7702_(BlockPos.m_274561_(x, y + 1.0D, z));
               if (_ent != null) {
                  _slotid = false;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.ENRICHED_LITHIUM_NUGGET.get())).m_41777_();
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
                  })).getAmount(world, BlockPos.m_274561_(x, y + 1.0D, z), 0) + 1);
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                     }

                  });
               }

               _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
               if (_ent != null) {
                  _slotid = false;
                  _amount = true;
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ItemStack _stk = capability.getStackInSlot(0).m_41777_();
                        _stk.m_41774_(1);
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                     }

                  });
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123745_, x + 0.5D, y + 0.5D, z + 0.5D, 10, 0.6D, 0.6D, 0.6D, 0.1D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                  }
               }
            } else {
               if (!world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128347_("T", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "T") + 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123815_, x + 0.5D, y + 0.5D, z + 0.5D, 10, 0.6D, 0.6D, 0.6D, 0.1D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "T") / (double)world.m_6106_().m_5470_().m_46215_(CrustyChunksModGameRules.ENRICHMENT_TIME) * 3.0D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "T") / (double)world.m_6106_().m_5470_().m_46215_(CrustyChunksModGameRules.ENRICHMENT_TIME) * 3.0D), false);
                  }
               }
            }
         }
      }

   }
}

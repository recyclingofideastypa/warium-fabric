package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.registries.ForgeRegistries;

public class FuelTankFillProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         BlockEntity _ent;
         int _amount;
         BlockState _bs;
         Level _level;
         BlockPos _bp;
         LivingEntity _entity;
         Level _level;
         BlockEntity _blockEntity;
         ItemStack _setstack;
         Player _player;
         if (var10000.m_41720_() == CrustyChunksModItems.DIESEL_BUCKET.get()) {
            if ((((<undefinedtype>)(new Object() {
               public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.m_7702_(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getFluidInTank(tank).getAmount());
                     });
                  }

                  return _retval.get();
               }
            })).getFluidTankLevel(world, BlockPos.m_274561_(x, y, z), ((<undefinedtype>)(new Object() {
               public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.m_7702_(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getFluidInTank(tank).getAmount());
                     });
                  }

                  return _retval.get();
               }
            })).getFluidTankLevel(world, BlockPos.m_274561_(x, y, z), ((<undefinedtype>)(new Object() {
               public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.m_7702_(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getTanks());
                     });
                  }

                  return _retval.get();
               }
            })).getBlockTanks(world, BlockPos.m_274561_(x, y, z)))) == 0 || ((<undefinedtype>)(new Object() {
               public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "FuelType").equals("Diesel")) && 900 <= ((<undefinedtype>)(new Object() {
               public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.m_7702_(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), amount), FluidAction.SIMULATE));
                     });
                  }

                  return _retval.get();
               }
            })).fillTankSimulate(world, BlockPos.m_274561_(x, y, z), 1000)) {
               _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
               _amount = ((<undefinedtype>)(new Object() {
                  public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), amount), FluidAction.SIMULATE));
                        });
                     }

                     return _retval.get();
                  }
               })).fillTankSimulate(world, BlockPos.m_274561_(x, y, z), 1000);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                     capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), _amount), FluidAction.EXECUTE);
                  });
               }

               if (!world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128359_("FuelType", "Diesel");
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }

               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _setstack = (new ItemStack(Items.f_42446_)).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == CrustyChunksModItems.KEROSENE_BUCKET.get()) {
               if ((((<undefinedtype>)(new Object() {
                  public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getFluidInTank(tank).getAmount());
                        });
                     }

                     return _retval.get();
                  }
               })).getFluidTankLevel(world, BlockPos.m_274561_(x, y, z), ((<undefinedtype>)(new Object() {
                  public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getFluidInTank(tank).getAmount());
                        });
                     }

                     return _retval.get();
                  }
               })).getFluidTankLevel(world, BlockPos.m_274561_(x, y, z), ((<undefinedtype>)(new Object() {
                  public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getTanks());
                        });
                     }

                     return _retval.get();
                  }
               })).getBlockTanks(world, BlockPos.m_274561_(x, y, z)))) == 0 || ((<undefinedtype>)(new Object() {
                  public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "FuelType").equals("Kerosene")) && 900 <= ((<undefinedtype>)(new Object() {
                  public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), amount), FluidAction.SIMULATE));
                        });
                     }

                     return _retval.get();
                  }
               })).fillTankSimulate(world, BlockPos.m_274561_(x, y, z), 1000)) {
                  _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
                  _amount = ((<undefinedtype>)(new Object() {
                     public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.m_7702_(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), amount), FluidAction.SIMULATE));
                           });
                        }

                        return _retval.get();
                     }
                  })).fillTankSimulate(world, BlockPos.m_274561_(x, y, z), 1000);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), _amount), FluidAction.EXECUTE);
                     });
                  }

                  if (!world.m_5776_()) {
                     _bp = BlockPos.m_274561_(x, y, z);
                     _blockEntity = world.m_7702_(_bp);
                     _bs = world.m_8055_(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().m_128359_("FuelType", "Kerosene");
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.m_7260_(_bp, _bs, _bs, 3);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     _setstack = (new ItemStack(Items.f_42446_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == CrustyChunksModItems.FUEL_HOSE.get()) {
                  ItemStack var10005;
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10005 = _entity.m_21205_();
                  } else {
                     var10005 = ItemStack.f_41583_;
                  }

                  HoseConnectionProcedure.execute(world, x, y, z, entity, var10005);
               }
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               String var10001 = (new DecimalFormat("####")).format((long)((<undefinedtype>)(new Object() {
                  public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getFluidInTank(tank).getAmount());
                        });
                     }

                     return _retval.get();
                  }
               })).getFluidTankLevel(world, BlockPos.m_274561_(x, y, z), ((<undefinedtype>)(new Object() {
                  public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getTanks());
                        });
                     }

                     return _retval.get();
                  }
               })).getBlockTanks(world, BlockPos.m_274561_(x, y, z))));
               _player.m_5661_(Component.m_237113_(var10001 + "/" + (new DecimalFormat("####")).format((long)((<undefinedtype>)(new Object() {
                  public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getTankCapacity(tank));
                        });
                     }

                     return _retval.get();
                  }
               })).getFluidTankCapacity(world, BlockPos.m_274561_(x, y, z), ((<undefinedtype>)(new Object() {
                  public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.m_7702_(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getTanks());
                        });
                     }

                     return _retval.get();
                  }
               })).getBlockTanks(world, BlockPos.m_274561_(x, y, z))))), true);
            }
         }

      }
   }
}

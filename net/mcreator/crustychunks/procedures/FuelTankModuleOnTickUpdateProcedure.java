package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class FuelTankModuleOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double amount = 0.0D;
      double fluid = 0.0D;
      double fillamount = 0.0D;
      sx = -1.0D;
      found = false;

      for(int index0 = 0; index0 < 3; ++index0) {
         sy = -1.0D;

         for(int index1 = 0; index1 < 3; ++index1) {
            sz = -1.0D;

            for(int index2 = 0; index2 < 3; ++index2) {
               if ((0.0D != sx || 0.0D != sy || 0.0D != sz) && (world.m_8055_(BlockPos.m_274561_(x + sx, y + sy, z + sz)).m_60734_() == CrustyChunksModBlocks.DAMAGEDFUELTANK.get() || world.m_8055_(BlockPos.m_274561_(x + sx, y + sy, z + sz)).m_60734_() == CrustyChunksModBlocks.FUEL_TANK.get() || world.m_8055_(BlockPos.m_274561_(x + sx, y + sy, z + sz)).m_60734_() == CrustyChunksModBlocks.FUEL_TANK_MODULE.get())) {
                  BlockEntity _ent;
                  int _amount;
                  BlockState _bs;
                  Level _level;
                  BlockPos _bp;
                  BlockEntity _blockEntity;
                  if (((<undefinedtype>)(new Object() {
                     public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.m_7702_(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
                     }
                  })).getValue(world, BlockPos.m_274561_(x, y, z), "FuelType").equals("Kerosene") && (((<undefinedtype>)(new Object() {
                     public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.m_7702_(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
                     }
                  })).getValue(world, BlockPos.m_274561_(x + sx, y + sy, z + sz), "FuelType").equals("Kerosene") || 0 >= ((<undefinedtype>)(new Object() {
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
                  })).getFluidTankLevel(world, BlockPos.m_274561_(x + sx, y + sy, z + sz), ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.m_274561_(x + sx, y + sy, z + sz)))) && ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.m_274561_(x, y, z))) > ((<undefinedtype>)(new Object() {
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
                  })).getFluidTankLevel(world, BlockPos.m_274561_(x + sx, y + sy, z + sz), ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.m_274561_(x + sx, y + sy, z + sz)))) {
                     amount = (double)((<undefinedtype>)(new Object() {
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
                     })).fillTankSimulate(world, BlockPos.m_274561_(x + sx, y + sy, z + sz), 250);
                     fillamount = (double)((<undefinedtype>)(new Object() {
                        public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.m_7702_(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                              });
                           }

                           return _retval.get();
                        }
                     })).drainTankSimulate(world, BlockPos.m_274561_(x, y, z), (int)amount);
                     _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
                     _amount = (int)(fillamount / 2.0D);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           capability.drain(_amount, FluidAction.EXECUTE);
                        });
                     }

                     _ent = world.m_7702_(BlockPos.m_274561_(x + sx, y + sy, z + sz));
                     _amount = (int)(fillamount / 2.0D);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), _amount), FluidAction.EXECUTE);
                        });
                     }

                     if (0.0D < fillamount && !world.m_5776_()) {
                        _bp = BlockPos.m_274561_(x + sx, y + sy, z + sz);
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
                  }

                  if (((<undefinedtype>)(new Object() {
                     public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.m_7702_(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
                     }
                  })).getValue(world, BlockPos.m_274561_(x, y, z), "FuelType").equals("Diesel") && (((<undefinedtype>)(new Object() {
                     public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.m_7702_(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
                     }
                  })).getValue(world, BlockPos.m_274561_(x + sx, y + sy, z + sz), "FuelType").equals("Diesel") || 0 >= ((<undefinedtype>)(new Object() {
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
                  })).getFluidTankLevel(world, BlockPos.m_274561_(x + sx, y + sy, z + sz), ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.m_274561_(x + sx, y + sy, z + sz)))) && ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.m_274561_(x, y, z))) > ((<undefinedtype>)(new Object() {
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
                  })).getFluidTankLevel(world, BlockPos.m_274561_(x + sx, y + sy, z + sz), ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.m_274561_(x + sx, y + sy, z + sz)))) {
                     amount = (double)((<undefinedtype>)(new Object() {
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
                     })).fillTankSimulate(world, BlockPos.m_274561_(x + sx, y + sy, z + sz), 250);
                     fillamount = (double)((<undefinedtype>)(new Object() {
                        public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.m_7702_(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                              });
                           }

                           return _retval.get();
                        }
                     })).drainTankSimulate(world, BlockPos.m_274561_(x, y, z), (int)amount);
                     _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
                     _amount = (int)(fillamount / 2.0D);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           capability.drain(_amount, FluidAction.EXECUTE);
                        });
                     }

                     _ent = world.m_7702_(BlockPos.m_274561_(x + sx, y + sy, z + sz));
                     _amount = (int)(fillamount / 2.0D);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), _amount), FluidAction.EXECUTE);
                        });
                     }

                     if (0.0D < fillamount && !world.m_5776_()) {
                        _bp = BlockPos.m_274561_(x + sx, y + sy, z + sz);
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
                  }
               }

               ++sz;
            }

            ++sy;
         }

         ++sx;
      }

   }
}

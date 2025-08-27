package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.registries.ForgeRegistries;

public class EngineUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      String direction = "";
      boolean found = false;
      double power = 0.0D;
      double multiplier = 0.0D;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      power = 0.0D;
      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
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

      Level _level;
      if (((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.m_274561_(x, y, z))) > 0 && ((<undefinedtype>)(new Object() {
         public String getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "FuelType").equals("Diesel")) {
         label88: {
            if (world instanceof Level) {
               _level = (Level)world;
               if (_level.m_276867_(BlockPos.m_274561_(x, y, z))) {
                  power = 50.0D;
                  break label88;
               }
            }

            if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "ControlX"), ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "ControlY"), ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "ControlZ")), "Throttle") > 0.0D) {
               power = ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "ControlX"), ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "ControlY"), ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "ControlZ")), "Throttle") * 5.0D;
            } else {
               power = 0.0D;
            }
         }

         if (0.0D >= ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "FuelQue")) {
            BlockEntity _ent = world.m_7702_(BlockPos.m_274561_(x, y, z));
            int _amount = ((<undefinedtype>)(new Object() {
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
            })).drainTankSimulate(world, BlockPos.m_274561_(x + sx, y + sy, z + sz), (int)(power / 5.0D));
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  capability.drain(_amount, FluidAction.EXECUTE);
               });
            }

            if (!world.m_5776_()) {
               _bp = BlockPos.m_274561_(x, y, z);
               _blockEntity = world.m_7702_(_bp);
               _bs = world.m_8055_(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().m_128347_("FuelQue", 20.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.m_7260_(_bp, _bs, _bs, 3);
               }
            }
         }
      }

      if (0.0D < power) {
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:engine")), SoundSource.NEUTRAL, 4.0F, (float)(0.8D + power / 50.0D + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D)));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:engine")), SoundSource.NEUTRAL, 4.0F, (float)(0.8D + power / 50.0D + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D)), false);
            }
         }

         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("KineticPower", power);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }
      } else if (!world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _blockEntity = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128347_("KineticPower", 0.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

      if (0.0D < ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "FuelQue") && !world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _blockEntity = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128347_("FuelQue", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "FuelQue") - 1.0D);
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
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") >= 2.0D && world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + 0.5D, y + 1.1D, z + 0.5D, 1, 0.0D, 1.0D, 0.0D, 0.1D);
      }

   }
}

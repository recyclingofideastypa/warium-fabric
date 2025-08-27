package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.registries.ForgeRegistries;

public class FuelTankDamageTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (0 < ((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.m_274561_(x, y, z)))) {
         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + 0.5D, y + 0.5D, z + 0.5D, 1, 0.2D, 0.2D, 0.2D, 0.0D);
         }

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
         })).drainTankSimulate(world, BlockPos.m_274561_(x, y, z), 10);
         if (_ent != null) {
            _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
               capability.drain(_amount, FluidAction.EXECUTE);
            });
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "FuelType").equals("Kerosene")) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1.0F, (float)(2 - ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.m_274561_(x, y, z))) / 1000));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1.0F, (float)(2 - ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.m_274561_(x, y, z))) / 1000), false);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x + 0.5D, y + 0.5D, z + 0.5D, 4, 0.2D, 0.2D, 0.2D, 0.0D);
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.RISING_FLAME.get(), x + 0.5D, y + 0.5D, z + 0.5D, 1, 0.2D, 0.2D, 0.2D, 0.0D);
            }

            DamagesProcedure.execute(world, x + (double)Mth.m_216271_(RandomSource.m_216327_(), -1, 1), y + (double)Mth.m_216271_(RandomSource.m_216327_(), -1, 1), z + (double)Mth.m_216271_(RandomSource.m_216327_(), -1, 1));
         }
      }

   }
}

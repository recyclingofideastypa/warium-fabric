package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.world.ForgeChunkManager;
import net.minecraftforge.registries.ForgeRegistries;

public class TorpedoFlightTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.getPersistentData().m_128347_("Time", immediatesourceentity.getPersistentData().m_128459_("Time") + 1.0D);
         ServerLevel _world;
         if (immediatesourceentity.m_5842_()) {
            immediatesourceentity.m_20242_(true);
            if (immediatesourceentity.getPersistentData().m_128459_("Time") >= 20.0D) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), y + Mth.m_216263_(RandomSource.m_216327_(), 0.1D, 0.3D), z + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.swim")), SoundSource.NEUTRAL, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 0.9D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.swim")), SoundSource.NEUTRAL, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 0.9D), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  _world = (ServerLevel)world;
                  _world.m_8767_(ParticleTypes.f_123769_, x, y, z, 1, 0.1D, 0.1D, 0.1D, 0.01D);
               }

               if (world.m_8055_(BlockPos.m_274561_(x, y + 1.5D, z)).m_60734_() instanceof LiquidBlock) {
                  immediatesourceentity.m_20256_(new Vec3(immediatesourceentity.m_20154_().f_82479_ * -1.0D, 0.4D, immediatesourceentity.m_20154_().f_82481_));
               } else {
                  immediatesourceentity.m_20256_(new Vec3(immediatesourceentity.m_20154_().f_82479_ * -1.0D, -0.2D, immediatesourceentity.m_20154_().f_82481_));
               }
            }
         } else {
            immediatesourceentity.m_20242_(false);
         }

         if (immediatesourceentity.getPersistentData().m_128459_("Time") >= 400.0D) {
            TorpedoHitProcedure.execute(world, immediatesourceentity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45579_, true, true);
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).m_7697_().f_45579_, true, true);
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).m_7697_().f_45579_, true, true);
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).m_7697_().f_45579_, true, true);
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).m_7697_().f_45579_, true, true);
         }

         CrustyChunksMod.queueServerWork(40, () -> {
            ServerLevel _world;
            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45579_, false, true);
            }

            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).m_7697_().f_45579_, false, true);
            }

            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).m_7697_().f_45579_, false, true);
            }

            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).m_7697_().f_45579_, false, true);
            }

            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).m_7697_().f_45579_, false, true);
            }

         });
      }
   }
}

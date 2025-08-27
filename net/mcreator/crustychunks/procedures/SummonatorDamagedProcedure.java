package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModEntities;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonatorDamagedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double spawnx = 0.0D;
      double spawnz = 0.0D;
      if (world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.m_8767_(ParticleTypes.f_123796_, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.4D, 0.4D, 0.4D, 1.0D);
      }

      Level _level;
      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:golemmad")), SoundSource.NEUTRAL, 20.0F, 0.2F);
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:golemmad")), SoundSource.NEUTRAL, 20.0F, 0.2F, false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.NEUTRAL, 20.0F, 0.2F);
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.NEUTRAL, 20.0F, 0.2F, false);
         }
      }

      for(int index0 = 0; index0 < Mth.m_216271_(RandomSource.m_216327_(), 2, 4); ++index0) {
         spawnx = (double)Mth.m_216271_(RandomSource.m_216327_(), -10, 10);
         spawnz = (double)Mth.m_216271_(RandomSource.m_216327_(), -10, 10);
         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            Entity entityToSpawn = ((EntityType)CrustyChunksModEntities.STRIKER.get()).m_262496_(_level, BlockPos.m_274561_(spawnx + x, (double)(2 + world.m_6924_(Types.MOTION_BLOCKING, Mth.m_14107_(spawnx + x), Mth.m_14107_(spawnz + z))), spawnz + z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
            }
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), spawnx + x, (double)(2 + world.m_6924_(Types.MOTION_BLOCKING, Mth.m_14107_(spawnx + x), Mth.m_14107_(spawnz + z))), spawnz + z, 5, 0.25D, 0.25D, 0.25D, 0.25D);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_254849_((Entity)null, x, y, z, 3.0F, ExplosionInteraction.NONE);
         }
      }

      world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50016_.m_49966_(), 3);
   }
}

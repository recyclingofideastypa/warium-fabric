package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraftforge.registries.ForgeRegistries;

public class IncendiaryGrenadeHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_175827_, immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_(), 25, 0.0D, 0.0D, 0.0D, 0.02D);
         }

         CrustyChunksMod.queueServerWork(20, () -> {
            GasolineExplosionProcedure.execute(world, x + immediatesourceentity.m_20154_().f_82479_ * Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 2.5D), y + immediatesourceentity.m_20154_().f_82480_ * Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 2.5D), z - immediatesourceentity.m_20154_().f_82481_ * Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 2.5D));
            GasolineExplosionProcedure.execute(world, x + immediatesourceentity.m_20154_().f_82479_ * Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 2.5D), y + immediatesourceentity.m_20154_().f_82480_ * Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 2.5D), z - immediatesourceentity.m_20154_().f_82481_ * Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 2.5D));
            GasolineExplosionProcedure.execute(world, x + immediatesourceentity.m_20154_().f_82479_ * Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 2.5D), y + immediatesourceentity.m_20154_().f_82480_ * Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 2.5D), z - immediatesourceentity.m_20154_().f_82481_ * Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 2.5D));
            Level _level;
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 10.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 10.0F, 1.0F, false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.NEUTRAL, 40.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.NEUTRAL, 40.0F, 1.0F, false);
               }
            }

         });
      }
   }
}

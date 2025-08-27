package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class StealthPistolFireSoundProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Movementinnacuracy = 0.0D;
      double recoil = 0.0D;
      CrustyChunksMod.queueServerWork(1, () -> {
         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 8.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.2D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 8.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.2D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:silencedshot")), SoundSource.NEUTRAL, 5.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.0D, 1.2D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:silencedshot")), SoundSource.NEUTRAL, 5.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.0D, 1.2D), false);
            }
         }

      });
   }
}

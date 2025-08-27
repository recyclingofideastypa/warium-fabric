package net.mcreator.crustychunks.procedures;

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

public class ShotgunCasingDropProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof Level) {
         Level _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotguncasing")), SoundSource.NEUTRAL, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.2D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:shotguncasing")), SoundSource.NEUTRAL, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.2D), false);
         }
      }

   }
}

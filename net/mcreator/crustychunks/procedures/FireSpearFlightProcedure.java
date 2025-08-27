package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class FireSpearFlightProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         ForceChunksProcedure.execute(world, x, y, z);
         immediatesourceentity.getPersistentData().m_128347_("Time", immediatesourceentity.getPersistentData().m_128459_("Time") + 1.0D);
         if (immediatesourceentity.getPersistentData().m_128459_("Time") <= 70.0D) {
            for(int index0 = 0; index0 < 4; ++index0) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), y + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), z + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
            }

            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.TRACER.get(), x, y, z, immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_());
            if (immediatesourceentity.getPersistentData().m_128459_("Time") / 5.0D == (double)Math.round(immediatesourceentity.getPersistentData().m_128459_("Time") / 5.0D) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.4D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.4D), false);
               }
            }

            Vec3 motion = immediatesourceentity.m_20184_().m_82490_(1.01D);
            immediatesourceentity.m_20256_(motion);
         }

         if (immediatesourceentity.m_5842_()) {
            TankFireProjectileHitsBlockProcedure.execute(world, immediatesourceentity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

      }
   }
}

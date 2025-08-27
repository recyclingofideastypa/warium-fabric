package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SolidArtilleryTracerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         ForceChunksProcedure.execute(world, x, y, z);
         if (!immediatesourceentity.m_5842_()) {
            SimpleParticleType var10001 = (SimpleParticleType)CrustyChunksModParticleTypes.WHITE_TRACER.get();
            double var10005 = immediatesourceentity.m_20154_().f_82479_ * -1.0D;
            double var10006;
            Projectile _projEnt;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10006 = _projEnt.m_20184_().m_82553_();
            } else {
               var10006 = 0.0D;
            }

            var10005 *= var10006;
            var10006 = immediatesourceentity.m_20154_().f_82480_ * -1.0D;
            double var10007;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10007 = _projEnt.m_20184_().m_82553_();
            } else {
               var10007 = 0.0D;
            }

            var10006 *= var10007;
            var10007 = immediatesourceentity.m_20154_().f_82481_;
            double var10008;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10008 = _projEnt.m_20184_().m_82553_();
            } else {
               var10008 = 0.0D;
            }

            world.m_7106_(var10001, x, y, z, var10005, var10006, var10007 * var10008);
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, 0.0D, 0.0D, 0.0D);
         }

         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
         if (immediatesourceentity.getPersistentData().m_128459_("T") >= 20.0D && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch")), SoundSource.NEUTRAL, 4.0F, (float)(3.0D - immediatesourceentity.m_20154_().f_82480_ * 3.0D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch")), SoundSource.NEUTRAL, 4.0F, (float)(3.0D - immediatesourceentity.m_20154_().f_82480_ * 3.0D), false);
            }
         }

      }
   }
}

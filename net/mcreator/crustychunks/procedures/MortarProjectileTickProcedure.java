package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class MortarProjectileTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double RocketVelocity = 0.0D;
         if (immediatesourceentity.m_5842_()) {
            MortarHitProcedure.execute(world, immediatesourceentity);
         }

         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
         if (immediatesourceentity.getPersistentData().m_128459_("T") >= 20.0D && world instanceof Level) {
            Level _level = (Level)world;
            Projectile _projEnt;
            if (!_level.m_5776_()) {
               BlockPos var10002 = BlockPos.m_274561_(x, y, z);
               SoundEvent var10003 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch"));
               SoundSource var10004 = SoundSource.NEUTRAL;
               double var10007;
               if (immediatesourceentity instanceof Projectile) {
                  _projEnt = (Projectile)immediatesourceentity;
                  var10007 = _projEnt.m_20184_().m_82553_();
               } else {
                  var10007 = 0.0D;
               }

               _level.m_5594_((Player)null, var10002, var10003, var10004, 2.0F, (float)(3.0D + var10007 / -1.0D));
            } else {
               SoundEvent var12 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch"));
               SoundSource var10005 = SoundSource.NEUTRAL;
               double var10008;
               if (immediatesourceentity instanceof Projectile) {
                  _projEnt = (Projectile)immediatesourceentity;
                  var10008 = _projEnt.m_20184_().m_82553_();
               } else {
                  var10008 = 0.0D;
               }

               _level.m_7785_(x, y, z, var12, var10005, 2.0F, (float)(3.0D + var10008 / -1.0D), false);
            }
         }

      }
   }
}

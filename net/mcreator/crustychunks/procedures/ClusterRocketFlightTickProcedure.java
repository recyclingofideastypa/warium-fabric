package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.SmallBombProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ClusterRocketFlightTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean Trigger = false;
         ForceChunksProcedure.execute(world, x, y, z);
         immediatesourceentity.getPersistentData().m_128347_("Time", immediatesourceentity.getPersistentData().m_128459_("Time") + 1.0D);
         int index0;
         Vec3 motion;
         if (immediatesourceentity.getPersistentData().m_128459_("Time") <= 30.0D) {
            for(index0 = 0; index0 < 4; ++index0) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), y + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), z + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
            }

            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.TRACER.get(), x, y, z, immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_());
            if (immediatesourceentity.getPersistentData().m_128459_("Time") / 10.0D == (double)Math.round(immediatesourceentity.getPersistentData().m_128459_("Time") / 10.0D)) {
               Level _level;
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 15.0F, (float)(1.4D - immediatesourceentity.getPersistentData().m_128459_("Time") / 30.0D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 15.0F, (float)(1.4D - immediatesourceentity.getPersistentData().m_128459_("Time") / 30.0D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 40.0F, (float)(1.4D - immediatesourceentity.getPersistentData().m_128459_("Time") / 30.0D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 40.0F, (float)(1.4D - immediatesourceentity.getPersistentData().m_128459_("Time") / 30.0D), false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123747_, x, y, z, 1, 0.1D, 0.1D, 0.1D, 0.01D);
            }

            motion = immediatesourceentity.m_20184_().m_82490_(1.02D);
            immediatesourceentity.m_20256_(motion);
         } else {
            for(index0 = 0; index0 < 4; ++index0) {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new SmallBombProjectileEntity((EntityType)CrustyChunksModEntities.SMALL_BOMB_PROJECTILE.get(), level);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 5.0F, 1);
                  _entityToSpawn.m_6034_(x, y, z);
                  double var10001 = immediatesourceentity.m_20184_().m_7096_();
                  double var10002 = immediatesourceentity.m_20184_().m_7098_();
                  double var10003 = immediatesourceentity.m_20184_().m_7094_();
                  double var10004;
                  if (immediatesourceentity instanceof Projectile) {
                     Projectile _projEnt = (Projectile)immediatesourceentity;
                     var10004 = _projEnt.m_20184_().m_82553_();
                  } else {
                     var10004 = 0.0D;
                  }

                  _entityToSpawn.m_6686_(var10001, var10002, var10003, (float)var10004, 12.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            }

            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

         if (immediatesourceentity.m_5842_()) {
            ClusterRocketHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

         motion = new Vec3(x, y, z);
         List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(motion, motion)).m_82400_(1.25D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.m_20238_(motion);
         })).toList();
         Iterator var17 = _entfound.iterator();

         while(var17.hasNext()) {
            Entity entityiterator = (Entity)var17.next();
            if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:bullet")))) {
               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }

               Trigger = true;
            }
         }

         if (Trigger) {
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }

            CrustyChunksMod.queueServerWork(1, () -> {
               ClusterRocketHitProcedure.execute(world, x, y, z, immediatesourceentity);
            });
         }

      }
   }
}

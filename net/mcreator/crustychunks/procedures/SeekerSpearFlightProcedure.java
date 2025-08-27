package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SeekerSpearFlightProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean detonate = false;
         boolean Trigger = false;
         new Vec3(0.0D, 0.0D, 0.0D);
         double distancetotarget = 0.0D;
         double speed = 0.0D;
         double targetspeed = 0.0D;
         double leadvariable = 0.0D;
         double Limiter = 0.0D;
         double mx = 0.0D;
         double my = 0.0D;
         double mz = 0.0D;
         ForceChunksProcedure.execute(world, x, y, z);
         immediatesourceentity.getPersistentData().m_128347_("Time", immediatesourceentity.getPersistentData().m_128459_("Time") + 1.0D);
         Vec3 _center;
         if (immediatesourceentity.getPersistentData().m_128459_("Time") <= 130.0D) {
            for(int index0 = 0; index0 < 2; ++index0) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.ROCKET_SMOKE.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), y + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), z + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D));
            }

            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.TRACER.get(), x, y, z, immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_());
            if (immediatesourceentity.getPersistentData().m_128459_("Time") / 5.0D == (double)Math.round(immediatesourceentity.getPersistentData().m_128459_("Time") / 5.0D)) {
               Level _level;
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 10.0F, (float)(2.0D - immediatesourceentity.getPersistentData().m_128459_("Time") / 140.0D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 10.0F, (float)(2.0D - immediatesourceentity.getPersistentData().m_128459_("Time") / 140.0D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 25.0F, (float)(2.0D - immediatesourceentity.getPersistentData().m_128459_("Time") / 140.0D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 25.0F, (float)(2.0D - immediatesourceentity.getPersistentData().m_128459_("Time") / 140.0D), false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123747_, x, y, z, 1, 0.1D, 0.1D, 0.1D, 0.01D);
            }

            _center = immediatesourceentity.m_20184_().m_82490_(1.02D);
            immediatesourceentity.m_20256_(_center);
            immediatesourceentity.m_20242_(true);
         } else {
            TankFireProjectileHitsBlockProcedure.execute(world, immediatesourceentity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

         _center = new Vec3(x, y, z);
         List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(200.0D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.m_20238_(_center);
         })).toList();
         Iterator var29 = _entfound.iterator();

         while(true) {
            Entity entityiterator;
            do {
               if (!var29.hasNext()) {
                  if (immediatesourceentity.getPersistentData().m_128459_("Time") >= 10.0D && speed > 8.0D) {
                     immediatesourceentity.m_20256_(new Vec3(immediatesourceentity.m_20184_().m_7096_() * 0.9D, immediatesourceentity.m_20184_().m_7098_() * 0.9D, immediatesourceentity.m_20184_().m_7094_() * 0.9D));
                  }

                  _center = new Vec3(x, y, z);
                  _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(7.5D), (e) -> {
                     return true;
                  }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                     return _entcnd.m_20238_(_center);
                  })).toList();
                  var29 = _entfound.iterator();

                  while(var29.hasNext()) {
                     entityiterator = (Entity)var29.next();
                     if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:warm")))) {
                        detonate = true;
                        double var10001;
                        if (entityiterator instanceof Projectile) {
                           Projectile _projEnt = (Projectile)entityiterator;
                           var10001 = _projEnt.m_20184_().m_82553_();
                        } else {
                           var10001 = 0.0D;
                        }

                        if (0.0D < var10001 && !entityiterator.m_9236_().m_5776_()) {
                           entityiterator.m_146870_();
                        }
                     }
                  }

                  if (detonate) {
                     CrustyChunksMod.queueServerWork(2, () -> {
                        TankFireProjectileHitsBlockProcedure.execute(world, immediatesourceentity);
                        if (!immediatesourceentity.m_9236_().m_5776_()) {
                           immediatesourceentity.m_146870_();
                        }

                     });
                  }

                  if (immediatesourceentity.m_5842_()) {
                     TankFireProjectileHitsBlockProcedure.execute(world, immediatesourceentity);
                     if (!immediatesourceentity.m_9236_().m_5776_()) {
                        immediatesourceentity.m_146870_();
                     }
                  }

                  _center = new Vec3(x, y, z);
                  _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(1.0D), (e) -> {
                     return true;
                  }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                     return _entcnd.m_20238_(_center);
                  })).toList();
                  var29 = _entfound.iterator();

                  while(var29.hasNext()) {
                     entityiterator = (Entity)var29.next();
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
                        TankFireProjectileHitsBlockProcedure.execute(world, immediatesourceentity);
                     });
                  }

                  ForceChunksProcedure.execute(world, x, y, z);
                  return;
               }

               entityiterator = (Entity)var29.next();
            } while(!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:warm"))));

            if (0.0D == entityiterator.getPersistentData().m_128459_("Mx") && 0.0D == entityiterator.getPersistentData().m_128459_("My") && 0.0D == entityiterator.getPersistentData().m_128459_("Mz")) {
               mx = entityiterator.m_20184_().m_7096_();
               my = entityiterator.m_20184_().m_7098_();
               mz = entityiterator.m_20184_().m_7094_();
            } else {
               mx = entityiterator.getPersistentData().m_128459_("Mx");
               my = entityiterator.getPersistentData().m_128459_("My");
               mz = entityiterator.getPersistentData().m_128459_("Mz");
            }

            distancetotarget = Math.sqrt(Math.pow(Math.abs(entityiterator.m_20186_() - y), 2.0D) + Math.pow(Math.abs(entityiterator.m_20185_() - x), 2.0D) + Math.pow(Math.abs(entityiterator.m_20189_() - z), 2.0D));
            speed = Math.sqrt(Math.pow(Math.abs(immediatesourceentity.m_20184_().m_7096_()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.m_20184_().m_7098_()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.m_20184_().m_7094_()), 2.0D));
            Limiter = 0.03D * speed;
            leadvariable = 1.0D;
            leadvariable = leadvariable * distancetotarget / speed;
            if (Math.sqrt(Math.pow(entityiterator.m_20186_() - y, 2.0D) + Math.pow(entityiterator.m_20185_() - x, 2.0D) + Math.pow(entityiterator.m_20189_() - z, 2.0D)) - Math.sqrt(Math.pow(entityiterator.m_20186_() - (y + immediatesourceentity.m_20184_().m_7098_()), 2.0D) + Math.pow(entityiterator.m_20185_() - (x + immediatesourceentity.m_20184_().m_7096_()), 2.0D) + Math.pow(entityiterator.m_20189_() - (z + immediatesourceentity.m_20184_().m_7094_()), 2.0D)) > 1.5D && immediatesourceentity.getPersistentData().m_128459_("Time") >= 10.0D) {
               immediatesourceentity.m_20256_(new Vec3(Math.min(immediatesourceentity.m_20184_().m_7096_() + Limiter, Math.max((immediatesourceentity.m_20184_().m_7096_() * 7.0D + (entityiterator.m_20185_() + mx * leadvariable - x) * speed / distancetotarget) / 8.0D, immediatesourceentity.m_20184_().m_7096_() - Limiter)), Math.min(immediatesourceentity.m_20184_().m_7098_() + Limiter, Math.max((immediatesourceentity.m_20184_().m_7098_() * 7.0D + (entityiterator.m_20186_() + my * leadvariable - y) * speed / distancetotarget) / 8.0D, immediatesourceentity.m_20184_().m_7098_() - Limiter)), Math.min(immediatesourceentity.m_20184_().m_7094_() + Limiter, Math.max((immediatesourceentity.m_20184_().m_7094_() * 7.0D + (entityiterator.m_20189_() + mz * leadvariable - z) * speed / distancetotarget) / 8.0D, immediatesourceentity.m_20184_().m_7094_() - Limiter))));
            }
         }
      }
   }
}

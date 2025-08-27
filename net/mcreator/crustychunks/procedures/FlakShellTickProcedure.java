package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class FlakShellTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean trigger = false;
         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
         Projectile _projEnt;
         double var10000;
         if (immediatesourceentity instanceof Projectile) {
            _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.m_20184_().m_82553_();
         } else {
            var10000 = 0.0D;
         }

         if (var10000 >= 2.0D && !immediatesourceentity.m_20068_()) {
            immediatesourceentity.m_20256_(new Vec3(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_() + 0.01D, immediatesourceentity.m_20184_().m_7094_()));
         }

         world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.BULLET_TRAIL.get(), immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_(), 0.0D, 0.0D, 0.0D);
         if (immediatesourceentity.getPersistentData().m_128459_("T") > 60.0D) {
            trigger = true;
         }

         if (0.0D < immediatesourceentity.getPersistentData().m_128459_("Range")) {
            var10000 = immediatesourceentity.getPersistentData().m_128459_("T");
            double var10001 = immediatesourceentity.getPersistentData().m_128459_("Range");
            double var10002;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10002 = _projEnt.m_20184_().m_82553_();
            } else {
               var10002 = 0.0D;
            }

            if (var10000 >= var10001 / var10002) {
               trigger = true;
            }
         }

         if (immediatesourceentity.m_5842_()) {
            trigger = true;
         }

         Vec3 _center = new Vec3(x, y, z);
         List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(6.0D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.m_20238_(_center);
         })).toList();
         Iterator var11 = _entfound.iterator();

         while(true) {
            Entity entityiterator;
            do {
               do {
                  if (!var11.hasNext()) {
                     if (trigger) {
                        trigger = false;
                        CrustyChunksMod.queueServerWork(1, () -> {
                           SmallShellHitProcedure.execute(world, immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_(), immediatesourceentity);
                           if (!immediatesourceentity.m_9236_().m_5776_()) {
                              immediatesourceentity.m_146870_();
                           }

                        });
                     }

                     ForceChunksProcedure.execute(world, x, y, z);
                     return;
                  }

                  entityiterator = (Entity)var11.next();
               } while(!(immediatesourceentity.getPersistentData().m_128459_("T") >= 7.0D));
            } while(!(entityiterator instanceof LivingEntity) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:warm"))));

            trigger = true;
            if (entityiterator instanceof Projectile) {
               Projectile _projEnt = (Projectile)entityiterator;
               var10000 = _projEnt.m_20184_().m_82553_();
            } else {
               var10000 = 0.0D;
            }

            if (var10000 > 0.0D && !entityiterator.m_9236_().m_5776_()) {
               entityiterator.m_146870_();
            }
         }
      }
   }
}

package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class NukeBombTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean Trigger = false;
         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
         if (immediatesourceentity.m_5842_()) {
            NuclearBombHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
         }

         double var10000;
         if (immediatesourceentity instanceof Projectile) {
            Projectile _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.m_20184_().m_82553_();
         } else {
            var10000 = 0.0D;
         }

         if (var10000 >= 2.0D && immediatesourceentity.getPersistentData().m_128459_("T") > 25.0D && !immediatesourceentity.m_20068_()) {
            immediatesourceentity.m_20256_(new Vec3(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_() + 0.045D, immediatesourceentity.m_20184_().m_7094_()));
         }

         Vec3 _center = new Vec3(x, y, z);
         List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.75D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.m_20238_(_center);
         })).toList();
         Iterator var11 = _entfound.iterator();

         while(var11.hasNext()) {
            Entity entityiterator = (Entity)var11.next();
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
               LargeRocketHitProcedure.execute(world, x, y, z, immediatesourceentity);
            });
         }

      }
   }
}

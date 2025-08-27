package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Rad1TickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Vec3 _center = new Vec3(x + 0.5D, y + 0.5D, z + 0.5D);
      List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(5.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.m_20238_(_center);
      })).toList();
      Iterator var9 = _entfound.iterator();

      while(var9.hasNext()) {
         Entity entityiterator = (Entity)var9.next();
         if (5000.0D > entityiterator.getPersistentData().m_128459_("Radiation")) {
            entityiterator.getPersistentData().m_128347_("Radiation", entityiterator.getPersistentData().m_128459_("Radiation") + 1.0D);
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entityiterator;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.RADIATION.get(), 60, 1, false, false));
               }
            }
         }
      }

   }
}

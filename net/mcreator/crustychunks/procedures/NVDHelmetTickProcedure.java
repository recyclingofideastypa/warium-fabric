package net.mcreator.crustychunks.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class NVDHelmetTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().m_128459_("HelmetState") == 0.0D) {
            entity.getPersistentData().m_128347_("HelmetState", 1.0D);
         }

         if (entity.getPersistentData().m_128459_("HelmetState") == 1.0D) {
            entity.getPersistentData().m_128347_("HelmetState", 2.0D);
         } else if (entity.getPersistentData().m_128459_("HelmetState") == 2.0D) {
            entity.getPersistentData().m_128347_("HelmetState", 1.0D);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19611_, 4, 3, false, false));
            }
         }

      }
   }
}

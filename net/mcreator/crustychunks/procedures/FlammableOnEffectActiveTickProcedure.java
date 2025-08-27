package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class FlammableOnEffectActiveTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.m_20094_() > 0) {
            int var10001;
            label17: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)CrustyChunksModMobEffects.FLAMMABLE.get())) {
                     var10001 = _livEnt.m_21124_((MobEffect)CrustyChunksModMobEffects.FLAMMABLE.get()).m_19564_();
                     break label17;
                  }
               }

               var10001 = 0;
            }

            entity.m_20254_(var10001);
         }

      }
   }
}

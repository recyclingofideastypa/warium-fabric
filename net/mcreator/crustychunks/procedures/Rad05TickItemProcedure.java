package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class Rad05TickItemProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (Mth.m_216271_(RandomSource.m_216327_(), 1, 40) == 1) {
            entity.getPersistentData().m_128347_("Radiation", entity.getPersistentData().m_128459_("Radiation") + 0.5D * (double)itemstack.m_41613_());
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.RADIATION.get(), 60, 1, false, false));
               }
            }
         }

      }
   }
}

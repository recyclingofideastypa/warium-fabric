package net.mcreator.crustychunks.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.crustychunks.procedures.AISiegeTriggerProcedure;
import net.mcreator.crustychunks.procedures.ImpendingDoomActiveTickConditionProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class ImpendingDoomMobEffect extends MobEffect {
   public ImpendingDoomMobEffect() {
      super(MobEffectCategory.HARMFUL, -13434880);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      ImpendingDoomActiveTickConditionProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      AISiegeTriggerProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}

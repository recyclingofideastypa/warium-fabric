package net.mcreator.crustychunks.potion;

import java.util.function.Consumer;
import net.mcreator.crustychunks.procedures.PlayerRadiationDoseProcedure;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

public class RadiationMobEffect extends MobEffect {
   public RadiationMobEffect() {
      super(MobEffectCategory.HARMFUL, -16777216);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      PlayerRadiationDoseProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }

   public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
      consumer.accept(new IClientMobEffectExtensions() {
         public boolean isVisibleInInventory(MobEffectInstance effect) {
            return false;
         }

         public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
            return false;
         }

         public boolean isVisibleInGui(MobEffectInstance effect) {
            return false;
         }
      });
   }
}

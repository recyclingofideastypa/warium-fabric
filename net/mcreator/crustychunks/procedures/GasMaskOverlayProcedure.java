package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class GasMaskOverlayProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean value = false;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() != CrustyChunksModItems.GAS_MASK_HELMET.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != CrustyChunksModItems.GAS_MASK_HELMET_HELMET.get()) {
               value = false;
               return value;
            }
         }

         value = true;
         return value;
      }
   }
}

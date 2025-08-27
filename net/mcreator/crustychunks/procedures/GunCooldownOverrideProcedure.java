package net.mcreator.crustychunks.procedures;

import net.minecraft.world.item.ItemStack;

public class GunCooldownOverrideProcedure {
   public static void execute(ItemStack itemstack) {
      if (itemstack.m_41784_().m_128459_("C") > 0.0D) {
         itemstack.m_41784_().m_128347_("C", itemstack.m_41784_().m_128459_("C") - 1.0D);
      }

   }
}

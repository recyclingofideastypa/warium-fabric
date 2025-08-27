package net.mcreator.crustychunks.procedures;

import net.minecraft.world.item.ItemStack;

public class SMGDoubleFireProcedure {
   public static void execute(ItemStack itemstack) {
      if (itemstack.m_41784_().m_128459_("ShotQue") == 0.0D) {
         itemstack.m_41784_().m_128347_("ShotQue", 4.0D);
      }

   }
}

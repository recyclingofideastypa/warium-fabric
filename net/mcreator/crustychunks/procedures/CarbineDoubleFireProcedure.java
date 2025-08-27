package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CarbineDoubleFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.m_41784_().m_128459_("Firemode") == 0.0D) {
            MCFireScriptProcedure.execute(world, x, y, z, entity, itemstack);
            itemstack.m_41784_().m_128347_("ShotQue", 0.0D);
         } else if (itemstack.m_41784_().m_128459_("Firemode") == 1.0D && itemstack.m_41784_().m_128459_("ShotQue") == 0.0D) {
            itemstack.m_41784_().m_128347_("ShotQue", 4.0D);
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class BurstRifleDoubleFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.m_41784_().m_128459_("Firemode") == 0.0D) {
            BurstRifleFireScriptProcedure.execute(world, x, y, z, entity, itemstack);
            itemstack.m_41784_().m_128347_("ShotQue", 0.0D);
         } else if (itemstack.m_41784_().m_128459_("Firemode") == 1.0D) {
            if (itemstack.m_41784_().m_128459_("ShotQue") == 0.0D) {
               itemstack.m_41784_().m_128347_("ShotQue", 3.0D);
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_36335_().m_41524_(itemstack.m_41720_(), 10);
            }
         }

      }
   }
}

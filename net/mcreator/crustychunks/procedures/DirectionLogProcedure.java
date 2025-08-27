package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.minecraft.world.item.ItemStack;

public class DirectionLogProcedure {
   public static String execute(ItemStack itemstack) {
      String WeaponAttatched = "";
      String ATGMMode = "";
      String Mode = "";
      if (itemstack.m_41784_().m_128459_("POSX") == 0.0D && itemstack.m_41784_().m_128459_("POSY") == 0.0D && itemstack.m_41784_().m_128459_("POSZ") == 0.0D) {
         WeaponAttatched = " ";
      } else {
         WeaponAttatched = "§3Weapon Attached";
      }

      if (itemstack.m_41784_().m_128471_("Mode")) {
         Mode = "§9Mouse-Aim Mode";
         ATGMMode = " ";
      } else {
         if (itemstack.m_41784_().m_128471_("ATGMMode")) {
            ATGMMode = "§4ATGM Guidance Mode";
         } else {
            ATGMMode = " ";
         }

         Mode = " ";
      }

      String var10000 = (new DecimalFormat("####")).format(itemstack.m_41784_().m_128459_("Pitch"));
      return "§8Pitch: §6" + var10000 + "§8Yaw:§6" + (new DecimalFormat("####")).format(itemstack.m_41784_().m_128459_("Yaw")) + WeaponAttatched + Mode + ATGMMode + "§7 Shift-Click on an Aimer Node while the item is in your off hand for linking.§7 Press the (Fire Select) Keybind to switch modes. Seat mode toggle in Main Hand, ATGM mode toggle in Off Hand.";
   }
}

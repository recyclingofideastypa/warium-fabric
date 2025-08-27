package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.client.gui.ABGuiScreen;
import net.mcreator.crustychunks.client.gui.BlastFurnaceGUIScreen;
import net.mcreator.crustychunks.client.gui.BreederReactorControlGUIScreen;
import net.mcreator.crustychunks.client.gui.ConveyorGUIScreen;
import net.mcreator.crustychunks.client.gui.EnergyDisplayScreen;
import net.mcreator.crustychunks.client.gui.FireboxGUIScreen;
import net.mcreator.crustychunks.client.gui.FissionBombGUIScreen;
import net.mcreator.crustychunks.client.gui.FissionWarheadGUIScreen;
import net.mcreator.crustychunks.client.gui.FoundryGUIScreen;
import net.mcreator.crustychunks.client.gui.FusionBombGUIScreen;
import net.mcreator.crustychunks.client.gui.MineralGrinderGUIScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class CrustyChunksModScreens {
   @SubscribeEvent
   public static void clientLoad(FMLClientSetupEvent event) {
      event.enqueueWork(() -> {
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.BLAST_FURNACE_GUI.get(), BlastFurnaceGUIScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.CONVEYOR_GUI.get(), ConveyorGUIScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.FOUNDRY_GUI.get(), FoundryGUIScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.FIREBOX_GUI.get(), FireboxGUIScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.MINERAL_GRINDER_GUI.get(), MineralGrinderGUIScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.FISSION_BOMB_GUI.get(), FissionBombGUIScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.BREEDER_REACTOR_CONTROL_GUI.get(), BreederReactorControlGUIScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.FISSION_WARHEAD_GUI.get(), FissionWarheadGUIScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.ENERGY_DISPLAY.get(), EnergyDisplayScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.AB_GUI.get(), ABGuiScreen::new);
         MenuScreens.m_96206_((MenuType)CrustyChunksModMenus.FUSION_BOMB_GUI.get(), FusionBombGUIScreen::new);
      });
   }
}

package net.mcreator.crustychunks.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.network.MineralGrinderGUIButtonMessage;
import net.mcreator.crustychunks.world.inventory.MineralGrinderGUIMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MineralGrinderGUIScreen extends AbstractContainerScreen<MineralGrinderGUIMenu> {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   Button button_process;
   private static final ResourceLocation texture;

   public MineralGrinderGUIScreen(MineralGrinderGUIMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 172;
      this.f_97727_ = 166;
   }

   public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.m_280273_(guiGraphics);
      super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      this.m_280072_(guiGraphics, mouseX, mouseY);
   }

   protected void m_7286_(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.m_280163_(texture, this.f_97735_, this.f_97736_, 0.0F, 0.0F, this.f_97726_, this.f_97727_, this.f_97726_, this.f_97727_);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/graydust.png"), this.f_97735_ + 77, this.f_97736_ + 53, 0.0F, 0.0F, 16, 16, 16, 16);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/graydust.png"), this.f_97735_ + 104, this.f_97736_ + 53, 0.0F, 0.0F, 16, 16, 16, 16);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/rawgray.png"), this.f_97735_ + 77, this.f_97736_ + 8, 0.0F, 0.0F, 16, 16, 16, 16);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/graygear.png"), this.f_97735_ + 41, this.f_97736_ + 26, 0.0F, 0.0F, 16, 16, 16, 16);
      RenderSystem.disableBlend();
   }

   public boolean m_7933_(int key, int b, int c) {
      if (key == 256) {
         this.f_96541_.f_91074_.m_6915_();
         return true;
      } else {
         return super.m_7933_(key, b, c);
      }
   }

   protected void m_280003_(GuiGraphics guiGraphics, int mouseX, int mouseY) {
   }

   public void m_7856_() {
      super.m_7856_();
      this.button_process = Button.m_253074_(Component.m_237115_("gui.crusty_chunks.mineral_grinder_gui.button_process"), (e) -> {
         CrustyChunksMod.PACKET_HANDLER.sendToServer(new MineralGrinderGUIButtonMessage(0, this.x, this.y, this.z));
         MineralGrinderGUIButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
      }).m_252987_(this.f_97735_ + 102, this.f_97736_ + 7, 61, 20).m_253136_();
      guistate.put("button:button_process", this.button_process);
      this.m_142416_(this.button_process);
   }

   static {
      guistate = MineralGrinderGUIMenu.guistate;
      texture = new ResourceLocation("crusty_chunks:textures/screens/mineral_grinder_gui.png");
   }
}

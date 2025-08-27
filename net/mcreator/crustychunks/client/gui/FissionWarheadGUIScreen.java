package net.mcreator.crustychunks.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.crustychunks.world.inventory.FissionWarheadGUIMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class FissionWarheadGUIScreen extends AbstractContainerScreen<FissionWarheadGUIMenu> {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final ResourceLocation texture;

   public FissionWarheadGUIScreen(FissionWarheadGUIMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 176;
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
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/coregray.png"), this.f_97735_ + 79, this.f_97736_ + 35, 0.0F, 0.0F, 16, 16, 16, 16);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/implosiongray.png"), this.f_97735_ + 79, this.f_97736_ + 8, 0.0F, 0.0F, 16, 16, 16, 16);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/implosiongray.png"), this.f_97735_ + 106, this.f_97736_ + 17, 0.0F, 0.0F, 16, 16, 16, 16);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/implosiongray.png"), this.f_97735_ + 52, this.f_97736_ + 17, 0.0F, 0.0F, 16, 16, 16, 16);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/implosiongray.png"), this.f_97735_ + 52, this.f_97736_ + 53, 0.0F, 0.0F, 16, 16, 16, 16);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/implosiongray.png"), this.f_97735_ + 79, this.f_97736_ + 62, 0.0F, 0.0F, 16, 16, 16, 16);
      guiGraphics.m_280163_(new ResourceLocation("crusty_chunks:textures/screens/implosiongray.png"), this.f_97735_ + 106, this.f_97736_ + 53, 0.0F, 0.0F, 16, 16, 16, 16);
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
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.crusty_chunks.fission_warhead_gui.label_fission_bomb"), 6, 7, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
   }

   static {
      guistate = FissionWarheadGUIMenu.guistate;
      texture = new ResourceLocation("crusty_chunks:textures/screens/fission_warhead_gui.png");
   }
}

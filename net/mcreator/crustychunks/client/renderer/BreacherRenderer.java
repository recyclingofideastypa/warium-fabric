package net.mcreator.crustychunks.client.renderer;

import net.mcreator.crustychunks.client.model.ModelBomber;
import net.mcreator.crustychunks.entity.BreacherEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class BreacherRenderer extends MobRenderer<BreacherEntity, ModelBomber<BreacherEntity>> {
   public BreacherRenderer(Context context) {
      super(context, new ModelBomber(context.m_174023_(ModelBomber.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(BreacherEntity entity) {
      return new ResourceLocation("crusty_chunks:textures/entities/breacher.png");
   }
}

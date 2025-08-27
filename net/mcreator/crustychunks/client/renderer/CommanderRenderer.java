package net.mcreator.crustychunks.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.crustychunks.client.model.Modelcommander;
import net.mcreator.crustychunks.entity.CommanderEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class CommanderRenderer extends MobRenderer<CommanderEntity, Modelcommander<CommanderEntity>> {
   public CommanderRenderer(Context context) {
      super(context, new Modelcommander(context.m_174023_(Modelcommander.LAYER_LOCATION)), 0.5F);
      this.m_115326_(new RenderLayer<CommanderEntity, Modelcommander<CommanderEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("crusty_chunks:textures/entities/commanderglow.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CommanderEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110488_(this.LAYER_TEXTURE));
            ((Modelcommander)this.m_117386_()).m_7695_(poseStack, vertexConsumer, light, LivingEntityRenderer.m_115338_(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   public ResourceLocation getTextureLocation(CommanderEntity entity) {
      return new ResourceLocation("crusty_chunks:textures/entities/commander.png");
   }
}

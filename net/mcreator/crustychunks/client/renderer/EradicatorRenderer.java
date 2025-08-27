package net.mcreator.crustychunks.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.crustychunks.entity.EradicatorEntity;
import net.mcreator.crustychunks.entity.layer.EradicatorLayer;
import net.mcreator.crustychunks.entity.model.EradicatorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EradicatorRenderer extends GeoEntityRenderer<EradicatorEntity> {
   public EradicatorRenderer(Context renderManager) {
      super(renderManager, new EradicatorModel());
      this.f_114477_ = 0.5F;
      this.addRenderLayer(new EradicatorLayer(this));
   }

   public RenderType getRenderType(EradicatorEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, EradicatorEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      float scale = 1.5F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(EradicatorEntity entityLivingBaseIn) {
      return 0.0F;
   }
}

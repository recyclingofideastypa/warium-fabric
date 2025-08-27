package net.mcreator.crustychunks.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ModelIRGuidedRocket<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_ir_guided_rocket"), "main");
   public final ModelPart Missile;
   public final ModelPart Core;
   public final ModelPart Fins;
   public final ModelPart Warhead;

   public ModelIRGuidedRocket(ModelPart root) {
      this.Missile = root.m_171324_("Missile");
      this.Core = this.Missile.m_171324_("Core");
      this.Fins = this.Missile.m_171324_("Fins");
      this.Warhead = this.Missile.m_171324_("Warhead");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Missile = partdefinition.m_171599_("Missile", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 16.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
      Missile.m_171599_("Core", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -12.0F, -5.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(24, 53).m_171488_(0.0F, -14.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(56, 0).m_171488_(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-1.0F, 6.0F, -3.0F));
      Missile.m_171599_("Fins", CubeListBuilder.m_171558_().m_171514_(40, 12).m_171488_(-7.0F, 2.0F, -2.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(40, 60).m_171488_(-9.0F, 7.0F, 1.0F, 4.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(40, 60).m_171488_(3.0F, 7.0F, 1.0F, 4.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(62, 56).m_171488_(-2.0F, 12.0F, 1.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(62, 56).m_171488_(-2.0F, 0.0F, 1.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(1.0F, -8.0F, 10.0F));
      Missile.m_171599_("Warhead", CubeListBuilder.m_171558_().m_171514_(2, 67).m_171488_(-10.0F, -9.0F, 2.0F, 12.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(2, 102).m_171488_(-8.0F, -7.0F, 0.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(4.0F, 3.0F, -24.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Missile.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}

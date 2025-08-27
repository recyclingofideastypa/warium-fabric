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

public class ModelTorpedo_Converted<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_torpedo_converted"), "main");
   public final ModelPart Thruster;
   public final ModelPart Warhead;
   public final ModelPart Core;

   public ModelTorpedo_Converted(ModelPart root) {
      this.Thruster = root.m_171324_("Thruster");
      this.Warhead = root.m_171324_("Warhead");
      this.Core = root.m_171324_("Core");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("Thruster", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171488_(-12.0F, -6.0F, 4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(20, 58).m_171488_(-9.0F, -6.0F, 2.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(36, 43).m_171488_(-14.0F, -16.0F, 2.0F, 12.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(36, 0).m_171488_(-14.0F, -6.0F, 7.0F, 12.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(8.0F, 24.0F, -8.0F));
      partdefinition.m_171599_("Warhead", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(-14.0F, -47.0F, 2.0F, 12.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(64, 16).m_171488_(-11.0F, -48.0F, 5.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(8.0F, 24.0F, -8.0F));
      partdefinition.m_171599_("Core", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-14.0F, -32.0F, 2.0F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(36, 12).m_171488_(-11.0F, -29.0F, 0.0F, 6.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(64, 0).m_171488_(-16.0F, -29.0F, 5.0F, 16.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(8.0F, 24.0F, -8.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Thruster.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Warhead.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Core.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}

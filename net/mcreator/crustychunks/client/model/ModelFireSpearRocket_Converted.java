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

public class ModelFireSpearRocket_Converted<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_fire_spear_rocket_converted"), "main");
   public final ModelPart Rocket;
   public final ModelPart fins;

   public ModelFireSpearRocket_Converted(ModelPart root) {
      this.Rocket = root.m_171324_("Rocket");
      this.fins = this.Rocket.m_171324_("fins");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Rocket = partdefinition.m_171599_("Rocket", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 16.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
      Rocket.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 69).m_171488_(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(58, 56).m_171488_(-2.5F, -2.5F, 7.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(0, 48).m_171488_(-2.5F, -2.5F, 29.0F, 5.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 44.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, -23.0F, 0.0F, 0.0F, 0.7854F));
      Rocket.m_171599_("fins", CubeListBuilder.m_171558_().m_171514_(42, 48).m_171488_(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(42, 56).m_171488_(0.0F, -8.0F, 0.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(42, 80).m_171488_(0.0F, -8.0F, -32.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(41, 80).m_171488_(-8.0F, 0.0F, -32.0F, 16.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 16.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Rocket.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}

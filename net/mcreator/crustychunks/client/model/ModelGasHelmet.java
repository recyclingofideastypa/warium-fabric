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

public class ModelGasHelmet<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_gas_helmet"), "main");
   public final ModelPart group;

   public ModelGasHelmet(ModelPart root) {
      this.group = root.m_171324_("group");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition group = partdefinition.m_171599_("group", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(-3.0F, -3.0F, -4.0F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.6F)).m_171514_(0, 16).m_171488_(-4.0F, -6.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.51F)).m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.7F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      group.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -5.2426F, -3.8284F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)).m_171514_(22, 28).m_171488_(-1.0F, -5.2426F, -3.4142F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.group.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}

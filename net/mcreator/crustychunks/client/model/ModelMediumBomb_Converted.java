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

public class ModelMediumBomb_Converted<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_medium_bomb_converted"), "main");
   public final ModelPart bone;

   public ModelMediumBomb_Converted(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 6).m_171488_(-13.0F, -17.0F, 3.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(36, 40).m_171488_(-11.0F, -9.0F, 5.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(68, 11).m_171480_().m_171488_(-8.5F, -9.0F, 0.0F, 1.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(31, 58).m_171488_(-11.0F, -18.0F, 5.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(8.0F, 24.0F, -8.0F));
      bone.m_171599_("Fin_r1", CubeListBuilder.m_171558_().m_171514_(0, 40).m_171488_(-1.0F, -10.0F, -8.0F, 2.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(48, 0).m_171488_(-8.0F, -10.0F, -1.0F, 16.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-8.0F, 0.0F, 8.0F, 0.0F, -0.7854F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}

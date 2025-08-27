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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelBomber<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_bomber"), "main");
   public final ModelPart LegFL;
   public final ModelPart LegFR;
   public final ModelPart LegBR;
   public final ModelPart LegBL;
   public final ModelPart bb_main;

   public ModelBomber(ModelPart root) {
      this.LegFL = root.m_171324_("LegFL");
      this.LegFR = root.m_171324_("LegFR");
      this.LegBR = root.m_171324_("LegBR");
      this.LegBL = root.m_171324_("LegBL");
      this.bb_main = root.m_171324_("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition LegFL = partdefinition.m_171599_("LegFL", CubeListBuilder.m_171558_(), PartPose.m_171419_(7.0F, 10.0F, -10.0F));
      LegFL.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 65).m_171488_(-1.5F, -6.0F, -5.5F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(44, 30).m_171488_(-1.0F, -5.0F, -5.0F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 7.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition LegFR = partdefinition.m_171599_("LegFR", CubeListBuilder.m_171558_(), PartPose.m_171419_(-7.0F, 10.0F, -10.0F));
      LegFR.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 65).m_171488_(-1.5F, -6.0F, -5.5F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(44, 30).m_171488_(-1.0F, -5.0F, -5.0F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 7.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition LegBR = partdefinition.m_171599_("LegBR", CubeListBuilder.m_171558_(), PartPose.m_171419_(-7.0F, 10.0F, 8.0F));
      LegBR.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 65).m_171488_(-1.5F, -6.0F, -5.5F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(44, 30).m_171488_(-1.0F, -5.0F, -5.0F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 7.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition LegBL = partdefinition.m_171599_("LegBL", CubeListBuilder.m_171558_(), PartPose.m_171419_(7.0F, 10.0F, 8.0F));
      LegBL.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(44, 30).m_171488_(-1.0F, -5.0F, -5.0F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(0, 65).m_171488_(-1.5F, -6.0F, -5.5F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 7.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
      partdefinition.m_171599_("bb_main", CubeListBuilder.m_171558_().m_171514_(0, 53).m_171488_(-6.0F, -15.0F, -11.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).m_171514_(1, 0).m_171488_(-4.0F, -17.0F, -12.0F, 8.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)).m_171514_(0, 30).m_171488_(-3.0F, -16.0F, -13.0F, 6.0F, 7.0F, 16.0F, new CubeDeformation(-0.25F)).m_171514_(0, 59).m_171488_(-6.0F, -15.0F, 7.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).m_171514_(44, 0).m_171488_(-3.0F, -23.0F, -9.0F, 6.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.LegFL.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LegFR.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LegBR.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LegBL.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bb_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.LegBR.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.LegFR.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LegBL.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LegFL.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}

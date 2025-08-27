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

public class ModelReaper<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_reaper"), "main");
   public final ModelPart Reaper;
   public final ModelPart Engine;
   public final ModelPart LeftWing;
   public final ModelPart RightWing;
   public final ModelPart LeftTail;
   public final ModelPart RightTail;

   public ModelReaper(ModelPart root) {
      this.Reaper = root.m_171324_("Reaper");
      this.Engine = this.Reaper.m_171324_("Engine");
      this.LeftWing = this.Reaper.m_171324_("LeftWing");
      this.RightWing = this.Reaper.m_171324_("RightWing");
      this.LeftTail = this.Reaper.m_171324_("LeftTail");
      this.RightTail = this.Reaper.m_171324_("RightTail");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Reaper = partdefinition.m_171599_("Reaper", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-6.0F, -12.0F, -39.0F, 12.0F, 12.0F, 72.0F, new CubeDeformation(0.0F)).m_171514_(72, 157).m_171488_(-4.5F, -12.5F, 33.0F, 9.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(0, 110).m_171488_(-10.5F, -11.75F, -18.0F, 21.0F, 11.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      Reaper.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(114, 110).m_171488_(-47.8355F, -1.225F, -12.1105F, 48.0F, 2.0F, 12.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-10.5F, -6.0F, 18.0F, 0.0F, -0.6981F, 0.0F));
      Reaper.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(114, 110).m_171480_().m_171488_(0.1645F, -1.225F, -12.1105F, 48.0F, 2.0F, 12.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(10.5F, -6.0F, 18.0F, 0.0F, 0.6981F, 0.0F));
      Reaper.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 157).m_171488_(-6.0F, 0.0F, -24.0F, 12.0F, 12.0F, 24.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -12.0F, -39.0F, 0.1745F, 0.0F, 0.0F));
      Reaper.m_171599_("Engine", CubeListBuilder.m_171558_().m_171514_(114, 124).m_171488_(-5.0F, -20.0F, 16.0F, 10.0F, 10.0F, 32.0F, new CubeDeformation(-0.25F)).m_171514_(142, 166).m_171488_(-4.0F, -19.0F, 47.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition LeftWing = Reaper.m_171599_("LeftWing", CubeListBuilder.m_171558_(), PartPose.m_171419_(10.5F, -6.0F, 6.0F));
      LeftWing.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 84).m_171480_().m_171488_(0.0F, -1.25F, -24.0F, 72.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));
      PartDefinition RightWing = Reaper.m_171599_("RightWing", CubeListBuilder.m_171558_(), PartPose.m_171419_(-10.5F, -6.0F, 6.0F));
      RightWing.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 84).m_171488_(-72.0F, -1.25F, -24.0F, 72.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));
      PartDefinition LeftTail = Reaper.m_171599_("LeftTail", CubeListBuilder.m_171558_(), PartPose.m_171423_(3.75F, -12.0F, 33.75F, 0.0F, 0.0F, 0.7854F));
      LeftTail.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(114, 166).m_171488_(-1.25F, -24.0F, -0.75F, 2.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
      PartDefinition RightTail = Reaper.m_171599_("RightTail", CubeListBuilder.m_171558_(), PartPose.m_171423_(-3.75F, -12.0F, 33.75F, 0.0F, 0.0F, -0.7854F));
      RightTail.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(114, 166).m_171480_().m_171488_(-1.25F, -24.0F, -0.75F, 2.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 256, 256);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Reaper.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.Reaper.f_104204_ = netHeadYaw / 57.295776F;
      this.Reaper.f_104203_ = headPitch / 57.295776F;
   }
}

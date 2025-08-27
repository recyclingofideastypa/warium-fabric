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

public class Modelcommander<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "modelcommander"), "main");
   public final ModelPart Commander;
   public final ModelPart RightArm;
   public final ModelPart Barrel;
   public final ModelPart LeftLeg;
   public final ModelPart LeftFoot;
   public final ModelPart Rightleg;
   public final ModelPart RightFoot;
   public final ModelPart Torso;
   public final ModelPart LeftArm;

   public Modelcommander(ModelPart root) {
      this.Commander = root.m_171324_("Commander");
      this.RightArm = this.Commander.m_171324_("RightArm");
      this.Barrel = this.RightArm.m_171324_("Barrel");
      this.LeftLeg = this.Commander.m_171324_("LeftLeg");
      this.LeftFoot = this.LeftLeg.m_171324_("LeftFoot");
      this.Rightleg = this.Commander.m_171324_("Rightleg");
      this.RightFoot = this.Rightleg.m_171324_("RightFoot");
      this.Torso = this.Commander.m_171324_("Torso");
      this.LeftArm = this.Commander.m_171324_("LeftArm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Commander = partdefinition.m_171599_("Commander", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, -3.0F));
      PartDefinition RightArm = Commander.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.0F, -1.0F, -9.0F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -8.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-5.0F, 0.0F, 5.0F));
      PartDefinition Barrel = RightArm.m_171599_("Barrel", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 1.0F, -15.0F));
      Barrel.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(16, 20).m_171488_(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, -1.0F, 2.0F, 0.0F, 0.0F, -0.829F));
      Barrel.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(15, 19).m_171488_(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.829F));
      PartDefinition LeftLeg = Commander.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(31, 19).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(4.0F, 9.0F, 5.0F));
      LeftLeg.m_171599_("LeftFoot", CubeListBuilder.m_171558_().m_171514_(4, 4).m_171488_(-0.5F, 1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(2, 31).m_171480_().m_171488_(-1.0F, 5.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition Rightleg = Commander.m_171599_("Rightleg", CubeListBuilder.m_171558_().m_171514_(31, 19).m_171488_(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-4.0F, 9.0F, 5.0F));
      Rightleg.m_171599_("RightFoot", CubeListBuilder.m_171558_().m_171514_(4, 4).m_171488_(-0.5F, 1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(2, 31).m_171488_(-1.0F, 5.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition Torso = Commander.m_171599_("Torso", CubeListBuilder.m_171558_().m_171514_(20, 0).m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(36, 0).m_171488_(-3.0F, -11.0F, -2.0F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(15, 15).m_171488_(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(15, 15).m_171488_(-4.0F, -10.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(28, 32).m_171488_(-3.0F, -13.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.m_171419_(0.0F, 9.0F, 5.0F));
      Torso.m_171599_("Antenna_r1", CubeListBuilder.m_171558_().m_171514_(48, 33).m_171488_(3.0F, -8.0F, -1.0F, 0.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(48, 33).m_171488_(-3.0F, -8.0F, -1.0F, 0.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -12.0F, 1.0F, -0.4363F, 0.0F, 0.0F));
      Commander.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(12, 33).m_171488_(-1.0F, -2.0F, -8.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(16, 32).m_171488_(-0.5F, -1.0F, -12.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 15).m_171488_(-0.5F, -1.0F, -9.0F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0F, 0.0F, 5.0F, 0.7854F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Commander.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.f_104204_ = headPitch / 57.295776F;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.Rightleg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.Commander.f_104204_ = netHeadYaw / 57.295776F;
   }
}

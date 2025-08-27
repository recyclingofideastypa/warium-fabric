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

public class ModelFusionBomb<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_fusion_bomb"), "main");
   public final ModelPart bone;
   public final ModelPart Core;
   public final ModelPart CoreAddition;
   public final ModelPart Fins;
   public final ModelPart bb_main;

   public ModelFusionBomb(ModelPart root) {
      this.bone = root.m_171324_("bone");
      this.Core = this.bone.m_171324_("Core");
      this.CoreAddition = this.bone.m_171324_("CoreAddition");
      this.Fins = this.bone.m_171324_("Fins");
      this.bb_main = root.m_171324_("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 24.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
      bone.m_171599_("Core", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -12.0F, -5.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(24, 53).m_171488_(0.0F, -14.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(56, 0).m_171488_(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-1.0F, -2.0F, -3.0F));
      PartDefinition CoreAddition = bone.m_171599_("CoreAddition", CubeListBuilder.m_171558_(), PartPose.m_171419_(6.0F, -2.0F, -24.0F));
      bone.m_171599_("Fins", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(-7.0F, 2.0F, -2.0F, 12.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)).m_171514_(0, 53).m_171488_(-5.0F, 4.0F, 10.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(50, 28).m_171488_(-11.0F, 7.0F, 0.0F, 4.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(50, 28).m_171488_(5.0F, 7.0F, 0.0F, 4.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(50, 44).m_171488_(-2.0F, 14.0F, 0.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(50, 44).m_171488_(-2.0F, -2.0F, 0.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(1.0F, -16.0F, 10.0F));
      PartDefinition bb_main = partdefinition.m_171599_("bb_main", CubeListBuilder.m_171558_().m_171514_(0, 65).m_171488_(-9.0F, -24.0F, -9.0F, 18.0F, 16.0F, 18.0F, new CubeDeformation(0.0F)).m_171514_(54, 81).m_171488_(-9.0F, -40.0F, -9.0F, 18.0F, 16.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bb_main.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(76, 26).m_171488_(-6.0F, -3.0F, -16.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(76, 0).m_171488_(-9.0F, -6.0F, -14.0F, 12.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.0F, -40.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bb_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}

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

public class ModelFissionBomb<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_fission_bomb"), "main");
   public final ModelPart FissionBomb;
   public final ModelPart CoreAddition;
   public final ModelPart Warhead;
   public final ModelPart Fins;
   public final ModelPart Core;

   public ModelFissionBomb(ModelPart root) {
      this.FissionBomb = root.m_171324_("FissionBomb");
      this.CoreAddition = this.FissionBomb.m_171324_("CoreAddition");
      this.Warhead = this.FissionBomb.m_171324_("Warhead");
      this.Fins = this.FissionBomb.m_171324_("Fins");
      this.Core = this.FissionBomb.m_171324_("Core");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition FissionBomb = partdefinition.m_171599_("FissionBomb", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 24.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
      FissionBomb.m_171599_("CoreAddition", CubeListBuilder.m_171558_().m_171514_(58, 65).m_171488_(-12.0F, -12.0F, 0.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(6.0F, -2.0F, -24.0F));
      FissionBomb.m_171599_("Warhead", CubeListBuilder.m_171558_().m_171514_(2, 67).m_171488_(-9.0F, -9.0F, 2.0F, 12.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(2, 93).m_171488_(-6.0F, -6.0F, 0.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(3.0F, -5.0F, -40.0F));
      PartDefinition Fins = FissionBomb.m_171599_("Fins", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(-7.0F, 2.0F, -2.0F, 12.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)).m_171514_(0, 53).m_171488_(-5.0F, 4.0F, 10.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(1.0F, -16.0F, 10.0F));
      Fins.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(44, 42).m_171488_(-5.0F, 1.0F, 4.0F, 10.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 8.0F, 14.0F, -1.5708F, 0.0F, 1.5708F));
      Fins.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(44, 42).m_171488_(-5.0F, 1.0F, 4.0F, 10.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 8.0F, 14.0F, -1.5708F, 0.0F, -1.5708F));
      Fins.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(44, 42).m_171488_(-5.0F, 1.0F, 4.0F, 10.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 8.0F, 13.0F, -1.5708F, 0.0F, 3.1416F));
      Fins.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(44, 42).m_171488_(-5.0F, 1.0F, 4.0F, 10.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 8.0F, 13.0F, -1.5708F, 0.0F, 0.0F));
      FissionBomb.m_171599_("Core", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -12.0F, -5.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(24, 53).m_171488_(0.0F, -14.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(56, 0).m_171488_(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-1.0F, -2.0F, -3.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.FissionBomb.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}

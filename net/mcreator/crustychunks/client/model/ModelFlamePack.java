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

public class ModelFlamePack<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_flame_pack"), "main");
   public final ModelPart Pack;
   public final ModelPart bone;
   public final ModelPart bone2;

   public ModelFlamePack(ModelPart root) {
      this.Pack = root.m_171324_("Pack");
      this.bone = root.m_171324_("bone");
      this.bone2 = root.m_171324_("bone2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("Pack", CubeListBuilder.m_171558_().m_171514_(12, 10).m_171488_(-4.0F, 1.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.4F)).m_171514_(12, 10).m_171488_(-4.0F, 5.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.4F)).m_171514_(0, 0).m_171488_(0.0F, 0.0F, 2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.3F)).m_171514_(0, 0).m_171488_(-4.0F, 0.0F, 2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.m_171419_(0.0F, 15.0F, 0.0F));
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      PartDefinition bone2 = partdefinition.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Pack.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}

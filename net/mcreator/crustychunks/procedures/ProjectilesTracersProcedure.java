package net.mcreator.crustychunks.procedures;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack.Pose;
import com.mojang.math.Axis;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Font.DisplayMode;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.MultiBufferSource.BufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.joml.Matrix4f;
import org.joml.Vector3f;

@EventBusSubscriber({Dist.CLIENT})
public class ProjectilesTracersProcedure {
   private static RenderLevelStageEvent provider = null;
   private static Map<EntityType, Entity> data = new HashMap();

   public static void renderBackground(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color) {
      Minecraft minecraft = Minecraft.m_91087_();
      Font font = minecraft.f_91062_;
      BufferSource bufferSource = minecraft.m_91269_().m_110104_();
      Vec3 pos = provider.getCamera().m_90583_();
      PoseStack poseStack = provider.getPoseStack();
      poseStack.m_85836_();
      poseStack.m_85837_(x - pos.m_7096_(), y - pos.m_7098_(), z - pos.m_7094_());
      poseStack.m_252781_(Axis.f_252392_.m_252977_(yaw));
      poseStack.m_252781_(Axis.f_252529_.m_252977_(pitch));
      poseStack.m_252781_(Axis.f_252393_.m_252977_(roll));
      poseStack.m_85841_(scale, -scale, 1.0F);
      float var10001 = (float)(font.m_92895_(texts) - 1) * -0.5F;
      Objects.requireNonNull(font);
      poseStack.m_252880_(var10001, (float)(9 - 1) * -0.5F, 0.0F);
      Matrix4f matrix4f = poseStack.m_85850_().m_252922_();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      font.m_271703_(texts, 0.0F, 0.0F, 0, false, matrix4f, bufferSource, DisplayMode.SEE_THROUGH, color, 15728880);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.m_85849_();
   }

   public static void renderBlock(BlockState blockState, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
      BlockPos blockPos = BlockPos.m_274561_(x, y, z);
      Vec3 pos = provider.getCamera().m_90583_();
      int packedLight = glowing ? 15728880 : LevelRenderer.m_109541_(Minecraft.m_91087_().f_91073_, blockPos);
      PoseStack poseStack = provider.getPoseStack();
      poseStack.m_85836_();
      poseStack.m_85837_(x - pos.m_7096_(), y - pos.m_7098_(), z - pos.m_7094_());
      poseStack.m_252781_(Axis.f_252392_.m_252977_(yaw));
      poseStack.m_252781_(Axis.f_252529_.m_252977_(pitch));
      poseStack.m_252781_(Axis.f_252393_.m_252977_(roll));
      poseStack.m_85841_(scale, scale, scale);
      poseStack.m_252880_(-0.5F, -0.5F, -0.5F);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      renderBlockModel(blockState, blockPos, poseStack, packedLight);
      renderBlockEntity(blockState, blockPos, poseStack, packedLight);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.m_85849_();
   }

   private static void renderBlockEntity(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
      Block var5 = blockState.m_60734_();
      if (var5 instanceof EntityBlock) {
         EntityBlock entityBlock = (EntityBlock)var5;
         Minecraft minecraft = Minecraft.m_91087_();
         ClientLevel level = minecraft.f_91073_;
         BlockEntity blockEntity = entityBlock.m_142194_(blockPos, blockState);
         if (blockEntity != null) {
            BlockEntityRenderer blockEntityRenderer = minecraft.m_167982_().m_112265_(blockEntity);
            if (blockEntityRenderer != null) {
               BufferSource bufferSource = minecraft.m_91269_().m_110104_();
               blockEntity.m_142339_(level);
               blockEntityRenderer.m_6922_(blockEntity, 0.0F, poseStack, bufferSource, packedLight, OverlayTexture.f_118083_);
            }
         }
      }

   }

   private static void renderBlockModel(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
      if (blockState.m_60799_() == RenderShape.MODEL) {
         Minecraft minecraft = Minecraft.m_91087_();
         ClientLevel level = minecraft.f_91073_;
         BufferSource bufferSource = minecraft.m_91269_().m_110104_();
         BlockRenderDispatcher dispatcher = minecraft.m_91289_();
         ModelBlockRenderer renderer = dispatcher.m_110937_();
         BakedModel bakedModel = dispatcher.m_110910_(blockState);
         ModelData modelData = bakedModel.getModelData(level, blockPos, blockState, ModelData.builder().build());
         Pose pose = poseStack.m_85850_();
         int color = minecraft.m_91298_().m_92582_(blockState, level, blockPos);
         float red = (float)(color >> 16 & 255) / 255.0F;
         float green = (float)(color >> 8 & 255) / 255.0F;
         float blue = (float)(color & 255) / 255.0F;
         Iterator var16 = bakedModel.getRenderTypes(blockState, RandomSource.m_216335_(42L), modelData).iterator();

         while(var16.hasNext()) {
            RenderType renderType = (RenderType)var16.next();
            renderer.renderModel(pose, bufferSource.m_6299_(Sheets.m_110792_()), blockState, bakedModel, red, green, blue, packedLight, OverlayTexture.f_118083_, modelData, renderType);
         }
      }

   }

   public static void renderEntity(EntityType type, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
      if (type != null) {
         ClientLevel level = Minecraft.m_91087_().f_91073_;
         Entity entity;
         if (data.containsKey(type)) {
            entity = (Entity)data.get(type);
            if (entity.m_9236_() != level) {
               entity = type.m_20615_(level);
               data.put(type, entity);
            }
         } else {
            entity = type.m_20615_(level);
            data.put(type, entity);
         }

         renderEntity(entity, 0.0F, x, y, z, yaw, pitch, roll, scale, glowing ? 15728880 : LevelRenderer.m_109541_(level, BlockPos.m_274561_(x, y, z)));
      }
   }

   public static void renderEntity(Entity entity, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
      float partialTick = provider.getPartialTick();
      int packedLight = glowing ? 15728880 : Minecraft.m_91087_().m_91290_().m_114394_(entity, partialTick);
      renderEntity(entity, partialTick, x, y, z, yaw, pitch, roll, scale, packedLight);
   }

   private static void renderEntity(Entity entity, float partialTick, double x, double y, double z, float yaw, float pitch, float roll, float scale, int packedLight) {
      if (entity != null) {
         Minecraft minecraft = Minecraft.m_91087_();
         BufferSource bufferSource = minecraft.m_91269_().m_110104_();
         EntityRenderer renderer = minecraft.m_91290_().m_114382_(entity);
         Vec3 pos = provider.getCamera().m_90583_();
         float offset = entity.m_20206_() / 2.0F * scale;
         PoseStack poseStack = provider.getPoseStack();
         poseStack.m_85836_();
         poseStack.m_85837_(x - pos.m_7096_(), y + (double)offset - pos.m_7098_(), z - pos.m_7094_());
         poseStack.m_252781_(Axis.f_252392_.m_252977_(yaw));
         poseStack.m_252781_(Axis.f_252529_.m_252977_(pitch));
         poseStack.m_252781_(Axis.f_252393_.m_252977_(roll));
         poseStack.m_252880_(0.0F, -offset, 0.0F);
         poseStack.m_85841_(scale, scale, scale);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         renderer.m_7392_(entity, entity.m_5675_(partialTick), partialTick, poseStack, bufferSource, packedLight);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         poseStack.m_85849_();
      }
   }

   public static void renderItem(ItemStack itemStack, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean flipping, boolean glowing) {
      Minecraft minecraft = Minecraft.m_91087_();
      BufferSource bufferSource = minecraft.m_91269_().m_110104_();
      ItemRenderer renderer = minecraft.m_91291_();
      Vec3 pos = provider.getCamera().m_90583_();
      int packedLight = glowing ? 15728880 : LevelRenderer.m_109541_(minecraft.f_91073_, BlockPos.m_274561_(x, y, z));
      PoseStack poseStack = provider.getPoseStack();
      poseStack.m_85836_();
      poseStack.m_85837_(x - pos.m_7096_(), y - pos.m_7098_(), z - pos.m_7094_());
      poseStack.m_252781_(Axis.f_252392_.m_252977_(yaw));
      poseStack.m_252781_(Axis.f_252529_.m_252977_(pitch));
      poseStack.m_252781_(Axis.f_252393_.m_252977_(roll));
      poseStack.m_85841_(scale, scale, scale);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      renderer.m_269491_((LivingEntity)null, itemStack, ItemDisplayContext.FIXED, flipping, poseStack, bufferSource, minecraft.f_91073_, packedLight, OverlayTexture.f_118083_, 0);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.m_85849_();
   }

   public static void renderLine(double x1, double y1, double z1, double x2, double y2, double z2, int color) {
      BufferSource bufferSource = Minecraft.m_91087_().m_91269_().m_110104_();
      Vec3 pos = provider.getCamera().m_90583_();
      Vector3f normal = (new Vec3(x2 - x1, y2 - y1, z2 - z1)).m_82541_().m_252839_();
      Matrix4f matrix4f = provider.getPoseStack().m_85850_().m_252922_();
      VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110504_());
      vertexConsumer.m_252986_(matrix4f, (float)(x1 - pos.m_7096_()), (float)(y1 - pos.m_7098_()), (float)(z1 - pos.m_7094_())).m_193479_(color).m_5601_(normal.x(), normal.y(), normal.z()).m_5752_();
      vertexConsumer.m_252986_(matrix4f, (float)(x2 - pos.m_7096_()), (float)(y2 - pos.m_7098_()), (float)(z2 - pos.m_7094_())).m_193479_(color).m_5601_(normal.x(), normal.y(), normal.z()).m_5752_();
   }

   public static void renderTexts(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color, boolean glowing) {
      Minecraft minecraft = Minecraft.m_91087_();
      Font font = minecraft.f_91062_;
      BufferSource bufferSource = minecraft.m_91269_().m_110104_();
      Vec3 pos = provider.getCamera().m_90583_();
      int packedLight = glowing ? 15728880 : LevelRenderer.m_109541_(minecraft.f_91073_, BlockPos.m_274561_(x, y, z));
      PoseStack poseStack = provider.getPoseStack();
      poseStack.m_85836_();
      poseStack.m_85837_(x - pos.m_7096_(), y - pos.m_7098_(), z - pos.m_7094_());
      poseStack.m_252781_(Axis.f_252392_.m_252977_(yaw));
      poseStack.m_252781_(Axis.f_252529_.m_252977_(pitch));
      poseStack.m_252781_(Axis.f_252393_.m_252977_(roll));
      poseStack.m_85841_(scale, -scale, 1.0F);
      float var10001 = (float)(font.m_92895_(texts) - 1) * -0.5F;
      Objects.requireNonNull(font);
      poseStack.m_252880_(var10001, (float)(9 - 1) * -0.5F, 0.0F);
      Matrix4f matrix4f = poseStack.m_85850_().m_252922_();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      font.m_271703_(texts, 0.0F, 0.0F, color, false, matrix4f, bufferSource, DisplayMode.NORMAL, 0, packedLight);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.m_85849_();
   }

   @SubscribeEvent
   public static void renderModels(RenderLevelStageEvent event) {
      provider = event;
      if (provider.getStage() == Stage.AFTER_ENTITIES) {
         ClientLevel level = Minecraft.m_91087_().f_91073_;
         Entity entity = provider.getCamera().m_90592_();
         Vec3 pos = entity.m_20318_(provider.getPartialTick());
         execute(provider, level, (double)provider.getPartialTick());
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.enableDepthTest();
         RenderSystem.depthMask(true);
      }

   }

   public static void execute(LevelAccessor world, double partialTick) {
      execute((Event)null, world, partialTick);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double partialTick) {
      double xvector = 0.0D;
      double yvector = 0.0D;
      double zvector = 0.0D;
      double pmagnitude = 0.0D;
      double vmagnitude = 0.0D;
      double scale = 0.0D;
      if (world instanceof ClientLevel) {
         Iterator var16 = ((ClientLevel)world).m_104735_().iterator();

         while(true) {
            Entity entityiterator;
            do {
               if (!var16.hasNext()) {
                  return;
               }

               entityiterator = (Entity)var16.next();
            } while(!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:redtracersmall"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:greentracersmall"))));

            entityiterator.getPersistentData().m_128347_("VX", entityiterator.m_20184_().m_7096_());
            entityiterator.getPersistentData().m_128347_("VY", entityiterator.m_20184_().m_7098_());
            entityiterator.getPersistentData().m_128347_("VZ", entityiterator.m_20184_().m_7094_());
            if (3.0D >= entityiterator.getPersistentData().m_128459_("Tracking")) {
               entityiterator.getPersistentData().m_128347_("Tracking", entityiterator.getPersistentData().m_128459_("Tracking") + 1.0D);
            } else {
               double var10000;
               if (entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  var10000 = _projEnt.m_20184_().m_82553_();
               } else {
                  var10000 = 0.0D;
               }

               vmagnitude = var10000 * 1.5D;
               xvector = entityiterator.m_20252_((float)partialTick).m_7096_() * -1.0D * vmagnitude;
               yvector = entityiterator.m_20252_((float)partialTick).m_7098_() * -1.0D * vmagnitude;
               zvector = entityiterator.m_20252_((float)partialTick).m_7094_() * vmagnitude;
               if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:redtracersmall")))) {
                  RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
                  renderLine(entityiterator.m_20318_((float)partialTick).m_7096_(), entityiterator.m_20318_((float)partialTick).m_7098_(), entityiterator.m_20318_((float)partialTick).m_7094_(), entityiterator.m_20318_((float)partialTick).m_7096_() - xvector * 2.0D, entityiterator.m_20318_((float)partialTick).m_7098_() - yvector * 2.0D, entityiterator.m_20318_((float)partialTick).m_7094_() - zvector * 2.0D, -39836);
                  renderLine(entityiterator.m_20318_((float)partialTick).m_7096_(), entityiterator.m_20318_((float)partialTick).m_7098_(), entityiterator.m_20318_((float)partialTick).m_7094_(), entityiterator.m_20318_((float)partialTick).m_7096_() - xvector * 1.5D, entityiterator.m_20318_((float)partialTick).m_7098_() - yvector * 1.5D, entityiterator.m_20318_((float)partialTick).m_7094_() - zvector * 1.5D, -20561);
                  renderLine(entityiterator.m_20318_((float)partialTick).m_7096_(), entityiterator.m_20318_((float)partialTick).m_7098_(), entityiterator.m_20318_((float)partialTick).m_7094_(), entityiterator.m_20318_((float)partialTick).m_7096_() - xvector * 0.5D, entityiterator.m_20318_((float)partialTick).m_7098_() - yvector * 0.5D, entityiterator.m_20318_((float)partialTick).m_7094_() - zvector * 0.5D, -1);
               } else if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:greentracersmall")))) {
                  RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
                  renderLine(entityiterator.m_20318_((float)partialTick).m_7096_(), entityiterator.m_20318_((float)partialTick).m_7098_(), entityiterator.m_20318_((float)partialTick).m_7094_(), entityiterator.m_20318_((float)partialTick).m_7096_() - xvector * 2.0D, entityiterator.m_20318_((float)partialTick).m_7098_() - yvector * 2.0D, entityiterator.m_20318_((float)partialTick).m_7094_() - zvector * 2.0D, -10158236);
                  renderLine(entityiterator.m_20318_((float)partialTick).m_7096_(), entityiterator.m_20318_((float)partialTick).m_7098_(), entityiterator.m_20318_((float)partialTick).m_7094_(), entityiterator.m_20318_((float)partialTick).m_7096_() - xvector * 1.5D, entityiterator.m_20318_((float)partialTick).m_7098_() - yvector * 1.5D, entityiterator.m_20318_((float)partialTick).m_7094_() - zvector * 1.5D, -5242961);
                  renderLine(entityiterator.m_20318_((float)partialTick).m_7096_(), entityiterator.m_20318_((float)partialTick).m_7098_(), entityiterator.m_20318_((float)partialTick).m_7094_(), entityiterator.m_20318_((float)partialTick).m_7096_() - xvector * 0.5D, entityiterator.m_20318_((float)partialTick).m_7098_() - yvector * 0.5D, entityiterator.m_20318_((float)partialTick).m_7094_() - zvector * 0.5D, -1);
               }
            }
         }
      }
   }
}

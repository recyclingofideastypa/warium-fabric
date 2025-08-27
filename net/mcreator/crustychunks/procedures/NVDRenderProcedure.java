package net.mcreator.crustychunks.procedures;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexBuffer.Usage;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import com.mojang.math.Axis;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.joml.Matrix4f;

@EventBusSubscriber({Dist.CLIENT})
public class NVDRenderProcedure {
   private static BufferBuilder bufferBuilder = null;
   private static VertexBuffer vertexBuffer = null;
   private static Mode mode = null;
   private static VertexFormat format = null;
   private static PoseStack poseStack = null;
   private static Matrix4f projectionMatrix = null;
   private static boolean worldCoordinate = true;
   private static Vec3 offset;
   private static int currentStage;
   private static int targetStage;

   private static void add(double x, double y, double z, int color) {
      add(x, y, z, 0.0F, 0.0F, color);
   }

   private static void add(double x, double y, double z, float u, float v, int color) {
      if (bufferBuilder != null && bufferBuilder.m_85732_()) {
         if (format == DefaultVertexFormat.f_85815_) {
            bufferBuilder.m_5483_(x, y, z).m_193479_(color).m_5752_();
         } else if (format == DefaultVertexFormat.f_85819_) {
            bufferBuilder.m_5483_(x, y, z).m_7421_(u, v).m_193479_(color).m_5752_();
         }

      }
   }

   private static boolean begin(Mode mode, VertexFormat format, boolean update) {
      if (bufferBuilder == null || !bufferBuilder.m_85732_()) {
         if (update) {
            clear();
         }

         if (vertexBuffer == null) {
            if (format == DefaultVertexFormat.f_85815_) {
               NVDRenderProcedure.mode = mode;
               NVDRenderProcedure.format = format;
               bufferBuilder = Tesselator.m_85913_().m_85915_();
               bufferBuilder.m_166779_(mode, DefaultVertexFormat.f_85815_);
               return true;
            }

            if (format == DefaultVertexFormat.f_85819_) {
               NVDRenderProcedure.mode = mode;
               NVDRenderProcedure.format = format;
               bufferBuilder = Tesselator.m_85913_().m_85915_();
               bufferBuilder.m_166779_(mode, DefaultVertexFormat.f_85819_);
               return true;
            }
         }
      }

      return false;
   }

   private static void clear() {
      if (vertexBuffer != null) {
         vertexBuffer.close();
         vertexBuffer = null;
      }

   }

   private static void end() {
      if (bufferBuilder != null && bufferBuilder.m_85732_()) {
         if (vertexBuffer != null) {
            vertexBuffer.close();
         }

         vertexBuffer = new VertexBuffer(Usage.STATIC);
         vertexBuffer.m_85921_();
         vertexBuffer.m_231221_(bufferBuilder.m_231175_());
         VertexBuffer.m_85931_();
      }
   }

   private static void offset(double x, double y, double z) {
      offset = new Vec3(x, y, z);
   }

   private static void release() {
      targetStage = 0;
   }

   private static VertexBuffer shape() {
      return vertexBuffer;
   }

   private static void system(boolean worldCoordinate) {
      NVDRenderProcedure.worldCoordinate = worldCoordinate;
   }

   private static boolean target(int targetStage) {
      if (targetStage == currentStage) {
         NVDRenderProcedure.targetStage = targetStage;
         return true;
      } else {
         return false;
      }
   }

   private static void renderShape(VertexBuffer vertexBuffer, double x, double y, double z, float yaw, float pitch, float roll, float xScale, float yScale, float zScale, int color) {
      if (currentStage != 0 && currentStage == targetStage) {
         if (poseStack != null && projectionMatrix != null) {
            if (vertexBuffer != null) {
               float i;
               float j;
               float k;
               if (worldCoordinate) {
                  Vec3 pos = Minecraft.m_91087_().f_91063_.m_109153_().m_90583_();
                  i = (float)(x - pos.m_7096_());
                  j = (float)(y - pos.m_7098_());
                  k = (float)(z - pos.m_7094_());
               } else {
                  i = (float)x;
                  j = (float)y;
                  k = (float)z;
               }

               poseStack.m_85836_();
               poseStack.m_252880_(i, j, k);
               poseStack.m_252781_(Axis.f_252392_.m_252977_(yaw));
               poseStack.m_252781_(Axis.f_252529_.m_252977_(pitch));
               poseStack.m_252781_(Axis.f_252393_.m_252977_(roll));
               poseStack.m_85841_(xScale, yScale, zScale);
               poseStack.m_85837_(offset.m_7096_(), offset.m_7098_(), offset.m_7094_());
               RenderSystem.setShaderColor((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F, (float)(color >>> 24) / 255.0F);
               vertexBuffer.m_85921_();
               vertexBuffer.m_253207_(poseStack.m_85850_().m_252922_(), projectionMatrix, vertexBuffer.m_166892_().hasUV(0) ? GameRenderer.m_172820_() : GameRenderer.m_172811_());
               VertexBuffer.m_85931_();
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               poseStack.m_85849_();
            }
         }
      }
   }

   @SubscribeEvent
   public static void renderLevel(RenderLevelStageEvent event) {
      if (event.getStage() == Stage.AFTER_SKY) {
         currentStage = 1;
         RenderSystem.depthMask(false);
         renderShapes(event);
         RenderSystem.enableCull();
         RenderSystem.depthMask(true);
         currentStage = 0;
      } else if (event.getStage() == Stage.AFTER_PARTICLES) {
         currentStage = 2;
         RenderSystem.depthMask(true);
         renderShapes(event);
         RenderSystem.enableCull();
         RenderSystem.depthMask(true);
         currentStage = 0;
      }

   }

   private static void renderShapes(RenderLevelStageEvent event) {
      Minecraft minecraft = Minecraft.m_91087_();
      ClientLevel level = minecraft.f_91073_;
      Entity entity = minecraft.f_91063_.m_109153_().m_90592_();
      if (level != null && entity != null) {
         poseStack = event.getPoseStack();
         projectionMatrix = event.getProjectionMatrix();
         entity.m_20318_(event.getPartialTick());
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         execute(event, entity);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableDepthTest();
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double scale = 0.0D;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == CrustyChunksModItems.NVD_HELMET_HELMET.get()) {
            if (begin(Mode.QUADS, DefaultVertexFormat.f_85815_, false)) {
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               end();
            }

            if (target(2)) {
               RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
               renderShape(shape(), Minecraft.m_91087_().f_91063_.m_109153_().m_90583_().m_7096_(), Minecraft.m_91087_().f_91063_.m_109153_().m_90583_().m_7098_(), Minecraft.m_91087_().f_91063_.m_109153_().m_90583_().m_7094_(), 0.0F, 0.0F, 0.0F, -0.4F, -0.4F, -0.4F, 1694498815);
               release();
            }

            clear();
            if (begin(Mode.QUADS, DefaultVertexFormat.f_85815_, false)) {
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               end();
            }

            if (target(2)) {
               RenderSystem.blendFuncSeparate(SourceFactor.DST_COLOR, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
               renderShape(shape(), Minecraft.m_91087_().f_91063_.m_109153_().m_90583_().m_7096_(), Minecraft.m_91087_().f_91063_.m_109153_().m_90583_().m_7098_(), Minecraft.m_91087_().f_91063_.m_109153_().m_90583_().m_7094_(), 0.0F, 0.0F, 0.0F, -0.4F, -0.4F, -0.4F, -16711936);
               release();
            }

            clear();
            if (begin(Mode.QUADS, DefaultVertexFormat.f_85815_, false)) {
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               end();
            }

            if (target(2)) {
               RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
               renderShape(shape(), Minecraft.m_91087_().f_91063_.m_109153_().m_90583_().m_7096_(), Minecraft.m_91087_().f_91063_.m_109153_().m_90583_().m_7098_(), Minecraft.m_91087_().f_91063_.m_109153_().m_90583_().m_7094_(), 0.0F, 0.0F, 0.0F, -0.4F, -0.4F, -0.4F, 436207615);
               release();
            }

            clear();
         }

      }
   }

   static {
      offset = Vec3.f_82478_;
      currentStage = 0;
      targetStage = 0;
   }
}

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
import java.util.Iterator;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.entity.MuzzleFlashProducerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.joml.Matrix4f;

@EventBusSubscriber({Dist.CLIENT})
public class RenderProjectileFlashProcedure {
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
               RenderProjectileFlashProcedure.mode = mode;
               RenderProjectileFlashProcedure.format = format;
               bufferBuilder = Tesselator.m_85913_().m_85915_();
               bufferBuilder.m_166779_(mode, DefaultVertexFormat.f_85815_);
               return true;
            }

            if (format == DefaultVertexFormat.f_85819_) {
               RenderProjectileFlashProcedure.mode = mode;
               RenderProjectileFlashProcedure.format = format;
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
      RenderProjectileFlashProcedure.worldCoordinate = worldCoordinate;
   }

   private static boolean target(int targetStage) {
      if (targetStage == currentStage) {
         RenderProjectileFlashProcedure.targetStage = targetStage;
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
         execute(event, level);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableDepthTest();
      }

   }

   public static void execute(LevelAccessor world) {
      execute((Event)null, world);
   }

   private static void execute(@Nullable Event event, LevelAccessor world) {
      double scale = 0.0D;
      double yvector = 0.0D;
      double vmagnitude = 0.0D;
      double xvector = 0.0D;
      double zvector = 0.0D;
      if (world instanceof ClientLevel) {
         Iterator var12 = ((ClientLevel)world).m_104735_().iterator();

         while(var12.hasNext()) {
            Entity entityiterator = (Entity)var12.next();
            if (entityiterator instanceof MuzzleFlashProducerEntity) {
               if (entityiterator.getPersistentData().m_128459_("Type") == 0.0D) {
                  entityiterator.getPersistentData().m_128347_("Type", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 4));
               }

               scale = Mth.m_216263_(RandomSource.m_216327_(), 3.95D, 4.05D);
               if (begin(Mode.QUADS, DefaultVertexFormat.f_85819_, false)) {
                  add(0.5D, 0.0D, 0.5D, 0.0F, 0.0F, -1);
                  add(0.5D, 0.0D, -0.5D, 0.0F, 1.0F, -1);
                  add(-0.5D, 0.0D, -0.5D, 1.0F, 1.0F, -1);
                  add(-0.5D, 0.0D, 0.5D, 1.0F, 0.0F, -1);
                  end();
               }

               if (target(2)) {
                  RenderSystem.depthMask(false);
                  RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ONE_MINUS_SRC_ALPHA);
                  if (entityiterator.getPersistentData().m_128459_("Type") == 1.0D) {
                     RenderSystem.setShaderTexture(0, new ResourceLocation("crusty_chunks:textures/muzzleflash.png"));
                  } else if (entityiterator.getPersistentData().m_128459_("Type") == 2.0D) {
                     RenderSystem.setShaderTexture(0, new ResourceLocation("crusty_chunks:textures/muzzleflash2.png"));
                  } else if (entityiterator.getPersistentData().m_128459_("Type") == 3.0D) {
                     RenderSystem.setShaderTexture(0, new ResourceLocation("crusty_chunks:textures/muzzleflash3.png"));
                  } else {
                     RenderSystem.setShaderTexture(0, new ResourceLocation("crusty_chunks:textures/muzzleflash4.png"));
                  }

                  renderShape(shape(), entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), Minecraft.m_91087_().f_91063_.m_109153_().m_90590_(), Minecraft.m_91087_().f_91063_.m_109153_().m_90589_() - 90.0F, 0.0F, (float)scale, (float)scale, (float)scale, -65536 | Mth.m_216271_(RandomSource.m_216327_(), 245, 255) << 8 | Mth.m_216271_(RandomSource.m_216327_(), 245, 255));
                  release();
               }

               clear();
            }
         }
      }

   }

   static {
      offset = Vec3.f_82478_;
      currentStage = 0;
      targetStage = 0;
   }
}

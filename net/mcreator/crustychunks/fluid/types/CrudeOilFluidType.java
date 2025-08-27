package net.mcreator.crustychunks.fluid.types;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Consumer;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer.FogMode;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.FluidType.Properties;

public class CrudeOilFluidType extends FluidType {
   public CrudeOilFluidType() {
      super(Properties.create().fallDistanceModifier(0.0F).canExtinguish(true).supportsBoating(true).canHydrate(true).motionScale(0.007D).sound(SoundActions.BUCKET_FILL, SoundEvents.f_11781_).sound(SoundActions.BUCKET_EMPTY, SoundEvents.f_11778_).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.f_11937_));
   }

   public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
      consumer.accept(new IClientFluidTypeExtensions() {
         private static final ResourceLocation STILL_TEXTURE = new ResourceLocation("crusty_chunks:block/crudeoil");
         private static final ResourceLocation FLOWING_TEXTURE = new ResourceLocation("crusty_chunks:block/crudeoil");

         public ResourceLocation getStillTexture() {
            return STILL_TEXTURE;
         }

         public ResourceLocation getFlowingTexture() {
            return FLOWING_TEXTURE;
         }

         public void modifyFogRender(Camera camera, FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
            Entity entity = camera.m_90592_();
            Level world = entity.m_9236_();
            RenderSystem.setShaderFogShape(FogShape.SPHERE);
            RenderSystem.setShaderFogStart(0.0F);
            RenderSystem.setShaderFogEnd(5.0F);
         }
      });
   }
}

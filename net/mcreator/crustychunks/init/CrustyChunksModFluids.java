package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.fluid.CrudeOilFluid;
import net.mcreator.crustychunks.fluid.DieselFluid;
import net.mcreator.crustychunks.fluid.KeroseneFluid;
import net.mcreator.crustychunks.fluid.OilFluid;
import net.mcreator.crustychunks.fluid.PetroliumFluid;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CrustyChunksModFluids {
   public static final DeferredRegister<Fluid> REGISTRY;
   public static final RegistryObject<FlowingFluid> CRUDE_OIL;
   public static final RegistryObject<FlowingFluid> FLOWING_CRUDE_OIL;
   public static final RegistryObject<FlowingFluid> OIL;
   public static final RegistryObject<FlowingFluid> FLOWING_OIL;
   public static final RegistryObject<FlowingFluid> DIESEL;
   public static final RegistryObject<FlowingFluid> FLOWING_DIESEL;
   public static final RegistryObject<FlowingFluid> KEROSENE;
   public static final RegistryObject<FlowingFluid> FLOWING_KEROSENE;
   public static final RegistryObject<FlowingFluid> PETROLIUM;
   public static final RegistryObject<FlowingFluid> FLOWING_PETROLIUM;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, "crusty_chunks");
      CRUDE_OIL = REGISTRY.register("crude_oil", () -> {
         return new CrudeOilFluid.Source();
      });
      FLOWING_CRUDE_OIL = REGISTRY.register("flowing_crude_oil", () -> {
         return new CrudeOilFluid.Flowing();
      });
      OIL = REGISTRY.register("oil", () -> {
         return new OilFluid.Source();
      });
      FLOWING_OIL = REGISTRY.register("flowing_oil", () -> {
         return new OilFluid.Flowing();
      });
      DIESEL = REGISTRY.register("diesel", () -> {
         return new DieselFluid.Source();
      });
      FLOWING_DIESEL = REGISTRY.register("flowing_diesel", () -> {
         return new DieselFluid.Flowing();
      });
      KEROSENE = REGISTRY.register("kerosene", () -> {
         return new KeroseneFluid.Source();
      });
      FLOWING_KEROSENE = REGISTRY.register("flowing_kerosene", () -> {
         return new KeroseneFluid.Flowing();
      });
      PETROLIUM = REGISTRY.register("petrolium", () -> {
         return new PetroliumFluid.Source();
      });
      FLOWING_PETROLIUM = REGISTRY.register("flowing_petrolium", () -> {
         return new PetroliumFluid.Flowing();
      });
   }

   @EventBusSubscriber(
      bus = Bus.MOD,
      value = {Dist.CLIENT}
   )
   public static class FluidsClientSideHandler {
      @SubscribeEvent
      public static void clientSetup(FMLClientSetupEvent event) {
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.CRUDE_OIL.get(), RenderType.m_110466_());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_CRUDE_OIL.get(), RenderType.m_110466_());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.OIL.get(), RenderType.m_110466_());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_OIL.get(), RenderType.m_110466_());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.DIESEL.get(), RenderType.m_110466_());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_DIESEL.get(), RenderType.m_110466_());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.KEROSENE.get(), RenderType.m_110466_());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_KEROSENE.get(), RenderType.m_110466_());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.PETROLIUM.get(), RenderType.m_110466_());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_PETROLIUM.get(), RenderType.m_110466_());
      }
   }
}

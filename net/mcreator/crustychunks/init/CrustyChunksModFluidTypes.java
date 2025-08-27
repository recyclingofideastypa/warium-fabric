package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.fluid.types.CrudeOilFluidType;
import net.mcreator.crustychunks.fluid.types.DieselFluidType;
import net.mcreator.crustychunks.fluid.types.KeroseneFluidType;
import net.mcreator.crustychunks.fluid.types.OilFluidType;
import net.mcreator.crustychunks.fluid.types.PetroliumFluidType;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries.Keys;

public class CrustyChunksModFluidTypes {
   public static final DeferredRegister<FluidType> REGISTRY;
   public static final RegistryObject<FluidType> CRUDE_OIL_TYPE;
   public static final RegistryObject<FluidType> OIL_TYPE;
   public static final RegistryObject<FluidType> DIESEL_TYPE;
   public static final RegistryObject<FluidType> KEROSENE_TYPE;
   public static final RegistryObject<FluidType> PETROLIUM_TYPE;

   static {
      REGISTRY = DeferredRegister.create(Keys.FLUID_TYPES, "crusty_chunks");
      CRUDE_OIL_TYPE = REGISTRY.register("crude_oil", () -> {
         return new CrudeOilFluidType();
      });
      OIL_TYPE = REGISTRY.register("oil", () -> {
         return new OilFluidType();
      });
      DIESEL_TYPE = REGISTRY.register("diesel", () -> {
         return new DieselFluidType();
      });
      KEROSENE_TYPE = REGISTRY.register("kerosene", () -> {
         return new KeroseneFluidType();
      });
      PETROLIUM_TYPE = REGISTRY.register("petrolium", () -> {
         return new PetroliumFluidType();
      });
   }
}

package net.mcreator.crustychunks.fluid;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModFluidTypes;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid.Properties;

public abstract class CrudeOilFluid extends ForgeFlowingFluid {
   public static final Properties PROPERTIES = (new Properties(() -> {
      return (FluidType)CrustyChunksModFluidTypes.CRUDE_OIL_TYPE.get();
   }, () -> {
      return (Fluid)CrustyChunksModFluids.CRUDE_OIL.get();
   }, () -> {
      return (Fluid)CrustyChunksModFluids.FLOWING_CRUDE_OIL.get();
   })).explosionResistance(100.0F).bucket(() -> {
      return (Item)CrustyChunksModItems.CRUDE_OIL_BUCKET.get();
   }).block(() -> {
      return (LiquidBlock)CrustyChunksModBlocks.CRUDE_OIL.get();
   });

   private CrudeOilFluid() {
      super(PROPERTIES);
   }

   public static class Flowing extends CrudeOilFluid {
      protected void m_7180_(Builder<Fluid, FluidState> builder) {
         super.m_7180_(builder);
         builder.m_61104_(new Property[]{f_75948_});
      }

      public int m_7430_(FluidState state) {
         return (Integer)state.m_61143_(f_75948_);
      }

      public boolean m_7444_(FluidState state) {
         return false;
      }
   }

   public static class Source extends CrudeOilFluid {
      public int m_7430_(FluidState state) {
         return 8;
      }

      public boolean m_7444_(FluidState state) {
         return true;
      }
   }
}

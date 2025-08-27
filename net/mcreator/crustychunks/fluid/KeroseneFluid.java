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

public abstract class KeroseneFluid extends ForgeFlowingFluid {
   public static final Properties PROPERTIES = (new Properties(() -> {
      return (FluidType)CrustyChunksModFluidTypes.KEROSENE_TYPE.get();
   }, () -> {
      return (Fluid)CrustyChunksModFluids.KEROSENE.get();
   }, () -> {
      return (Fluid)CrustyChunksModFluids.FLOWING_KEROSENE.get();
   })).explosionResistance(100.0F).tickRate(4).bucket(() -> {
      return (Item)CrustyChunksModItems.KEROSENE_BUCKET.get();
   }).block(() -> {
      return (LiquidBlock)CrustyChunksModBlocks.KEROSENE.get();
   });

   private KeroseneFluid() {
      super(PROPERTIES);
   }

   public static class Flowing extends KeroseneFluid {
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

   public static class Source extends KeroseneFluid {
      public int m_7430_(FluidState state) {
         return 8;
      }

      public boolean m_7444_(FluidState state) {
         return true;
      }
   }
}

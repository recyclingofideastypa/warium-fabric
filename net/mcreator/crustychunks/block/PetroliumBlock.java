package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.mcreator.crustychunks.procedures.FlammableFluidEffectProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class PetroliumBlock extends LiquidBlock {
   public PetroliumBlock() {
      super(() -> {
         return (FlowingFluid)CrustyChunksModFluids.PETROLIUM.get();
      }, Properties.m_284310_().m_284180_(MapColor.f_283864_).m_60978_(100.0F).m_60910_().m_222994_().m_278788_().m_278166_(PushReaction.DESTROY).m_60918_(SoundType.f_279557_).m_280170_());
   }

   public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
      return 100;
   }

   public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
      return 100;
   }

   public void m_7892_(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.m_7892_(blockstate, world, pos, entity);
      FlammableFluidEffectProcedure.execute(entity);
   }
}

package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.procedures.RawLithiumBlockNeighbourBlockChangesProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class RawLithiumBlockBlock extends Block {
   public RawLithiumBlockBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56742_).m_60913_(2.0F, 4.0F).m_60999_());
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public void m_6807_(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.m_6807_(blockstate, world, pos, oldState, moving);
      RawLithiumBlockNeighbourBlockChangesProcedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
   }

   public void m_6861_(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
      super.m_6861_(blockstate, world, pos, neighborBlock, fromPos, moving);
      RawLithiumBlockNeighbourBlockChangesProcedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
   }
}

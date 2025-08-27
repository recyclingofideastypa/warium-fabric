package net.mcreator.crustychunks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class ReinforcedGlassTrapdoorBlock extends TrapDoorBlock {
   public ReinforcedGlassTrapdoorBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.HAT).m_60918_(SoundType.f_56744_).m_60978_(2.0F).m_60955_().m_60924_((bs, br, bp) -> {
         return false;
      }), BlockSetType.f_271479_);
   }

   public boolean m_6104_(BlockState state, BlockState adjacentBlockState, Direction side) {
      return adjacentBlockState.m_60734_() == this ? true : super.m_6104_(state, adjacentBlockState, side);
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }
}

package net.mcreator.crustychunks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PolishedBauxiteBlock extends Block {
   public PolishedBauxiteBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_154680_).m_60913_(1.0F, 2.0F).m_60999_());
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }
}

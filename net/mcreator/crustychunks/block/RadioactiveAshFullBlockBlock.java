package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.procedures.Rad5TickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class RadioactiveAshFullBlockBlock extends FallingBlock {
   public RadioactiveAshFullBlockBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.SNARE).m_60918_(SoundType.f_56716_).m_60913_(0.5F, 15.0F));
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public void m_6807_(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.m_6807_(blockstate, world, pos, oldState, moving);
      world.m_186460_(pos, this, 60);
   }

   public void m_213897_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.m_213897_(blockstate, world, pos, random);
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      Rad5TickProcedure.execute(world, (double)x, (double)y, (double)z);
      world.m_186460_(pos, this, 60);
   }
}

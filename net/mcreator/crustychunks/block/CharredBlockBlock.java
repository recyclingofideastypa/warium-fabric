package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.procedures.AshUpdateProcedure;
import net.mcreator.crustychunks.procedures.CharredBlockOnRandomClientDisplayTickProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CharredBlockBlock extends Block {
   public CharredBlockBlock() {
      super(Properties.m_284310_().m_278183_().m_280658_(NoteBlockInstrument.BASS).m_60918_(SoundType.f_56716_).m_60913_(0.5F, 5.0F).m_60977_());
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public void m_213897_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.m_213897_(blockstate, world, pos, random);
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      AshUpdateProcedure.execute(world, (double)x, (double)y, (double)z);
   }

   @OnlyIn(Dist.CLIENT)
   public void m_214162_(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
      super.m_214162_(blockstate, world, pos, random);
      Player entity = Minecraft.m_91087_().f_91074_;
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      CharredBlockOnRandomClientDisplayTickProcedure.execute(world, (double)x, (double)y, (double)z);
   }
}

package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.procedures.AncientLightOnRandomClientDisplayTickProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
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

public class AncientLightBlock extends Block {
   public AncientLightBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56749_).m_60913_(1.0F, 10.0F).m_60953_((s) -> {
         return 10;
      }).m_60977_().m_60982_((bs, br, bp) -> {
         return true;
      }).m_60991_((bs, br, bp) -> {
         return true;
      }));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   @OnlyIn(Dist.CLIENT)
   public void m_214162_(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
      super.m_214162_(blockstate, world, pos, random);
      Player entity = Minecraft.m_91087_().f_91074_;
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      AncientLightOnRandomClientDisplayTickProcedure.execute(world, (double)x, (double)y, (double)z);
   }
}

package net.mcreator.crustychunks.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PurpleArmorStairsBlock extends StairBlock {
   public PurpleArmorStairsBlock() {
      super(() -> {
         return Blocks.f_50016_.m_49966_();
      }, Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56725_).m_60978_(15.0F));
   }

   public float m_7325_() {
      return 15.0F;
   }

   public boolean m_6724_(BlockState state) {
      return false;
   }
}

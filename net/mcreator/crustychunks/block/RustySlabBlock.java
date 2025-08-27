package net.mcreator.crustychunks.block;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class RustySlabBlock extends SlabBlock {
   public RustySlabBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_284180_(MapColor.f_283825_).m_60918_(SoundType.f_56725_).m_60913_(13.0F, 5.0F));
   }
}

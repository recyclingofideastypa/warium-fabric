package net.mcreator.crustychunks.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class GrayArmorTrapdoorBlock extends TrapDoorBlock {
   public GrayArmorTrapdoorBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56725_).m_60978_(15.0F), BlockSetType.f_271479_);
   }
}

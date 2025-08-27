package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.procedures.ConcreteDamage1Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.ForgeRegistries;

public class OvergrownReenforcedConcreteBlock extends Block {
   public OvergrownReenforcedConcreteBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(new ForgeSoundType(1.0F, 1.0F, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.hit"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.hit"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.fall"));
      })).m_60978_(5.0F));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public void m_7592_(Level world, BlockPos pos, Explosion e) {
      super.m_7592_(world, pos, e);
      ConcreteDamage1Procedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
   }
}

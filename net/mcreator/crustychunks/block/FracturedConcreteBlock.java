package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.procedures.ConcreteDamage3Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.HitResult;

public class FracturedConcreteBlock extends Block {
   public FracturedConcreteBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56718_).m_60978_(4.0F));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
      return new ItemStack((ItemLike)CrustyChunksModBlocks.REENFORCED_CONCRETE.get());
   }

   public void m_7592_(Level world, BlockPos pos, Explosion e) {
      super.m_7592_(world, pos, e);
      ConcreteDamage3Procedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
   }
}

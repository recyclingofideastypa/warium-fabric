package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.procedures.DirtupdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.HitResult;

public class HarddirtBlock extends Block {
   public HarddirtBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_222471_).m_60913_(1.0F, 15.0F).m_60977_());
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
      return new ItemStack(Blocks.f_50493_);
   }

   public void m_213897_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.m_213897_(blockstate, world, pos, random);
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      DirtupdateProcedure.execute(world, (double)x, (double)y, (double)z);
   }
}

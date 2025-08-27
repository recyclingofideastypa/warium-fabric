package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.procedures.RazorWireEntityWalksOnTheBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RazorWireBlock extends Block {
   public RazorWireBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56728_).m_60913_(20.0F, 10.0F).m_60910_().m_60956_(0.05F).m_60967_(0.2F).m_60955_().m_60924_((bs, br, bp) -> {
         return false;
      }));
   }

   public boolean m_6104_(BlockState state, BlockState adjacentBlockState, Direction side) {
      return adjacentBlockState.m_60734_() == this ? true : super.m_6104_(state, adjacentBlockState, side);
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.m_83040_();
   }

   public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return m_49796_(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
   }

   public void m_7892_(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.m_7892_(blockstate, world, pos, entity);
      RazorWireEntityWalksOnTheBlockProcedure.execute(world, entity);
   }

   public void m_141947_(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
      super.m_141947_(world, pos, blockstate, entity);
      RazorWireEntityWalksOnTheBlockProcedure.execute(world, entity);
   }
}

package net.mcreator.crustychunks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SteelTrussBlock extends Block implements SimpleWaterloggedBlock {
   public static final EnumProperty<Axis> AXIS;
   public static final BooleanProperty WATERLOGGED;

   public SteelTrussBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56725_).m_60978_(5.0F).m_60955_().m_60924_((bs, br, bp) -> {
         return false;
      }));
      this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(AXIS, Axis.Y)).m_61124_(WATERLOGGED, false));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 2;
   }

   public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.m_83040_();
   }

   protected void m_7926_(Builder<Block, BlockState> builder) {
      super.m_7926_(builder);
      builder.m_61104_(new Property[]{AXIS, WATERLOGGED});
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      boolean flag = context.m_43725_().m_6425_(context.m_8083_()).m_76152_() == Fluids.f_76193_;
      return (BlockState)((BlockState)super.m_5573_(context).m_61124_(AXIS, context.m_43719_().m_122434_())).m_61124_(WATERLOGGED, flag);
   }

   public BlockState m_6843_(BlockState state, Rotation rot) {
      if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
         if (state.m_61143_(AXIS) == Axis.X) {
            return (BlockState)state.m_61124_(AXIS, Axis.Z);
         }

         if (state.m_61143_(AXIS) == Axis.Z) {
            return (BlockState)state.m_61124_(AXIS, Axis.X);
         }
      }

      return state;
   }

   public FluidState m_5888_(BlockState state) {
      return (Boolean)state.m_61143_(WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
   }

   public BlockState m_7417_(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
      if ((Boolean)state.m_61143_(WATERLOGGED)) {
         world.m_186469_(currentPos, Fluids.f_76193_, Fluids.f_76193_.m_6718_(world));
      }

      return super.m_7417_(state, facing, facingState, world, currentPos, facingPos);
   }

   static {
      AXIS = BlockStateProperties.f_61365_;
      WATERLOGGED = BlockStateProperties.f_61362_;
   }
}

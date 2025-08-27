package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.procedures.AIMineTriggerProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AIMineBlock extends Block implements SimpleWaterloggedBlock {
   public static final BooleanProperty WATERLOGGED;

   public AIMineBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56743_).m_60913_(2.0F, 1.0F).m_60955_().m_60924_((bs, br, bp) -> {
         return false;
      }));
      this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(WATERLOGGED, false));
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return state.m_60819_().m_76178_();
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.m_83040_();
   }

   public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.m_83110_(m_49796_(4.0D, -4.0D, 4.0D, 12.0D, -1.0D, 12.0D), m_49796_(6.0D, -1.0D, 6.0D, 10.0D, 1.0D, 10.0D));
   }

   protected void m_7926_(Builder<Block, BlockState> builder) {
      super.m_7926_(builder);
      builder.m_61104_(new Property[]{WATERLOGGED});
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      boolean flag = context.m_43725_().m_6425_(context.m_8083_()).m_76152_() == Fluids.f_76193_;
      return (BlockState)super.m_5573_(context).m_61124_(WATERLOGGED, flag);
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

   public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
      return new ItemStack((ItemLike)CrustyChunksModBlocks.LAND_MINE.get());
   }

   public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
      return BlockPathTypes.OPEN;
   }

   public void m_7892_(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.m_7892_(blockstate, world, pos, entity);
      AIMineTriggerProcedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), entity);
   }

   public void m_141947_(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
      super.m_141947_(world, pos, blockstate, entity);
      AIMineTriggerProcedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), entity);
   }

   static {
      WATERLOGGED = BlockStateProperties.f_61362_;
   }
}

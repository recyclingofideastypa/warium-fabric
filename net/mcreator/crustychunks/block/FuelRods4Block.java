package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.procedures.FuelRodsLoadProcedure;
import net.mcreator.crustychunks.procedures.MeltdownProcedure;
import net.mcreator.crustychunks.procedures.Rad1TickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FuelRods4Block extends Block {
   public FuelRods4Block() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_154663_).m_60978_(1.0F).m_60999_().m_60955_().m_60924_((bs, br, bp) -> {
         return false;
      }));
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
      return Shapes.m_83124_(m_49796_(3.0D, 0.0D, 3.0D, 5.0D, 3.0D, 5.0D), new VoxelShape[]{m_49796_(2.0D, 0.0D, 10.0D, 6.0D, 2.0D, 14.0D), m_49796_(3.0D, 0.0D, 11.0D, 5.0D, 3.0D, 13.0D), m_49796_(2.0D, 0.0D, 2.0D, 6.0D, 2.0D, 6.0D), m_49796_(11.0D, 0.0D, 11.0D, 13.0D, 3.0D, 13.0D), m_49796_(10.0D, 0.0D, 10.0D, 14.0D, 2.0D, 14.0D), m_49796_(11.0D, 0.0D, 3.0D, 13.0D, 3.0D, 5.0D), m_49796_(10.0D, 0.0D, 2.0D, 14.0D, 2.0D, 6.0D)});
   }

   public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
      return new ItemStack((ItemLike)CrustyChunksModBlocks.EMPTY_FUEL_RODS.get());
   }

   public void m_6807_(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.m_6807_(blockstate, world, pos, oldState, moving);
      world.m_186460_(pos, this, 30);
   }

   public void m_213897_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.m_213897_(blockstate, world, pos, random);
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      Rad1TickProcedure.execute(world, (double)x, (double)y, (double)z);
      world.m_186460_(pos, this, 30);
   }

   public void m_7592_(Level world, BlockPos pos, Explosion e) {
      super.m_7592_(world, pos, e);
      MeltdownProcedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
   }

   public InteractionResult m_6227_(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.m_6227_(blockstate, world, pos, entity, hand, hit);
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      double hitX = hit.m_82450_().f_82479_;
      double hitY = hit.m_82450_().f_82480_;
      double hitZ = hit.m_82450_().f_82481_;
      Direction direction = hit.m_82434_();
      FuelRodsLoadProcedure.execute(world, (double)x, (double)y, (double)z, entity);
      return InteractionResult.SUCCESS;
   }
}

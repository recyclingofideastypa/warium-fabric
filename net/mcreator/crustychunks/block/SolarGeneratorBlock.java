package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.block.entity.SolarGeneratorBlockEntity;
import net.mcreator.crustychunks.procedures.SolarGeneratorTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SolarGeneratorBlock extends Block implements EntityBlock {
   public static final DirectionProperty FACING;

   public SolarGeneratorBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56749_).m_60913_(11.0F, 1.0F).m_60955_().m_60924_((bs, br, bp) -> {
         return false;
      }));
      this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(FACING, Direction.NORTH));
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
      VoxelShape var10000;
      switch((Direction)state.m_61143_(FACING)) {
      case NORTH:
         var10000 = Shapes.m_83124_(m_49796_(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D), new VoxelShape[]{m_49796_(6.0D, -2.0D, 6.0D, 10.0D, 0.0D, 10.0D), m_49796_(0.0D, 3.0D, 0.0D, 16.0D, 4.0D, 18.0D)});
         break;
      case EAST:
         var10000 = Shapes.m_83124_(m_49796_(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D), new VoxelShape[]{m_49796_(6.0D, -2.0D, 6.0D, 10.0D, 0.0D, 10.0D), m_49796_(-2.0D, 3.0D, 0.0D, 16.0D, 4.0D, 16.0D)});
         break;
      case WEST:
         var10000 = Shapes.m_83124_(m_49796_(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D), new VoxelShape[]{m_49796_(6.0D, -2.0D, 6.0D, 10.0D, 0.0D, 10.0D), m_49796_(0.0D, 3.0D, 0.0D, 18.0D, 4.0D, 16.0D)});
         break;
      default:
         var10000 = Shapes.m_83124_(m_49796_(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D), new VoxelShape[]{m_49796_(6.0D, -2.0D, 6.0D, 10.0D, 0.0D, 10.0D), m_49796_(0.0D, 3.0D, -2.0D, 16.0D, 4.0D, 16.0D)});
      }

      return var10000;
   }

   protected void m_7926_(Builder<Block, BlockState> builder) {
      super.m_7926_(builder);
      builder.m_61104_(new Property[]{FACING});
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      return (BlockState)super.m_5573_(context).m_61124_(FACING, context.m_8125_().m_122424_());
   }

   public BlockState m_6843_(BlockState state, Rotation rot) {
      return (BlockState)state.m_61124_(FACING, rot.m_55954_((Direction)state.m_61143_(FACING)));
   }

   public BlockState m_6943_(BlockState state, Mirror mirrorIn) {
      return state.m_60717_(mirrorIn.m_54846_((Direction)state.m_61143_(FACING)));
   }

   public void m_6807_(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.m_6807_(blockstate, world, pos, oldState, moving);
      world.m_186460_(pos, this, 20);
   }

   public void m_213897_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.m_213897_(blockstate, world, pos, random);
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      SolarGeneratorTickProcedure.execute(world, (double)x, (double)y, (double)z);
      world.m_186460_(pos, this, 20);
   }

   public MenuProvider m_7246_(BlockState state, Level worldIn, BlockPos pos) {
      BlockEntity tileEntity = worldIn.m_7702_(pos);
      MenuProvider var10000;
      if (tileEntity instanceof MenuProvider) {
         MenuProvider menuProvider = (MenuProvider)tileEntity;
         var10000 = menuProvider;
      } else {
         var10000 = null;
      }

      return var10000;
   }

   public BlockEntity m_142194_(BlockPos pos, BlockState state) {
      return new SolarGeneratorBlockEntity(pos, state);
   }

   public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.m_8133_(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.m_7702_(pos);
      return blockEntity == null ? false : blockEntity.m_7531_(eventID, eventParam);
   }

   public void m_6810_(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.m_60734_() != newState.m_60734_()) {
         BlockEntity blockEntity = world.m_7702_(pos);
         if (blockEntity instanceof SolarGeneratorBlockEntity) {
            SolarGeneratorBlockEntity be = (SolarGeneratorBlockEntity)blockEntity;
            Containers.m_19002_(world, pos, be);
            world.m_46717_(pos, this);
         }

         super.m_6810_(state, world, pos, newState, isMoving);
      }

   }

   public boolean m_7278_(BlockState state) {
      return true;
   }

   public int m_6782_(BlockState blockState, Level world, BlockPos pos) {
      BlockEntity tileentity = world.m_7702_(pos);
      if (tileentity instanceof SolarGeneratorBlockEntity) {
         SolarGeneratorBlockEntity be = (SolarGeneratorBlockEntity)tileentity;
         return AbstractContainerMenu.m_38938_(be);
      } else {
         return 0;
      }
   }

   static {
      FACING = HorizontalDirectionalBlock.f_54117_;
   }
}

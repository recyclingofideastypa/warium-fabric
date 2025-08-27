package net.mcreator.crustychunks.block;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.block.entity.RACBarrelTileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RACBarrelBlock extends BaseEntityBlock implements EntityBlock {
   public static final IntegerProperty ANIMATION = IntegerProperty.m_61631_("animation", 0, 4);
   public static final DirectionProperty FACING;

   public RACBarrelBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56749_).m_60913_(1.0F, 10.0F).m_60955_().m_60924_((bs, br, bp) -> {
         return false;
      }));
      this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(FACING, Direction.NORTH));
   }

   public RenderShape m_7514_(BlockState state) {
      return RenderShape.ENTITYBLOCK_ANIMATED;
   }

   @Nullable
   public BlockEntity m_142194_(BlockPos blockPos, BlockState blockState) {
      return ((BlockEntityType)CrustyChunksModBlockEntities.RAC_BARREL.get()).m_155264_(blockPos, blockState);
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      VoxelShape var10000;
      switch((Direction)state.m_61143_(FACING)) {
      case NORTH:
         var10000 = m_49796_(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 16.0D);
         break;
      case EAST:
         var10000 = m_49796_(0.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D);
         break;
      case WEST:
         var10000 = m_49796_(0.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D);
         break;
      default:
         var10000 = m_49796_(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 16.0D);
      }

      return var10000;
   }

   protected void m_7926_(Builder<Block, BlockState> builder) {
      builder.m_61104_(new Property[]{ANIMATION, FACING});
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      return (BlockState)this.m_49966_().m_61124_(FACING, context.m_8125_().m_122424_());
   }

   public BlockState m_6843_(BlockState state, Rotation rot) {
      return (BlockState)state.m_61124_(FACING, rot.m_55954_((Direction)state.m_61143_(FACING)));
   }

   public BlockState m_6943_(BlockState state, Mirror mirrorIn) {
      return state.m_60717_(mirrorIn.m_54846_((Direction)state.m_61143_(FACING)));
   }

   public List<ItemStack> m_49635_(BlockState state, net.minecraft.world.level.storage.loot.LootParams.Builder builder) {
      List<ItemStack> dropsOriginal = super.m_49635_(state, builder);
      return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, 1));
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

   public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.m_8133_(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.m_7702_(pos);
      return blockEntity == null ? false : blockEntity.m_7531_(eventID, eventParam);
   }

   public void m_6810_(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.m_60734_() != newState.m_60734_()) {
         BlockEntity blockEntity = world.m_7702_(pos);
         if (blockEntity instanceof RACBarrelTileEntity) {
            RACBarrelTileEntity be = (RACBarrelTileEntity)blockEntity;
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
      if (tileentity instanceof RACBarrelTileEntity) {
         RACBarrelTileEntity be = (RACBarrelTileEntity)tileentity;
         return AbstractContainerMenu.m_38938_(be);
      } else {
         return 0;
      }
   }

   static {
      FACING = HorizontalDirectionalBlock.f_54117_;
   }
}

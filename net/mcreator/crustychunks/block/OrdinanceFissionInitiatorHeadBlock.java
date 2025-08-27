package net.mcreator.crustychunks.block;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OrdinanceFissionInitiatorHeadBlock extends Block {
   public static final DirectionProperty FACING;
   public static final EnumProperty<AttachFace> FACE;

   public OrdinanceFissionInitiatorHeadBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56749_).m_60913_(1.0F, 5.0F).m_60955_().m_60924_((bs, br, bp) -> {
         return false;
      }));
      this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(FACING, Direction.NORTH)).m_61124_(FACE, AttachFace.WALL));
   }

   public void m_5871_(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.m_5871_(itemstack, level, list, flag);
      list.add(Component.m_237115_("block.crusty_chunks.ordinance_fission_initiator_head.description_0"));
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
         switch((AttachFace)state.m_61143_(FACE)) {
         case FLOOR:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), m_49796_(5.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D));
            return var10000;
         case WALL:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 2.0D, 2.0D, 14.0D, 14.0D, 16.0D), m_49796_(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 2.0D));
            return var10000;
         case CEILING:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 2.0D, 2.0D, 14.0D, 16.0D, 14.0D), m_49796_(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D));
            return var10000;
         default:
            throw new IncompatibleClassChangeError();
         }
      case EAST:
         switch((AttachFace)state.m_61143_(FACE)) {
         case FLOOR:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), m_49796_(5.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D));
            return var10000;
         case WALL:
            var10000 = Shapes.m_83110_(m_49796_(0.0D, 2.0D, 2.0D, 14.0D, 14.0D, 14.0D), m_49796_(14.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D));
            return var10000;
         case CEILING:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 2.0D, 2.0D, 14.0D, 16.0D, 14.0D), m_49796_(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D));
            return var10000;
         default:
            throw new IncompatibleClassChangeError();
         }
      case WEST:
         switch((AttachFace)state.m_61143_(FACE)) {
         case FLOOR:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), m_49796_(5.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D));
            return var10000;
         case WALL:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 2.0D, 2.0D, 16.0D, 14.0D, 14.0D), m_49796_(0.0D, 5.0D, 5.0D, 2.0D, 11.0D, 11.0D));
            return var10000;
         case CEILING:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 2.0D, 2.0D, 14.0D, 16.0D, 14.0D), m_49796_(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D));
            return var10000;
         default:
            throw new IncompatibleClassChangeError();
         }
      default:
         switch((AttachFace)state.m_61143_(FACE)) {
         case FLOOR:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), m_49796_(5.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D));
            break;
         case WALL:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 2.0D, 0.0D, 14.0D, 14.0D, 14.0D), m_49796_(5.0D, 5.0D, 14.0D, 11.0D, 11.0D, 16.0D));
            break;
         case CEILING:
            var10000 = Shapes.m_83110_(m_49796_(2.0D, 2.0D, 2.0D, 14.0D, 16.0D, 14.0D), m_49796_(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D));
            break;
         default:
            throw new IncompatibleClassChangeError();
         }
      }

      return var10000;
   }

   protected void m_7926_(Builder<Block, BlockState> builder) {
      super.m_7926_(builder);
      builder.m_61104_(new Property[]{FACING, FACE});
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      return (BlockState)((BlockState)super.m_5573_(context).m_61124_(FACE, this.faceForDirection(context.m_7820_()))).m_61124_(FACING, context.m_8125_().m_122424_());
   }

   public BlockState m_6843_(BlockState state, Rotation rot) {
      return (BlockState)state.m_61124_(FACING, rot.m_55954_((Direction)state.m_61143_(FACING)));
   }

   public BlockState m_6943_(BlockState state, Mirror mirrorIn) {
      return state.m_60717_(mirrorIn.m_54846_((Direction)state.m_61143_(FACING)));
   }

   private AttachFace faceForDirection(Direction direction) {
      if (direction.m_122434_() == Axis.Y) {
         return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
      } else {
         return AttachFace.WALL;
      }
   }

   static {
      FACING = HorizontalDirectionalBlock.f_54117_;
      FACE = FaceAttachedHorizontalDirectionalBlock.f_53179_;
   }
}

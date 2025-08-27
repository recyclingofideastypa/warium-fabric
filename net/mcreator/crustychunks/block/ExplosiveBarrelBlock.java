package net.mcreator.crustychunks.block;

import java.util.List;
import net.mcreator.crustychunks.procedures.ExplosiveBarrelTriggerProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
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
import net.minecraft.world.phys.BlockHitResult;

public class ExplosiveBarrelBlock extends Block {
   public static final DirectionProperty FACING;
   public static final EnumProperty<AttachFace> FACE;

   public ExplosiveBarrelBlock() {
      super(Properties.m_284310_().m_278183_().m_280658_(NoteBlockInstrument.BASS).m_60918_(SoundType.f_56736_).m_60913_(1.0F, 4.0F));
      this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(FACING, Direction.NORTH)).m_61124_(FACE, AttachFace.WALL));
   }

   public void m_5871_(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.m_5871_(itemstack, level, list, flag);
      list.add(Component.m_237115_("block.crusty_chunks.explosive_barrel.description_0"));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
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

   public void m_6861_(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
      super.m_6861_(blockstate, world, pos, neighborBlock, fromPos, moving);
      if (world.m_277086_(pos) > 0) {
         ExplosiveBarrelTriggerProcedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
      }

   }

   public void m_7592_(Level world, BlockPos pos, Explosion e) {
      super.m_7592_(world, pos, e);
      ExplosiveBarrelTriggerProcedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
   }

   public void m_5581_(Level world, BlockState blockstate, BlockHitResult hit, Projectile entity) {
      ExplosiveBarrelTriggerProcedure.execute(world, (double)hit.m_82425_().m_123341_(), (double)hit.m_82425_().m_123342_(), (double)hit.m_82425_().m_123343_());
   }

   static {
      FACING = HorizontalDirectionalBlock.f_54117_;
      FACE = FaceAttachedHorizontalDirectionalBlock.f_53179_;
   }
}

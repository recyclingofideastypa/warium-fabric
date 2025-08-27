package net.mcreator.crustychunks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;

public class GiantCoilBlock extends Block {
   public static final EnumProperty<Axis> AXIS;

   public GiantCoilBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56749_).m_60978_(1.0F));
      this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(AXIS, Axis.Y));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   protected void m_7926_(Builder<Block, BlockState> builder) {
      super.m_7926_(builder);
      builder.m_61104_(new Property[]{AXIS});
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      return (BlockState)super.m_5573_(context).m_61124_(AXIS, context.m_43719_().m_122434_());
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

   static {
      AXIS = BlockStateProperties.f_61365_;
   }
}

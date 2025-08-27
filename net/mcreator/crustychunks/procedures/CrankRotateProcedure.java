package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class CrankRotateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      Property var9 = blockstate.m_60734_().m_49965_().m_61081_("positioned");
      if (var9 instanceof BooleanProperty) {
         BooleanProperty _getbp1 = (BooleanProperty)var9;
         if ((Boolean)blockstate.m_61143_(_getbp1)) {
            return;
         }
      }

      BlockPos _pos = BlockPos.m_274561_(x, y, z);
      BlockState _bs = world.m_8055_(_pos);
      Property var12 = _bs.m_60734_().m_49965_().m_61081_("positioned");
      if (var12 instanceof BooleanProperty) {
         BooleanProperty _booleanProp = (BooleanProperty)var12;
         world.m_7731_(_pos, (BlockState)_bs.m_61124_(_booleanProp, true), 3);
      }

      CrustyChunksMod.queueServerWork(1, () -> {
         Direction _dir = ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               BlockState _bs = world.m_8055_(pos);
               Property<?> property = _bs.m_60734_().m_49965_().m_61081_("facing");
               if (property != null) {
                  Comparable var5 = _bs.m_61143_(property);
                  if (var5 instanceof Direction) {
                     Direction _dir = (Direction)var5;
                     return _dir;
                  }
               }

               if (_bs.m_61138_(BlockStateProperties.f_61365_)) {
                  return Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61365_), AxisDirection.POSITIVE);
               } else {
                  return _bs.m_61138_(BlockStateProperties.f_61364_) ? Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61364_), AxisDirection.POSITIVE) : Direction.NORTH;
               }
            }
         })).getDirection(BlockPos.m_274561_(x, y, z)).m_175362_(Axis.Y).m_175362_(Axis.Y);
         BlockPos _pos = BlockPos.m_274561_(x, y, z);
         BlockState _bs = world.m_8055_(_pos);
         Property<?> _property = _bs.m_60734_().m_49965_().m_61081_("facing");
         if (_property instanceof DirectionProperty) {
            DirectionProperty _dp = (DirectionProperty)_property;
            if (_dp.m_6908_().contains(_dir)) {
               world.m_7731_(_pos, (BlockState)_bs.m_61124_(_dp, _dir), 3);
               return;
            }
         }

         _property = _bs.m_60734_().m_49965_().m_61081_("axis");
         if (_property instanceof EnumProperty) {
            EnumProperty _ap = (EnumProperty)_property;
            if (_ap.m_6908_().contains(_dir.m_122434_())) {
               world.m_7731_(_pos, (BlockState)_bs.m_61124_(_ap, _dir.m_122434_()), 3);
            }
         }

      });
   }
}

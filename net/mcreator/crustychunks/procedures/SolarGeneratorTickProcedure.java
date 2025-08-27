package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SolarGeneratorTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Kinetic = 0.0D;
      if (!world.m_5776_()) {
         BlockPos _bp = BlockPos.m_274561_(x, y, z);
         BlockEntity _blockEntity = world.m_7702_(_bp);
         BlockState _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128347_("Capacity", 5.0D);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

      if (world instanceof Level) {
         Level _lvl1 = (Level)world;
         if (_lvl1.m_46461_() && world.m_46861_(BlockPos.m_274561_(x, y, z)) && ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y - 1.0D, z), "Energy") < ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y - 1.0D, z), "Capacity") && !world.m_5776_()) {
            BlockPos _bp = BlockPos.m_274561_(x, y - 1.0D, z);
            BlockEntity _blockEntity = world.m_7702_(_bp);
            BlockState _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Energy", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y - 1.0D, z), "Energy") + 1.0D);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }
      }

   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DamagableBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.STEEL_PLATING.get()) {
         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Damage", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") + 1.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") >= 50.0D) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.STEEL_PLATING_SLAB.get()) {
         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Damage", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") + 1.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") >= 50.0D) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.STEEL_PLATING_STAIRS.get()) {
         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Damage", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") + 1.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") >= 50.0D) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.STEEL_BLOCK.get()) {
         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Damage", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") + 1.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") >= 50.0D) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.STEEL_BLOCK.get()) {
         if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Damage", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") + 1.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Damage") >= 50.0D) {
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }
      }

   }
}

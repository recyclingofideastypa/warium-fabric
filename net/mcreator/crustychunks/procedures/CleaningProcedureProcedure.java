package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class CleaningProcedureProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockPos _bp;
      BlockState _bs;
      BlockState _bso;
      UnmodifiableIterator var10;
      Entry entry;
      Property _property;
      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50079_) {
         _bp = BlockPos.m_274561_(x, y, z);
         _bs = Blocks.f_50652_.m_49966_();
         _bso = world.m_8055_(_bp);
         var10 = _bso.m_61148_().entrySet().iterator();

         while(var10.hasNext()) {
            entry = (Entry)var10.next();
            _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
            if (_property != null && _bs.m_61143_(_property) != null) {
               try {
                  _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
               } catch (Exception var16) {
               }
            }
         }

         world.m_7731_(_bp, _bs, 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50223_) {
         _bp = BlockPos.m_274561_(x, y, z);
         _bs = Blocks.f_50222_.m_49966_();
         _bso = world.m_8055_(_bp);
         var10 = _bso.m_61148_().entrySet().iterator();

         while(var10.hasNext()) {
            entry = (Entry)var10.next();
            _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
            if (_property != null && _bs.m_61143_(_property) != null) {
               try {
                  _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
               } catch (Exception var15) {
               }
            }
         }

         world.m_7731_(_bp, _bs, 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.OVERGROWN_REENFORCED_CONCRETE.get()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _bs = ((Block)CrustyChunksModBlocks.REENFORCED_CONCRETE.get()).m_49966_();
         _bso = world.m_8055_(_bp);
         var10 = _bso.m_61148_().entrySet().iterator();

         while(var10.hasNext()) {
            entry = (Entry)var10.next();
            _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
            if (_property != null && _bs.m_61143_(_property) != null) {
               try {
                  _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
               } catch (Exception var14) {
               }
            }
         }

         world.m_7731_(_bp, _bs, 3);
      }

   }
}

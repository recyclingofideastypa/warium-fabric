package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class EradicatorMeleeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      int horizontalRadiusSquare = 5;
      int verticalRadiusSquare = 3;
      int yIterationsSquare = verticalRadiusSquare;

      for(int i = -verticalRadiusSquare; i <= yIterationsSquare; ++i) {
         for(int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; ++xi) {
            for(int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; ++zi) {
               if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 4.0D, z + (double)zi)).m_60800_(world, BlockPos.m_274561_(x + (double)xi, y + (double)i + 4.0D, z + (double)zi)) < 5.0F && world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 4.0D, z + (double)zi)).m_60800_(world, BlockPos.m_274561_(x + (double)xi, y + (double)i + 4.0D, z + (double)zi)) >= 0.0F || world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 4.0D, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:chippable"))) || world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 4.0D, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:concrete")))) {
                  world.m_7731_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 4.0D, z + (double)zi), Blocks.f_50016_.m_49966_(), 3);
               }

               if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)).m_60734_() == CrustyChunksModBlocks.STRUCTURAL_CONCRETE.get()) {
                  BlockPos _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi);
                  BlockState _bs = ((Block)CrustyChunksModBlocks.REENFORCED_CONCRETE.get()).m_49966_();
                  BlockState _bso = world.m_8055_(_bp);
                  UnmodifiableIterator var16 = _bso.m_61148_().entrySet().iterator();

                  while(var16.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entry = (Entry)var16.next();
                     Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var20) {
                        }
                     }
                  }

                  world.m_7731_(_bp, _bs, 3);
               }

               if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:chippable"))) || world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:splinterable")))) {
                  world.m_7731_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi), Blocks.f_50016_.m_49966_(), 3);
               }
            }
         }
      }

   }
}

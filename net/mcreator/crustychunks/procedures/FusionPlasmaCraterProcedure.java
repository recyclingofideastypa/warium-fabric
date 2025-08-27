package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class FusionPlasmaCraterProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      int horizontalRadiusSphere = 89;
      int verticalRadiusSphere = 19;
      int yIterationsSphere = verticalRadiusSphere;

      for(int i = -verticalRadiusSphere; i <= yIterationsSphere; ++i) {
         for(int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; ++xi) {
            for(int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; ++zi) {
               double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere) + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere) + (double)(zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
               if (distanceSq <= 1.0D && !world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:immortal")))) {
                  BlockPos _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                  BlockState _bs = Blocks.f_50083_.m_49966_();
                  BlockState _bso = world.m_8055_(_bp);
                  UnmodifiableIterator var18 = _bso.m_61148_().entrySet().iterator();

                  while(var18.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entry = (Entry)var18.next();
                     Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var26) {
                        }
                     }
                  }

                  world.m_7731_(_bp, _bs, 3);
               }
            }
         }
      }

      int horizontalRadiusHemiTop = 89;
      int verticalRadiusHemiTop = 90;
      int yIterationsHemiTop = verticalRadiusHemiTop;

      for(int i = 0; i < yIterationsHemiTop; ++i) {
         if (i != verticalRadiusHemiTop) {
            for(int xi = -horizontalRadiusHemiTop; xi <= horizontalRadiusHemiTop; ++xi) {
               for(int zi = -horizontalRadiusHemiTop; zi <= horizontalRadiusHemiTop; ++zi) {
                  double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusHemiTop * horizontalRadiusHemiTop) + (double)(i * i) / (double)(verticalRadiusHemiTop * verticalRadiusHemiTop) + (double)(zi * zi) / (double)(horizontalRadiusHemiTop * horizontalRadiusHemiTop);
                  if (distanceSq <= 1.0D && !world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:immortal")))) {
                     BlockPos _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                     BlockState _bs = Blocks.f_50083_.m_49966_();
                     BlockState _bso = world.m_8055_(_bp);
                     UnmodifiableIterator var21 = _bso.m_61148_().entrySet().iterator();

                     while(var21.hasNext()) {
                        Entry<Property<?>, Comparable<?>> entry = (Entry)var21.next();
                        Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                        if (_property != null && _bs.m_61143_(_property) != null) {
                           try {
                              _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                           } catch (Exception var25) {
                           }
                        }
                     }

                     world.m_7731_(_bp, _bs, 3);
                  }
               }
            }
         }
      }

   }
}

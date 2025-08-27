package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class MassBurnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      CleaningProcedureProcedure.execute(world, x, y, z);
      BlockPos _bp;
      BlockState _bs;
      BlockState _bso;
      UnmodifiableIterator var10;
      Entry entry;
      Property _property;
      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50440_ && !ModList.get().isLoaded("burnt")) {
         _bp = BlockPos.m_274561_(x, y, z);
         _bs = ((Block)CrustyChunksModBlocks.BURNTGRASS.get()).m_49966_();
         _bso = world.m_8055_(_bp);
         var10 = _bso.m_61148_().entrySet().iterator();

         while(var10.hasNext()) {
            entry = (Entry)var10.next();
            _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
            if (_property != null && _bs.m_61143_(_property) != null) {
               try {
                  _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
               } catch (Exception var18) {
               }
            }
         }

         world.m_7731_(_bp, _bs, 3);
         if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() == Blocks.f_50016_) {
            _bp = BlockPos.m_274561_(x, y + 1.0D, z);
            _bs = Blocks.f_50083_.m_49966_();
            _bso = world.m_8055_(_bp);
            var10 = _bso.m_61148_().entrySet().iterator();

            while(var10.hasNext()) {
               entry = (Entry)var10.next();
               _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
               if (_property != null && _bs.m_61143_(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                  } catch (Exception var17) {
                  }
               }
            }

            world.m_7731_(_bp, _bs, 3);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:burnable"))) && !ModList.get().isLoaded("burnt")) {
         _bp = BlockPos.m_274561_(x, y, z);
         _bs = ((Block)CrustyChunksModBlocks.CHARRED_BLOCK.get()).m_49966_();
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
         if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() == Blocks.f_50016_) {
            _bp = BlockPos.m_274561_(x, y + 1.0D, z);
            _bs = Blocks.f_50083_.m_49966_();
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
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:inceneratable")))) {
         _bp = BlockPos.m_274561_(x, y, z);
         _bs = Blocks.f_50083_.m_49966_();
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

      if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 30)) {
         if (!ModList.get().isLoaded("burnt")) {
            if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() != Blocks.f_50016_ && world.m_46861_(BlockPos.m_274561_(x, y, z)) && world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() == Blocks.f_50016_) {
               CrustyChunksMod.queueServerWork(1, () -> {
                  BlockPos _bp = BlockPos.m_274561_(x, y + 1.0D, z);
                  BlockState _bs = Blocks.f_50083_.m_49966_();
                  BlockState _bso = world.m_8055_(_bp);
                  UnmodifiableIterator var10 = _bso.m_61148_().entrySet().iterator();

                  while(var10.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entry = (Entry)var10.next();
                     Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var14) {
                        }
                     }
                  }

                  world.m_7731_(_bp, _bs, 3);
               });
            }
         } else if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() != Blocks.f_50016_ && world.m_46861_(BlockPos.m_274561_(x, y, z)) && world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() == Blocks.f_50016_) {
            CrustyChunksMod.queueServerWork(1, () -> {
               BlockPos _bp = BlockPos.m_274561_(x, y + 1.0D, z);
               BlockState _bs = ((Block)ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("crusty_chunks:firestarter"))).getRandomElement(RandomSource.m_216327_()).orElseGet(() -> {
                  return Blocks.f_50016_;
               })).m_49966_();
               BlockState _bso = world.m_8055_(_bp);
               UnmodifiableIterator var10 = _bso.m_61148_().entrySet().iterator();

               while(var10.hasNext()) {
                  Entry<Property<?>, Comparable<?>> entry = (Entry)var10.next();
                  Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                  if (_property != null && _bs.m_61143_(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                     } catch (Exception var14) {
                     }
                  }
               }

               world.m_7731_(_bp, _bs, 3);
            });
         }
      }

   }
}

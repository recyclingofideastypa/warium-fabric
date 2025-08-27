package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class FissionEffectsProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double loop = 0.0D;
      CrustyChunksMod.queueServerWork(1, () -> {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rumble")), SoundSource.NEUTRAL, 100.0F, 1.2F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rumble")), SoundSource.NEUTRAL, 100.0F, 1.2F, false);
            }
         }

         PlasmaCraterProcedure.execute(world, x, y, z);
         ScorchProcedure.execute(world, x, y, z);
         int horizontalRadiusSphere = 119;
         int verticalRadiusSphere = 39;
         int yIterationsSphere = verticalRadiusSphere;

         for(int i = -verticalRadiusSphere; i <= yIterationsSphere; ++i) {
            for(int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; ++xi) {
               for(int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; ++zi) {
                  double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere) + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere) + (double)(zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
                  if (distanceSq <= 1.0D) {
                     BlockPos _bp;
                     BlockState _bs;
                     BlockState _bso;
                     UnmodifiableIterator var18;
                     Entry entry;
                     Property _property;
                     if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60734_() != Blocks.f_50440_ && world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60734_() != Blocks.f_152544_) {
                        MassBurnBlockProcedure.execute(world, x + (double)xi, y + (double)i, z + (double)zi);
                     } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, 100) == 1) {
                        _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = ((Block)CrustyChunksModBlocks.RADIOACTIVE_ASH_FULL_BLOCK.get()).m_49966_();
                        _bso = world.m_8055_(_bp);
                        var18 = _bso.m_61148_().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                           if (_property != null && _bs.m_61143_(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                              } catch (Exception var28) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     } else if ((double)Mth.m_216271_(RandomSource.m_216327_(), 100, 120) > Math.sqrt(Math.pow(Math.abs(x + (double)xi - x), 2.0D) + Math.pow(Math.abs(z + (double)zi - z), 2.0D)) && world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60815_()) {
                        MassBurnBlockProcedure.execute(world, x + (double)xi, y + (double)i, z + (double)zi);
                     }

                     if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:sands")))) {
                        if (!world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60815_() && Mth.m_216271_(RandomSource.m_216327_(), 1, 100) == 1) {
                           _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                           _bs = ((Block)CrustyChunksModBlocks.RADIOACTIVE_ASH_FULL_BLOCK.get()).m_49966_();
                           _bso = world.m_8055_(_bp);
                           var18 = _bso.m_61148_().entrySet().iterator();

                           while(var18.hasNext()) {
                              entry = (Entry)var18.next();
                              _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                              if (_property != null && _bs.m_61143_(_property) != null) {
                                 try {
                                    _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                                 } catch (Exception var27) {
                                 }
                              }
                           }

                           world.m_7731_(_bp, _bs, 3);
                        }

                        if ((double)Mth.m_216271_(RandomSource.m_216327_(), 50, 120) > Math.sqrt(Math.pow(Math.abs(x + (double)xi - x), 2.0D) + Math.pow(Math.abs(z + (double)zi - z), 2.0D)) && world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).m_60734_() == Blocks.f_50016_) {
                           if (Mth.m_216271_(RandomSource.m_216327_(), 1, 3) == 1) {
                              _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                              _bs = ((Block)CrustyChunksModBlocks.TRINITITE.get()).m_49966_();
                              _bso = world.m_8055_(_bp);
                              var18 = _bso.m_61148_().entrySet().iterator();

                              while(var18.hasNext()) {
                                 entry = (Entry)var18.next();
                                 _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                                 if (_property != null && _bs.m_61143_(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                                    } catch (Exception var26) {
                                    }
                                 }
                              }

                              world.m_7731_(_bp, _bs, 3);
                           } else {
                              _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                              _bs = Blocks.f_152496_.m_49966_();
                              _bso = world.m_8055_(_bp);
                              var18 = _bso.m_61148_().entrySet().iterator();

                              while(var18.hasNext()) {
                                 entry = (Entry)var18.next();
                                 _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
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

                     if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60734_() == Blocks.f_50125_) {
                        _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.f_50016_.m_49966_();
                        _bso = world.m_8055_(_bp);
                        var18 = _bso.m_61148_().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                           if (_property != null && _bs.m_61143_(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                              } catch (Exception var24) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     }

                     if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60734_() == Blocks.f_50127_) {
                        _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.f_50016_.m_49966_();
                        _bso = world.m_8055_(_bp);
                        var18 = _bso.m_61148_().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                           if (_property != null && _bs.m_61143_(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                              } catch (Exception var23) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     }

                     if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60734_() == Blocks.f_50126_) {
                        _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.f_49990_.m_49966_();
                        _bso = world.m_8055_(_bp);
                        var18 = _bso.m_61148_().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                           if (_property != null && _bs.m_61143_(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                              } catch (Exception var22) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     }
                  }
               }
            }
         }

      });
      Level _level;
      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_254849_((Entity)null, x, y + 4.0D, z, 30.0F, ExplosionInteraction.BLOCK);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_254849_((Entity)null, x, y + 4.0D, z, 40.0F, ExplosionInteraction.NONE);
         }
      }

      Iterator var11 = (new ArrayList(world.m_6907_())).iterator();

      while(var11.hasNext()) {
         Entity entityiterator = (Entity)var11.next();
         CrustyChunksMod.queueServerWork((int)Math.abs(Math.round(Math.sqrt(Math.pow(x - entityiterator.m_20185_(), 2.0D) + Math.pow(z - entityiterator.m_20189_(), 2.0D)) * 0.5D)), () -> {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:fissionblast")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:fissionblast")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

         });
      }

   }
}

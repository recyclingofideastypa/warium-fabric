package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class FusionScorchProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Vec3 _center = new Vec3(x, y, z);
      List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(90.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.m_20238_(_center);
      })).toList();
      Iterator var9 = _entfound.iterator();

      while(var9.hasNext()) {
         Entity entityiterator = (Entity)var9.next();
         entityiterator.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("crusty_chunks:vaporized")))), 5000.0F);
         entityiterator.m_20254_(30);
      }

      int horizontalRadiusSphere = 94;
      int verticalRadiusSphere = 24;
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
                  if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:crushable"))) || world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:stone")))) {
                     if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 50) && !world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).m_60815_()) {
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
                              } catch (Exception var36) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     } else if ((double)Mth.m_216271_(RandomSource.m_216327_(), 15, 40) > Math.sqrt(Math.pow(Math.abs(x + (double)xi - x), 2.0D) + Math.pow(Math.abs(z + (double)zi - z), 2.0D))) {
                        _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.f_50080_.m_49966_();
                        _bso = world.m_8055_(_bp);
                        var18 = _bso.m_61148_().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                           if (_property != null && _bs.m_61143_(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                              } catch (Exception var35) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     } else if ((double)Mth.m_216271_(RandomSource.m_216327_(), 40, 50) > Math.sqrt(Math.pow(Math.abs(x + (double)xi - x), 2.0D) + Math.pow(Math.abs(z + (double)zi - z), 2.0D))) {
                        _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.f_50730_.m_49966_();
                        _bso = world.m_8055_(_bp);
                        var18 = _bso.m_61148_().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                           if (_property != null && _bs.m_61143_(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                              } catch (Exception var34) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     } else if ((double)Mth.m_216271_(RandomSource.m_216327_(), 50, 60) > Math.sqrt(Math.pow(Math.abs(x + (double)xi - x), 2.0D) + Math.pow(Math.abs(z + (double)zi - z), 2.0D))) {
                        if (Math.random() < 0.5D) {
                           _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                           _bs = Blocks.f_50730_.m_49966_();
                           _bso = world.m_8055_(_bp);
                           var18 = _bso.m_61148_().entrySet().iterator();

                           while(var18.hasNext()) {
                              entry = (Entry)var18.next();
                              _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                              if (_property != null && _bs.m_61143_(_property) != null) {
                                 try {
                                    _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                                 } catch (Exception var33) {
                                 }
                              }
                           }

                           world.m_7731_(_bp, _bs, 3);
                        } else {
                           _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                           _bs = Blocks.f_152597_.m_49966_();
                           _bso = world.m_8055_(_bp);
                           var18 = _bso.m_61148_().entrySet().iterator();

                           while(var18.hasNext()) {
                              entry = (Entry)var18.next();
                              _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                              if (_property != null && _bs.m_61143_(_property) != null) {
                                 try {
                                    _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                                 } catch (Exception var32) {
                                 }
                              }
                           }

                           world.m_7731_(_bp, _bs, 3);
                        }
                     } else if ((double)Mth.m_216271_(RandomSource.m_216327_(), 60, 70) > Math.sqrt(Math.pow(Math.abs(x + (double)xi - x), 2.0D) + Math.pow(Math.abs(z + (double)zi - z), 2.0D))) {
                        if (Math.random() < 0.5D) {
                           _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                           _bs = Blocks.f_152551_.m_49966_();
                           _bso = world.m_8055_(_bp);
                           var18 = _bso.m_61148_().entrySet().iterator();

                           while(var18.hasNext()) {
                              entry = (Entry)var18.next();
                              _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                              if (_property != null && _bs.m_61143_(_property) != null) {
                                 try {
                                    _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                                 } catch (Exception var31) {
                                 }
                              }
                           }

                           world.m_7731_(_bp, _bs, 3);
                        } else {
                           _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                           _bs = Blocks.f_152597_.m_49966_();
                           _bso = world.m_8055_(_bp);
                           var18 = _bso.m_61148_().entrySet().iterator();

                           while(var18.hasNext()) {
                              entry = (Entry)var18.next();
                              _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                              if (_property != null && _bs.m_61143_(_property) != null) {
                                 try {
                                    _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                                 } catch (Exception var30) {
                                 }
                              }
                           }

                           world.m_7731_(_bp, _bs, 3);
                        }
                     } else if (Math.random() < 0.5D) {
                        _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.f_152551_.m_49966_();
                        _bso = world.m_8055_(_bp);
                        var18 = _bso.m_61148_().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                           if (_property != null && _bs.m_61143_(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                              } catch (Exception var29) {
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
                              } catch (Exception var28) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     }
                  }

                  if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:dirts")))) {
                     if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 50) && !world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).m_60815_()) {
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
                     } else if (Math.random() < 0.5D) {
                        _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.f_220843_.m_49966_();
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
                        _bs = Blocks.f_50352_.m_49966_();
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

                  if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:sands")))) {
                     if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 50) && !world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).m_60815_()) {
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
                              } catch (Exception var24) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     } else if (Math.random() < 0.5D) {
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
                              } catch (Exception var23) {
                              }
                           }
                        }

                        world.m_7731_(_bp, _bs, 3);
                     } else {
                        _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.f_152551_.m_49966_();
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
      }

   }
}

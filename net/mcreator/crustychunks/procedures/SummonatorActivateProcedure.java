package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class SummonatorActivateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.m_8767_(ParticleTypes.f_235902_, x, y, z, 15, 3.0D, 3.0D, 3.0D, 1.0D);
      }

      int horizontalRadiusSquare = 49;
      int verticalRadiusSquare = 49;
      int yIterationsSquare = verticalRadiusSquare;

      for(int i = -verticalRadiusSquare; i <= yIterationsSquare; ++i) {
         for(int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; ++xi) {
            for(int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; ++zi) {
               BlockPos _bp;
               BlockState _bs;
               BlockState _bso;
               UnmodifiableIterator var16;
               Entry entry;
               Property _property;
               BlockEntity _be;
               CompoundTag _bnbt;
               if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60734_() == CrustyChunksModBlocks.ROBOT_CHUTE.get()) {
                  _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                  _bs = ((Block)CrustyChunksModBlocks.ACTIVE_ROBOT_CHUTE.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var16 = _bso.m_61148_().entrySet().iterator();

                  while(var16.hasNext()) {
                     entry = (Entry)var16.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var20) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var27) {
                        }
                     }
                  }
               }

               if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60734_() == CrustyChunksModBlocks.GAS_DISPENSER.get()) {
                  _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                  _bs = ((Block)CrustyChunksModBlocks.GAS_DISPENSER.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var16 = _bso.m_61148_().entrySet().iterator();

                  while(var16.hasNext()) {
                     entry = (Entry)var16.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var26) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var25) {
                        }
                     }
                  }
               }

               if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60734_() == CrustyChunksModBlocks.SUMMONATOR.get()) {
                  _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                  _bs = ((Block)CrustyChunksModBlocks.SUMMONATOR_ACTIVE.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var16 = _bso.m_61148_().entrySet().iterator();

                  while(var16.hasNext()) {
                     entry = (Entry)var16.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var24) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var23) {
                        }
                     }
                  }
               }

               if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi)).m_60734_() == CrustyChunksModBlocks.DEFENSE_CORE.get()) {
                  _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i, z + (double)zi);
                  _bs = ((Block)CrustyChunksModBlocks.DEFENSE_CORE.get()).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var16 = _bso.m_61148_().entrySet().iterator();

                  while(var16.hasNext()) {
                     entry = (Entry)var16.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var22) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.m_187480_();
                     _be.m_7651_();
                  }

                  world.m_7731_(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.m_7702_(_bp);
                     if (_be != null) {
                        try {
                           _be.m_142466_(_bnbt);
                        } catch (Exception var21) {
                        }
                     }
                  }
               }
            }
         }
      }

      ++CrustyChunksModVariables.MapVariables.get(world).Production;
      CrustyChunksModVariables.MapVariables.get(world).syncData(world);
   }
}

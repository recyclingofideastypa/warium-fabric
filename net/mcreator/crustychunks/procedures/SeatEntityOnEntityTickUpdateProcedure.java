package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SeatEntityOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.m_20160_()) {
            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         } else {
            Entity var9 = entity.m_146895_();
            ItemStack var10000;
            if (var9 instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)var9;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == CrustyChunksModItems.AIMER.get() || world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.MANUAL_AIMER.get()) {
               CrustyChunksMod.queueServerWork(1, () -> {
                  if (entity.m_20160_()) {
                     Entity patt1301$temp = entity.m_146895_();
                     ItemStack var10000;
                     if (patt1301$temp instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)patt1301$temp;
                        var10000 = _livEntxx.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() == CrustyChunksModItems.AIMER.get()) {
                        Entity patt1471$temp = entity.m_146895_();
                        if (patt1471$temp instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)patt1471$temp;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41784_().m_128471_("Mode")) {
                           Entity patt1972$temp = entity.m_146895_();
                           LivingEntity _livEntx;
                           if (patt1972$temp instanceof LivingEntity) {
                              _livEntx = (LivingEntity)patt1972$temp;
                              var10000 = _livEntx.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_("Pitch", (double)Math.min(Math.max(-22.0F, (entity.m_146895_().m_146909_() - entity.m_146909_()) * -1.0F), 45.0F));
                           if (180.0F < entity.m_146895_().m_146908_() - entity.m_146908_()) {
                              patt1972$temp = entity.m_146895_();
                              if (patt1972$temp instanceof LivingEntity) {
                                 _livEntx = (LivingEntity)patt1972$temp;
                                 var10000 = _livEntx.m_21205_();
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              var10000.m_41784_().m_128347_("Yaw", (double)Math.min(Math.max(-22.0F, (360.0F - (entity.m_146895_().m_146908_() - entity.m_146908_())) * -1.0F), 22.0F));
                           } else {
                              patt1972$temp = entity.m_146895_();
                              if (patt1972$temp instanceof LivingEntity) {
                                 _livEntx = (LivingEntity)patt1972$temp;
                                 var10000 = _livEntx.m_21205_();
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              var10000.m_41784_().m_128347_("Yaw", (double)Math.min(Math.max(-22.0F, entity.m_146895_().m_146908_() - entity.m_146908_()), 22.0F));
                           }
                        }
                     }

                     if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.MANUAL_AIMER.get()) {
                        BlockPos _bp;
                        BlockEntity _blockEntity;
                        BlockState _bs;
                        Level _level;
                        if (!world.m_5776_()) {
                           _bp = BlockPos.m_274561_(x, y, z);
                           _blockEntity = world.m_7702_(_bp);
                           _bs = world.m_8055_(_bp);
                           if (_blockEntity != null) {
                              _blockEntity.getPersistentData().m_128347_("Pitch", (double)Math.min(Math.max(-22.0F, (entity.m_146895_().m_146909_() - entity.m_146909_()) * -1.0F), 45.0F));
                           }

                           if (world instanceof Level) {
                              _level = (Level)world;
                              _level.m_7260_(_bp, _bs, _bs, 3);
                           }
                        }

                        if (!world.m_5776_()) {
                           _bp = BlockPos.m_274561_(x, y, z);
                           _blockEntity = world.m_7702_(_bp);
                           _bs = world.m_8055_(_bp);
                           if (_blockEntity != null) {
                              _blockEntity.getPersistentData().m_128347_("Updated", 5.0D);
                           }

                           if (world instanceof Level) {
                              _level = (Level)world;
                              _level.m_7260_(_bp, _bs, _bs, 3);
                           }
                        }

                        if (180.0F < entity.m_146895_().m_146908_() - entity.m_146908_()) {
                           if (!world.m_5776_()) {
                              _bp = BlockPos.m_274561_(x, y, z);
                              _blockEntity = world.m_7702_(_bp);
                              _bs = world.m_8055_(_bp);
                              if (_blockEntity != null) {
                                 _blockEntity.getPersistentData().m_128347_("Yaw", (double)Math.min(Math.max(-22.0F, (360.0F - (entity.m_146895_().m_146908_() - entity.m_146908_())) * -1.0F), 22.0F));
                              }

                              if (world instanceof Level) {
                                 _level = (Level)world;
                                 _level.m_7260_(_bp, _bs, _bs, 3);
                              }
                           }
                        } else if (!world.m_5776_()) {
                           _bp = BlockPos.m_274561_(x, y, z);
                           _blockEntity = world.m_7702_(_bp);
                           _bs = world.m_8055_(_bp);
                           if (_blockEntity != null) {
                              _blockEntity.getPersistentData().m_128347_("Yaw", (double)Math.min(Math.max(-22.0F, entity.m_146895_().m_146908_() - entity.m_146908_()), 22.0F));
                           }

                           if (world instanceof Level) {
                              _level = (Level)world;
                              _level.m_7260_(_bp, _bs, _bs, 3);
                           }
                        }
                     }
                  }

               });
            }
         }

      }
   }
}

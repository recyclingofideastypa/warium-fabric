package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class StrikerAISystemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rev = 0.0D;
         double LeadRange = 0.0D;
         double targetrange = 0.0D;
         if (entity.getPersistentData().m_128459_("T") > 0.0D) {
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") - 1.0D);
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 != null) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000.m_6084_()) {
               Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               Mob _mobEnt;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var24 = var10004.m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var25 = var10005.m_20186_() + 1.0D;
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var24, var25, var10006.m_20189_());
               entity.m_7618_(var10001, var10002);
               float var23;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var23 = _livEnt.m_21223_();
               } else {
                  var23 = -1.0F;
               }

               if (var23 > 0.0F) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (Math.abs(var10000.m_20186_() - y) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123342_() - y) + 0.5D) <= 0.0D) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (Math.abs(var10000.m_20185_() - x) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123341_() - x) + 0.5D) <= 0.0D) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (Math.abs(var10000.m_20189_() - z) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123343_() - z) + 0.5D) <= 0.0D) {
                           CrustyChunksMod.queueServerWork(10, () -> {
                              if (entity.getPersistentData().m_128459_("T") <= 0.0D) {
                                 StrikerRifleProcedure.execute(world, x, y, z, entity);
                              }

                           });
                        }
                     }
                  }
               }

               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:robot"))) && entity instanceof Mob) {
                  try {
                     ((Mob)entity).m_6710_((LivingEntity)null);
                  } catch (Exception var20) {
                     var20.printStackTrace();
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("Cycle") > 0.0D) {
            entity.getPersistentData().m_128347_("Cycle", entity.getPersistentData().m_128459_("Cycle") - 1.0D);
         } else if (entity.m_20184_().m_7096_() != 0.0D && entity.m_20184_().m_7094_() != 0.0D) {
            entity.getPersistentData().m_128347_("Cycle", 5.0D);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:strikerstep")), SoundSource.NEUTRAL, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.5D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:strikerstep")), SoundSource.NEUTRAL, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.5D), false);
               }
            }
         }

      }
   }
}

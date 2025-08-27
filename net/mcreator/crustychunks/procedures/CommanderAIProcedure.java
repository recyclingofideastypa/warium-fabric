package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CommanderAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distancetotarget = 0.0D;
         Entity Robotarget = null;
         Entity target = null;
         if (entity.getPersistentData().m_128459_("T") > 0.0D) {
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") - 1.0D);
         }

         if (entity.getPersistentData().m_128459_("T2") > 0.0D) {
            entity.getPersistentData().m_128347_("T2", entity.getPersistentData().m_128459_("T2") - 1.0D);
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

               double var21 = var10004.m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var23 = var10005.m_20186_() + 1.0D;
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var21, var23, var10006.m_20189_());
               entity.m_7618_(var10001, var10002);
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (Math.abs(var10000.m_20186_() - y) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(200.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123342_() - y) + 0.5D) <= 0.0D) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (Math.abs(var10000.m_20185_() - x) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(10.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123341_() - x) + 0.5D) <= 0.0D) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (Math.abs(var10000.m_20189_() - z) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(10.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123343_() - z) + 0.5D) <= 0.0D && entity.getPersistentData().m_128459_("T2") <= 0.0D) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderalert")), SoundSource.HOSTILE, 5.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderalert")), SoundSource.HOSTILE, 5.0F, 1.0F, false);
                           }
                        }

                        entity.getPersistentData().m_128347_("T2", 80.0D);
                        CrustyChunksMod.queueServerWork(80, () -> {
                           Vec3 _center = new Vec3(x, y, z);
                           List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(256.0D), (e) -> {
                              return true;
                           }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                              return _entcnd.m_20238_(_center);
                           })).toList();
                           Iterator var10 = _entfound.iterator();

                           while(var10.hasNext()) {
                              Entity entityiterator = (Entity)var10.next();
                              if (entity.m_6084_() && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:robot")))) {
                                 LivingEntity var10000;
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (var10000 != null && entityiterator instanceof Mob) {
                                    Mob _entity = (Mob)entityiterator;
                                    if (entity instanceof Mob) {
                                       Mob _mobEntx = (Mob)entity;
                                       var10000 = _mobEntx.m_5448_();
                                    } else {
                                       var10000 = null;
                                    }

                                    Entity patt4437$temp = var10000;
                                    if (patt4437$temp instanceof LivingEntity) {
                                       LivingEntity _ent = (LivingEntity)patt4437$temp;
                                       _entity.m_6710_(_ent);
                                    }
                                 }
                              }
                           }

                        });
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("T") <= 0.0D) {
                  float var22;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var22 = _livEnt.m_21223_();
                  } else {
                     var22 = -1.0F;
                  }

                  if (var22 > 0.0F) {
                     CrustyChunksMod.queueServerWork(1, () -> {
                        EliteRifleProcedure.execute(world, x, y, z, entity);
                     });
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
                  } catch (Exception var18) {
                     var18.printStackTrace();
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
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:strikerstep")), SoundSource.HOSTILE, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.5D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:strikerstep")), SoundSource.HOSTILE, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.5D), false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("Cycle2") > 0.0D) {
            entity.getPersistentData().m_128347_("Cycle2", entity.getPersistentData().m_128459_("Cycle2") - 1.0D);
         } else {
            entity.getPersistentData().m_128347_("Cycle2", 440.0D);
            CrustyChunksMod.queueServerWork(1, () -> {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderwaffing")), SoundSource.HOSTILE, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.05D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderwaffing")), SoundSource.HOSTILE, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.05D), false);
                  }
               }

            });
         }

      }
   }
}

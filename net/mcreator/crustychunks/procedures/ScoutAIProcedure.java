package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ScoutAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean schedoodlemode = false;
         double buddydistance = 0.0D;
         double distancetotarget = 0.0D;
         Entity target = null;
         Mob _entity;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            _entity = (Mob)entity;
            var10000 = _entity.m_5448_();
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
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               target = var10000;
            }
         }

         if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 160) && (target != null && !((Entity)target).m_6084_() || target == null)) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(128.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.m_20238_(_center);
            })).toList();
            Iterator var22 = _entfound.iterator();

            label112:
            while(true) {
               Entity entityiterator;
               do {
                  do {
                     do {
                        if (!var22.hasNext()) {
                           break label112;
                        }

                        entityiterator = (Entity)var22.next();
                     } while(!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:robotarget"))) && (!(entityiterator instanceof Player) || !((<undefinedtype>)(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                              return _serverPlayer.f_8941_.m_9290_() == GameType.SURVIVAL;
                           } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player) {
                              Player _player = (Player)_ent;
                              return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SURVIVAL;
                           } else {
                              return false;
                           }
                        }
                     })).checkGamemode(entityiterator)));
                  } while(!world.m_46861_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_())));
               } while((target == null || ((Entity)target).m_6084_()) && target != null);

               target = entityiterator;
            }
         }

         if (entity.getPersistentData().m_128459_("T") > 0.0D) {
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") - 1.0D);
         }

         Level _level;
         if (target != null) {
            distancetotarget = Math.sqrt(Math.pow(Math.abs(((Entity)target).m_20185_() - x), 2.0D) + Math.pow(Math.abs(((Entity)target).m_20189_() - z), 2.0D));
            entity.m_7618_(Anchor.EYES, new Vec3(((Entity)target).m_20185_(), ((Entity)target).m_20186_() + 1.0D, ((Entity)target).m_20189_()));
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_() + entity.m_20154_().f_82479_ / 18.0D, entity.m_20184_().m_7098_(), entity.m_20184_().m_7094_() + entity.m_20154_().f_82481_ / 18.0D));
            if (Math.abs(((Entity)target).m_20186_() - y) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(200.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123342_() - y) + 0.5D) <= 0.0D && Math.abs(((Entity)target).m_20185_() - x) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(10.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123341_() - x) + 0.5D) <= 0.0D && Math.abs(((Entity)target).m_20189_() - z) - (Math.abs((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(10.0D)), Block.COLLIDER, Fluid.ANY, entity)).m_82425_().m_123343_() - z) + 0.5D) <= 0.0D && entity.getPersistentData().m_128459_("T") <= 0.0D) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:beep")), SoundSource.HOSTILE, 5.0F, 2.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:beep")), SoundSource.HOSTILE, 5.0F, 2.0F, false);
                  }
               }

               entity.getPersistentData().m_128347_("T", 160.0D);
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

                           Entity patt6055$temp = var10000;
                           if (patt6055$temp instanceof LivingEntity) {
                              LivingEntity _ent = (LivingEntity)patt6055$temp;
                              _entity.m_6710_(_ent);
                           }
                        }
                     }
                  }

               });
            }
         }

         if (entity.getPersistentData().m_128459_("Cycle") > 0.0D) {
            entity.getPersistentData().m_128347_("Cycle", entity.getPersistentData().m_128459_("Cycle") - 1.0D);
         } else {
            entity.getPersistentData().m_128347_("Cycle", 15.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:drone")), SoundSource.HOSTILE, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:drone")), SoundSource.HOSTILE, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
               }
            }
         }

         if (entity.m_20186_() < (double)(world.m_6924_(Types.MOTION_BLOCKING, Mth.m_14107_(x), Mth.m_14107_(z)) + 15)) {
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() + 0.01D, entity.m_20184_().m_7094_()));
         } else if (entity.m_20186_() > (double)(world.m_6924_(Types.MOTION_BLOCKING, Mth.m_14107_(x), Mth.m_14107_(z)) + 20)) {
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() - 0.005D, entity.m_20184_().m_7094_()));
         }

         entity.m_20256_(new Vec3(entity.m_20184_().m_7096_() * 0.995D, entity.m_20184_().m_7098_() * 0.995D, entity.m_20184_().m_7094_() * 0.995D));
         if (target != null && entity instanceof Mob) {
            _entity = (Mob)entity;
            if (target instanceof LivingEntity) {
               LivingEntity _ent = (LivingEntity)target;
               _entity.m_6710_(_ent);
            }
         }

      }
   }
}

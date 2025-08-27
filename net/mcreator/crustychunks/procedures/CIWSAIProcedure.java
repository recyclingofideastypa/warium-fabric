package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.ClusterRocketEntity;
import net.mcreator.crustychunks.entity.IRMissileEntity;
import net.mcreator.crustychunks.entity.IncindiaryRocketProjectileEntity;
import net.mcreator.crustychunks.entity.LargeRocketEntity;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CIWSAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         boolean hottarget = false;
         double rev = 0.0D;
         double targetrange = 0.0D;
         double LeadRange = 0.0D;
         double leadx = 0.0D;
         double leady = 0.0D;
         double leadz = 0.0D;
         if (entity.getPersistentData().m_128459_("T") > -1.0D) {
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") - 1.0D);
         }

         LivingEntity var10000;
         Mob _mobEnt;
         if (entity instanceof Mob) {
            _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Vec3 _center;
         List _entfound;
         Iterator var25;
         Entity entityiterator;
         Mob _mobEnt;
         if (var10000 == null && 1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 40)) {
            _center = new Vec3(x, y, z);
            _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(256.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.m_20238_(_center);
            })).toList();
            var25 = _entfound.iterator();

            label177:
            while(true) {
               do {
                  if (!var25.hasNext()) {
                     break label177;
                  }

                  entityiterator = (Entity)var25.next();
               } while((!((<undefinedtype>)(new Object() {
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
               })).checkGamemode(entityiterator) || !(entityiterator instanceof Player)) && !(entityiterator instanceof LargeRocketEntity) && !(entityiterator instanceof IncindiaryRocketProjectileEntity) && !(entityiterator instanceof ClusterRocketEntity) && !(entityiterator instanceof IRMissileEntity));

               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _ent = (LivingEntity)entityiterator;
                     _mobEnt.m_6710_(_ent);
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

         if (var10000 != null) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            target = var10000;
            hottarget = false;
            Vec3 var29 = new Vec3;
            LivingEntity var10002;
            Mob _mobEnt;
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            double var30 = var10002.m_20185_();
            LivingEntity var10003;
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10003 = _mobEnt.m_5448_();
            } else {
               var10003 = null;
            }

            double var31 = var10003.m_20186_();
            LivingEntity var10004;
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10004 = _mobEnt.m_5448_();
            } else {
               var10004 = null;
            }

            var29.<init>(var30, var31, var10004.m_20189_());
            _center = var29;
            _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(25.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.m_20238_(_center);
            })).toList();
            var25 = _entfound.iterator();

            label156:
            while(true) {
               while(true) {
                  if (!var25.hasNext()) {
                     break label156;
                  }

                  entityiterator = (Entity)var25.next();
                  if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:warm"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:robot")))) {
                     leadx = entityiterator.getPersistentData().m_128459_("Mx");
                     leady = entityiterator.getPersistentData().m_128459_("My");
                     leadz = entityiterator.getPersistentData().m_128459_("Mz");
                     hottarget = true;
                  } else {
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     leadx = var10000.m_20184_().m_7096_();
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     leady = var10000.m_20184_().m_7098_();
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     leadz = var10000.m_20184_().m_7094_();
                  }
               }
            }
         }

         if (target != null && target.m_20186_() > y + 25.0D) {
            targetrange = Math.sqrt(Math.pow(Math.abs(y - target.m_20186_()), 2.0D) + Math.pow(Math.abs(z - target.m_20189_()), 2.0D) + Math.pow(Math.abs(x - target.m_20185_()), 2.0D));
            LeadRange = targetrange + Math.pow(targetrange, 2.0D) / 225.0D;
            entity.m_7618_(Anchor.EYES, new Vec3(target.m_20185_() + leadx * 1.25D * LeadRange * 0.09D, Math.max(y + 25.0D, target.m_20186_() + 3.0D + leady * 1.25D * LeadRange * 0.09D), target.m_20189_() + leadz * 1.25D * LeadRange * 0.09D));
            if (target.m_20186_() > y + 25.0D && 250.0D > targetrange && entity.getPersistentData().m_128459_("T") <= -1.0D) {
               if (hottarget && entity.getPersistentData().m_128459_("Rocket") < 3.0D) {
                  CrustyChunksMod.queueServerWork(1, () -> {
                     CIWSSAMProcedure.execute(world, x, y, z, entity);
                  });
               } else {
                  CrustyChunksMod.queueServerWork(1, () -> {
                     CIWSGunProcedure.execute(world, x, y, z, entity);
                  });
               }
            }
         }

         if (entity.getPersistentData().m_128459_("Rocket") > 0.0D && 1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 200)) {
            entity.getPersistentData().m_128347_("Rocket", entity.getPersistentData().m_128459_("Rocket") - 1.0D);
         }

         float var32;
         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var32 = _livEnt.m_21223_();
         } else {
            var32 = -1.0F;
         }

         float var10001;
         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21233_();
         } else {
            var10001 = -1.0F;
         }

         if (var32 < var10001 / 2.0F && 10 == Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 4.0D, z, 0.0D, 1.0D, 0.0D);
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var32 = _livEnt.m_21223_();
         } else {
            var32 = -1.0F;
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21233_();
         } else {
            var10001 = -1.0F;
         }

         if (var32 < var10001 / 4.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x, y + 2.0D, z, 2, 1.0D, 1.0D, 1.0D, 1.0D);
            }

            if (10 == Mth.m_216271_(RandomSource.m_216327_(), 1, 80) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 4.0F, 0.7F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 4.0F, 0.7F, false);
               }
            }
         }

         if (entity.m_20069_()) {
            entity.m_20256_(new Vec3(0.0D, 0.1D, 0.0D));
         }

      }
   }
}

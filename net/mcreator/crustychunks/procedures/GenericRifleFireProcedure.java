package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.APMediumBulletEntity;
import net.mcreator.crustychunks.entity.BulletfireProjectileEntity;
import net.mcreator.crustychunks.entity.StealthMediumBulletEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.mcreator.crustychunks.item.BurstRifleItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GenericRifleFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         double recoil = 0.0D;
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         if (entity.m_20142_()) {
            Movementinnacuracy = 6.0D;
         } else {
            Movementinnacuracy = 2.0D;
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (!var10000.m_41784_().m_128471_("action")) {
            ItemStack var10001;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            if (1.0D <= var10001.m_41784_().m_128459_("Ammo")) {
               if (entity instanceof Player) {
                  Player _plrCldCheck7 = (Player)entity;
                  ItemCooldowns var24 = _plrCldCheck7.m_36335_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  if (var24.m_41519_(var10001.m_41720_())) {
                     return;
                  }
               }

               LivingEntity _livEnt;
               LivingEntity _livEnt;
               if (entity.m_6144_()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() instanceof BurstRifleItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128359_("geckoAnim", "sightfire");
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() instanceof BurstRifleItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128359_("geckoAnim", "fire");
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               Level projectileLevel;
               Projectile _entityToSpawn;
               if (var10000.m_41784_().m_128461_("Type").equals("AP")) {
                  projectileLevel = entity.m_9236_();
                  if (!projectileLevel.m_5776_()) {
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new APMediumBulletEntity((EntityType)CrustyChunksModEntities.AP_MEDIUM_BULLET.get(), level);
                           entityToSpawn.m_5602_(shooter);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           entityToSpawn.m_36767_(piercing);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)5);
                     _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                     _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 6.5F, (float)Movementinnacuracy);
                     projectileLevel.m_7967_(_entityToSpawn);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41784_().m_128461_("Type").equals("MB")) {
                     projectileLevel = entity.m_9236_();
                     if (!projectileLevel.m_5776_()) {
                        _entityToSpawn = ((<undefinedtype>)(new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                              AbstractArrow entityToSpawn = new BulletfireProjectileEntity((EntityType)CrustyChunksModEntities.BULLETFIRE_PROJECTILE.get(), level);
                              entityToSpawn.m_5602_(shooter);
                              entityToSpawn.m_36781_((double)damage);
                              entityToSpawn.m_36735_(knockback);
                              entityToSpawn.m_20225_(true);
                              entityToSpawn.m_36767_(piercing);
                              return entityToSpawn;
                           }
                        })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)2);
                        _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                        _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 6.5F, (float)Movementinnacuracy);
                        projectileLevel.m_7967_(_entityToSpawn);
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41784_().m_128461_("Type").equals("ST")) {
                        projectileLevel = entity.m_9236_();
                        if (!projectileLevel.m_5776_()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                 AbstractArrow entityToSpawn = new StealthMediumBulletEntity((EntityType)CrustyChunksModEntities.STEALTH_MEDIUM_BULLET.get(), level);
                                 entityToSpawn.m_5602_(shooter);
                                 entityToSpawn.m_36781_((double)damage);
                                 entityToSpawn.m_36735_(knockback);
                                 entityToSpawn.m_20225_(true);
                                 entityToSpawn.m_36767_(piercing);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)2);
                           _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                           _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 6.5F, (float)Movementinnacuracy);
                           projectileLevel.m_7967_(_entityToSpawn);
                        }
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               CompoundTag var28 = var10000.m_41784_();
               ItemStack var10002;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.m_21205_();
               } else {
                  var10002 = ItemStack.f_41583_;
               }

               var28.m_128347_("Ammo", var10002.m_41784_().m_128459_("Ammo") - 1.0D);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.MEDIUM_CASING.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }

               CasingDropProcedure.execute(world, x, y, z);
               MediumFireSoundProcedure.execute(world, x, y, z);

               for(int index0 = 0; index0 < 3; ++index0) {
                  world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.GUN_SMOKE.get(), x + entity.m_20154_().f_82479_ * 0.8D, y + (double)entity.m_20192_() - 0.1D, z + entity.m_20154_().f_82481_ * 0.8D, entity.m_20154_().f_82479_ * 0.2D + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), entity.m_20154_().f_82480_ * 0.2D + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), entity.m_20154_().f_82481_ * 0.2D + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D));
               }

               entity.getPersistentData().m_128347_("GunCooldown", 6.0D);
            } else {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                  }
               }

               entity.getPersistentData().m_128347_("GunCooldown", 6.0D);
            }
         }

      }
   }
}

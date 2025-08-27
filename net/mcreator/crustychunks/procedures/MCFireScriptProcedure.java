package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.SmallBulletHPEntity;
import net.mcreator.crustychunks.entity.SmallBulletStealthEntity;
import net.mcreator.crustychunks.entity.SmallbulletfireProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.MachineCarbineItem;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class MCFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         double recoil = 0.0D;
         if (entity.m_20142_()) {
            Movementinnacuracy = 5.0D;
         } else {
            Movementinnacuracy = 3.0D;
         }

         if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
            Movementinnacuracy = 0.3D;
            recoil = Mth.m_216263_(RandomSource.m_216327_(), 0.2D, 0.3D);
         } else {
            recoil = Mth.m_216263_(RandomSource.m_216327_(), 0.4D, 0.5D);
         }

         ItemStack var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21205_();
         } else {
            var10001 = ItemStack.f_41583_;
         }

         if (0.0D != var10001.m_41784_().m_128459_("Firemode") || ((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).clickrelease) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (!var10000.m_41784_().m_128471_("action")) {
                  LivingEntity _livEnt;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128379_("action", true);
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  if (1.0D <= var10001.m_41784_().m_128459_("Ammo")) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     if (var10001.m_41784_().m_128471_("Loaded")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        if (0.0D >= var10001.m_41784_().m_128459_("Cooldown")) {
                           if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                              if (itemstack.m_41720_() instanceof MachineCarbineItem) {
                                 itemstack.m_41784_().m_128359_("geckoAnim", "sightfire");
                              }
                           } else if (itemstack.m_41720_() instanceof MachineCarbineItem) {
                              itemstack.m_41784_().m_128359_("geckoAnim", "fire");
                           }

                           Level projectileLevel;
                           Projectile _entityToSpawn;
                           if (itemstack.m_41784_().m_128461_("Type").equals("AP")) {
                              projectileLevel = entity.m_9236_();
                              if (!projectileLevel.m_5776_()) {
                                 _entityToSpawn = ((<undefinedtype>)(new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                       AbstractArrow entityToSpawn = new SmallbulletfireProjectileEntity((EntityType)CrustyChunksModEntities.SMALLBULLETFIRE_PROJECTILE.get(), level);
                                       entityToSpawn.m_5602_(shooter);
                                       entityToSpawn.m_36781_((double)damage);
                                       entityToSpawn.m_36735_(knockback);
                                       entityToSpawn.m_20225_(true);
                                       entityToSpawn.m_36767_(piercing);
                                       return entityToSpawn;
                                    }
                                 })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)1);
                                 _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                                 _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 6.0F, (float)Movementinnacuracy);
                                 projectileLevel.m_7967_(_entityToSpawn);
                              }
                           } else if (itemstack.m_41784_().m_128461_("Type").equals("HP")) {
                              projectileLevel = entity.m_9236_();
                              if (!projectileLevel.m_5776_()) {
                                 _entityToSpawn = ((<undefinedtype>)(new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                       AbstractArrow entityToSpawn = new SmallBulletHPEntity((EntityType)CrustyChunksModEntities.SMALL_BULLET_HP.get(), level);
                                       entityToSpawn.m_5602_(shooter);
                                       entityToSpawn.m_36781_((double)damage);
                                       entityToSpawn.m_36735_(knockback);
                                       entityToSpawn.m_20225_(true);
                                       return entityToSpawn;
                                    }
                                 })).getArrow(projectileLevel, entity, 0.1F, 0);
                                 _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                                 _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 6.0F, (float)Movementinnacuracy);
                                 projectileLevel.m_7967_(_entityToSpawn);
                              }
                           } else if (itemstack.m_41784_().m_128461_("Type").equals("ST")) {
                              projectileLevel = entity.m_9236_();
                              if (!projectileLevel.m_5776_()) {
                                 _entityToSpawn = ((<undefinedtype>)(new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                       AbstractArrow entityToSpawn = new SmallBulletStealthEntity((EntityType)CrustyChunksModEntities.SMALL_BULLET_STEALTH.get(), level);
                                       entityToSpawn.m_5602_(shooter);
                                       entityToSpawn.m_36781_((double)damage);
                                       entityToSpawn.m_36735_(knockback);
                                       entityToSpawn.m_20225_(true);
                                       return entityToSpawn;
                                    }
                                 })).getArrow(projectileLevel, entity, 0.1F, 0);
                                 _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                                 _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 6.0F, (float)Movementinnacuracy);
                                 projectileLevel.m_7967_(_entityToSpawn);
                              }
                           }

                           LivingEntity _livEnt;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           CompoundTag var26 = var10000.m_41784_();
                           ItemStack var10002;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.m_21205_();
                           } else {
                              var10002 = ItemStack.f_41583_;
                           }

                           var26.m_128347_("Ammo", var10002.m_41784_().m_128459_("Ammo") - 1.0D);
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_CASING.get()));
                              entityToSpawn.m_32010_(10);
                              _level.m_7967_(entityToSpawn);
                           }

                           SmallCasingDropProcedure.execute(world, x, y, z);
                           PistolFireSoundProcedure.execute(world, x, y, z);
                           entity.m_146922_((float)((double)entity.m_146908_() + Mth.m_216263_(RandomSource.m_216327_(), -0.3D, 0.3D)));
                           entity.m_146926_((float)((double)entity.m_146909_() - recoil));
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128379_("action", false);
                        }
                     }
                  } else if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                     }
                  }
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("§4Weapon requires 2 hands to fire."), true);
               }
            }

            boolean _setval = false;
            entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.clickrelease = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.BirdshotParticleEntity;
import net.mcreator.crustychunks.entity.BreechingProjectileEntity;
import net.mcreator.crustychunks.entity.LargeStealthBulletEntity;
import net.mcreator.crustychunks.entity.TinyprojectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.mcreator.crustychunks.item.PumpActionShotgunAnimatedItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class ShotgunFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
            if (!itemstack.m_41784_().m_128471_("action")) {
               itemstack.m_41784_().m_128379_("action", true);
               if (1.0D <= itemstack.m_41784_().m_128459_("Ammo")) {
                  itemstack.m_41784_().m_128347_("Ammo", itemstack.m_41784_().m_128459_("Ammo") - 1.0D);
                  if (itemstack.m_41720_() instanceof PumpActionShotgunAnimatedItem) {
                     itemstack.m_41784_().m_128359_("geckoAnim", "fire");
                  }

                  int index2;
                  Level projectileLevel;
                  Level projectileLevel;
                  Projectile _entityToSpawn;
                  Projectile _entityToSpawn;
                  if (!itemstack.m_41784_().m_128461_("Type").equals("BU")) {
                     if (itemstack.m_41784_().m_128461_("Type").equals("BI")) {
                        for(index2 = 0; index2 < 30; ++index2) {
                           projectileLevel = entity.m_9236_();
                           if (!projectileLevel.m_5776_()) {
                              _entityToSpawn = ((<undefinedtype>)(new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new BirdshotParticleEntity((EntityType)CrustyChunksModEntities.BIRDSHOT_PARTICLE.get(), level);
                                    entityToSpawn.m_5602_(shooter);
                                    entityToSpawn.m_36781_((double)damage);
                                    entityToSpawn.m_36735_(knockback);
                                    entityToSpawn.m_20225_(true);
                                    return entityToSpawn;
                                 }
                              })).getArrow(projectileLevel, entity, 0.0F, 0);
                              _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                              _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, (float)Mth.m_216263_(RandomSource.m_216327_(), 5.9D, 6.1D), 6.5F);
                              projectileLevel.m_7967_(_entityToSpawn);
                           }
                        }
                     } else if (itemstack.m_41784_().m_128461_("Type").equals("AP")) {
                        projectileLevel = entity.m_9236_();
                        if (!projectileLevel.m_5776_()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                 AbstractArrow entityToSpawn = new LargeStealthBulletEntity((EntityType)CrustyChunksModEntities.LARGE_STEALTH_BULLET.get(), level);
                                 entityToSpawn.m_5602_(shooter);
                                 entityToSpawn.m_36781_((double)damage);
                                 entityToSpawn.m_36735_(knockback);
                                 entityToSpawn.m_20225_(true);
                                 entityToSpawn.m_36767_(piercing);
                                 entityToSpawn.m_36762_(true);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.0F, 2, (byte)1);
                           _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                           _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 7.0F, 2.0F);
                           projectileLevel.m_7967_(_entityToSpawn);
                        }
                     }
                  } else {
                     for(index2 = 0; index2 < 10; ++index2) {
                        projectileLevel = entity.m_9236_();
                        if (!projectileLevel.m_5776_()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new TinyprojectileEntity((EntityType)CrustyChunksModEntities.TINYPROJECTILE.get(), level);
                                 entityToSpawn.m_5602_(shooter);
                                 entityToSpawn.m_36781_((double)damage);
                                 entityToSpawn.m_36735_(knockback);
                                 entityToSpawn.m_20225_(true);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.05F, 0);
                           _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                           _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, (float)Mth.m_216263_(RandomSource.m_216327_(), 5.9D, 6.1D), 6.0F);
                           projectileLevel.m_7967_(_entityToSpawn);
                        }
                     }

                     projectileLevel = entity.m_9236_();
                     if (!projectileLevel.m_5776_()) {
                        _entityToSpawn = ((<undefinedtype>)(new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new BreechingProjectileEntity((EntityType)CrustyChunksModEntities.BREECHING_PROJECTILE.get(), level);
                              entityToSpawn.m_5602_(shooter);
                              entityToSpawn.m_36781_((double)damage);
                              entityToSpawn.m_36735_(knockback);
                              entityToSpawn.m_20225_(true);
                              entityToSpawn.m_36762_(true);
                              return entityToSpawn;
                           }
                        })).getArrow(projectileLevel, entity, 0.0F, 1);
                        _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                        _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 3.0F, 0.0F);
                        projectileLevel.m_7967_(_entityToSpawn);
                     }
                  }

                  ShotgunFireSoundProcedure.execute(world, x, y, z);
                  itemstack.m_41784_().m_128379_("Casing", true);

                  for(index2 = 0; index2 < 5; ++index2) {
                     world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.GUN_SMOKE.get(), x + entity.m_20154_().f_82479_ * 0.8D, y + (double)entity.m_20192_() - 0.1D, z + entity.m_20154_().f_82481_ * 0.8D, entity.m_20154_().f_82479_ * 0.2D + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), entity.m_20154_().f_82480_ * 0.2D + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), entity.m_20154_().f_82481_ * 0.2D + Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D));
                  }

                  entity.m_146922_((float)((double)entity.m_146908_() + Mth.m_216263_(RandomSource.m_216327_(), -3.0D, 3.0D)));
                  entity.m_146926_((float)((double)entity.m_146909_() - Mth.m_216263_(RandomSource.m_216327_(), 4.0D, 6.0D)));
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                  }
               }
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_("§4Weapon requires 2 hands to fire."), true);
            }
         }

      }
   }
}

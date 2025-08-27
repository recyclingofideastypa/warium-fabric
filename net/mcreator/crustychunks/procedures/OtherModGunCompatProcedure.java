package net.mcreator.crustychunks.procedures;

import javax.annotation.Nullable;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.BulletfireProjectileEntity;
import net.mcreator.crustychunks.entity.LargeBulletFireProjectileEntity;
import net.mcreator.crustychunks.entity.SmallbulletfireProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
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
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class OtherModGunCompatProcedure {
   @SubscribeEvent
   public static void onPlayerTick(PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.m_9236_(), event.player.m_20185_(), event.player.m_20186_(), event.player.m_20189_(), event.player);
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         IForgeRegistry var10000 = ForgeRegistries.ITEMS;
         LivingEntity _livEnt;
         ItemStack var10001;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21205_();
         } else {
            var10001 = ItemStack.f_41583_;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         Level projectileLevel;
         Projectile _entityToSpawn;
         LivingEntity _livEnt;
         ItemStack var15;
         double var16;
         double var10002;
         double var10003;
         ItemStack var10005;
         if (var10000.getKey(var10001.m_41720_()).toString().equals("futurism:advanced_revolver")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var15 = _livEnt.m_21205_();
            } else {
               var15 = ItemStack.f_41583_;
            }

            if (var15.m_41784_().m_128471_("Firing")) {
               projectileLevel = entity.m_9236_();
               if (!projectileLevel.m_5776_()) {
                  _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new LargeBulletFireProjectileEntity((EntityType)CrustyChunksModEntities.LARGE_BULLET_FIRE_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, 5.0F, 1);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                  var16 = entity.m_20154_().f_82479_;
                  var10002 = entity.m_20154_().f_82480_;
                  var10003 = entity.m_20154_().f_82481_;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10005 = _livEnt.m_21205_();
                  } else {
                     var10005 = ItemStack.f_41583_;
                  }

                  _entityToSpawn.m_6686_(var16, var10002, var10003, 6.5F, (float)var10005.m_41784_().m_128459_("Innacuracy"));
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               CrustyChunksMod.queueServerWork(1, () -> {
                  Level _level;
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:largeshot")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:largeshot")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                     }
                  }

               });
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var15 = _livEnt.m_21205_();
               } else {
                  var15 = ItemStack.f_41583_;
               }

               var15.m_41784_().m_128379_("Firing", false);
            }
         }

         var10000 = ForgeRegistries.ITEMS;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21205_();
         } else {
            var10001 = ItemStack.f_41583_;
         }

         if (var10000.getKey(var10001.m_41720_()).toString().equals("futurism:battle_rifle")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var15 = _livEnt.m_21205_();
            } else {
               var15 = ItemStack.f_41583_;
            }

            if (var15.m_41784_().m_128471_("Firing")) {
               projectileLevel = entity.m_9236_();
               if (!projectileLevel.m_5776_()) {
                  _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new LargeBulletFireProjectileEntity((EntityType)CrustyChunksModEntities.LARGE_BULLET_FIRE_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, 5.0F, 1);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                  var16 = entity.m_20154_().f_82479_;
                  var10002 = entity.m_20154_().f_82480_;
                  var10003 = entity.m_20154_().f_82481_;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10005 = _livEnt.m_21205_();
                  } else {
                     var10005 = ItemStack.f_41583_;
                  }

                  _entityToSpawn.m_6686_(var16, var10002, var10003, 6.5F, (float)var10005.m_41784_().m_128459_("Innacuracy"));
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               CrustyChunksMod.queueServerWork(1, () -> {
                  Level _level;
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:largeshot")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:largeshot")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                     }
                  }

               });
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var15 = _livEnt.m_21205_();
               } else {
                  var15 = ItemStack.f_41583_;
               }

               var15.m_41784_().m_128379_("Firing", false);
            }
         }

         var10000 = ForgeRegistries.ITEMS;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21205_();
         } else {
            var10001 = ItemStack.f_41583_;
         }

         if (var10000.getKey(var10001.m_41720_()).toString().equals("futurism:advanced_automatic_rifle")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var15 = _livEnt.m_21205_();
            } else {
               var15 = ItemStack.f_41583_;
            }

            if (var15.m_41784_().m_128471_("Firing")) {
               projectileLevel = entity.m_9236_();
               if (!projectileLevel.m_5776_()) {
                  _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new BulletfireProjectileEntity((EntityType)CrustyChunksModEntities.BULLETFIRE_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, 5.0F, 1);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                  var16 = entity.m_20154_().f_82479_;
                  var10002 = entity.m_20154_().f_82480_;
                  var10003 = entity.m_20154_().f_82481_;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10005 = _livEnt.m_21205_();
                  } else {
                     var10005 = ItemStack.f_41583_;
                  }

                  _entityToSpawn.m_6686_(var16, var10002, var10003, 6.5F, (float)var10005.m_41784_().m_128459_("Innacuracy"));
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               CrustyChunksMod.queueServerWork(1, () -> {
                  Level _level;
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.15D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.15D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumshot")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumshot")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                     }
                  }

               });
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var15 = _livEnt.m_21205_();
               } else {
                  var15 = ItemStack.f_41583_;
               }

               var15.m_41784_().m_128379_("Firing", false);
            }
         }

         var10000 = ForgeRegistries.ITEMS;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21205_();
         } else {
            var10001 = ItemStack.f_41583_;
         }

         if (var10000.getKey(var10001.m_41720_()).toString().equals("futurism:advanced_pistol")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var15 = _livEnt.m_21205_();
            } else {
               var15 = ItemStack.f_41583_;
            }

            if (var15.m_41784_().m_128471_("Firing")) {
               projectileLevel = entity.m_9236_();
               if (!projectileLevel.m_5776_()) {
                  _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new SmallbulletfireProjectileEntity((EntityType)CrustyChunksModEntities.SMALLBULLETFIRE_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, 5.0F, 1);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                  var16 = entity.m_20154_().f_82479_;
                  var10002 = entity.m_20154_().f_82480_;
                  var10003 = entity.m_20154_().f_82481_;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10005 = _livEnt.m_21205_();
                  } else {
                     var10005 = ItemStack.f_41583_;
                  }

                  _entityToSpawn.m_6686_(var16, var10002, var10003, 6.5F, (float)var10005.m_41784_().m_128459_("Innacuracy"));
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               CrustyChunksMod.queueServerWork(1, () -> {
                  Level _level;
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.2D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.2D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallshot")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.05D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallshot")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.05D), false);
                     }
                  }

               });
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var15 = _livEnt.m_21205_();
               } else {
                  var15 = ItemStack.f_41583_;
               }

               var15.m_41784_().m_128379_("Firing", false);
            }
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.FlameThrowerEmberEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class FlameThrowerFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == CrustyChunksModItems.FLAME_THROWER_TANK_CHESTPLATE.get()) {
            itemstack.m_41784_().m_128379_("firinglog", true);
            if (entity.m_20142_()) {
               Movementinnacuracy = 10.0D;
            } else {
               Movementinnacuracy = 9.0D;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
               if (0.0D >= itemstack.m_41784_().m_128459_("Cooldown")) {
                  ItemStack var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10001 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  if (0.0D < var10001.m_41784_().m_128459_("Fluid")) {
                     LivingEntity _entity;
                     for(int index0 = 0; index0 < 3; ++index0) {
                        if (entity instanceof LivingEntity) {
                           _entity = (LivingEntity)entity;
                           var10001 = _entity.m_6844_(EquipmentSlot.CHEST);
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        if (1.0D < var10001.m_41784_().m_128459_("Fluid")) {
                           Level projectileLevel = entity.m_9236_();
                           if (!projectileLevel.m_5776_()) {
                              Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new FlameThrowerEmberEntity((EntityType)CrustyChunksModEntities.FLAME_THROWER_EMBER.get(), level);
                                    entityToSpawn.m_5602_(shooter);
                                    entityToSpawn.m_36781_((double)damage);
                                    entityToSpawn.m_36735_(knockback);
                                    entityToSpawn.m_20225_(true);
                                    entityToSpawn.m_20254_(100);
                                    return entityToSpawn;
                                 }
                              })).getArrow(projectileLevel, entity, 0.0F, 0);
                              _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                              _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.4D, 1.5D), (float)Movementinnacuracy);
                              projectileLevel.m_7967_(_entityToSpawn);
                           }

                           LivingEntity _entGetArmor;
                           if (entity instanceof LivingEntity) {
                              _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           CompoundTag var22 = var10000.m_41784_();
                           ItemStack var10002;
                           if (entity instanceof LivingEntity) {
                              _entGetArmor = (LivingEntity)entity;
                              var10002 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var10002 = ItemStack.f_41583_;
                           }

                           var22.m_128347_("Fluid", var10002.m_41784_().m_128459_("Fluid") - 2.0D);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                        }
                     }

                     entity.m_146922_(entity.m_146908_());
                     entity.m_146926_((float)((double)entity.m_146909_() - Mth.m_216263_(RandomSource.m_216327_(), 0.2D, 0.4D)));
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  }
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("§4Weapon requires 2 hands to fire."), true);
               }
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_("§4Fuel tank required."), true);
            }
         }

      }
   }
}

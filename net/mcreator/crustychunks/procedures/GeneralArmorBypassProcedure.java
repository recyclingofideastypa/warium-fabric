package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.APMediumBulletEntity;
import net.mcreator.crustychunks.entity.BulletfireProjectileEntity;
import net.mcreator.crustychunks.entity.ExtraLargeBulletFireEntity;
import net.mcreator.crustychunks.entity.LargeAPBulletEntity;
import net.mcreator.crustychunks.entity.LargeBulletFireProjectileEntity;
import net.mcreator.crustychunks.entity.LargeStealthBulletEntity;
import net.mcreator.crustychunks.entity.SmallBulletAltEntity;
import net.mcreator.crustychunks.entity.SmallBulletHPEntity;
import net.mcreator.crustychunks.entity.SmallBulletStealthEntity;
import net.mcreator.crustychunks.entity.SmallbulletfireProjectileEntity;
import net.mcreator.crustychunks.entity.StealthMediumBulletEntity;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GeneralArmorBypassProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double Health = 0.0D;
         double damagemultiplier = 0.0D;
         double penetrationmult = 0.0D;
         if (immediatesourceentity instanceof SmallbulletfireProjectileEntity) {
            penetrationmult = 1.0D;
            damagemultiplier = 0.9D;
         } else if (immediatesourceentity instanceof SmallBulletAltEntity) {
            penetrationmult = 0.5D;
            damagemultiplier = 0.8D;
         } else if (immediatesourceentity instanceof SmallBulletHPEntity) {
            penetrationmult = -0.1D;
            damagemultiplier = 1.0D;
         } else if (immediatesourceentity instanceof SmallBulletStealthEntity) {
            penetrationmult = 0.5D;
            damagemultiplier = 0.8D;
         } else if (immediatesourceentity instanceof BulletfireProjectileEntity) {
            penetrationmult = -0.1D;
            damagemultiplier = 1.1D;
         } else if (immediatesourceentity instanceof APMediumBulletEntity) {
            penetrationmult = 1.0D;
            damagemultiplier = 1.0D;
         } else if (immediatesourceentity instanceof StealthMediumBulletEntity) {
            penetrationmult = 0.0D;
            damagemultiplier = 1.0D;
         } else if (immediatesourceentity instanceof LargeBulletFireProjectileEntity) {
            penetrationmult = 0.0D;
            damagemultiplier = 2.0D;
         } else if (immediatesourceentity instanceof LargeAPBulletEntity) {
            penetrationmult = 1.5D;
            damagemultiplier = 1.9D;
         } else if (immediatesourceentity instanceof LargeStealthBulletEntity) {
            penetrationmult = 0.0D;
            damagemultiplier = 1.9D;
         } else if (immediatesourceentity instanceof ExtraLargeBulletFireEntity) {
            penetrationmult = 0.0D;
            damagemultiplier = 2.25D;
         } else {
            penetrationmult = 0.0D;
            damagemultiplier = 1.0D;
         }

         Level _level;
         if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:bulletproof")))) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:wizz")), SoundSource.NEUTRAL, 3.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:wizz")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
               }
            }

            ItemStack var10000;
            LivingEntity _entGetArmor;
            if (entity instanceof LivingEntity) {
               _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            LivingEntity _entGetArmor;
            LivingEntity _entGetArmor;
            label148: {
               if (var10000.m_41720_() != CrustyChunksModItems.BLAST_ARMOR_CHESTPLATE.get()) {
                  if (entity instanceof LivingEntity) {
                     _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() != CrustyChunksModItems.BODY_ARMOR_CHESTPLATE.get()) {
                     entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("crusty_chunks:armor_bypass_damage")))), (float)(6.0D * damagemultiplier - penetrationmult));
                     break label148;
                  }
               }

               entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("crusty_chunks:armor_bypass_damage")))), (float)(4.0D * damagemultiplier + penetrationmult));
               if (entity instanceof LivingEntity) {
                  _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               ItemStack _ist = var10000;
               if (_ist.m_220157_(4, RandomSource.m_216327_(), (ServerPlayer)null)) {
                  _ist.m_41774_(1);
                  _ist.m_41721_(0);
               }
            }

            if (immediatesourceentity.m_20186_() - immediatesourceentity.m_20154_().f_82480_ * Math.sqrt(Math.pow(entity.m_20185_() - immediatesourceentity.m_20185_(), 2.0D) + Math.pow(entity.m_20189_() - immediatesourceentity.m_20189_(), 2.0D)) > entity.m_20186_() + 1.55D) {
               if (entity instanceof LivingEntity) {
                  _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() != CrustyChunksModItems.BLAST_ARMOR_HELMET.get()) {
                  if (entity instanceof LivingEntity) {
                     _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() != CrustyChunksModItems.BULLET_RESISTANT_HELMET_HELMET.get()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() != CrustyChunksModItems.NVD_HELMET_HELMET.get()) {
                        if (entity instanceof LivingEntity) {
                           _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41720_() != CrustyChunksModItems.GAS_MASK_HELMET_HELMET.get()) {
                           entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("crusty_chunks:armor_bypass_damage")))), (float)(6.0D * damagemultiplier - penetrationmult));
                           return;
                        }
                     }
                  }
               }

               entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("crusty_chunks:armor_bypass_damage")))), (float)(3.0D * damagemultiplier + penetrationmult));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               ItemStack _ist = var10000;
               if (_ist.m_220157_(7, RandomSource.m_216327_(), (ServerPlayer)null)) {
                  _ist.m_41774_(1);
                  _ist.m_41721_(0);
               }
            }
         } else {
            if (Mth.m_216271_(RandomSource.m_216327_(), 1, 2) == 1) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            } else if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123759_, x, y, z, 5, 1.0D, 3.0D, 1.0D, 0.05D);
            }

            entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268739_)), (float)(4.0D * damagemultiplier + penetrationmult));
         }

      }
   }
}

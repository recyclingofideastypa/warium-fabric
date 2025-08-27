package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ToxicCloudEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean found = false;
         double particleRadius = 0.0D;
         double particleAmount = 0.0D;
         double sx = 0.0D;
         double sy = 0.0D;
         double sz = 0.0D;
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double Groundatspot = 0.0D;
         immediatesourceentity.m_20242_(true);
         immediatesourceentity.f_19794_ = true;
         immediatesourceentity.m_20256_(new Vec3(0.0D, 0.0D, 0.0D));
         if (!immediatesourceentity.getPersistentData().m_128471_("Used")) {
            for(int index0 = 0; index0 < 5; ++index0) {
               world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.GAS_CLOUD.get(), x + Mth.m_216263_(RandomSource.m_216327_(), -6.5D, 7.5D), y + 1.0D, z + Mth.m_216263_(RandomSource.m_216327_(), -6.5D, 7.5D), Mth.m_216263_(RandomSource.m_216327_(), -0.5D, 0.5D), Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.3D), Mth.m_216263_(RandomSource.m_216327_(), -0.5D, 0.5D));
            }

            immediatesourceentity.getPersistentData().m_128379_("Used", true);
         }

         if (immediatesourceentity.getPersistentData().m_128459_("T") <= 200.0D) {
            immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
            if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 20)) {
               Vec3 _center = new Vec3(x, y, z);
               List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(15.0D), (e) -> {
                  return true;
               }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.m_20238_(_center);
               })).toList();
               Iterator var29 = _entfound.iterator();

               while(var29.hasNext()) {
                  Entity entityiterator = (Entity)var29.next();
                  if (entityiterator instanceof LivingEntity) {
                     immediatesourceentity.m_7618_(Anchor.EYES, new Vec3(entityiterator.m_20185_(), entityiterator.m_20186_() + 1.0D, entityiterator.m_20189_()));
                     if (Math.abs(entityiterator.m_20186_() - y) - (Math.abs((double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(8.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123342_() - y) + 0.5D) <= 0.0D && Math.abs(entityiterator.m_20185_() - x) - (Math.abs((double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(17.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123341_() - x) + 0.5D) <= 0.0D && Math.abs(entityiterator.m_20189_() - z) - (Math.abs((double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(17.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123343_() - z) + 0.5D) <= 0.0D) {
                        Object var10000 = CrustyChunksModItems.GAS_MASK_HELMET.get();
                        ItemStack var10001;
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                           var10001 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        if (var10000 != var10001.m_41720_()) {
                           var10000 = CrustyChunksModItems.GAS_MASK_HELMET_HELMET.get();
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                              var10001 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10001 = ItemStack.f_41583_;
                           }

                           if (var10000 != var10001.m_41720_()) {
                              LivingEntity _entity;
                              if (entityiterator instanceof LivingEntity) {
                                 _entity = (LivingEntity)entityiterator;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19614_, 60, 1, false, false));
                                 }
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 _entity = (LivingEntity)entityiterator;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19612_, 60, 1, false, false));
                                 }
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 _entity = (LivingEntity)entityiterator;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 60, 0, false, false));
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         } else if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

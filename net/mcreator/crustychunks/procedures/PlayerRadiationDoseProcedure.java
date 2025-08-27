package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class PlayerRadiationDoseProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         LivingEntity _entity;
         if (Mth.m_216271_(RandomSource.m_216327_(), 1, 100) == 1 && (double)Mth.m_216271_(RandomSource.m_216327_(), 10, 1000) <= entity.getPersistentData().m_128459_("Radiation") && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:radiation_proof"))) && 50.0D <= entity.getPersistentData().m_128459_("Radiation")) {
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19614_, 400, 0, false, false));
               }
            }

            if (250.0D <= entity.getPersistentData().m_128459_("Radiation")) {
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19615_, 400, 0, false, false));
                  }
               }

               entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 2.0F);
            }
         }

         if (4000.0D <= entity.getPersistentData().m_128459_("Radiation") && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:radiation_proof")))) {
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19615_, 400, 1, false, false));
               }
            }

            entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 2.0F);
         }

         if (entity.getPersistentData().m_128459_("Radiation") >= 1.0D) {
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.RADIATION.get(), 20, 1, false, false));
               }
            }

            if (Mth.m_216271_(RandomSource.m_216327_(), 1, 10) == 1) {
               entity.getPersistentData().m_128347_("Radiation", entity.getPersistentData().m_128459_("Radiation") - 1.0D);
            }
         } else {
            entity.getPersistentData().m_128347_("Radiation", 0.0D);
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)CrustyChunksModMobEffects.RADIATION.get());
            }
         }

      }
   }
}

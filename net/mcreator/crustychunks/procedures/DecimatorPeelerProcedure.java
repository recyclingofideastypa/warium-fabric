package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.RocketEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class DecimatorPeelerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 100, 8, true, false));
            }
         }

         if (entity.getPersistentData().m_128459_("Rocket") < 4.0D) {
            if (entity instanceof Mob) {
               Mob _entity = (Mob)entity;
               _entity.m_21573_().m_26573_();
            }

            if (world instanceof ServerLevel) {
               ServerLevel projectileLevel = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new RocketEntity((EntityType)CrustyChunksModEntities.ROCKET.get(), level);
                     entityToSpawn.m_5602_(shooter);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36762_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, 1.0F, 1);
               _entityToSpawn.m_6034_(x + entity.m_20154_().f_82479_ * 2.0D, y + 3.0D, z + entity.m_20154_().f_82481_ * 2.0D);
               _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_ + 0.08D, entity.m_20154_().f_82481_, 5.0F, 1.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }

            entity.getPersistentData().m_128347_("T", (double)Mth.m_216271_(RandomSource.m_216327_(), 15, 20));
            entity.getPersistentData().m_128347_("Rocket", entity.getPersistentData().m_128459_("Rocket") + 1.0D);
            Level _level;
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:peelerpod")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 1.6D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:peelerpod")), SoundSource.NEUTRAL, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 1.6D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:peelerpodfar")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 1.6D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:peelerpodfar")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 1.6D), false);
               }
            }
         }

      }
   }
}

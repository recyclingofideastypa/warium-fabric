package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.EradicatorEntity;
import net.mcreator.crustychunks.entity.LargeFlakProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
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

public class EradicatorFlakProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Barrels = 0.0D;
         double Xvector = 0.0D;
         double Zvector = 0.0D;
         double Pitch = 0.0D;
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 80, 8, true, false));
            }
         }

         entity.m_146922_(entity.m_146908_());
         entity.m_146926_(entity.m_146909_());
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

         Level projectileLevel = entity.m_9236_();
         if (!projectileLevel.m_5776_()) {
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new LargeFlakProjectileEntity((EntityType)CrustyChunksModEntities.LARGE_FLAK_PROJECTILE.get(), level);
                  entityToSpawn.m_5602_(shooter);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36762_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, entity, 1.0F, 1);
            _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
            _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 7.2F, 1.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         entity.getPersistentData().m_128347_("T", (double)Mth.m_216271_(RandomSource.m_216327_(), 38, 42));
         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:battlecannon")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:battlecannon")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.NEUTRAL, 60.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.3D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.NEUTRAL, 60.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.3D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.NEUTRAL, 120.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.3D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.NEUTRAL, 120.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.3D), false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.PUFF.get(), x + entity.m_20154_().f_82479_ * 8.0D + 0.0D, y + entity.m_20154_().f_82480_ * 5.0D + 5.0D, z + entity.m_20154_().f_82481_ * 8.0D + 0.0D, 20, 0.1D, 0.1D, 0.1D, 0.5D);
         }

         if (entity instanceof EradicatorEntity) {
            ((EradicatorEntity)entity).setAnimation("Fire");
         }

      }
   }
}

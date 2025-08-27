package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.ToxicCloudDetectorEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class GasExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double particleRadius = 0.0D;
      double particleAmount = 0.0D;
      Level _level;
      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_254849_((Entity)null, x, y, z, 2.0F, ExplosionInteraction.NONE);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 5.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 5.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 20.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 20.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
         }
      }

      for(int index0 = 0; index0 < 10; ++index0) {
         if (world instanceof ServerLevel) {
            ServerLevel projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new ToxicCloudDetectorEntity((EntityType)CrustyChunksModEntities.TOXIC_CLOUD_DETECTOR.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 0);
            _entityToSpawn.m_6034_(x, y + 3.0D, z);
            _entityToSpawn.m_6686_(Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), Mth.m_216263_(RandomSource.m_216327_(), 0.0D, 1.0D), Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), 5.0F, 0.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }
      }

   }
}

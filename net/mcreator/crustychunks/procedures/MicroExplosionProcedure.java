package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.ParticleProjectileEntity;
import net.mcreator.crustychunks.entity.SplashEffectClientBypassEntity;
import net.mcreator.crustychunks.entity.TinyClientEffectEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.registries.ForgeRegistries;

public class MicroExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      ServerLevel _level;
      Projectile _entityToSpawn;
      Level _level;
      if (world.m_6425_(BlockPos.m_274561_(x, y + 1.0D, z)).m_76188_().m_60734_() instanceof LiquidBlock) {
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new SplashEffectClientBypassEntity((EntityType)CrustyChunksModEntities.SPLASH_EFFECT_CLIENT_BYPASS.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  return entityToSpawn;
               }
            })).getArrow(_level, 0.0F, 0);
            _entityToSpawn.m_6034_(x, y + 1.5D, z);
            _entityToSpawn.m_6686_(0.0D, 1.0D, 0.0D, 0.3F, 180.0F);
            _level.m_7967_(_entityToSpawn);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_254849_((Entity)null, x, y, z, 1.0F, ExplosionInteraction.TNT);
            }
         }
      } else if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new TinyClientEffectEntity((EntityType)CrustyChunksModEntities.TINY_CLIENT_EFFECT.get(), level);
               entityToSpawn.m_36781_((double)damage);
               entityToSpawn.m_36735_(knockback);
               entityToSpawn.m_20225_(true);
               return entityToSpawn;
            }
         })).getArrow(_level, 0.0F, 0);
         _entityToSpawn.m_6034_(x, y + 1.5D, z);
         _entityToSpawn.m_6686_(0.0D, 1.0D, 0.0D, 0.3F, 180.0F);
         _level.m_7967_(_entityToSpawn);
      }

      CrustyChunksMod.queueServerWork(5, () -> {
         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_254849_((Entity)null, x + 0.0D, y + 0.0D, z + 0.0D, 1.5F, ExplosionInteraction.TNT);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_254849_((Entity)null, x + 0.0D, y + 0.0D, z + 0.0D, 2.0F, ExplosionInteraction.NONE);
            }
         }

      });
      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.MASTER, 1000.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.MASTER, 1000.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.MASTER, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.5D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.MASTER, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.5D), false);
         }
      }

      for(int index0 = 0; index0 < 20; ++index0) {
         if (world instanceof ServerLevel) {
            ServerLevel projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new ParticleProjectileEntity((EntityType)CrustyChunksModEntities.PARTICLE_PROJECTILE.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 3, (byte)2);
            _entityToSpawn.m_6034_(x, y + 0.5D, z);
            _entityToSpawn.m_6686_(Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), 0.2D, Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.6D, 0.7D), 45.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.m_8767_(ParticleTypes.f_123747_, x, y, z, 1, 0.5D, 0.5D, 0.5D, 0.6D);
      }

   }
}

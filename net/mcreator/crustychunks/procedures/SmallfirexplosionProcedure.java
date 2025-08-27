package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.entity.EmberParticleProjectileEntity;
import net.mcreator.crustychunks.entity.FireClientEffectEntity;
import net.mcreator.crustychunks.entity.FlameThrowerEmberEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SmallfirexplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      world.m_46961_(BlockPos.m_274561_(x, y, z), false);
      Level _level;
      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:huge_explosion_distant")), SoundSource.MASTER, 40.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), -0.9D, 1.1D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:huge_explosion_distant")), SoundSource.MASTER, 40.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), -0.9D, 1.1D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.MASTER, 6.0F, (float)(0.5D + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D)));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.MASTER, 6.0F, (float)(0.5D + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D)), false);
         }
      }

      if (world.m_6425_(BlockPos.m_274561_(x, y + 1.0D, z)).m_76188_().m_60734_() instanceof LiquidBlock) {
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_254849_((Entity)null, x, y, z, 2.0F, ExplosionInteraction.NONE);
            }
         }
      } else if (world instanceof ServerLevel) {
         ServerLevel projectileLevel = (ServerLevel)world;
         Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
               AbstractArrow entityToSpawn = new FireClientEffectEntity((EntityType)CrustyChunksModEntities.FIRE_CLIENT_EFFECT.get(), level);
               entityToSpawn.m_36781_((double)damage);
               entityToSpawn.m_36735_(knockback);
               entityToSpawn.m_20225_(true);
               entityToSpawn.m_36767_(piercing);
               entityToSpawn.m_20254_(100);
               entityToSpawn.m_36762_(true);
               return entityToSpawn;
            }
         })).getArrow(projectileLevel, 11.0F, 3, (byte)2);
         _entityToSpawn.m_6034_(x, y + 1.0D, z);
         _entityToSpawn.m_6686_(0.0D, 1.0D, 0.0D, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.5D, 0.6D), 90.0F);
         projectileLevel.m_7967_(_entityToSpawn);
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_254849_((Entity)null, x, y + 1.0D, z, 2.0F, ExplosionInteraction.TNT);
         }
      }

      Projectile _entityToSpawn;
      ServerLevel projectileLevel;
      int index2;
      for(index2 = 0; index2 < 100; ++index2) {
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new EmberParticleProjectileEntity((EntityType)CrustyChunksModEntities.EMBER_PARTICLE_PROJECTILE.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  entityToSpawn.m_20254_(100);
                  entityToSpawn.m_36762_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 11.0F, 3, (byte)2);
            _entityToSpawn.m_6034_(x, y + 1.0D, z);
            _entityToSpawn.m_6686_(0.0D, 1.0D, 0.0D, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.6D, 0.7D), 90.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }
      }

      for(index2 = 0; index2 < 15; ++index2) {
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new FlameThrowerEmberEntity((EntityType)CrustyChunksModEntities.FLAME_THROWER_EMBER.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  entityToSpawn.m_20254_(100);
                  entityToSpawn.m_36762_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 11.0F, 3, (byte)2);
            _entityToSpawn.m_6034_(x, y + 1.0D, z);
            _entityToSpawn.m_6686_(0.0D, 1.0D, 0.0D, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.4D, 0.6D), 90.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }
      }

      sx = -5.0D;
      found = false;

      for(index2 = 0; index2 < 10; ++index2) {
         sy = -3.0D;

         for(int index3 = 0; index3 < 6; ++index3) {
            sz = -5.0D;

            for(int index4 = 0; index4 < 10; ++index4) {
               if (Math.sqrt(Math.pow(sz, 2.0D) + Math.pow(sx, 2.0D)) < 8.0D) {
                  BurnBlockProcedure.execute(world, x + sx, y + sy, z + sz);
               }

               ++sz;
            }

            ++sy;
         }

         ++sx;
      }

      Vec3 _center = new Vec3(x, y, z);
      List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(6.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.m_20238_(_center);
      })).toList();
      Iterator var25 = _entfound.iterator();

      while(var25.hasNext()) {
         Entity entityiterator = (Entity)var25.next();
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.FLAMMABLE.get(), 1000, 3));
            }
         }
      }

   }
}

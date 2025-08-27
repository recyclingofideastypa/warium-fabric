package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.entity.SmallClientEffectEntity;
import net.mcreator.crustychunks.entity.SplashEffectClientBypassEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class SmallExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      sx = -6.0D;
      found = false;

      int index3;
      for(index3 = 0; index3 < 12; ++index3) {
         sy = -3.0D;

         for(int index1 = 0; index1 < 2; ++index1) {
            sz = -6.0D;

            for(int index2 = 0; index2 < 12; ++index2) {
               if (world.m_8055_(BlockPos.m_274561_(x + sx, y + sy + 1.0D, z + sz)).m_60734_() != Blocks.f_50016_ && world.m_8055_(BlockPos.m_274561_(x + sx, y + sy, z + sz)).m_60734_() == Blocks.f_50493_) {
                  found = true;
                  if (found) {
                     BlockPos _bp = BlockPos.m_274561_(x + sx, y + sy, z + sz);
                     BlockState _bs = ((Block)CrustyChunksModBlocks.HARDDIRT.get()).m_49966_();
                     BlockState _bso = world.m_8055_(_bp);
                     UnmodifiableIterator var20 = _bso.m_61148_().entrySet().iterator();

                     while(var20.hasNext()) {
                        Entry<Property<?>, Comparable<?>> entry = (Entry)var20.next();
                        Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                        if (_property != null && _bs.m_61143_(_property) != null) {
                           try {
                              _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                           } catch (Exception var24) {
                           }
                        }
                     }

                     world.m_7731_(_bp, _bs, 3);
                  }
               }

               ++sz;
            }

            ++sy;
         }

         ++sx;
      }

      ServerLevel _level;
      Level _level;
      Projectile _entityToSpawn;
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
               _level.m_254849_((Entity)null, x, y, z, 3.0F, ExplosionInteraction.TNT);
            }
         }
      } else if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new SmallClientEffectEntity((EntityType)CrustyChunksModEntities.SMALL_CLIENT_EFFECT.get(), level);
               entityToSpawn.m_36781_((double)damage);
               entityToSpawn.m_36735_(knockback);
               entityToSpawn.m_20225_(true);
               return entityToSpawn;
            }
         })).getArrow(_level, 0.0F, 0);
         _entityToSpawn.m_6034_(x, y, z);
         _entityToSpawn.m_6686_(0.0D, 1.0D, 0.0D, 0.3F, 180.0F);
         _level.m_7967_(_entityToSpawn);
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_254849_((Entity)null, x, y, z, 3.0F, ExplosionInteraction.TNT);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_254849_((Entity)null, x, y, z, 5.0F, ExplosionInteraction.NONE);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.MASTER, 120.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.2D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.MASTER, 120.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.1D, 1.2D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.MASTER, 60.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.MASTER, 60.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.MASTER, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.05D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.MASTER, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.05D), false);
         }
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.m_8767_(ParticleTypes.f_123747_, x, y, z, 1, 0.0D, 0.0D, 0.0D, 1.0D);
      }

      for(index3 = 0; index3 < 75; ++index3) {
         if (world instanceof ServerLevel) {
            ServerLevel projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 3, (byte)2);
            _entityToSpawn.m_6034_(x, y, z);
            _entityToSpawn.m_6686_(Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), 0.1D, Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), (float)Mth.m_216263_(RandomSource.m_216327_(), 1.0D, 1.2D), 45.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }
      }

   }
}

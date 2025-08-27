package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.CIWSEntity;
import net.mcreator.crustychunks.entity.HugeAIBulletEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraftforge.registries.ForgeRegistries;

public class CIWSGunProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Barrels = 0.0D;
         double Xvector = 0.0D;
         double DrumPosition = 0.0D;
         double Zvector = 0.0D;
         double Pitch = 0.0D;
         Level projectileLevel = entity.m_9236_();
         if (!projectileLevel.m_5776_()) {
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new HugeAIBulletEntity((EntityType)CrustyChunksModEntities.HUGE_AI_BULLET.get(), level);
                  entityToSpawn.m_5602_(shooter);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, entity, 0.1F, 1, (byte)3);
            _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
            _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 8.0F, 2.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:brtttfar")), SoundSource.BLOCKS, 60.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:brtttfar")), SoundSource.BLOCKS, 60.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2D, 1.4D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rac")), SoundSource.BLOCKS, 30.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rac")), SoundSource.BLOCKS, 30.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.BLOCKS, 8.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 1.6D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.BLOCKS, 8.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 1.6D), false);
            }
         }

         if (entity instanceof CIWSEntity) {
            ((CIWSEntity)entity).setAnimation("Fire");
         }

      }
   }
}

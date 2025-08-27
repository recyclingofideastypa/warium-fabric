package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.entity.MuzzleFlashProducerEntity;
import net.mcreator.crustychunks.entity.SmallFlakShellProjectileEntity;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DecimatorFlakProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Barrels = 0.0D;
         double Xvector = 0.0D;
         double DrumPosition = 0.0D;
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

         Projectile _entityToSpawn;
         ServerLevel projectileLevel;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new SmallFlakShellProjectileEntity((EntityType)CrustyChunksModEntities.SMALL_FLAK_SHELL_PROJECTILE.get(), level);
                  entityToSpawn.m_5602_(shooter);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36762_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, entity, 1.0F, 1);
            _entityToSpawn.m_6034_(x + entity.m_20154_().f_82479_ * 3.0D, y + 3.0D + entity.m_20154_().f_82480_ * 3.0D, z + entity.m_20154_().f_82481_ * 3.0D);
            _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 8.0F, 4.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         Vec3 _center = new Vec3(x + entity.m_20154_().f_82479_ * 3.0D, y + 3.0D + entity.m_20154_().f_82480_ * 3.0D, z + entity.m_20154_().f_82481_ * 3.0D);
         List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(2.0D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.m_20238_(_center);
         })).toList();
         Iterator var20 = _entfound.iterator();

         while(var20.hasNext()) {
            Entity entityiterator = (Entity)var20.next();
            if (entityiterator instanceof SmallFlakShellProjectileEntity) {
               entityiterator.getPersistentData().m_128347_("Range", entity.getPersistentData().m_128459_("Range"));
            }
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new MuzzleFlashProducerEntity((EntityType)CrustyChunksModEntities.MUZZLE_FLASH_PRODUCER.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 0);
            _entityToSpawn.m_6034_(x + entity.m_20154_().f_82479_ * 3.0D, y + 3.0D + entity.m_20154_().f_82480_ * 3.0D, z + entity.m_20154_().f_82481_ * 3.0D);
            _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 0.0F, 0.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         entity.getPersistentData().m_128347_("T", 5.0D);
         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.05D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.NEUTRAL, 80.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.95D, 1.05D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.NEUTRAL, 25.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.4D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.NEUTRAL, 25.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3D, 1.4D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonclose")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 1.6D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonclose")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.5D, 1.6D), false);
            }
         }

         if (entity instanceof DecimatorEntity) {
            ((DecimatorEntity)entity).setAnimation("Shoot");
         }

      }
   }
}

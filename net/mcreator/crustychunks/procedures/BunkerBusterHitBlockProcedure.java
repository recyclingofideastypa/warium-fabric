package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.entity.BunkerBusterProjectileEntity;
import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BunkerBusterHitBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double Power = 0.0D;
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.BATTLE_CANNON_BREECH.get() && ((<undefinedtype>)(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Loaded")) {
            SmallExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.ARTILLERYBREECH.get() && ((<undefinedtype>)(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Loaded")) {
            MediumExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
            world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         }

         DamagesProcedure.execute(world, x, y, z);
         double var10000;
         if (immediatesourceentity instanceof Projectile) {
            Projectile _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.m_20184_().m_82553_();
         } else {
            var10000 = 0.0D;
         }

         Power = var10000;
         ServerLevel projectileLevel;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            projectileLevel.m_8767_(ParticleTypes.f_123747_, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.5D, 0.5D, 0.5D, 0.05D);
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            projectileLevel.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x + 0.5D, y + 0.5D, z + 0.5D, 40, 0.6D, 0.6D, 0.6D, 1.2D);
         }

         if (!world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:concrete"))) && (!(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60800_(world, BlockPos.m_274561_(x, y, z)) <= 10.0F) || !(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60800_(world, BlockPos.m_274561_(x, y, z)) >= 0.0F))) {
            SuperLargeBombProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
         } else {
            Level _level;
            if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:metal"))) && world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 15.0F, 0.8F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 15.0F, 0.8F, false);
               }
            }

            if (0.0D >= immediatesourceentity.getPersistentData().m_128459_("Hits") && 1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 10) && world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 20.0F, 0.8F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 20.0F, 0.8F, false);
               }
            }

            if (!(15.0D > immediatesourceentity.getPersistentData().m_128459_("Hits"))) {
               SuperLargeBombProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
            } else {
               if (world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new BunkerBusterProjectileEntity((EntityType)CrustyChunksModEntities.BUNKER_BUSTER_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36767_(piercing);
                        entityToSpawn.m_36762_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, immediatesourceentity, 20.0F, 1, (byte)50);
                  _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
                  _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), 3.0F, 0.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               Vec3 _center = new Vec3(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
               List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5D), (e) -> {
                  return true;
               }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.m_20238_(_center);
               })).toList();
               Iterator var12 = _entfound.iterator();

               while(var12.hasNext()) {
                  Entity entityiterator = (Entity)var12.next();
                  if (entityiterator instanceof BunkerBusterProjectileEntity) {
                     entityiterator.getPersistentData().m_128347_("Hits", immediatesourceentity.getPersistentData().m_128459_("Hits") + 1.0D + (double)Math.round(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60800_(world, BlockPos.m_274561_(x, y, z)) / 5.0F));
                  }
               }

               if (!immediatesourceentity.m_9236_().m_5776_()) {
                  immediatesourceentity.m_146870_();
               }
            }

            world.m_46961_(BlockPos.m_274561_(x, y, z), false);

            for(int index0 = 0; index0 < 15; ++index0) {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36762_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, immediatesourceentity, 0.5F, 1);
                  _entityToSpawn.m_6034_(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
                  _entityToSpawn.m_6686_(immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_(), (float)(Power + 2.0D), 8.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            }
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.HugeBulletFireEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.mcreator.crustychunks.item.SingleShotRifleItem;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SingleShotFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         if (entity.m_20142_()) {
            Movementinnacuracy = 7.0D;
         } else {
            Movementinnacuracy = 3.0D;
         }

         if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
            Movementinnacuracy = 0.05D;
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
            if (itemstack.m_41784_().m_128471_("Loaded")) {
               if (itemstack.m_41720_() instanceof SingleShotRifleItem) {
                  itemstack.m_41784_().m_128359_("geckoAnim", "fire");
               }

               Level projectileLevel = entity.m_9236_();
               if (!projectileLevel.m_5776_()) {
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new HugeBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_BULLET_FIRE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36767_(piercing);
                        entityToSpawn.m_36762_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, 3.0F, 1, (byte)5);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
                  _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 8.0F, (float)Movementinnacuracy);
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.HUGE_CASING.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }

               CrustyChunksMod.queueServerWork(1, () -> {
                  Level _level;
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumshot")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 0.8D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumshot")), SoundSource.NEUTRAL, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 0.8D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 40.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 40.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.NEUTRAL, 20.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.NEUTRAL, 20.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                     }
                  }

               });
               entity.m_146922_((float)((double)entity.m_146908_() + Mth.m_216263_(RandomSource.m_216327_(), -8.0D, 8.0D)));
               entity.m_146926_((float)((double)entity.m_146909_() - Mth.m_216263_(RandomSource.m_216327_(), 20.0D, 24.0D)));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               itemstack.m_41784_().m_128379_("Loaded", false);
               entity.m_20256_(new Vec3(entity.m_20184_().m_7096_() - entity.m_20154_().f_82479_, entity.m_20184_().m_7098_() - entity.m_20154_().f_82480_, entity.m_20184_().m_7094_() - entity.m_20154_().f_82481_));

               for(int index0 = 0; index0 < 15; ++index0) {
                  world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x + entity.m_20154_().f_82479_ * 1.0D, y + 1.5D, z + entity.m_20154_().f_82481_ * 1.0D, entity.m_20154_().f_82479_ * 0.2D + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), entity.m_20154_().f_82480_ * 0.2D + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D), entity.m_20154_().f_82481_ * 0.2D + Mth.m_216263_(RandomSource.m_216327_(), -0.1D, 0.1D));
               }
            } else if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
               }
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_("§4Weapon requires 2 hands to fire."), true);
            }
         }

      }
   }
}

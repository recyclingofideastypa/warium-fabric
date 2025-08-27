package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.SmokeClientBypassEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SmokeGrenadeHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_175827_, x, y + 1.0D, z, 25, 0.5D, 0.5D, 0.5D, 0.02D);
         }

         CrustyChunksMod.queueServerWork(20, () -> {
            if (world instanceof ServerLevel) {
               ServerLevel projectileLevel = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new SmokeClientBypassEntity((EntityType)CrustyChunksModEntities.SMOKE_CLIENT_BYPASS.get(), level);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, 5.0F, 1);
               _entityToSpawn.m_6034_(x + immediatesourceentity.m_20154_().f_82479_ * 1.5D, y + immediatesourceentity.m_20154_().f_82480_ * 1.5D + 2.0D, z - immediatesourceentity.m_20154_().f_82481_ * 1.5D);
               _entityToSpawn.m_6686_(0.0D, 1.0D, 0.0D, 1.0F, 0.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.BLOCKS, 3.0F, 1.6F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.BLOCKS, 3.0F, 1.6F, false);
               }
            }

         });
      }
   }
}

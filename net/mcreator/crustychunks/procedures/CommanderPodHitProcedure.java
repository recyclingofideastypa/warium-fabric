package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class CommanderPodHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

         HeavyCrackProcedureProcedure.execute(world, x, y, z);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x + 0.5D, y + 1.5D, z + 0.5D, 25, 1.0D, 1.0D, 1.0D, 0.1D);
         }

         world.m_46796_(2001, BlockPos.m_274561_(x, y, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y, z))));
         CrustyChunksMod.queueServerWork(20, () -> {
            ServerLevel _level;
            Entity entityToSpawn;
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)CrustyChunksModEntities.COMMANDER.get()).m_262496_(_level, BlockPos.m_274561_(x + 0.5D, y + 1.0D, z + 0.5D), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)CrustyChunksModEntities.SCOUT.get()).m_262496_(_level, BlockPos.m_274561_(x + 0.5D, y + 2.0D, z + 0.5D), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
               }
            }

         });
         MicroExplosionProcedure.execute(world, immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());
      }
   }
}

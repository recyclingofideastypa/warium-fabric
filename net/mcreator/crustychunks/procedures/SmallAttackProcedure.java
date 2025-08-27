package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;

public class SmallAttackProcedure {
   public static void execute(LevelAccessor world, double x, double z) {
      double Riflers = 0.0D;
      double spawnx = 0.0D;
      double spawnz = 0.0D;
      double strikers = 0.0D;
      double workers = 0.0D;
      double breachers = 0.0D;
      if (world.m_6106_().m_5470_().m_46207_(CrustyChunksModGameRules.APOCALYPSE_MODE)) {
         Riflers = Math.min(4.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers -= Riflers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         strikers = Math.min(4.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseStrikers);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseStrikers -= strikers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         workers = Math.min(2.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseWorkers);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseWorkers -= workers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         breachers = Math.min(2.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseBreachers);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseBreachers -= breachers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
      } else {
         strikers = 4.0D;
         Riflers = 4.0D;
         workers = 2.0D;
         breachers = 2.0D;
      }

      int index3;
      ServerLevel _level;
      Entity entityToSpawn;
      for(index3 = 0; index3 < (int)Riflers; ++index3) {
         spawnx = x + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25);
         spawnz = z + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.RIFLER.get()).m_262496_(_level, BlockPos.m_274561_(spawnx, (double)(world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 2), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index3 = 0; index3 < (int)strikers; ++index3) {
         spawnx = x + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25);
         spawnz = z + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.STRIKER.get()).m_262496_(_level, BlockPos.m_274561_(spawnx, (double)(world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 2), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index3 = 0; index3 < (int)workers; ++index3) {
         spawnx = x + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25);
         spawnz = z + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.WORKER.get()).m_262496_(_level, BlockPos.m_274561_(spawnx, (double)(world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 2), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index3 = 0; index3 < (int)breachers; ++index3) {
         spawnx = x + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25);
         spawnz = z + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.BREACHER.get()).m_262496_(_level, BlockPos.m_274561_(spawnx, (double)(world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 2), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
            }
         }
      }

      if (world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         Entity entityToSpawn = ((EntityType)CrustyChunksModEntities.SCOUT.get()).m_262496_(_level, BlockPos.m_274561_(spawnx, (double)(world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 8), spawnz), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
         }
      }

   }
}

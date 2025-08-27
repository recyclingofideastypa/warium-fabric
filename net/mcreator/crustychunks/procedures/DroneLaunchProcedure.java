package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class DroneLaunchProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().m_128459_("I") <= 4.0D) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)CrustyChunksModEntities.SCOUT.get()).m_262496_(_level, BlockPos.m_274561_(x, y + 3.0D, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
               }
            }

            entity.getPersistentData().m_128347_("I", entity.getPersistentData().m_128459_("I") + 1.0D);
            entity.getPersistentData().m_128347_("T", entity.getPersistentData().m_128459_("T") + 80.0D);
         }

      }
   }
}

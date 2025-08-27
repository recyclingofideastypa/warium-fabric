package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class LandMineTriggerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            CrustyChunksMod.queueServerWork(7, () -> {
               if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.LAND_MINE.get()) {
                  world.m_46961_(BlockPos.m_274561_(x, y, z), false);
                  TinyExplosionProcedure.execute(world, x + 0.5D, y + 0.25D, z + 0.5D);
               }

            });
         }

      }
   }
}

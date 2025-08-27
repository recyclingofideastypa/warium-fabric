package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class HunterDeathProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         SmallExplosionProcedure.execute(world, x, y, z);
         GasolineExplosionProcedure.execute(world, x, y, z);
         if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         CrustyChunksMod.queueServerWork(60, () -> {
            if (world instanceof ServerLevel) {
               ServerLevel _levelx = (ServerLevel)world;
               ItemEntity entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ENGINE_COMPONENT.get()));
               entityToSpawn.m_32010_(10);
               _levelx.m_7967_(entityToSpawn);
            }

            for(int index0 = 0; index0 < 3; ++index0) {
               ItemEntity entityToSpawnx;
               ServerLevel _level;
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ALUMINUM_PLATE.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.HUGE_BULLET.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.HUGE_BULLET.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ELECTRIC_MOTOR.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ADVANCED_COMPONENT.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }
            }

         });
      }
   }
}

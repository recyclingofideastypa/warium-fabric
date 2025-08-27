package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class DecimatorDeathProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         MediumExplosionProcedure.execute(world, x, y, z);
         if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         CrustyChunksMod.queueServerWork(60, () -> {
            for(int index0 = 0; index0 < 3; ++index0) {
               ServerLevel _level;
               ItemEntity entityToSpawnx;
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.STEEL_BLOCK.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_SHELL.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_SHELL.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.AUTOCANNON_BARREL.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ADVANCED_COMPONENT.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.TECH_COMPONENT.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_GEAR.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.CAST_COMPONENT.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ELECTRIC_MOTOR.get()));
                  entityToSpawnx.m_32010_(10);
                  _level.m_7967_(entityToSpawnx);
               }
            }

            ServerLevel _levelx;
            ItemEntity entityToSpawn;
            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.MG_RECEIVER.get()));
               entityToSpawn.m_32010_(10);
               _levelx.m_7967_(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.STEEL_BLOCK.get()));
               entityToSpawn.m_32010_(10);
               _levelx.m_7967_(entityToSpawn);
            }

         });
      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.world.ForgeChunkManager;

public class ForceChunksProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel) {
         ServerLevel _world = (ServerLevel)world;
         ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45579_, true, true);
      }

      CrustyChunksMod.queueServerWork(60, () -> {
         if (world instanceof ServerLevel) {
            ServerLevel _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45578_, 0, world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45579_), world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45578_, world.m_46865_(new BlockPos((int)x, (int)y, (int)z)).m_7697_().f_45579_, false, true);
         }

      });
   }
}

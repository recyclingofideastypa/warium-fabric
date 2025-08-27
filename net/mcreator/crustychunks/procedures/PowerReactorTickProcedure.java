package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class PowerReactorTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.m_8055_(BlockPos.m_274561_(x, y - 2.0D, z)).m_60734_() == CrustyChunksModBlocks.POWER_REACTOR_PORT.get() && world.m_8055_(BlockPos.m_274561_(x, y - 1.0D, z)).m_60734_() == CrustyChunksModBlocks.BREEDER_REACTOR_CORE.get() && world.m_8055_(BlockPos.m_274561_(x, y - 1.0D, z - 2.0D)).m_60734_() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.m_8055_(BlockPos.m_274561_(x, y - 1.0D, z + 2.0D)).m_60734_() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.m_8055_(BlockPos.m_274561_(x - 2.0D, y - 1.0D, z)).m_60734_() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.m_8055_(BlockPos.m_274561_(x + 2.0D, y - 1.0D, z)).m_60734_() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x, y - 1.0D, z - 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x, y - 1.0D, z + 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x - 2.0D, y - 1.0D, z), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x + 2.0D, y - 1.0D, z), "Ready") && world.m_8055_(BlockPos.m_274561_(x, y, z - 2.0D)).m_60734_() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.m_8055_(BlockPos.m_274561_(x, y, z + 2.0D)).m_60734_() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.m_8055_(BlockPos.m_274561_(x - 2.0D, y, z)).m_60734_() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.m_8055_(BlockPos.m_274561_(x + 2.0D, y, z)).m_60734_() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z - 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z + 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x - 2.0D, y, z), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x + 2.0D, y, z), "Ready")) {
         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y - 2.0D, z), "Energy") < ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y - 2.0D, z), "Capacity") && !world.m_5776_()) {
            BlockPos _bp = BlockPos.m_274561_(x, y - 2.0D, z);
            BlockEntity _blockEntity = world.m_7702_(_bp);
            BlockState _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Energy", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.m_7702_(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.m_274561_(x, y - 2.0D, z), "Energy") + 40.0D);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:turbine")), SoundSource.NEUTRAL, 5.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:turbine")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
            }
         }
      }

   }
}

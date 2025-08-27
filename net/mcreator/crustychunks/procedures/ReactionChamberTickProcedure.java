package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class ReactionChamberTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean Ready = false;
      Ready = false;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      BlockPos _bp;
      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Cooldown") <= 0.0D) {
         if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:fuelrod")))) {
            FuelRodsDepleteProcedure.execute(world, x, y + 1.0D, z);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")), SoundSource.NEUTRAL, 1.0F, 2.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
               }
            }

            if (!world.m_5776_()) {
               _bp = BlockPos.m_274561_(x, y, z);
               _blockEntity = world.m_7702_(_bp);
               _bs = world.m_8055_(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().m_128347_("Cooldown", 12000.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.m_7260_(_bp, _bs, _bs, 3);
               }
            }
         }
      } else if (!world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _blockEntity = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128347_("Cooldown", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Cooldown") - 1.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z + 1.0D)).m_60734_() == CrustyChunksModBlocks.CONTROL_ROD.get() && world.m_8055_(BlockPos.m_274561_(x, y, z - 1.0D)).m_60734_() == CrustyChunksModBlocks.CONTROL_ROD.get() && world.m_8055_(BlockPos.m_274561_(x + 1.0D, y, z)).m_60734_() == CrustyChunksModBlocks.CONTROL_ROD.get() && world.m_8055_(BlockPos.m_274561_(x - 1.0D, y, z)).m_60734_() == CrustyChunksModBlocks.CONTROL_ROD.get() && world.m_8055_(BlockPos.m_274561_(x + 1.0D, y, z + 1.0D)).m_60734_() == CrustyChunksModBlocks.REACTOR_CASING.get() && world.m_8055_(BlockPos.m_274561_(x - 1.0D, y, z - 1.0D)).m_60734_() == CrustyChunksModBlocks.REACTOR_CASING.get() && world.m_8055_(BlockPos.m_274561_(x + 1.0D, y, z - 1.0D)).m_60734_() == CrustyChunksModBlocks.REACTOR_CASING.get() && world.m_8055_(BlockPos.m_274561_(x - 1.0D, y, z + 1.0D)).m_60734_() == CrustyChunksModBlocks.REACTOR_CASING.get()) {
         if (world.m_8055_(BlockPos.m_274561_(x, y - 1.0D, z)).m_60734_() == CrustyChunksModBlocks.REACTION_CHAMBER.get()) {
            if (world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:fuelrod")))) {
               Ready = true;
            } else {
               Ready = false;
            }
         } else if (!world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:fuelrod"))) && world.m_8055_(BlockPos.m_274561_(x, y + 1.0D, z)).m_60734_() != CrustyChunksModBlocks.REACTION_CHAMBER.get()) {
            Ready = false;
         } else {
            Ready = true;
         }
      } else {
         Ready = false;
      }

      if (Ready && world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.m_8767_(ParticleTypes.f_123745_, x + 0.5D, y + 0.7D, z + 0.5D, 8, 0.2D, 0.4D, 0.2D, 0.01D);
      }

      if (!world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _blockEntity = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128379_("Ready", Ready);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

   }
}

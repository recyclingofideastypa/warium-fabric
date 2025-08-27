package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class CuttersRightclickedOnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
      Level _level;
      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.RAZOR_WIRE.get()) {
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.m_220157_(4, RandomSource.m_216327_(), (ServerPlayer)null)) {
            itemstack.m_41774_(1);
            itemstack.m_41721_(0);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50033_) {
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.m_220157_(1, RandomSource.m_216327_(), (ServerPlayer)null)) {
            itemstack.m_41774_(1);
            itemstack.m_41721_(0);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50183_) {
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.m_220157_(8, RandomSource.m_216327_(), (ServerPlayer)null)) {
            itemstack.m_41774_(1);
            itemstack.m_41721_(0);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50191_) {
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.m_220157_(1, RandomSource.m_216327_(), (ServerPlayer)null)) {
            itemstack.m_41774_(1);
            itemstack.m_41721_(0);
         }
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.WIRE_FENCE.get()) {
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.m_220157_(8, RandomSource.m_216327_(), (ServerPlayer)null)) {
            itemstack.m_41774_(1);
            itemstack.m_41721_(0);
         }
      }

   }
}

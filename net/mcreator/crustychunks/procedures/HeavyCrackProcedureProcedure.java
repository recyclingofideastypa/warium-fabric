package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class HeavyCrackProcedureProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50228_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_49994_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.DESTROYED_CONCRETE.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_49994_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.DAMAGED_CONCRETE.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.DESTROYED_CONCRETE.get()).m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FRACTURED_CONCRETE.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.DAMAGED_CONCRETE.get()).m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.CRACKED_CONCRETE.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.FRACTURED_CONCRETE.get()).m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.REENFORCED_CONCRETE.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.CRACKED_CONCRETE.get()).m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.DAMAGED_CONCRETE_WALL.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.DESTROYED_CONCRETE_WALL.get()).m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FRACTURED_CONCRETE_WALL.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.DAMAGED_CONCRETE_WALL.get()).m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.CRACKED_CONCRETE_WALL.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.FRACTURED_CONCRETE_WALL.get()).m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.CONCRETE_WALL.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)CrustyChunksModBlocks.CRACKED_CONCRETE_WALL.get()).m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50228_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50652_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50122_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50652_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50334_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50652_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_152496_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50652_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50069_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50652_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_152550_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_152551_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50440_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50493_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50224_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50652_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50222_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50224_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50223_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50224_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_152594_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_152551_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_152589_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_152594_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_152595_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_152551_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_152559_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_152595_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50736_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50730_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50735_) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50736_.m_49966_(), 3);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50080_ || world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == Blocks.f_50723_) {
         world.m_46961_(BlockPos.m_274561_(x, y, z), false);
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }
      }

   }
}

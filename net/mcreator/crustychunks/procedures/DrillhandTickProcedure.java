package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class DrillhandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
      if (0.0D < itemstack.m_41784_().m_128459_("T")) {
         itemstack.m_41784_().m_128347_("T", itemstack.m_41784_().m_128459_("T") - 1.0D);
      }

      if (0.0D < itemstack.m_41784_().m_128459_("Fluid")) {
         Level _level;
         if (0.0D < itemstack.m_41784_().m_128459_("T")) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")), SoundSource.NEUTRAL, 0.7F, (float)Mth.m_216263_(RandomSource.m_216327_(), 2.3D, 2.4D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")), SoundSource.NEUTRAL, 0.7F, (float)Mth.m_216263_(RandomSource.m_216327_(), 2.3D, 2.4D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.polished_deepslate.break")), SoundSource.NEUTRAL, 0.7F, (float)Mth.m_216263_(RandomSource.m_216327_(), 2.3D, 2.4D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.polished_deepslate.break")), SoundSource.NEUTRAL, 0.7F, (float)Mth.m_216263_(RandomSource.m_216327_(), 2.3D, 2.4D), false);
               }
            }
         } else if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.8D, 2.0D));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.8D, 2.0D), false);
            }
         }
      }

   }
}

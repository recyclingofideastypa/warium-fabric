package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GeigerCounterHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String severitycolor = "";
         if (0.0D <= entity.getPersistentData().m_128459_("Radiation")) {
            severitycolor = "§a";
            if (20.0D <= entity.getPersistentData().m_128459_("Radiation")) {
               severitycolor = "§e";
               if (40.0D <= entity.getPersistentData().m_128459_("Radiation")) {
                  severitycolor = "§6";
                  if (60.0D <= entity.getPersistentData().m_128459_("Radiation")) {
                     severitycolor = "§c";
                     if (100.0D <= entity.getPersistentData().m_128459_("Radiation")) {
                        severitycolor = "§m";
                        if (140.0D <= entity.getPersistentData().m_128459_("Radiation")) {
                           severitycolor = "§4";
                           if (180.0D <= entity.getPersistentData().m_128459_("Radiation")) {
                              severitycolor = "§0";
                           }
                        }
                     }
                  }
               }
            }
         }

         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            if (_livEnt.m_21023_((MobEffect)CrustyChunksModMobEffects.RADIATION.get()) && Mth.m_216263_(RandomSource.m_216327_(), 2.0D, 250.0D) <= entity.getPersistentData().m_128459_("Radiation") && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 2.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
               }
            }
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() != CrustyChunksModItems.GEIGER_COUNTER.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != CrustyChunksModItems.GEIGER_COUNTER.get()) {
               return;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(severitycolor + "Radiation Exposure:" + (new DecimalFormat("####")).format(entity.getPersistentData().m_128459_("Radiation"))), true);
            }
         }

      }
   }
}

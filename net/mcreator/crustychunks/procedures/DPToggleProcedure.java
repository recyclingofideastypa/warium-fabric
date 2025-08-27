package net.mcreator.crustychunks.procedures;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules.BooleanValue;

public class DPToggleProcedure {
   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity != null) {
         double Riflers = 0.0D;
         double Commanders = 0.0D;
         double Decimators = 0.0D;
         double spawnx = 0.0D;
         double spawnz = 0.0D;
         double Mortarers = 0.0D;
         double Flamers = 0.0D;
         double Hunters = 0.0D;
         ((BooleanValue)world.m_6106_().m_5470_().m_46170_(CrustyChunksModGameRules.WARIUM_APOCALYPSE_DYNAMIC_PRODUCTION)).m_46246_(BoolArgumentType.getBool(arguments, "Toggle"), world.m_7654_());
         Player _player;
         if (BoolArgumentType.getBool(arguments, "Toggle")) {
            if (entity instanceof Player) {
               _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("Dynamic Production set to: True"), false);
               }
            }
         } else if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_("Dynamic Production set to: False"), false);
            }
         }

      }
   }
}

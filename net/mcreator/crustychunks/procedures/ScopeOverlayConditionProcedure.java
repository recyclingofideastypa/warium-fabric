package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

public class ScopeOverlayConditionProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean Sneaking = false;
         if (entity instanceof Player) {
            Player _plrCldCheck1 = (Player)entity;
            ItemCooldowns var10000 = _plrCldCheck1.m_36335_();
            ItemStack var10001;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            if (var10000.m_41519_(var10001.m_41720_())) {
               return Sneaking;
            }
         }

         ItemStack var6;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var6 = _livEnt.m_21205_();
         } else {
            var6 = ItemStack.f_41583_;
         }

         if (var6.m_41720_() != CrustyChunksModItems.SCOPED_BOLT_ACTION_RIFLE_ANIMATED.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var6 = _livEnt.m_21205_();
            } else {
               var6 = ItemStack.f_41583_;
            }

            if (var6.m_41720_() != CrustyChunksModItems.SCOPED_BREECH_RIFLE.get()) {
               return Sneaking;
            }
         }

         if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
            Sneaking = true;
         } else {
            Sneaking = false;
         }

         return Sneaking;
      }
   }
}

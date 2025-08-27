package net.mcreator.crustychunks.procedures;

import javax.annotation.Nullable;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent.ComputeFov;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class WeaponCrossOverlayProcedure {
   public static ComputeFov provider = null;

   public static void setFOV(double fov) {
      provider.setFOV(fov);
   }

   @SubscribeEvent
   public static void computeFOV(ComputeFov event) {
      provider = event;
      ClientLevel level = Minecraft.m_91087_().f_91073_;
      Entity entity = provider.getCamera().m_90592_();
      if (level != null && entity != null) {
         Vec3 entPos = entity.m_20318_((float)provider.getPartialTick());
         execute(provider, level, entity);
      }

   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_204117_(ItemTags.create(new ResourceLocation("crusty_chunks:firearm")))) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != CrustyChunksModItems.PUMP_ACTION_SHOTGUN_ANIMATED.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() != CrustyChunksModItems.BREAK_ACTION_SHOTGUN_ANIMATED.get()) {
                  if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                     if (world.m_5776_()) {
                        Minecraft.m_91087_().m_91097_().m_174784_(new ResourceLocation("crusty_chunks:textures/screens/iconssneak.png"));
                        Minecraft.m_91087_().m_91097_().m_118495_(new ResourceLocation("minecraft:textures/gui/icons.png"), Minecraft.m_91087_().m_91097_().m_118506_(new ResourceLocation("crusty_chunks:textures/screens/iconssneak.png")));
                        return;
                     }
                  } else if (world.m_5776_()) {
                     Minecraft.m_91087_().m_91097_().m_174784_(new ResourceLocation("crusty_chunks:textures/screens/icons.png"));
                     Minecraft.m_91087_().m_91097_().m_118495_(new ResourceLocation("minecraft:textures/gui/icons.png"), Minecraft.m_91087_().m_91097_().m_118506_(new ResourceLocation("crusty_chunks:textures/screens/icons.png")));
                     return;
                  }

                  return;
               }
            }

            if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
               if (world.m_5776_()) {
                  Minecraft.m_91087_().m_91097_().m_174784_(new ResourceLocation("crusty_chunks:textures/screens/iconshotgunsneak.png"));
                  Minecraft.m_91087_().m_91097_().m_118495_(new ResourceLocation("minecraft:textures/gui/icons.png"), Minecraft.m_91087_().m_91097_().m_118506_(new ResourceLocation("crusty_chunks:textures/screens/iconshotgunsneak.png")));
               }
            } else if (world.m_5776_()) {
               Minecraft.m_91087_().m_91097_().m_174784_(new ResourceLocation("crusty_chunks:textures/screens/iconshotgun.png"));
               Minecraft.m_91087_().m_91097_().m_118495_(new ResourceLocation("minecraft:textures/gui/icons.png"), Minecraft.m_91087_().m_91097_().m_118506_(new ResourceLocation("crusty_chunks:textures/screens/iconshotgun.png")));
            }
         } else if (world.m_5776_()) {
            Minecraft.m_91087_().m_91097_().m_174784_(new ResourceLocation("crusty_chunks:textures/screens/iconsdefault.png"));
            Minecraft.m_91087_().m_91097_().m_118495_(new ResourceLocation("minecraft:textures/gui/icons.png"), Minecraft.m_91087_().m_91097_().m_118506_(new ResourceLocation("crusty_chunks:textures/screens/iconsdefault.png")));
         }

      }
   }
}

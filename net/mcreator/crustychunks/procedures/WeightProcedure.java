package net.mcreator.crustychunks.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.IItemHandler;

@EventBusSubscriber
public class WeightProcedure {
   @SubscribeEvent
   public static void onPlayerTick(PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.m_9236_(), event.player);
      }

   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         double Weight = 0.0D;
         if (((<undefinedtype>)(new Object() {
            public boolean checkGamemode(Entity _ent) {
               if (_ent instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                  return _serverPlayer.f_8941_.m_9290_() == GameType.SURVIVAL;
               } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player) {
                  Player _player = (Player)_ent;
                  return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SURVIVAL;
               } else {
                  return false;
               }
            }
         })).checkGamemode(entity)) {
            Weight = 0.0D;
            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
            LazyOptional var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
            Objects.requireNonNull(_iitemhandlerref);
            var10000.ifPresent(_iitemhandlerref::set);
            if (_iitemhandlerref.get() != null) {
               for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                  ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                  if (CrustyChunksModItems.ARMOR_PEELER_ROCKET.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 200);
                  }

                  if (CrustyChunksModItems.GRENADE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 50);
                  }

                  if (CrustyChunksModItems.SMOKE_GRENADE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 50);
                  }

                  if (CrustyChunksModItems.SEMI_AUTOMATIC_PISTOL_ANIMATED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 75);
                  }

                  if (CrustyChunksModItems.STEALTH_PISTOL.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 75);
                  }

                  if (CrustyChunksModItems.REVOLVER_ANIMATED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 75);
                  }

                  if (CrustyChunksModItems.AUTO_PISTOL.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 75);
                  }

                  if (CrustyChunksModItems.AUTOMATIC_RIFLE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  if (CrustyChunksModItems.SEMI_AUTOMATIC_RIFLE_ANIMATED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  if (CrustyChunksModItems.SCOPED_BOLT_ACTION_RIFLE_ANIMATED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  if (CrustyChunksModItems.ARMOR_PEELER_UNLOADED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 100);
                  }

                  if (CrustyChunksModItems.ARMOR_PEELER_ANIMATED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  if (CrustyChunksModItems.SMG_ANIMATED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 150);
                  }

                  if (CrustyChunksModItems.PUMP_ACTION_SHOTGUN_ANIMATED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  if (CrustyChunksModItems.BREAK_ACTION_SHOTGUN_ANIMATED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  if (CrustyChunksModItems.SINGLE_SHOT_RIFLE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 750);
                  }

                  if (CrustyChunksModItems.LMG_ANIMATED.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 600);
                  }

                  if (CrustyChunksModItems.ERADICATION.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 750);
                  }

                  if (CrustyChunksModItems.BATTLE_RIFLE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 600);
                  }

                  if (CrustyChunksModItems.BURST_RIFLE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  if (CrustyChunksModItems.MACHINE_CARBINE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 200);
                  }

                  if (CrustyChunksModItems.BREECH_RIFLE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  if (CrustyChunksModItems.SCOPED_BREECH_RIFLE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  if (CrustyChunksModItems.LEVER_RIFLE.get() == itemstackiterator.m_41720_()) {
                     Weight += (double)(itemstackiterator.m_41613_() * 300);
                  }

                  LivingEntity _entity;
                  if (Weight > 1000.0D && entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
                     }
                  }

                  if (Weight > 1500.0D) {
                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 4, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 2, 2, false, false));
                        }
                     }
                  }

                  if (itemstackiterator.m_204117_(ItemTags.create(new ResourceLocation("crusty_chunks:heavy"))) && entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 4, false, false));
                     }
                  }
               }
            }
         }

      }
   }
}

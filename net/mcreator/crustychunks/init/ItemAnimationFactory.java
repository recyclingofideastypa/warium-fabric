package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.item.ArmorPeelerAnimatedItem;
import net.mcreator.crustychunks.item.AutoPistolItem;
import net.mcreator.crustychunks.item.AutomaticRifleItem;
import net.mcreator.crustychunks.item.BattleRifleItem;
import net.mcreator.crustychunks.item.BoltActionRifleAnimatedItem;
import net.mcreator.crustychunks.item.BreakActionShotgunAnimatedItem;
import net.mcreator.crustychunks.item.BreechRifleItem;
import net.mcreator.crustychunks.item.BurstRifleItem;
import net.mcreator.crustychunks.item.EradicationItem;
import net.mcreator.crustychunks.item.FlameThrowerAnimatedItem;
import net.mcreator.crustychunks.item.FlarePistolItem;
import net.mcreator.crustychunks.item.HandDrillItem;
import net.mcreator.crustychunks.item.LMGAnimatedItem;
import net.mcreator.crustychunks.item.LeverRifleItem;
import net.mcreator.crustychunks.item.MachineCarbineItem;
import net.mcreator.crustychunks.item.PumpActionShotgunAnimatedItem;
import net.mcreator.crustychunks.item.RevolverAnimatedItem;
import net.mcreator.crustychunks.item.SMGAnimatedItem;
import net.mcreator.crustychunks.item.ScopedBoltActionRifleAnimatedItem;
import net.mcreator.crustychunks.item.ScopedBreechRifleItem;
import net.mcreator.crustychunks.item.SemiAutomaticPistolAnimatedItem;
import net.mcreator.crustychunks.item.SemiAutomaticRifleAnimatedItem;
import net.mcreator.crustychunks.item.SingleShotRifleItem;
import net.mcreator.crustychunks.item.StealthPistolItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ItemAnimationFactory {
   @SubscribeEvent
   public static void animatedItems(PlayerTickEvent event) {
      String animation = "";
      ItemStack mainhandItem = event.player.m_21205_().m_41777_();
      ItemStack offhandItem = event.player.m_21206_().m_41777_();
      if (event.phase == Phase.START && (mainhandItem.m_41720_() instanceof GeoItem || offhandItem.m_41720_() instanceof GeoItem)) {
         Item var5 = mainhandItem.m_41720_();
         SemiAutomaticRifleAnimatedItem animatable;
         if (var5 instanceof SemiAutomaticRifleAnimatedItem) {
            animatable = (SemiAutomaticRifleAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SemiAutomaticRifleAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof SemiAutomaticRifleAnimatedItem) {
            animatable = (SemiAutomaticRifleAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SemiAutomaticRifleAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         SemiAutomaticPistolAnimatedItem animatable;
         if (var5 instanceof SemiAutomaticPistolAnimatedItem) {
            animatable = (SemiAutomaticPistolAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SemiAutomaticPistolAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof SemiAutomaticPistolAnimatedItem) {
            animatable = (SemiAutomaticPistolAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SemiAutomaticPistolAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         BoltActionRifleAnimatedItem animatable;
         if (var5 instanceof BoltActionRifleAnimatedItem) {
            animatable = (BoltActionRifleAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BoltActionRifleAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof BoltActionRifleAnimatedItem) {
            animatable = (BoltActionRifleAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BoltActionRifleAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         ScopedBoltActionRifleAnimatedItem animatable;
         if (var5 instanceof ScopedBoltActionRifleAnimatedItem) {
            animatable = (ScopedBoltActionRifleAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ScopedBoltActionRifleAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof ScopedBoltActionRifleAnimatedItem) {
            animatable = (ScopedBoltActionRifleAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ScopedBoltActionRifleAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         PumpActionShotgunAnimatedItem animatable;
         if (var5 instanceof PumpActionShotgunAnimatedItem) {
            animatable = (PumpActionShotgunAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((PumpActionShotgunAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof PumpActionShotgunAnimatedItem) {
            animatable = (PumpActionShotgunAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((PumpActionShotgunAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         ArmorPeelerAnimatedItem animatable;
         if (var5 instanceof ArmorPeelerAnimatedItem) {
            animatable = (ArmorPeelerAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ArmorPeelerAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof ArmorPeelerAnimatedItem) {
            animatable = (ArmorPeelerAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ArmorPeelerAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         SMGAnimatedItem animatable;
         if (var5 instanceof SMGAnimatedItem) {
            animatable = (SMGAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SMGAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof SMGAnimatedItem) {
            animatable = (SMGAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SMGAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         FlameThrowerAnimatedItem animatable;
         if (var5 instanceof FlameThrowerAnimatedItem) {
            animatable = (FlameThrowerAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((FlameThrowerAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof FlameThrowerAnimatedItem) {
            animatable = (FlameThrowerAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((FlameThrowerAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         RevolverAnimatedItem animatable;
         if (var5 instanceof RevolverAnimatedItem) {
            animatable = (RevolverAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((RevolverAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof RevolverAnimatedItem) {
            animatable = (RevolverAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((RevolverAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         SingleShotRifleItem animatable;
         if (var5 instanceof SingleShotRifleItem) {
            animatable = (SingleShotRifleItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SingleShotRifleItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof SingleShotRifleItem) {
            animatable = (SingleShotRifleItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SingleShotRifleItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         LMGAnimatedItem animatable;
         if (var5 instanceof LMGAnimatedItem) {
            animatable = (LMGAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((LMGAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof LMGAnimatedItem) {
            animatable = (LMGAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((LMGAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         BurstRifleItem animatable;
         if (var5 instanceof BurstRifleItem) {
            animatable = (BurstRifleItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BurstRifleItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof BurstRifleItem) {
            animatable = (BurstRifleItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BurstRifleItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         AutoPistolItem animatable;
         if (var5 instanceof AutoPistolItem) {
            animatable = (AutoPistolItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((AutoPistolItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof AutoPistolItem) {
            animatable = (AutoPistolItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((AutoPistolItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         BreakActionShotgunAnimatedItem animatable;
         if (var5 instanceof BreakActionShotgunAnimatedItem) {
            animatable = (BreakActionShotgunAnimatedItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BreakActionShotgunAnimatedItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof BreakActionShotgunAnimatedItem) {
            animatable = (BreakActionShotgunAnimatedItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BreakActionShotgunAnimatedItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         BattleRifleItem animatable;
         if (var5 instanceof BattleRifleItem) {
            animatable = (BattleRifleItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BattleRifleItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof BattleRifleItem) {
            animatable = (BattleRifleItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BattleRifleItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         MachineCarbineItem animatable;
         if (var5 instanceof MachineCarbineItem) {
            animatable = (MachineCarbineItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((MachineCarbineItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof MachineCarbineItem) {
            animatable = (MachineCarbineItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((MachineCarbineItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         HandDrillItem animatable;
         if (var5 instanceof HandDrillItem) {
            animatable = (HandDrillItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((HandDrillItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof HandDrillItem) {
            animatable = (HandDrillItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((HandDrillItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         FlarePistolItem animatable;
         if (var5 instanceof FlarePistolItem) {
            animatable = (FlarePistolItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((FlarePistolItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof FlarePistolItem) {
            animatable = (FlarePistolItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((FlarePistolItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         StealthPistolItem animatable;
         if (var5 instanceof StealthPistolItem) {
            animatable = (StealthPistolItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((StealthPistolItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof StealthPistolItem) {
            animatable = (StealthPistolItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((StealthPistolItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         BreechRifleItem animatable;
         if (var5 instanceof BreechRifleItem) {
            animatable = (BreechRifleItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BreechRifleItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof BreechRifleItem) {
            animatable = (BreechRifleItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BreechRifleItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         ScopedBreechRifleItem animatable;
         if (var5 instanceof ScopedBreechRifleItem) {
            animatable = (ScopedBreechRifleItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ScopedBreechRifleItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof ScopedBreechRifleItem) {
            animatable = (ScopedBreechRifleItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ScopedBreechRifleItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         EradicationItem animatable;
         if (var5 instanceof EradicationItem) {
            animatable = (EradicationItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((EradicationItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof EradicationItem) {
            animatable = (EradicationItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((EradicationItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         LeverRifleItem animatable;
         if (var5 instanceof LeverRifleItem) {
            animatable = (LeverRifleItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((LeverRifleItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof LeverRifleItem) {
            animatable = (LeverRifleItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((LeverRifleItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         AutomaticRifleItem animatable;
         if (var5 instanceof AutomaticRifleItem) {
            animatable = (AutomaticRifleItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((AutomaticRifleItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof AutomaticRifleItem) {
            animatable = (AutomaticRifleItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((AutomaticRifleItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }
      }

   }
}

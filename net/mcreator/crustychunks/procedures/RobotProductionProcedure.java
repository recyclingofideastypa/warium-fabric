package net.mcreator.crustychunks.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class RobotProductionProcedure {
   @SubscribeEvent
   public static void onWorldTick(LevelTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.level);
      }

   }

   public static void execute(LevelAccessor world) {
      execute((Event)null, world);
   }

   private static void execute(@Nullable Event event, LevelAccessor world) {
      double spawnx = 0.0D;
      double spawnz = 0.0D;
      double attempts = 0.0D;
      double locationx = 0.0D;
      double locationz = 0.0D;
      double productionvalue = 0.0D;
      if (world.m_6106_().m_5470_().m_46207_(CrustyChunksModGameRules.WARIUM_APOCALYPSE_DYNAMIC_PRODUCTION)) {
         productionvalue = CrustyChunksModVariables.MapVariables.get(world).Production;
      } else {
         productionvalue = 2.0D;
      }

      if (world.m_6106_().m_5470_().m_46207_(CrustyChunksModGameRules.APOCALYPSE_MODE)) {
         for(int index0 = 0; index0 < (int)(productionvalue * CrustyChunksModVariables.MapVariables.get(world).ApocalypseMultiplier); ++index0) {
            if (Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(1600.0D * CrustyChunksModVariables.MapVariables.get(world).ApocalypseStrikers)) == 1) {
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseStrikers = Math.min(CrustyChunksModVariables.MapVariables.get(world).ApocalypseStrikers + 1.0D, 50.0D);
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(1600.0D * CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers)) == 1) {
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers = Math.min(CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers + 1.0D, 50.0D);
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(4000.0D * CrustyChunksModVariables.MapVariables.get(world).ApocalypseCommanders)) == 1) {
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseCommanders = Math.min(CrustyChunksModVariables.MapVariables.get(world).ApocalypseCommanders + 1.0D, 15.0D);
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(16000.0D * CrustyChunksModVariables.MapVariables.get(world).ApocalypseWorkers)) == 1) {
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseWorkers = Math.min(CrustyChunksModVariables.MapVariables.get(world).ApocalypseWorkers + 1.0D, 15.0D);
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(16000.0D * CrustyChunksModVariables.MapVariables.get(world).ApocalypseHunters)) == 1) {
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseHunters = Math.min(CrustyChunksModVariables.MapVariables.get(world).ApocalypseHunters + 1.0D, 8.0D);
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(32000.0D * CrustyChunksModVariables.MapVariables.get(world).ApocalypseDecimators)) == 1) {
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseDecimators = Math.min(CrustyChunksModVariables.MapVariables.get(world).ApocalypseDecimators + 1.0D, 5.0D);
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(30000.0D * CrustyChunksModVariables.MapVariables.get(world).ApocalypseReapers)) == 1) {
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseReapers = Math.min(CrustyChunksModVariables.MapVariables.get(world).ApocalypseReapers + 1.0D, 6.0D);
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(48000.0D * CrustyChunksModVariables.MapVariables.get(world).ApocalypseEradicators)) == 1) {
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseEradicators = Math.min(CrustyChunksModVariables.MapVariables.get(world).ApocalypseEradicators + 1.0D, 3.0D);
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(1600.0D * CrustyChunksModVariables.MapVariables.get(world).ApocalypseBreachers)) == 1) {
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseBreachers = Math.min(CrustyChunksModVariables.MapVariables.get(world).ApocalypseBreachers + 1.0D, 15.0D);
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            }
         }

         if (1.0D < productionvalue) {
            Entity entityiterator;
            for(Iterator var19 = (new ArrayList(world.m_6907_())).iterator(); var19.hasNext(); locationz = entityiterator.m_20189_()) {
               entityiterator = (Entity)var19.next();
               if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(4000.0D / CrustyChunksModVariables.MapVariables.get(world).ApocalypseMultiplier / productionvalue)) && world.m_46861_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()))) {
                  ++CrustyChunksModVariables.MapVariables.get(world).motivation;
                  CrustyChunksModVariables.MapVariables.get(world).syncData(world);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level19 = (ServerLevel)world;
                     if (_level19.m_8802_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()))) {
                        ++CrustyChunksModVariables.MapVariables.get(world).motivation;
                        CrustyChunksModVariables.MapVariables.get(world).syncData(world);
                     }
                  }
               }

               if (20.0D < CrustyChunksModVariables.MapVariables.get(world).motivation && 1 == Mth.m_216271_(RandomSource.m_216327_(), 1, (int)(2000.0D / CrustyChunksModVariables.MapVariables.get(world).ApocalypseMultiplier / productionvalue)) && world.m_46861_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()))) {
                  if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 2)) {
                     spawnx = (double)Mth.m_216271_(RandomSource.m_216327_(), -100, -75);
                  } else {
                     spawnx = (double)Mth.m_216271_(RandomSource.m_216327_(), 75, 100);
                  }

                  if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 2)) {
                     spawnz = (double)Mth.m_216271_(RandomSource.m_216327_(), -100, -75);
                  } else {
                     spawnz = (double)Mth.m_216271_(RandomSource.m_216327_(), 75, 100);
                  }

                  while(true) {
                     if (!(world.m_8055_(BlockPos.m_274561_(spawnx, (double)(world.m_6924_(Types.MOTION_BLOCKING, Mth.m_14107_(spawnx), Mth.m_14107_(spawnz)) - 2), spawnz)).m_60734_() instanceof LiquidBlock) && !(10.0D < attempts)) {
                        CrustyChunksModVariables.MapVariables.get(world).motivation = 0.0D;
                        CrustyChunksModVariables.MapVariables.get(world).syncData(world);
                        if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 3)) {
                           AirRaidProcedure.execute(world, entityiterator.m_20185_() + spawnx, entityiterator.m_20189_() + spawnz);
                        } else {
                           SmallAttackProcedure.execute(world, entityiterator.m_20185_() + spawnx, entityiterator.m_20189_() + spawnz);
                        }
                        break;
                     }

                     if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 2)) {
                        spawnx = (double)Mth.m_216271_(RandomSource.m_216327_(), -100, -75);
                     } else {
                        spawnx = (double)Mth.m_216271_(RandomSource.m_216327_(), 75, 100);
                     }

                     if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 2)) {
                        spawnz = (double)Mth.m_216271_(RandomSource.m_216327_(), -100, -75);
                     } else {
                        spawnz = (double)Mth.m_216271_(RandomSource.m_216327_(), 75, 100);
                     }

                     ++attempts;
                  }
               }

               locationx = entityiterator.m_20185_();
            }

            if (0.0D != locationx && 0.0D != locationz) {
               Vec3 _center = new Vec3(locationx + spawnx, (double)world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)(locationx + spawnx), (int)(locationz + spawnz)), locationz + spawnz);
               List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(20.0D), (e) -> {
                  return true;
               }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.m_20238_(_center);
               })).toList();
               Iterator var22 = _entfound.iterator();

               while(var22.hasNext()) {
                  Entity entityiterator = (Entity)var22.next();
                  if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:robot")))) {
                     Mob _entity;
                     if (entityiterator instanceof Mob) {
                        _entity = (Mob)entityiterator;
                        _entity.m_21573_().m_26573_();
                     }

                     if (entityiterator instanceof Mob) {
                        _entity = (Mob)entityiterator;
                        _entity.m_21573_().m_26519_(locationx, (double)world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)locationx, (int)locationz), locationz, 1.0D);
                     }
                  }
               }
            }
         }
      }

      locationx = 0.0D;
      locationz = 0.0D;
   }
}

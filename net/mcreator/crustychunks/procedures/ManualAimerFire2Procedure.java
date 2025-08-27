package net.mcreator.crustychunks.procedures;

import javax.annotation.Nullable;
import net.mcreator.crustychunks.entity.SeatEntityEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ManualAimerFire2Procedure {
   @SubscribeEvent
   public static void onLeftClickBlock(LeftClickBlock event) {
      execute(event, event.getLevel(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.m_20201_() instanceof SeatEntityEntity && world.m_8055_(BlockPos.m_274561_(entity.m_20201_().m_20185_(), entity.m_20201_().m_20186_(), entity.m_20201_().m_20189_())).m_60734_() == CrustyChunksModBlocks.MANUAL_AIMER.get()) {
            int _value = 5;
            BlockPos _pos = BlockPos.m_274561_(entity.m_20201_().m_20185_(), entity.m_20201_().m_20186_(), entity.m_20201_().m_20189_());
            BlockState _bs = world.m_8055_(_pos);
            Property var7 = _bs.m_60734_().m_49965_().m_61081_("firing");
            if (var7 instanceof IntegerProperty) {
               IntegerProperty _integerProp = (IntegerProperty)var7;
               if (_integerProp.m_6908_().contains(Integer.valueOf(_value))) {
                  world.m_7731_(_pos, (BlockState)_bs.m_61124_(_integerProp, Integer.valueOf(_value)), 3);
               }
            }
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.SeatEntityEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickEmpty;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber({Dist.CLIENT})
public class ManualAimerFireProcedure {
   @SubscribeEvent
   public static void onLeftClick(LeftClickEmpty event) {
      CrustyChunksMod.PACKET_HANDLER.sendToServer(new ManualAimerFireProcedure.ManualAimerFireMessage());
      execute(event.getLevel(), event.getEntity());
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

   @EventBusSubscriber(
      bus = Bus.MOD
   )
   public static class ManualAimerFireMessage {
      public ManualAimerFireMessage() {
      }

      public ManualAimerFireMessage(FriendlyByteBuf buffer) {
      }

      public static void buffer(ManualAimerFireProcedure.ManualAimerFireMessage message, FriendlyByteBuf buffer) {
      }

      public static void handler(ManualAimerFireProcedure.ManualAimerFireMessage message, Supplier<Context> contextSupplier) {
         Context context = (Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (context.getSender().m_9236_().m_46805_(context.getSender().m_20183_())) {
               ManualAimerFireProcedure.execute(context.getSender().m_9236_(), context.getSender());
            }
         });
         context.setPacketHandled(true);
      }

      @SubscribeEvent
      public static void registerMessage(FMLCommonSetupEvent event) {
         CrustyChunksMod.addNetworkMessage(ManualAimerFireProcedure.ManualAimerFireMessage.class, ManualAimerFireProcedure.ManualAimerFireMessage::buffer, ManualAimerFireProcedure.ManualAimerFireMessage::new, ManualAimerFireProcedure.ManualAimerFireMessage::handler);
      }
   }
}

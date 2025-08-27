package net.mcreator.crustychunks.network;

import java.util.function.Supplier;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.procedures.FireSelectOnKeyPressedProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class FireSelectMessage {
   int type;
   int pressedms;

   public FireSelectMessage(int type, int pressedms) {
      this.type = type;
      this.pressedms = pressedms;
   }

   public FireSelectMessage(FriendlyByteBuf buffer) {
      this.type = buffer.readInt();
      this.pressedms = buffer.readInt();
   }

   public static void buffer(FireSelectMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.type);
      buffer.writeInt(message.pressedms);
   }

   public static void handler(FireSelectMessage message, Supplier<Context> contextSupplier) {
      Context context = (Context)contextSupplier.get();
      context.enqueueWork(() -> {
         pressAction(context.getSender(), message.type, message.pressedms);
      });
      context.setPacketHandled(true);
   }

   public static void pressAction(Player entity, int type, int pressedms) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      if (world.m_46805_(entity.m_20183_())) {
         if (type == 0) {
            FireSelectOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      CrustyChunksMod.addNetworkMessage(FireSelectMessage.class, FireSelectMessage::buffer, FireSelectMessage::new, FireSelectMessage::handler);
   }
}

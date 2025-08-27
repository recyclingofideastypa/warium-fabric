package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.network.ADSMessage;
import net.mcreator.crustychunks.network.DownPullMessage;
import net.mcreator.crustychunks.network.FireSelectMessage;
import net.mcreator.crustychunks.network.LeftPullMessage;
import net.mcreator.crustychunks.network.ReloadMessage;
import net.mcreator.crustychunks.network.RightPullMessage;
import net.mcreator.crustychunks.network.UpPullMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class CrustyChunksModKeyMappings {
   public static final KeyMapping RELOAD = new KeyMapping("key.crusty_chunks.reload", 82, "key.categories.firearms") {
      private boolean isDownOld = false;

      public void m_7249_(boolean isDown) {
         super.m_7249_(isDown);
         if (this.isDownOld != isDown && isDown) {
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new ReloadMessage(0, 0));
            ReloadMessage.pressAction(Minecraft.m_91087_().f_91074_, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping LEFT_PULL = new KeyMapping("key.crusty_chunks.left_pull", 263, "key.categories.aiming") {
      private boolean isDownOld = false;

      public void m_7249_(boolean isDown) {
         super.m_7249_(isDown);
         if (this.isDownOld != isDown && isDown) {
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new LeftPullMessage(0, 0));
            LeftPullMessage.pressAction(Minecraft.m_91087_().f_91074_, 0, 0);
            CrustyChunksModKeyMappings.LEFT_PULL_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - CrustyChunksModKeyMappings.LEFT_PULL_LASTPRESS);
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new LeftPullMessage(1, dt));
            LeftPullMessage.pressAction(Minecraft.m_91087_().f_91074_, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping RIGHT_PULL = new KeyMapping("key.crusty_chunks.right_pull", 262, "key.categories.aiming") {
      private boolean isDownOld = false;

      public void m_7249_(boolean isDown) {
         super.m_7249_(isDown);
         if (this.isDownOld != isDown && isDown) {
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new RightPullMessage(0, 0));
            RightPullMessage.pressAction(Minecraft.m_91087_().f_91074_, 0, 0);
            CrustyChunksModKeyMappings.RIGHT_PULL_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - CrustyChunksModKeyMappings.RIGHT_PULL_LASTPRESS);
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new RightPullMessage(1, dt));
            RightPullMessage.pressAction(Minecraft.m_91087_().f_91074_, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping UP_PULL = new KeyMapping("key.crusty_chunks.up_pull", 265, "key.categories.aiming") {
      private boolean isDownOld = false;

      public void m_7249_(boolean isDown) {
         super.m_7249_(isDown);
         if (this.isDownOld != isDown && isDown) {
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new UpPullMessage(0, 0));
            UpPullMessage.pressAction(Minecraft.m_91087_().f_91074_, 0, 0);
            CrustyChunksModKeyMappings.UP_PULL_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - CrustyChunksModKeyMappings.UP_PULL_LASTPRESS);
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new UpPullMessage(1, dt));
            UpPullMessage.pressAction(Minecraft.m_91087_().f_91074_, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping DOWN_PULL = new KeyMapping("key.crusty_chunks.down_pull", 264, "key.categories.aiming") {
      private boolean isDownOld = false;

      public void m_7249_(boolean isDown) {
         super.m_7249_(isDown);
         if (this.isDownOld != isDown && isDown) {
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new DownPullMessage(0, 0));
            DownPullMessage.pressAction(Minecraft.m_91087_().f_91074_, 0, 0);
            CrustyChunksModKeyMappings.DOWN_PULL_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - CrustyChunksModKeyMappings.DOWN_PULL_LASTPRESS);
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new DownPullMessage(1, dt));
            DownPullMessage.pressAction(Minecraft.m_91087_().f_91074_, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping FIRE_SELECT = new KeyMapping("key.crusty_chunks.fire_select", 71, "key.categories.firearms") {
      private boolean isDownOld = false;

      public void m_7249_(boolean isDown) {
         super.m_7249_(isDown);
         if (this.isDownOld != isDown && isDown) {
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new FireSelectMessage(0, 0));
            FireSelectMessage.pressAction(Minecraft.m_91087_().f_91074_, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping ADS = new KeyMapping("key.crusty_chunks.ads", 341, "key.categories.firearms") {
      private boolean isDownOld = false;

      public void m_7249_(boolean isDown) {
         super.m_7249_(isDown);
         if (this.isDownOld != isDown && isDown) {
            CrustyChunksMod.PACKET_HANDLER.sendToServer(new ADSMessage(0, 0));
            ADSMessage.pressAction(Minecraft.m_91087_().f_91074_, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };
   private static long LEFT_PULL_LASTPRESS = 0L;
   private static long RIGHT_PULL_LASTPRESS = 0L;
   private static long UP_PULL_LASTPRESS = 0L;
   private static long DOWN_PULL_LASTPRESS = 0L;

   @SubscribeEvent
   public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
      event.register(RELOAD);
      event.register(LEFT_PULL);
      event.register(RIGHT_PULL);
      event.register(UP_PULL);
      event.register(DOWN_PULL);
      event.register(FIRE_SELECT);
      event.register(ADS);
   }

   @EventBusSubscriber({Dist.CLIENT})
   public static class KeyEventListener {
      @SubscribeEvent
      public static void onClientTick(ClientTickEvent event) {
         if (Minecraft.m_91087_().f_91080_ == null) {
            CrustyChunksModKeyMappings.RELOAD.m_90859_();
            CrustyChunksModKeyMappings.LEFT_PULL.m_90859_();
            CrustyChunksModKeyMappings.RIGHT_PULL.m_90859_();
            CrustyChunksModKeyMappings.UP_PULL.m_90859_();
            CrustyChunksModKeyMappings.DOWN_PULL.m_90859_();
            CrustyChunksModKeyMappings.FIRE_SELECT.m_90859_();
            CrustyChunksModKeyMappings.ADS.m_90859_();
         }

      }
   }
}

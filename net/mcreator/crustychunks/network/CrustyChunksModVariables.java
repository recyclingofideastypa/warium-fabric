package net.mcreator.crustychunks.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Supplier;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent.Context;
import net.minecraftforge.network.simple.SimpleChannel;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class CrustyChunksModVariables {
   public static final Capability<CrustyChunksModVariables.PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<CrustyChunksModVariables.PlayerVariables>() {
   });

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      CrustyChunksMod.addNetworkMessage(CrustyChunksModVariables.SavedDataSyncMessage.class, CrustyChunksModVariables.SavedDataSyncMessage::buffer, CrustyChunksModVariables.SavedDataSyncMessage::new, CrustyChunksModVariables.SavedDataSyncMessage::handler);
      CrustyChunksMod.addNetworkMessage(CrustyChunksModVariables.PlayerVariablesSyncMessage.class, CrustyChunksModVariables.PlayerVariablesSyncMessage::buffer, CrustyChunksModVariables.PlayerVariablesSyncMessage::new, CrustyChunksModVariables.PlayerVariablesSyncMessage::handler);
   }

   @SubscribeEvent
   public static void init(RegisterCapabilitiesEvent event) {
      event.register(CrustyChunksModVariables.PlayerVariables.class);
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      CrustyChunksMod.addNetworkMessage(CrustyChunksModVariables.PlayerVariablesSyncMessage.class, CrustyChunksModVariables.PlayerVariablesSyncMessage::buffer, CrustyChunksModVariables.PlayerVariablesSyncMessage::new, CrustyChunksModVariables.PlayerVariablesSyncMessage::handler);
   }

   public static class SavedDataSyncMessage {
      private final int type;
      private SavedData data;

      public SavedDataSyncMessage(FriendlyByteBuf buffer) {
         this.type = buffer.readInt();
         CompoundTag nbt = buffer.m_130260_();
         if (nbt != null) {
            this.data = (SavedData)(this.type == 0 ? new CrustyChunksModVariables.MapVariables() : new CrustyChunksModVariables.WorldVariables());
            SavedData var5 = this.data;
            if (var5 instanceof CrustyChunksModVariables.MapVariables) {
               CrustyChunksModVariables.MapVariables mapVariables = (CrustyChunksModVariables.MapVariables)var5;
               mapVariables.read(nbt);
            } else {
               var5 = this.data;
               if (var5 instanceof CrustyChunksModVariables.WorldVariables) {
                  CrustyChunksModVariables.WorldVariables worldVariables = (CrustyChunksModVariables.WorldVariables)var5;
                  worldVariables.read(nbt);
               }
            }
         }

      }

      public SavedDataSyncMessage(int type, SavedData data) {
         this.type = type;
         this.data = data;
      }

      public static void buffer(CrustyChunksModVariables.SavedDataSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.type);
         if (message.data != null) {
            buffer.m_130079_(message.data.m_7176_(new CompoundTag()));
         }

      }

      public static void handler(CrustyChunksModVariables.SavedDataSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = (Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
               if (message.type == 0) {
                  CrustyChunksModVariables.MapVariables.clientSide = (CrustyChunksModVariables.MapVariables)message.data;
               } else {
                  CrustyChunksModVariables.WorldVariables.clientSide = (CrustyChunksModVariables.WorldVariables)message.data;
               }
            }

         });
         context.setPacketHandled(true);
      }
   }

   public static class PlayerVariablesSyncMessage {
      private final int target;
      private final CrustyChunksModVariables.PlayerVariables data;

      public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
         this.data = new CrustyChunksModVariables.PlayerVariables();
         this.data.readNBT(buffer.m_130260_());
         this.target = buffer.readInt();
      }

      public PlayerVariablesSyncMessage(CrustyChunksModVariables.PlayerVariables data, int entityid) {
         this.data = data;
         this.target = entityid;
      }

      public static void buffer(CrustyChunksModVariables.PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
         buffer.m_130079_((CompoundTag)message.data.writeNBT());
         buffer.writeInt(message.target);
      }

      public static void handler(CrustyChunksModVariables.PlayerVariablesSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = (Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer()) {
               CrustyChunksModVariables.PlayerVariables variables = (CrustyChunksModVariables.PlayerVariables)Minecraft.m_91087_().f_91074_.m_9236_().m_6815_(message.target).getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables());
               variables.Inflash = message.data.Inflash;
               variables.UpKey = message.data.UpKey;
               variables.DownKey = message.data.DownKey;
               variables.LeftKey = message.data.LeftKey;
               variables.RightKey = message.data.RightKey;
               variables.clickrelease = message.data.clickrelease;
               variables.eastereggcooldown = message.data.eastereggcooldown;
               variables.AimDownSights = message.data.AimDownSights;
            }

         });
         context.setPacketHandled(true);
      }
   }

   public static class PlayerVariables {
      public boolean Inflash = false;
      public boolean UpKey = false;
      public boolean DownKey = false;
      public boolean LeftKey = false;
      public boolean RightKey = false;
      public boolean clickrelease = true;
      public double eastereggcooldown = 0.0D;
      public boolean AimDownSights = false;

      public void syncPlayerVariables(Entity entity) {
         if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            SimpleChannel var10000 = CrustyChunksMod.PACKET_HANDLER;
            PacketDistributor var10001 = PacketDistributor.DIMENSION;
            Level var10002 = entity.m_9236_();
            Objects.requireNonNull(var10002);
            var10000.send(var10001.with(var10002::m_46472_), new CrustyChunksModVariables.PlayerVariablesSyncMessage(this, entity.m_19879_()));
         }

      }

      public Tag writeNBT() {
         CompoundTag nbt = new CompoundTag();
         nbt.m_128379_("Inflash", this.Inflash);
         nbt.m_128379_("UpKey", this.UpKey);
         nbt.m_128379_("DownKey", this.DownKey);
         nbt.m_128379_("LeftKey", this.LeftKey);
         nbt.m_128379_("RightKey", this.RightKey);
         nbt.m_128379_("clickrelease", this.clickrelease);
         nbt.m_128347_("eastereggcooldown", this.eastereggcooldown);
         nbt.m_128379_("AimDownSights", this.AimDownSights);
         return nbt;
      }

      public void readNBT(Tag tag) {
         if (tag == null) {
            tag = this.writeNBT();
         }

         CompoundTag nbt = (CompoundTag)tag;
         if (nbt == null) {
            nbt = (CompoundTag)this.writeNBT();
         }

         this.Inflash = nbt.m_128471_("Inflash");
         this.UpKey = nbt.m_128471_("UpKey");
         this.DownKey = nbt.m_128471_("DownKey");
         this.LeftKey = nbt.m_128471_("LeftKey");
         this.RightKey = nbt.m_128471_("RightKey");
         this.clickrelease = nbt.m_128471_("clickrelease");
         this.eastereggcooldown = nbt.m_128459_("eastereggcooldown");
         this.AimDownSights = nbt.m_128471_("AimDownSights");
      }
   }

   @EventBusSubscriber
   private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
      private final CrustyChunksModVariables.PlayerVariables playerVariables = new CrustyChunksModVariables.PlayerVariables();
      private final LazyOptional<CrustyChunksModVariables.PlayerVariables> instance = LazyOptional.of(() -> {
         return this.playerVariables;
      });

      @SubscribeEvent
      public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
         if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer)) {
            event.addCapability(new ResourceLocation("crusty_chunks", "player_variables"), new CrustyChunksModVariables.PlayerVariablesProvider());
         }

      }

      public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
         return cap == CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY ? this.instance.cast() : LazyOptional.empty();
      }

      public Tag serializeNBT() {
         return this.playerVariables.writeNBT();
      }

      public void deserializeNBT(Tag nbt) {
         this.playerVariables.readNBT(nbt);
      }
   }

   public static class MapVariables extends SavedData {
      public static final String DATA_NAME = "crusty_chunks_mapvars";
      public double ApocalypseStrikers = 20.0D;
      public double ApocalypseRiflers = 20.0D;
      public double ApocalypseCommanders = 8.0D;
      public double ApocalypseHunters = 5.0D;
      public double ApocalypseDecimators = 4.0D;
      public double ApocalypseEradicators = 1.0D;
      public double ApocalypseArtillery = 4.0D;
      public double Production = 0.0D;
      public double ApocalypseWorkers = 5.0D;
      public double motivation = 0.0D;
      public double ApocalypseMultiplier = 1.0D;
      public double ApocalypseReapers = 4.0D;
      public double ApocalypseBreachers = 6.0D;
      static CrustyChunksModVariables.MapVariables clientSide = new CrustyChunksModVariables.MapVariables();

      public static CrustyChunksModVariables.MapVariables load(CompoundTag tag) {
         CrustyChunksModVariables.MapVariables data = new CrustyChunksModVariables.MapVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
         if (nbt == null) {
            nbt = this.m_7176_(new CompoundTag());
         }

         this.ApocalypseStrikers = nbt.m_128459_("ApocalypseStrikers");
         this.ApocalypseRiflers = nbt.m_128459_("ApocalypseRiflers");
         this.ApocalypseCommanders = nbt.m_128459_("ApocalypseCommanders");
         this.ApocalypseHunters = nbt.m_128459_("ApocalypseHunters");
         this.ApocalypseDecimators = nbt.m_128459_("ApocalypseDecimators");
         this.ApocalypseEradicators = nbt.m_128459_("ApocalypseEradicators");
         this.ApocalypseArtillery = nbt.m_128459_("ApocalypseArtillery");
         this.Production = nbt.m_128459_("Production");
         this.ApocalypseWorkers = nbt.m_128459_("ApocalypseWorkers");
         this.motivation = nbt.m_128459_("motivation");
         this.ApocalypseMultiplier = nbt.m_128459_("ApocalypseMultiplier");
         this.ApocalypseReapers = nbt.m_128459_("ApocalypseReapers");
         this.ApocalypseBreachers = nbt.m_128459_("ApocalypseBreachers");
      }

      public CompoundTag m_7176_(CompoundTag nbt) {
         nbt.m_128347_("ApocalypseStrikers", this.ApocalypseStrikers);
         nbt.m_128347_("ApocalypseRiflers", this.ApocalypseRiflers);
         nbt.m_128347_("ApocalypseCommanders", this.ApocalypseCommanders);
         nbt.m_128347_("ApocalypseHunters", this.ApocalypseHunters);
         nbt.m_128347_("ApocalypseDecimators", this.ApocalypseDecimators);
         nbt.m_128347_("ApocalypseEradicators", this.ApocalypseEradicators);
         nbt.m_128347_("ApocalypseArtillery", this.ApocalypseArtillery);
         nbt.m_128347_("Production", this.Production);
         nbt.m_128347_("ApocalypseWorkers", this.ApocalypseWorkers);
         nbt.m_128347_("motivation", this.motivation);
         nbt.m_128347_("ApocalypseMultiplier", this.ApocalypseMultiplier);
         nbt.m_128347_("ApocalypseReapers", this.ApocalypseReapers);
         nbt.m_128347_("ApocalypseBreachers", this.ApocalypseBreachers);
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.m_77762_();
         if (world instanceof Level && !world.m_5776_()) {
            CrustyChunksMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new CrustyChunksModVariables.SavedDataSyncMessage(0, this));
         }

      }

      public static CrustyChunksModVariables.MapVariables get(LevelAccessor world) {
         if (world instanceof ServerLevelAccessor) {
            ServerLevelAccessor serverLevelAcc = (ServerLevelAccessor)world;
            return (CrustyChunksModVariables.MapVariables)serverLevelAcc.m_6018_().m_7654_().m_129880_(Level.f_46428_).m_8895_().m_164861_((e) -> {
               return load(e);
            }, CrustyChunksModVariables.MapVariables::new, "crusty_chunks_mapvars");
         } else {
            return clientSide;
         }
      }
   }

   public static class WorldVariables extends SavedData {
      public static final String DATA_NAME = "crusty_chunks_worldvars";
      static CrustyChunksModVariables.WorldVariables clientSide = new CrustyChunksModVariables.WorldVariables();

      public static CrustyChunksModVariables.WorldVariables load(CompoundTag tag) {
         CrustyChunksModVariables.WorldVariables data = new CrustyChunksModVariables.WorldVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
      }

      public CompoundTag m_7176_(CompoundTag nbt) {
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.m_77762_();
         if (world instanceof Level) {
            Level level = (Level)world;
            if (!level.m_5776_()) {
               SimpleChannel var10000 = CrustyChunksMod.PACKET_HANDLER;
               PacketDistributor var10001 = PacketDistributor.DIMENSION;
               Objects.requireNonNull(level);
               var10000.send(var10001.with(level::m_46472_), new CrustyChunksModVariables.SavedDataSyncMessage(1, this));
            }
         }

      }

      public static CrustyChunksModVariables.WorldVariables get(LevelAccessor world) {
         if (world instanceof ServerLevel) {
            ServerLevel level = (ServerLevel)world;
            return (CrustyChunksModVariables.WorldVariables)level.m_8895_().m_164861_((e) -> {
               return load(e);
            }, CrustyChunksModVariables.WorldVariables::new, "crusty_chunks_worldvars");
         } else {
            return clientSide;
         }
      }
   }

   @EventBusSubscriber
   public static class EventBusVariableHandlers {
      @SubscribeEvent
      public static void onPlayerLoggedInSyncPlayerVariables(PlayerLoggedInEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            Iterator var1 = (new ArrayList(event.getEntity().m_9236_().m_6907_())).iterator();

            while(var1.hasNext()) {
               Entity entityiterator = (Entity)var1.next();
               ((CrustyChunksModVariables.PlayerVariables)entityiterator.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerRespawnedSyncPlayerVariables(PlayerRespawnEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            Iterator var1 = (new ArrayList(event.getEntity().m_9236_().m_6907_())).iterator();

            while(var1.hasNext()) {
               Entity entityiterator = (Entity)var1.next();
               ((CrustyChunksModVariables.PlayerVariables)entityiterator.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerChangedDimensionEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            Iterator var1 = (new ArrayList(event.getEntity().m_9236_().m_6907_())).iterator();

            while(var1.hasNext()) {
               Entity entityiterator = (Entity)var1.next();
               ((CrustyChunksModVariables.PlayerVariables)entityiterator.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void clonePlayer(Clone event) {
         event.getOriginal().revive();
         CrustyChunksModVariables.PlayerVariables original = (CrustyChunksModVariables.PlayerVariables)event.getOriginal().getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables());
         CrustyChunksModVariables.PlayerVariables clone = (CrustyChunksModVariables.PlayerVariables)event.getEntity().getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables());
         clone.eastereggcooldown = original.eastereggcooldown;
         if (!event.isWasDeath()) {
            clone.Inflash = original.Inflash;
            clone.UpKey = original.UpKey;
            clone.DownKey = original.DownKey;
            clone.LeftKey = original.LeftKey;
            clone.RightKey = original.RightKey;
            clone.clickrelease = original.clickrelease;
            clone.AimDownSights = original.AimDownSights;
         }

         if (!event.getEntity().m_9236_().m_5776_()) {
            Iterator var3 = (new ArrayList(event.getEntity().m_9236_().m_6907_())).iterator();

            while(var3.hasNext()) {
               Entity entityiterator = (Entity)var3.next();
               ((CrustyChunksModVariables.PlayerVariables)entityiterator.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData mapdata = CrustyChunksModVariables.MapVariables.get(event.getEntity().m_9236_());
            SavedData worlddata = CrustyChunksModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (mapdata != null) {
               CrustyChunksMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
                  return (ServerPlayer)event.getEntity();
               }), new CrustyChunksModVariables.SavedDataSyncMessage(0, mapdata));
            }

            if (worlddata != null) {
               CrustyChunksMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
                  return (ServerPlayer)event.getEntity();
               }), new CrustyChunksModVariables.SavedDataSyncMessage(1, worlddata));
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerChangedDimension(PlayerChangedDimensionEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData worlddata = CrustyChunksModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (worlddata != null) {
               CrustyChunksMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
                  return (ServerPlayer)event.getEntity();
               }), new CrustyChunksModVariables.SavedDataSyncMessage(1, worlddata));
            }
         }

      }
   }
}

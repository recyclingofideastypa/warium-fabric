package net.mcreator.crustychunks.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CrustyChunksModSounds {
   public static final DeferredRegister<SoundEvent> REGISTRY;
   public static final RegistryObject<SoundEvent> ROCKET_LAUNCH;
   public static final RegistryObject<SoundEvent> GOLEMIDLE;
   public static final RegistryObject<SoundEvent> GOLEMMAD;
   public static final RegistryObject<SoundEvent> MAGAZINE;
   public static final RegistryObject<SoundEvent> SHOTGUNCYCLE;
   public static final RegistryObject<SoundEvent> REVOLVER;
   public static final RegistryObject<SoundEvent> SMALLEXPLOSION;
   public static final RegistryObject<SoundEvent> EXPLOSION;
   public static final RegistryObject<SoundEvent> EXPLOSION_DISTANT;
   public static final RegistryObject<SoundEvent> HUGE_EXPLOSION_DISTANT;
   public static final RegistryObject<SoundEvent> BOUNCE;
   public static final RegistryObject<SoundEvent> SHOTGUNRELOAD;
   public static final RegistryObject<SoundEvent> CANNONFAR;
   public static final RegistryObject<SoundEvent> CANNONCLOSE;
   public static final RegistryObject<SoundEvent> SMALLCASING;
   public static final RegistryObject<SoundEvent> MEDIUMCASING;
   public static final RegistryObject<SoundEvent> SHOTGUNCASING;
   public static final RegistryObject<SoundEvent> SMALL_EXPLLOSION_DISTANT;
   public static final RegistryObject<SoundEvent> AUTOCANNONSHOT;
   public static final RegistryObject<SoundEvent> MECHSTEP;
   public static final RegistryObject<SoundEvent> HUNTERFAR;
   public static final RegistryObject<SoundEvent> HUNTERNEAR;
   public static final RegistryObject<SoundEvent> MIDRANGESHOT;
   public static final RegistryObject<SoundEvent> DISTANTSHOT;
   public static final RegistryObject<SoundEvent> PISTOLACTION;
   public static final RegistryObject<SoundEvent> FARBLAST;
   public static final RegistryObject<SoundEvent> BATTLECANNON;
   public static final RegistryObject<SoundEvent> PEELERPOD;
   public static final RegistryObject<SoundEvent> FLAREGUN;
   public static final RegistryObject<SoundEvent> FISSIONBLAST;
   public static final RegistryObject<SoundEvent> RUMBLE;
   public static final RegistryObject<SoundEvent> ROCKETFLIGHT;
   public static final RegistryObject<SoundEvent> ROCKETFAR;
   public static final RegistryObject<SoundEvent> HEAVYLAUNCH;
   public static final RegistryObject<SoundEvent> JETFAR;
   public static final RegistryObject<SoundEvent> WIZZ;
   public static final RegistryObject<SoundEvent> SILENCEDSHOT;
   public static final RegistryObject<SoundEvent> BRTTTFAR;
   public static final RegistryObject<SoundEvent> RAC;
   public static final RegistryObject<SoundEvent> SPARKS;
   public static final RegistryObject<SoundEvent> HUMM;
   public static final RegistryObject<SoundEvent> STRIKERSTEP;
   public static final RegistryObject<SoundEvent> SONICBOOM;
   public static final RegistryObject<SoundEvent> TURBINE;
   public static final RegistryObject<SoundEvent> MEGAMECHSTEP;
   public static final RegistryObject<SoundEvent> SIRENFAR;
   public static final RegistryObject<SoundEvent> SIREN;
   public static final RegistryObject<SoundEvent> DRONE;
   public static final RegistryObject<SoundEvent> LARGESHOT;
   public static final RegistryObject<SoundEvent> BOLT;
   public static final RegistryObject<SoundEvent> BOLTRELOAD;
   public static final RegistryObject<SoundEvent> BOLT3;
   public static final RegistryObject<SoundEvent> BOLT2;
   public static final RegistryObject<SoundEvent> DRYFIRE;
   public static final RegistryObject<SoundEvent> MEDIUMSHOT;
   public static final RegistryObject<SoundEvent> SMALLSHOT;
   public static final RegistryObject<SoundEvent> RIFLEMAGAZINE;
   public static final RegistryObject<SoundEvent> REVOLVERRELOAD;
   public static final RegistryObject<SoundEvent> BEEP;
   public static final RegistryObject<SoundEvent> PEELERPODFAR;
   public static final RegistryObject<SoundEvent> DISTANTSHOTMEDIUM;
   public static final RegistryObject<SoundEvent> ENGINE;
   public static final RegistryObject<SoundEvent> MOTOR;
   public static final RegistryObject<SoundEvent> LEVERACTION;
   public static final RegistryObject<SoundEvent> COMMANDERWAFFING;
   public static final RegistryObject<SoundEvent> COMMANDERALERT;
   public static final RegistryObject<SoundEvent> JETIDLE;
   public static final RegistryObject<SoundEvent> SPACENUKE;
   public static final RegistryObject<SoundEvent> MEDIUM_SMALL_EXPLOSION_DISTANT;
   public static final RegistryObject<SoundEvent> SMALLFARBLAST;
   public static final RegistryObject<SoundEvent> DISTANTGUNFIRE;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "crusty_chunks");
      ROCKET_LAUNCH = REGISTRY.register("rocket_launch", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "rocket_launch"));
      });
      GOLEMIDLE = REGISTRY.register("golemidle", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "golemidle"));
      });
      GOLEMMAD = REGISTRY.register("golemmad", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "golemmad"));
      });
      MAGAZINE = REGISTRY.register("magazine", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "magazine"));
      });
      SHOTGUNCYCLE = REGISTRY.register("shotguncycle", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "shotguncycle"));
      });
      REVOLVER = REGISTRY.register("revolver", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "revolver"));
      });
      SMALLEXPLOSION = REGISTRY.register("smallexplosion", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "smallexplosion"));
      });
      EXPLOSION = REGISTRY.register("explosion", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "explosion"));
      });
      EXPLOSION_DISTANT = REGISTRY.register("explosion_distant", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "explosion_distant"));
      });
      HUGE_EXPLOSION_DISTANT = REGISTRY.register("huge_explosion_distant", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "huge_explosion_distant"));
      });
      BOUNCE = REGISTRY.register("bounce", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "bounce"));
      });
      SHOTGUNRELOAD = REGISTRY.register("shotgunreload", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "shotgunreload"));
      });
      CANNONFAR = REGISTRY.register("cannonfar", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "cannonfar"));
      });
      CANNONCLOSE = REGISTRY.register("cannonclose", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "cannonclose"));
      });
      SMALLCASING = REGISTRY.register("smallcasing", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "smallcasing"));
      });
      MEDIUMCASING = REGISTRY.register("mediumcasing", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "mediumcasing"));
      });
      SHOTGUNCASING = REGISTRY.register("shotguncasing", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "shotguncasing"));
      });
      SMALL_EXPLLOSION_DISTANT = REGISTRY.register("small_expllosion_distant", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "small_expllosion_distant"));
      });
      AUTOCANNONSHOT = REGISTRY.register("autocannonshot", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "autocannonshot"));
      });
      MECHSTEP = REGISTRY.register("mechstep", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "mechstep"));
      });
      HUNTERFAR = REGISTRY.register("hunterfar", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "hunterfar"));
      });
      HUNTERNEAR = REGISTRY.register("hunternear", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "hunternear"));
      });
      MIDRANGESHOT = REGISTRY.register("midrangeshot", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "midrangeshot"));
      });
      DISTANTSHOT = REGISTRY.register("distantshot", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "distantshot"));
      });
      PISTOLACTION = REGISTRY.register("pistolaction", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "pistolaction"));
      });
      FARBLAST = REGISTRY.register("farblast", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "farblast"));
      });
      BATTLECANNON = REGISTRY.register("battlecannon", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "battlecannon"));
      });
      PEELERPOD = REGISTRY.register("peelerpod", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "peelerpod"));
      });
      FLAREGUN = REGISTRY.register("flaregun", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "flaregun"));
      });
      FISSIONBLAST = REGISTRY.register("fissionblast", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "fissionblast"));
      });
      RUMBLE = REGISTRY.register("rumble", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "rumble"));
      });
      ROCKETFLIGHT = REGISTRY.register("rocketflight", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "rocketflight"));
      });
      ROCKETFAR = REGISTRY.register("rocketfar", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "rocketfar"));
      });
      HEAVYLAUNCH = REGISTRY.register("heavylaunch", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "heavylaunch"));
      });
      JETFAR = REGISTRY.register("jetfar", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "jetfar"));
      });
      WIZZ = REGISTRY.register("wizz", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "wizz"));
      });
      SILENCEDSHOT = REGISTRY.register("silencedshot", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "silencedshot"));
      });
      BRTTTFAR = REGISTRY.register("brtttfar", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "brtttfar"));
      });
      RAC = REGISTRY.register("rac", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "rac"));
      });
      SPARKS = REGISTRY.register("sparks", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "sparks"));
      });
      HUMM = REGISTRY.register("humm", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "humm"));
      });
      STRIKERSTEP = REGISTRY.register("strikerstep", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "strikerstep"));
      });
      SONICBOOM = REGISTRY.register("sonicboom", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "sonicboom"));
      });
      TURBINE = REGISTRY.register("turbine", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "turbine"));
      });
      MEGAMECHSTEP = REGISTRY.register("megamechstep", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "megamechstep"));
      });
      SIRENFAR = REGISTRY.register("sirenfar", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "sirenfar"));
      });
      SIREN = REGISTRY.register("siren", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "siren"));
      });
      DRONE = REGISTRY.register("drone", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "drone"));
      });
      LARGESHOT = REGISTRY.register("largeshot", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "largeshot"));
      });
      BOLT = REGISTRY.register("bolt", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "bolt"));
      });
      BOLTRELOAD = REGISTRY.register("boltreload", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "boltreload"));
      });
      BOLT3 = REGISTRY.register("bolt3", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "bolt3"));
      });
      BOLT2 = REGISTRY.register("bolt2", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "bolt2"));
      });
      DRYFIRE = REGISTRY.register("dryfire", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "dryfire"));
      });
      MEDIUMSHOT = REGISTRY.register("mediumshot", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "mediumshot"));
      });
      SMALLSHOT = REGISTRY.register("smallshot", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "smallshot"));
      });
      RIFLEMAGAZINE = REGISTRY.register("riflemagazine", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "riflemagazine"));
      });
      REVOLVERRELOAD = REGISTRY.register("revolverreload", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "revolverreload"));
      });
      BEEP = REGISTRY.register("beep", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "beep"));
      });
      PEELERPODFAR = REGISTRY.register("peelerpodfar", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "peelerpodfar"));
      });
      DISTANTSHOTMEDIUM = REGISTRY.register("distantshotmedium", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "distantshotmedium"));
      });
      ENGINE = REGISTRY.register("engine", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "engine"));
      });
      MOTOR = REGISTRY.register("motor", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "motor"));
      });
      LEVERACTION = REGISTRY.register("leveraction", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "leveraction"));
      });
      COMMANDERWAFFING = REGISTRY.register("commanderwaffing", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "commanderwaffing"));
      });
      COMMANDERALERT = REGISTRY.register("commanderalert", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "commanderalert"));
      });
      JETIDLE = REGISTRY.register("jetidle", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "jetidle"));
      });
      SPACENUKE = REGISTRY.register("spacenuke", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "spacenuke"));
      });
      MEDIUM_SMALL_EXPLOSION_DISTANT = REGISTRY.register("medium_small_explosion_distant", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "medium_small_explosion_distant"));
      });
      SMALLFARBLAST = REGISTRY.register("smallfarblast", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "smallfarblast"));
      });
      DISTANTGUNFIRE = REGISTRY.register("distantgunfire", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("crusty_chunks", "distantgunfire"));
      });
   }
}

package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.client.particle.AerialSparksParticle;
import net.mcreator.crustychunks.client.particle.BulletTrailParticle;
import net.mcreator.crustychunks.client.particle.CampSmokeParticle;
import net.mcreator.crustychunks.client.particle.DeathRayParticle;
import net.mcreator.crustychunks.client.particle.DustParticle;
import net.mcreator.crustychunks.client.particle.DustWaveParticle;
import net.mcreator.crustychunks.client.particle.FireballParticle;
import net.mcreator.crustychunks.client.particle.FlareParticle;
import net.mcreator.crustychunks.client.particle.FusionFireballParticle;
import net.mcreator.crustychunks.client.particle.FusionSmokeParticle;
import net.mcreator.crustychunks.client.particle.FusionStaticFireballParticle;
import net.mcreator.crustychunks.client.particle.GasCloudParticle;
import net.mcreator.crustychunks.client.particle.GreenTracerParticle;
import net.mcreator.crustychunks.client.particle.GroundHugeSmokeParticle;
import net.mcreator.crustychunks.client.particle.GunSmokeParticle;
import net.mcreator.crustychunks.client.particle.HugeFireballParticle;
import net.mcreator.crustychunks.client.particle.HugeSmokeParticle;
import net.mcreator.crustychunks.client.particle.HugeSparksParticle;
import net.mcreator.crustychunks.client.particle.HugeStaticFireballParticle;
import net.mcreator.crustychunks.client.particle.JetFlameParticle;
import net.mcreator.crustychunks.client.particle.LargeBulletTrailParticle;
import net.mcreator.crustychunks.client.particle.LargeSmokeParticle;
import net.mcreator.crustychunks.client.particle.MediumTracerParticle;
import net.mcreator.crustychunks.client.particle.NuclearShockParticleParticle;
import net.mcreator.crustychunks.client.particle.PuffParticle;
import net.mcreator.crustychunks.client.particle.RisingFlameParticle;
import net.mcreator.crustychunks.client.particle.RocketSmokeParticle;
import net.mcreator.crustychunks.client.particle.SandParticle;
import net.mcreator.crustychunks.client.particle.ShockWaveParticle;
import net.mcreator.crustychunks.client.particle.SmallGreenTracerParticle;
import net.mcreator.crustychunks.client.particle.SmallPuffParticle;
import net.mcreator.crustychunks.client.particle.SmallTracerParticle;
import net.mcreator.crustychunks.client.particle.SmokeParticle;
import net.mcreator.crustychunks.client.particle.SmokeScreenParticle;
import net.mcreator.crustychunks.client.particle.SpaceFireballParticle;
import net.mcreator.crustychunks.client.particle.SparksParticle;
import net.mcreator.crustychunks.client.particle.SplashPuffParticle;
import net.mcreator.crustychunks.client.particle.TracerParticle;
import net.mcreator.crustychunks.client.particle.WhiteDustParticle;
import net.mcreator.crustychunks.client.particle.WhiteTracerParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class CrustyChunksModParticles {
   @SubscribeEvent
   public static void registerParticles(RegisterParticleProvidersEvent event) {
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.LARGE_SMOKE.get(), LargeSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.FIREBALL.get(), FireballParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SAND.get(), SandParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.DUST.get(), DustParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.WHITE_DUST.get(), WhiteDustParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SMOKE_SCREEN.get(), SmokeScreenParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.PUFF.get(), PuffParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.TRACER.get(), TracerParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), CampSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SMALL_TRACER.get(), SmallTracerParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SPARKS.get(), SparksParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SMALL_PUFF.get(), SmallPuffParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), HugeSparksParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SHOCK_WAVE.get(), ShockWaveParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.NUCLEAR_SHOCK_PARTICLE.get(), NuclearShockParticleParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.HUGE_FIREBALL.get(), HugeFireballParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.HUGE_SMOKE.get(), HugeSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.GROUND_HUGE_SMOKE.get(), GroundHugeSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.MEDIUM_TRACER.get(), MediumTracerParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), SplashPuffParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SMOKE.get(), SmokeParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.BULLET_TRAIL.get(), BulletTrailParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.LARGE_BULLET_TRAIL.get(), LargeBulletTrailParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.AERIAL_SPARKS.get(), AerialSparksParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.GREEN_TRACER.get(), GreenTracerParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.WHITE_TRACER.get(), WhiteTracerParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SMALL_GREEN_TRACER.get(), SmallGreenTracerParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.RISING_FLAME.get(), RisingFlameParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.GUN_SMOKE.get(), GunSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.DUST_WAVE.get(), DustWaveParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.FLARE.get(), FlareParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), JetFlameParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.DEATH_RAY.get(), DeathRayParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.HUGE_STATIC_FIREBALL.get(), HugeStaticFireballParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.GAS_CLOUD.get(), GasCloudParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.ROCKET_SMOKE.get(), RocketSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.FUSION_FIREBALL.get(), FusionFireballParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.FUSION_STATIC_FIREBALL.get(), FusionStaticFireballParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.FUSION_SMOKE.get(), FusionSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)CrustyChunksModParticleTypes.SPACE_FIREBALL.get(), SpaceFireballParticle::provider);
   }
}

package net.mcreator.crustychunks.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FusionSmokeParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;
   private float angularVelocity;
   private float angularAcceleration;

   public static FusionSmokeParticle.FusionSmokeParticleProvider provider(SpriteSet spriteSet) {
      return new FusionSmokeParticle.FusionSmokeParticleProvider(spriteSet);
   }

   protected FusionSmokeParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.0F, 0.0F);
      this.f_107663_ *= 60.0F;
      this.f_107225_ = Math.max(1, 2880 + (this.f_107223_.m_188503_(400) - 200));
      this.f_107226_ = -0.04F;
      this.f_107219_ = false;
      this.f_107215_ = vx * 0.4D;
      this.f_107216_ = vy * 0.4D;
      this.f_107217_ = vz * 0.4D;
      this.angularVelocity = 0.02F;
      this.angularAcceleration = 0.0F;
      this.m_108335_(spriteSet);
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public void m_5989_() {
      super.m_5989_();
      this.f_107204_ = this.f_107231_;
      this.f_107231_ += this.angularVelocity;
      this.angularVelocity += this.angularAcceleration;
   }

   public static class FusionSmokeParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public FusionSmokeParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new FusionSmokeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}

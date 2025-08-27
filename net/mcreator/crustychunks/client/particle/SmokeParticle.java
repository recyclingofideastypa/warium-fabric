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
public class SmokeParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static SmokeParticle.SmokeParticleProvider provider(SpriteSet spriteSet) {
      return new SmokeParticle.SmokeParticleProvider(spriteSet);
   }

   protected SmokeParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(1.0F, 1.0F);
      this.f_107663_ *= 10.0F;
      this.f_107225_ = Math.max(1, 200 + (this.f_107223_.m_188503_(10) - 5));
      this.f_107226_ = -0.02F;
      this.f_107219_ = true;
      this.f_107215_ = vx * 0.15D;
      this.f_107216_ = vy * 0.15D;
      this.f_107217_ = vz * 0.15D;
      this.m_108339_(spriteSet);
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public void m_5989_() {
      super.m_5989_();
      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 17 % 12 + 1, 12));
      }

   }

   public static class SmokeParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public SmokeParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new SmokeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}

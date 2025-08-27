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
public class GroundHugeSmokeParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static GroundHugeSmokeParticle.GroundHugeSmokeParticleProvider provider(SpriteSet spriteSet) {
      return new GroundHugeSmokeParticle.GroundHugeSmokeParticleProvider(spriteSet);
   }

   protected GroundHugeSmokeParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.2F, 15.0F);
      this.f_107663_ *= 120.0F;
      this.f_107225_ = Math.max(1, 3000 + (this.f_107223_.m_188503_(1200) - 600));
      this.f_107226_ = 0.2F;
      this.f_107219_ = true;
      this.f_107215_ = vx * 0.1D;
      this.f_107216_ = vy * 0.1D;
      this.f_107217_ = vz * 0.1D;
      this.m_108335_(spriteSet);
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public void m_5989_() {
      super.m_5989_();
   }

   public static class GroundHugeSmokeParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public GroundHugeSmokeParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new GroundHugeSmokeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}

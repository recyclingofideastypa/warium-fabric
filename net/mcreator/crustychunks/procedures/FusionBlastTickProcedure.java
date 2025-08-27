package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;

public class FusionBlastTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean found = false;
         double particleRadius = 0.0D;
         double particleAmount = 0.0D;
         double sx = 0.0D;
         double sy = 0.0D;
         double sz = 0.0D;
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double Groundatspot = 0.0D;
         if (1.0D == immediatesourceentity.getPersistentData().m_128459_("T")) {
            FusionEffectsProcedure.execute(world, x, immediatesourceentity.m_20186_() - 15.0D, z);
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(500.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.m_20238_(_center);
            })).toList();
            Iterator var29 = _entfound.iterator();

            while(var29.hasNext()) {
               Entity entityiterator = (Entity)var29.next();
               CrustyChunksMod.queueServerWork((int)Math.abs(Math.round(Math.sqrt(Math.pow(x - entityiterator.m_20185_(), 2.0D) + Math.pow(z - entityiterator.m_20189_(), 2.0D)) * 0.5D)), () -> {
                  immediatesourceentity.m_7618_(Anchor.EYES, new Vec3(entityiterator.m_20185_(), entityiterator.m_20186_() + 1.0D, entityiterator.m_20189_()));
                  if (Math.abs(entityiterator.m_20186_() + 0.5D - y) - (Math.abs((double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123342_() - y) + 0.5D) <= 0.0D && Math.abs(entityiterator.m_20185_() - x) - (Math.abs((double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123341_() - x) + 0.5D) <= 0.0D && Math.abs(entityiterator.m_20189_() - z) - (Math.abs((double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123343_() - z) + 0.5D) <= 0.0D) {
                     entityiterator.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268565_)), 7.0F);
                     entityiterator.m_20256_(new Vec3(immediatesourceentity.m_20154_().f_82479_ * 2.0D + entityiterator.m_20184_().m_7096_(), immediatesourceentity.m_20154_().f_82480_ * 2.0D + entityiterator.m_20184_().m_7098_(), immediatesourceentity.m_20154_().f_82481_ * 2.0D + entityiterator.m_20184_().m_7094_()));
                  }

               });
            }
         }

         immediatesourceentity.m_20242_(true);
         immediatesourceentity.f_19794_ = true;
         immediatesourceentity.m_20256_(new Vec3(0.0D, 0.0D, 0.0D));
         immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);
         xRadius = 1.0D + immediatesourceentity.getPersistentData().m_128459_("T");
         zRadius = 1.0D + immediatesourceentity.getPersistentData().m_128459_("T");

         for(particleAmount = (double)(1L + Math.round(xRadius * 0.9D)); loop < particleAmount; ++loop) {
            if (immediatesourceentity.getPersistentData().m_128459_("T") / 2.0D == (double)Math.round(immediatesourceentity.getPersistentData().m_128459_("T") / 2.0D)) {
               if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 5)) {
                  Level _level;
                  if (y + 10.0D > (double)world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) && !ModList.get().isLoaded("explosionoverhaul") && world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius, (double)(world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) + 9), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius, 6.0F, ExplosionInteraction.BLOCK);
                     }
                  }

                  if (5.0D <= immediatesourceentity.getPersistentData().m_128459_("T") && !ModList.get().isLoaded("explosionoverhaul") && y + 5.0D > (double)world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) && world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius, Math.max((double)(world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) + 22), y + 8.0D), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius, (float)(16.0D / Math.ceil(xRadius / 75.0D) + 4.0D), ExplosionInteraction.BLOCK);
                     }
                  }

                  if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 2) && 550.0D >= immediatesourceentity.getPersistentData().m_128459_("T")) {
                     Groundatspot = (double)world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius));
                     if (5.0D <= immediatesourceentity.getPersistentData().m_128459_("T")) {
                        world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.DUST_WAVE.get(), x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius, (double)(world.m_6924_(Types.MOTION_BLOCKING, Mth.m_14107_(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), Mth.m_14107_(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) + 4), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius, Math.cos(6.283185307179586D / particleAmount * loop), 0.0D, Math.sin(6.283185307179586D / particleAmount * loop));
                        world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.NUCLEAR_SHOCK_PARTICLE.get(), x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius, y + Mth.m_216263_(RandomSource.m_216327_(), 25.0D, 30.0D), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius, Math.cos(6.283185307179586D / particleAmount * loop), 0.0D, Math.sin(6.283185307179586D / particleAmount * loop));
                        if (30.0D <= immediatesourceentity.getPersistentData().m_128459_("T")) {
                           world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.NUCLEAR_SHOCK_PARTICLE.get(), x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * (xRadius - 30.0D), y + Mth.m_216263_(RandomSource.m_216327_(), 75.0D, 80.0D), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * (zRadius - 30.0D), Math.cos(6.283185307179586D / particleAmount * loop), 0.0D, Math.sin(6.283185307179586D / particleAmount * loop));
                        }
                     }
                  }
               }

               if (Mth.m_216271_(RandomSource.m_216327_(), 1, 10) == 1 && 130.0D > immediatesourceentity.getPersistentData().m_128459_("T") && 5.0D <= immediatesourceentity.getPersistentData().m_128459_("T")) {
                  world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.GROUND_HUGE_SMOKE.get(), x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * (xRadius - 20.0D), (double)(world.m_6924_(Types.MOTION_BLOCKING, Mth.m_14107_(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * (xRadius - 20.0D)), Mth.m_14107_(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * (zRadius - 20.0D))) + 8), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * (zRadius - 20.0D), 0.0D, 0.25D, 0.0D);
               }
            }
         }

         immediatesourceentity.getPersistentData().m_128347_("Iterations", immediatesourceentity.getPersistentData().m_128459_("Iterations") + 1.0D);
         if (450.0D <= immediatesourceentity.getPersistentData().m_128459_("T") && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

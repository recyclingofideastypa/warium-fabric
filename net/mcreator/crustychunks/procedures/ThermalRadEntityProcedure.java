package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ThermalRadEntityProcedure {
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
         immediatesourceentity.m_20242_(true);
         immediatesourceentity.f_19794_ = true;
         immediatesourceentity.m_20256_(new Vec3(0.0D, 0.0D, 0.0D));
         if (immediatesourceentity.getPersistentData().m_128459_("T") <= 20.0D) {
            immediatesourceentity.getPersistentData().m_128347_("T", immediatesourceentity.getPersistentData().m_128459_("T") + 1.0D);

            for(int index0 = 0; index0 < 200; ++index0) {
               immediatesourceentity.m_146922_((float)Mth.m_216263_(RandomSource.m_216327_(), -360.0D, 360.0D));
               immediatesourceentity.m_146926_((float)Mth.m_216263_(RandomSource.m_216327_(), -360.0D, 360.0D));
               immediatesourceentity.m_5618_(immediatesourceentity.m_146908_());
               immediatesourceentity.m_5616_(immediatesourceentity.m_146908_());
               immediatesourceentity.f_19859_ = immediatesourceentity.m_146908_();
               immediatesourceentity.f_19860_ = immediatesourceentity.m_146909_();
               if (immediatesourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)immediatesourceentity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (!world.m_46859_(new BlockPos(immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123341_(), immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123342_(), immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(160.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123343_()))) {
                  CrustyChunksMod.queueServerWork(1, () -> {
                     BurnBlockProcedure.execute(world, (double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123341_(), (double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123342_(), (double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123343_());
                  });
               }

               if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 40)) {
                  world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.DEATH_RAY.get(), x + immediatesourceentity.m_20154_().f_82479_ * 0.0D, y + immediatesourceentity.m_20154_().f_82480_ * 0.0D, z + immediatesourceentity.m_20154_().f_82481_ * 0.0D, immediatesourceentity.m_20154_().f_82479_, immediatesourceentity.m_20154_().f_82480_, immediatesourceentity.m_20154_().f_82481_);
                  world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.DEATH_RAY.get(), x + immediatesourceentity.m_20154_().f_82479_ * 8.0D, y + immediatesourceentity.m_20154_().f_82480_ * 8.0D, z + immediatesourceentity.m_20154_().f_82481_ * 8.0D, immediatesourceentity.m_20154_().f_82479_, immediatesourceentity.m_20154_().f_82480_, immediatesourceentity.m_20154_().f_82481_);
                  world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.DEATH_RAY.get(), x + immediatesourceentity.m_20154_().f_82479_ * 12.0D, y + immediatesourceentity.m_20154_().f_82480_ * 12.0D, z + immediatesourceentity.m_20154_().f_82481_ * 12.0D, immediatesourceentity.m_20154_().f_82479_, immediatesourceentity.m_20154_().f_82480_, immediatesourceentity.m_20154_().f_82481_);
                  world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.DEATH_RAY.get(), x + immediatesourceentity.m_20154_().f_82479_ * 16.0D, y + immediatesourceentity.m_20154_().f_82480_ * 16.0D, z + immediatesourceentity.m_20154_().f_82481_ * 16.0D, immediatesourceentity.m_20154_().f_82479_, immediatesourceentity.m_20154_().f_82480_, immediatesourceentity.m_20154_().f_82481_);
                  world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.DEATH_RAY.get(), x + immediatesourceentity.m_20154_().f_82479_ * 20.0D, y + immediatesourceentity.m_20154_().f_82480_ * 20.0D, z + immediatesourceentity.m_20154_().f_82481_ * 20.0D, immediatesourceentity.m_20154_().f_82479_, immediatesourceentity.m_20154_().f_82480_, immediatesourceentity.m_20154_().f_82481_);
               }
            }
         } else {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(250.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.m_20238_(_center);
            })).toList();
            Iterator var32 = _entfound.iterator();

            while(var32.hasNext()) {
               Entity entityiterator = (Entity)var32.next();
               if (entityiterator instanceof LivingEntity) {
                  immediatesourceentity.m_7618_(Anchor.EYES, new Vec3(entityiterator.m_20185_(), entityiterator.m_20186_() + 1.0D, entityiterator.m_20189_()));
                  if (Math.abs(entityiterator.m_20185_() - x) - (Math.abs((double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123341_() - x) + 0.5D) <= 0.0D && Math.abs(entityiterator.m_20189_() - z) - (Math.abs((double)immediatesourceentity.m_9236_().m_45547_(new ClipContext(immediatesourceentity.m_20299_(1.0F), immediatesourceentity.m_20299_(1.0F).m_82549_(immediatesourceentity.m_20252_(1.0F).m_82490_(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).m_82425_().m_123343_() - z) + 0.5D) <= 0.0D) {
                     entityiterator.m_20254_(40);
                  }
               }
            }

            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

      }
   }
}

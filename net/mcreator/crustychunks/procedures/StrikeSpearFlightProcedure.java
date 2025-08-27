package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class StrikeSpearFlightProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean detonate = false;
         boolean Trigger = false;
         new Vec3(0.0D, 0.0D, 0.0D);
         BlockState Lblock = Blocks.f_50016_.m_49966_();
         double distancetotarget = 0.0D;
         double speed = 0.0D;
         double targetspeed = 0.0D;
         double leadvariable = 0.0D;
         double Limiter = 0.0D;
         double mx = 0.0D;
         double my = 0.0D;
         double mz = 0.0D;
         double Xvector = 0.0D;
         double Zvector = 0.0D;
         double Pitch = 0.0D;
         double LX = 0.0D;
         double LY = 0.0D;
         double LZ = 0.0D;
         ForceChunksProcedure.execute(world, x, y, z);
         Lblock = world.m_8055_(BlockPos.m_274561_(immediatesourceentity.getPersistentData().m_128459_("LX"), immediatesourceentity.getPersistentData().m_128459_("LY"), immediatesourceentity.getPersistentData().m_128459_("LZ")));
         LX = immediatesourceentity.getPersistentData().m_128459_("LX");
         LY = immediatesourceentity.getPersistentData().m_128459_("LY");
         LZ = immediatesourceentity.getPersistentData().m_128459_("LZ");
         immediatesourceentity.getPersistentData().m_128347_("Time", immediatesourceentity.getPersistentData().m_128459_("Time") + 1.0D);
         if (1.0D > Math.abs((double)((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockState _bs) {
               Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
               if (_prop instanceof DirectionProperty) {
                  DirectionProperty _dp = (DirectionProperty)_prop;
                  return (Direction)_bs.m_61143_(_dp);
               } else {
                  _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                  Direction var10000;
                  if (_prop instanceof EnumProperty) {
                     EnumProperty _ep = (EnumProperty)_prop;
                     if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                        var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                        return var10000;
                     }
                  }

                  var10000 = Direction.NORTH;
                  return var10000;
               }
            }
         })).getDirection(Lblock).m_122429_() - ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(LX, LY, LZ), "X")) || 0.5D > Math.abs((double)((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockState _bs) {
               Property<?> _prop = _bs.m_60734_().m_49965_().m_61081_("facing");
               if (_prop instanceof DirectionProperty) {
                  DirectionProperty _dp = (DirectionProperty)_prop;
                  return (Direction)_bs.m_61143_(_dp);
               } else {
                  _prop = _bs.m_60734_().m_49965_().m_61081_("axis");
                  Direction var10000;
                  if (_prop instanceof EnumProperty) {
                     EnumProperty _ep = (EnumProperty)_prop;
                     if (_ep.m_6908_().toArray()[0] instanceof Axis) {
                        var10000 = Direction.m_122387_((Axis)_bs.m_61143_(_ep), AxisDirection.POSITIVE);
                        return var10000;
                     }
                  }

                  var10000 = Direction.NORTH;
                  return var10000;
               }
            }
         })).getDirection(Lblock).m_122431_() - ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(LX, LY, LZ), "Z"))) {
            Pitch = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(LX, LY, LZ), "Pitch") + immediatesourceentity.m_20184_().m_7098_() / (Math.pow(immediatesourceentity.m_20184_().m_7096_(), 2.0D) + Math.pow(immediatesourceentity.m_20184_().m_7094_(), 2.0D) + Math.pow(immediatesourceentity.m_20184_().m_7098_(), 2.0D));
            Xvector = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(LX, LY, LZ), "X") + immediatesourceentity.m_20184_().m_7096_() / (Math.pow(immediatesourceentity.m_20184_().m_7096_(), 2.0D) + Math.pow(immediatesourceentity.m_20184_().m_7094_(), 2.0D) + Math.pow(immediatesourceentity.m_20184_().m_7098_(), 2.0D));
            Zvector = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(LX, LY, LZ), "Z") + immediatesourceentity.m_20184_().m_7094_() / (Math.pow(immediatesourceentity.m_20184_().m_7096_(), 2.0D) + Math.pow(immediatesourceentity.m_20184_().m_7094_(), 2.0D) + Math.pow(immediatesourceentity.m_20184_().m_7098_(), 2.0D));
         }

         Vec3 _center;
         if (immediatesourceentity.getPersistentData().m_128459_("Time") <= 220.0D) {
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_BULLET_TRAIL.get(), x, y, z, Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D), Mth.m_216263_(RandomSource.m_216327_(), -0.05D, 0.05D));
            world.m_7106_((SimpleParticleType)CrustyChunksModParticleTypes.TRACER.get(), x, y, z, immediatesourceentity.m_20184_().m_7096_(), immediatesourceentity.m_20184_().m_7098_(), immediatesourceentity.m_20184_().m_7094_());
            if (immediatesourceentity.getPersistentData().m_128459_("Time") / 5.0D == (double)Math.round(immediatesourceentity.getPersistentData().m_128459_("Time") / 5.0D)) {
               Level _level;
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 10.0F, (float)(2.0D - immediatesourceentity.getPersistentData().m_128459_("Time") / 140.0D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 10.0F, (float)(2.0D - immediatesourceentity.getPersistentData().m_128459_("Time") / 140.0D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 25.0F, (float)(2.0D - immediatesourceentity.getPersistentData().m_128459_("Time") / 140.0D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 25.0F, (float)(2.0D - immediatesourceentity.getPersistentData().m_128459_("Time") / 140.0D), false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123747_, x, y, z, 1, 0.1D, 0.1D, 0.1D, 0.01D);
            }

            _center = immediatesourceentity.m_20184_().m_82490_(1.02D);
            immediatesourceentity.m_20256_(_center);
            immediatesourceentity.m_20242_(true);
            speed = Math.sqrt(Math.pow(Math.abs(immediatesourceentity.m_20184_().m_7096_()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.m_20184_().m_7098_()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.m_20184_().m_7094_()), 2.0D));
            Limiter = 0.4D * speed;
            if (immediatesourceentity.getPersistentData().m_128459_("Time") > 5.0D) {
               immediatesourceentity.m_20256_(new Vec3(Math.min(immediatesourceentity.m_20184_().m_7096_() + Limiter, Math.max(immediatesourceentity.m_20184_().m_7096_() + Xvector, immediatesourceentity.m_20184_().m_7096_() - Limiter)), Math.min(immediatesourceentity.m_20184_().m_7098_() + Limiter, Math.max(immediatesourceentity.m_20184_().m_7098_() + Pitch, immediatesourceentity.m_20184_().m_7098_() - Limiter)), Math.min(immediatesourceentity.m_20184_().m_7094_() + Limiter, Math.max(immediatesourceentity.m_20184_().m_7094_() + Zvector, immediatesourceentity.m_20184_().m_7094_() - Limiter))));
            }
         } else {
            LargeHEATHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

         if (speed > 3.0D && immediatesourceentity.getPersistentData().m_128459_("Time") > 10.0D) {
            immediatesourceentity.m_20256_(new Vec3(immediatesourceentity.m_20184_().m_7096_() * 0.8D, immediatesourceentity.m_20184_().m_7098_() * 0.8D, immediatesourceentity.m_20184_().m_7094_() * 0.8D));
         }

         if (immediatesourceentity.m_5842_()) {
            LargeHEATHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

         _center = new Vec3(x, y, z);
         List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(1.0D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.m_20238_(_center);
         })).toList();
         Iterator var42 = _entfound.iterator();

         while(var42.hasNext()) {
            Entity entityiterator = (Entity)var42.next();
            if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:bullet")))) {
               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }

               Trigger = true;
            }
         }

         if (Trigger) {
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }

            CrustyChunksMod.queueServerWork(1, () -> {
               LargeHEATHitProcedure.execute(world, x, y, z, immediatesourceentity);
            });
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import net.mcreator.crustychunks.entity.ToxicCloudDetectorEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class GasDispenserTickProcedure {
   public static void execute(final LevelAccessor world, double x, double y, double z) {
      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      Level _level;
      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Cooldown") <= 0.0D) {
         if (null != (Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x + 0.5D, y, z + 0.5D), 5.0D, 5.0D, 5.0D), (e) -> {
            return true;
         }).stream().sorted(((<undefinedtype>)(new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.m_20275_(_x, _y, _z);
               });
            }
         })).compareDistOf(x + 0.5D, y, z + 0.5D)).findFirst().orElse((Object)null)) {
            if (!world.m_5776_()) {
               _bp = BlockPos.m_274561_(x, y, z);
               _blockEntity = world.m_7702_(_bp);
               _bs = world.m_8055_(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().m_128347_("Cooldown", 120.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.m_7260_(_bp, _bs, _bs, 3);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 4.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
               }
            }
         }
      } else if (!world.m_5776_()) {
         _bp = BlockPos.m_274561_(x, y, z);
         _blockEntity = world.m_7702_(_bp);
         _bs = world.m_8055_(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().m_128347_("Cooldown", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Cooldown") - 1.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.m_7260_(_bp, _bs, _bs, 3);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Cooldown") >= 110.0D && world instanceof Level) {
         _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 4.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.6D, 1.8D));
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 4.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.6D, 1.8D), false);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Cooldown") == 110.0D) {
         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new ToxicCloudDetectorEntity((EntityType)CrustyChunksModEntities.TOXIC_CLOUD_DETECTOR.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  return entityToSpawn;
               }
            })).getArrow(_level, 5.0F, 1);
            _entityToSpawn.m_6034_(x + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockPos pos) {
                  BlockState _bs = world.m_8055_(pos);
                  Property<?> property = _bs.m_60734_().m_49965_().m_61081_("facing");
                  if (property != null) {
                     Comparable var5 = _bs.m_61143_(property);
                     if (var5 instanceof Direction) {
                        Direction _dir = (Direction)var5;
                        return _dir;
                     }
                  }

                  if (_bs.m_61138_(BlockStateProperties.f_61365_)) {
                     return Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61365_), AxisDirection.POSITIVE);
                  } else {
                     return _bs.m_61138_(BlockStateProperties.f_61364_) ? Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61364_), AxisDirection.POSITIVE) : Direction.NORTH;
                  }
               }
            })).getDirection(BlockPos.m_274561_(x, y, z)).m_122429_() + 0.5D, y + 0.5D, z + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockPos pos) {
                  BlockState _bs = world.m_8055_(pos);
                  Property<?> property = _bs.m_60734_().m_49965_().m_61081_("facing");
                  if (property != null) {
                     Comparable var5 = _bs.m_61143_(property);
                     if (var5 instanceof Direction) {
                        Direction _dir = (Direction)var5;
                        return _dir;
                     }
                  }

                  if (_bs.m_61138_(BlockStateProperties.f_61365_)) {
                     return Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61365_), AxisDirection.POSITIVE);
                  } else {
                     return _bs.m_61138_(BlockStateProperties.f_61364_) ? Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61364_), AxisDirection.POSITIVE) : Direction.NORTH;
                  }
               }
            })).getDirection(BlockPos.m_274561_(x, y, z)).m_122431_() + 0.5D);
            _entityToSpawn.m_6686_(0.0D, 1.0D, 0.0D, 1.0F, 0.0F);
            _level.m_7967_(_entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.GAS_CLOUD.get(), x + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockPos pos) {
                  BlockState _bs = world.m_8055_(pos);
                  Property<?> property = _bs.m_60734_().m_49965_().m_61081_("facing");
                  if (property != null) {
                     Comparable var5 = _bs.m_61143_(property);
                     if (var5 instanceof Direction) {
                        Direction _dir = (Direction)var5;
                        return _dir;
                     }
                  }

                  if (_bs.m_61138_(BlockStateProperties.f_61365_)) {
                     return Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61365_), AxisDirection.POSITIVE);
                  } else {
                     return _bs.m_61138_(BlockStateProperties.f_61364_) ? Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61364_), AxisDirection.POSITIVE) : Direction.NORTH;
                  }
               }
            })).getDirection(BlockPos.m_274561_(x, y, z)).m_122429_() + 0.5D, y + 0.5D, z + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockPos pos) {
                  BlockState _bs = world.m_8055_(pos);
                  Property<?> property = _bs.m_60734_().m_49965_().m_61081_("facing");
                  if (property != null) {
                     Comparable var5 = _bs.m_61143_(property);
                     if (var5 instanceof Direction) {
                        Direction _dir = (Direction)var5;
                        return _dir;
                     }
                  }

                  if (_bs.m_61138_(BlockStateProperties.f_61365_)) {
                     return Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61365_), AxisDirection.POSITIVE);
                  } else {
                     return _bs.m_61138_(BlockStateProperties.f_61364_) ? Direction.m_122387_((Axis)_bs.m_61143_(BlockStateProperties.f_61364_), AxisDirection.POSITIVE) : Direction.NORTH;
                  }
               }
            })).getDirection(BlockPos.m_274561_(x, y, z)).m_122431_() + 0.5D, 25, 0.0D, 0.0D, 0.0D, 0.25D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.NEUTRAL, 4.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
            }
         }
      }

   }
}

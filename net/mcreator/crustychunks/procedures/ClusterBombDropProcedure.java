package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.ClusterBombProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;

public class ClusterBombDropProcedure {
   public static void execute(final LevelAccessor world, double x, double y, double z) {
      if (world.m_8055_(BlockPos.m_274561_(x + 0.5D, y - 1.0D, z + 0.5D)).m_60734_() == Blocks.f_50016_) {
         if (world instanceof ServerLevel) {
            ServerLevel projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new ClusterBombProjectileEntity((EntityType)CrustyChunksModEntities.CLUSTER_BOMB_PROJECTILE.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 5.0F, 1);
            _entityToSpawn.m_6034_(x + 0.5D, y - 0.9D, z + 0.5D);
            _entityToSpawn.m_6686_((double)((<undefinedtype>)(new Object() {
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
            })).getDirection(BlockPos.m_274561_(x, y, z)).m_122429_(), (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(BlockPos.m_274561_(x, y, z)).m_122430_(), (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(BlockPos.m_274561_(x, y, z)).m_122431_(), 0.2F, 0.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50016_.m_49966_(), 3);
      } else {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50016_.m_49966_(), 3);
         MediumExplosionProcedure.execute(world, x, y, z);
      }

   }
}

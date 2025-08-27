package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.ChaffEntity;
import net.mcreator.crustychunks.entity.VehicleFlareProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class CountermeasureDispenserFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      Direction playerdirection = Direction.NORTH;
      boolean found = false;
      boolean DetectedPlayer = false;
      boolean fire = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double Pitch = 0.0D;
      double Xvector = 0.0D;
      double Zvector = 0.0D;
      double Barrels = 0.0D;
      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "Cooldown") <= 0.0D) {
         BlockState _bs;
         Level _level;
         BlockEntity _blockEntity;
         BlockPos _bp;
         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Ammo") >= 1.0D) {
            Level _level;
            if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Type") == 1.0D) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.BLOCKS, 25.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 0.8D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.BLOCKS, 25.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 0.8D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.BLOCKS, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.4D, 0.6D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.BLOCKS, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.4D, 0.6D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.dispense")), SoundSource.BLOCKS, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.dispense")), SoundSource.BLOCKS, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D), false);
                  }
               }

               ServerLevel projectileLevel;
               if (world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  projectileLevel.m_8767_(ParticleTypes.f_123744_, x + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).m_122429_(), y + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).m_122430_(), z + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).m_122431_(), 20, 0.0D, 0.0D, 0.0D, 0.05D);
               }

               if (world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new VehicleFlareProjectileEntity((EntityType)CrustyChunksModEntities.VEHICLE_FLARE_PROJECTILE.get(), level);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36767_(piercing);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 10.0F, 2, (byte)10);
                  _entityToSpawn.m_6034_(x + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).m_122429_() * 1.5D, y + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).m_122430_() * 1.5D, z + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).m_122431_() * 1.5D);
                  _entityToSpawn.m_6686_((double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).m_122429_(), (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).m_122430_(), (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).m_122431_(), 2.0F, 11.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               if (!world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128347_("Ammo", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "Ammo") - 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128347_("Cooldown", 4.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }
            } else if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Type") == 2.0D) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 0.8D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 0.8D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9D, 1.1D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.BLOCKS, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.4D, 0.6D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.BLOCKS, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.4D, 0.6D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle_far")), SoundSource.BLOCKS, 25.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.4D, 0.6D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle_far")), SoundSource.BLOCKS, 25.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.4D, 0.6D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.dispense")), SoundSource.BLOCKS, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.dispense")), SoundSource.BLOCKS, 10.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8D, 0.9D), false);
                  }
               }

               for(int index0 = 0; index0 < 6; ++index0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel projectileLevel = (ServerLevel)world;
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new ChaffEntity((EntityType)CrustyChunksModEntities.CHAFF.get(), level);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           entityToSpawn.m_36767_(piercing);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, 10.0F, 2, (byte)10);
                     _entityToSpawn.m_6034_(x + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).m_122429_() * 1.5D, y + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).m_122430_() * 1.5D, z + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).m_122431_() * 1.5D);
                     _entityToSpawn.m_6686_((double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).m_122429_(), (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).m_122430_(), (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).m_122431_(), 1.0F, 15.0F);
                     projectileLevel.m_7967_(_entityToSpawn);
                  }
               }

               if (!world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128347_("Ammo", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "Ammo") - 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.m_5776_()) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _blockEntity = world.m_7702_(_bp);
                  _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128347_("Cooldown", 4.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }
            }
         } else if (!world.m_5776_()) {
            _bp = BlockPos.m_274561_(x, y, z);
            _blockEntity = world.m_7702_(_bp);
            _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("Type", 0.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }
      }

   }
}

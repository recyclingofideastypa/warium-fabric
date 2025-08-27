package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class SmokeLauncherReloadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         Level _level;
         BlockPos _bp;
         Level _level;
         BlockEntity _blockEntity;
         BlockState _bs;
         if (var10000.m_41720_() == CrustyChunksModItems.SMOKE_MORTAR_SHELL.get()) {
            if (3.0D > ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Ammo")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMOKE_MORTAR_SHELL.get())).m_41777_();
                  ItemStack var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  _setstack.m_41764_(var10001.m_41613_() - 1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
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
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "Ammo") + 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                  }
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_() && 1.0D <= ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.m_7702_(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.m_274561_(x, y, z), "Ammo")) {
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

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 1.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.SMOKE_MORTAR_SHELL.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                  }
               }
            }
         }

      }
   }
}

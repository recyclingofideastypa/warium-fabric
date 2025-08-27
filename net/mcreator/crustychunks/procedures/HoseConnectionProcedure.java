package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class HoseConnectionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         Player _player;
         if (0.0D == itemstack.m_41784_().m_128459_("SelectedX") && 0.0D == itemstack.m_41784_().m_128459_("SelectedY") && 0.0D == itemstack.m_41784_().m_128459_("SelectedZ") && world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:engines")))) {
            itemstack.m_41784_().m_128347_("SelectedX", x);
            itemstack.m_41784_().m_128347_("SelectedY", y);
            itemstack.m_41784_().m_128347_("SelectedZ", z);
            if (entity instanceof Player) {
               _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("§6Position 1 Selected!"), true);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_175831_, x + 0.5D, y + 0.5D, z + 0.5D, 25, 0.25D, 0.25D, 0.25D, 0.0D);
            }
         } else if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FUEL_TANK.get()) {
            if (25.0D >= Math.abs(x - itemstack.m_41784_().m_128459_("SelectedX")) && 25.0D >= Math.abs(y - itemstack.m_41784_().m_128459_("SelectedY")) && 25.0D >= Math.abs(z - itemstack.m_41784_().m_128459_("SelectedZ"))) {
               CrustyChunksMod.queueServerWork(1, () -> {
                  BlockPos _bp;
                  BlockEntity _blockEntity;
                  BlockState _bs;
                  Level _level;
                  if (!world.m_5776_()) {
                     _bp = BlockPos.m_274561_(x, y, z);
                     _blockEntity = world.m_7702_(_bp);
                     _bs = world.m_8055_(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().m_128347_("ConnectionX", x - itemstack.m_41784_().m_128459_("SelectedX"));
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
                        _blockEntity.getPersistentData().m_128347_("ConnectionY", y - itemstack.m_41784_().m_128459_("SelectedY"));
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
                        _blockEntity.getPersistentData().m_128347_("ConnectionZ", z - itemstack.m_41784_().m_128459_("SelectedZ"));
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.m_7260_(_bp, _bs, _bs, 3);
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_("§6Link Succesful!"), true);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _levelx = (ServerLevel)world;
                     _levelx.m_8767_(ParticleTypes.f_175830_, x + 0.5D, y + 0.5D, z + 0.5D, 25, 0.25D, 0.25D, 0.25D, 0.0D);
                  }

                  if (world instanceof Level) {
                     Level _levelxx = (Level)world;
                     if (!_levelxx.m_5776_()) {
                        _levelxx.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _levelxx.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  itemstack.m_41784_().m_128347_("SelectedX", 0.0D);
                  itemstack.m_41784_().m_128347_("SelectedY", 0.0D);
                  itemstack.m_41784_().m_128347_("SelectedZ", 0.0D);
                  itemstack.m_41774_(1);
               });
            } else {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                  }
               }

               if (entity instanceof Player) {
                  _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("§6Link Failed: Out of Range."), true);
                  }
               }
            }
         }

      }
   }
}

package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidDrainProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack Bucket = ItemStack.f_41583_;
         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Fluid").equals("Oil")) {
            Bucket = (new ItemStack((ItemLike)CrustyChunksModItems.OIL_BUCKET.get())).m_41777_();
         } else if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Fluid").equals("Diesel")) {
            Bucket = (new ItemStack((ItemLike)CrustyChunksModItems.DIESEL_BUCKET.get())).m_41777_();
         } else if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Fluid").equals("Kerosene")) {
            Bucket = (new ItemStack((ItemLike)CrustyChunksModItems.KEROSENE_BUCKET.get())).m_41777_();
         } else if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Fluid").equals("Petrolium")) {
            Bucket = (new ItemStack((ItemLike)CrustyChunksModItems.PETROLIUM_BUCKET.get())).m_41777_();
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.m_7702_(pos);
               return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.m_274561_(x, y, z), "Level") >= 1000.0D) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == Items.f_42446_) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41774_(1);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), Bucket);
                  entityToSpawn.m_32010_(5);
                  _level.m_7967_(entityToSpawn);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (!world.m_5776_()) {
                  BlockPos _bp = BlockPos.m_274561_(x, y, z);
                  BlockEntity _blockEntity = world.m_7702_(_bp);
                  BlockState _bs = world.m_8055_(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().m_128347_("Level", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "Level") - 1000.0D);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     _level.m_7260_(_bp, _bs, _bs, 3);
                  }
               }
            }
         }

      }
   }
}

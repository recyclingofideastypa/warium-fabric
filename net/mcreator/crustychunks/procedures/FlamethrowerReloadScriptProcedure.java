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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class FlamethrowerReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         LivingEntity _livEnt;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         LivingEntity _livEnt;
         if (var10000.m_41784_().m_128459_("Fluid") <= 0.0D) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            var10000.m_41784_().m_128379_("Loaded", false);
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == CrustyChunksModItems.PETROLIUM_BUCKET.get()) {
            ItemStack var10001;
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21205_();
            } else {
               var10001 = ItemStack.f_41583_;
            }

            if (!var10001.m_41784_().m_128471_("Loaded")) {
               LivingEntity _livEnt;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128379_("Loaded", true);
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41774_(1);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.f_42446_));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")), SoundSource.NEUTRAL, 1.0F, 0.4F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")), SoundSource.NEUTRAL, 1.0F, 0.4F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128347_("Fluid", 1000.0D);
            }
         }

      }
   }
}

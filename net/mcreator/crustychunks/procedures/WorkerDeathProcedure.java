package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class WorkerDeathProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
            }
         }

         world.m_46796_(2001, BlockPos.m_274561_(x, y, z), Block.m_49956_(((Block)CrustyChunksModBlocks.STEEL_BLOCK.get()).m_49966_()));
         world.m_46796_(2001, BlockPos.m_274561_(x, y + 1.0D, z), Block.m_49956_(((Block)CrustyChunksModBlocks.GREEN_ARMOR.get()).m_49966_()));
         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 1.0D, z, 5, 0.0D, 0.0D, 0.0D, 0.5D);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x, y + 1.0D, z, 5, 0.0D, 0.0D, 0.0D, 0.5D);
         }

         MicroExplosionProcedure.execute(world, x, y, z);
         if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         CrustyChunksMod.queueServerWork(10, () -> {
            int index6;
            ServerLevel _level;
            ItemEntity entityToSpawn;
            for(index6 = 0; index6 < Mth.m_216271_(RandomSource.m_216327_(), 25, 32); ++index6) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.BULLET.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }
            }

            for(index6 = 0; index6 < Mth.m_216271_(RandomSource.m_216327_(), 3, 4); ++index6) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.ADVANCED_COMPONENT.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }
            }

            for(index6 = 0; index6 < Mth.m_216271_(RandomSource.m_216327_(), 2, 3); ++index6) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.TECH_COMPONENT.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }
            }

            for(index6 = 0; index6 < Mth.m_216271_(RandomSource.m_216327_(), 3, 5); ++index6) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_INGOT.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }
            }

            for(index6 = 0; index6 < Mth.m_216271_(RandomSource.m_216327_(), 3, 5); ++index6) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }
            }

            for(index6 = 0; index6 < Mth.m_216271_(RandomSource.m_216327_(), 3, 5); ++index6) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.CAST_COMPONENT.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }
            }

            for(index6 = 0; index6 < 1; ++index6) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.LARGE_BORED_BARREL.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.BORED_COMPONENT.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }
            }

         });
         if (world.m_6106_().m_5470_().m_46207_(CrustyChunksModGameRules.APOCALYPSE_MODE)) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(32.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.m_20238_(_center);
            })).toList();
            Iterator var10 = _entfound.iterator();

            while(var10.hasNext()) {
               Entity entityiterator = (Entity)var10.next();
               if (1 == Mth.m_216271_(RandomSource.m_216327_(), 1, 30) && entityiterator instanceof Player && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.IMPENDING_DOOM.get(), 8000, 1, false, false));
                  }
               }
            }
         }

      }
   }
}

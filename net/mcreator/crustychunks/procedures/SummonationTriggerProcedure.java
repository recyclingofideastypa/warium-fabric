package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonationTriggerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Modules = 0.0D;
      double spawnx = 0.0D;
      double spawnz = 0.0D;
      boolean PlayerFound = false;
      BlockPos _bp = BlockPos.m_274561_(x, y, z);
      BlockState _bs = ((Block)CrustyChunksModBlocks.OPEN_SUMMONATION.get()).m_49966_();
      BlockState _bso = world.m_8055_(_bp);
      UnmodifiableIterator var17 = _bso.m_61148_().entrySet().iterator();

      while(var17.hasNext()) {
         Entry<Property<?>, Comparable<?>> entry = (Entry)var17.next();
         Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
         if (_property != null && _bs.m_61143_(_property) != null) {
            try {
               _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
            } catch (Exception var21) {
            }
         }
      }

      world.m_7731_(_bp, _bs, 3);
      if (world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + 0.5D, y + 3.0D, z + 0.5D, 5, 0.0D, 3.0D, 0.0D, 0.01D);
      }

      if (world instanceof Level) {
         Level _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:golemidle")), SoundSource.NEUTRAL, 1.0F, 1.0F);
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:golemidle")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
         }
      }

      PlayerFound = false;
      Vec3 _center = new Vec3(x, y, z);
      List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(256.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.m_20238_(_center);
      })).toList();
      Iterator var26 = _entfound.iterator();

      while(var26.hasNext()) {
         Entity entityiterator = (Entity)var26.next();
         if (entityiterator instanceof Player && !PlayerFound) {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entityiterator;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.IMPENDING_DOOM.get(), 40000, 2, false, false));
               }
            }

            PlayerFound = true;
         }
      }

      CrustyChunksMod.queueServerWork(20, () -> {
         int index5;
         ServerLevel _level;
         ItemEntity entityToSpawn;
         for(index5 = 0; index5 < Mth.m_216271_(RandomSource.m_216327_(), 6, 9); ++index5) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.PLUTONIUM_NUGGET.get()));
               entityToSpawn.m_32010_(10);
               _level.m_7967_(entityToSpawn);
            }
         }

         for(index5 = 0; index5 < Mth.m_216271_(RandomSource.m_216327_(), 5, 6); ++index5) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.STEEL_BLOCK.get()));
               entityToSpawn.m_32010_(10);
               _level.m_7967_(entityToSpawn);
            }
         }

         for(index5 = 0; index5 < Mth.m_216271_(RandomSource.m_216327_(), 8, 16); ++index5) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.TECH_COMPONENT.get()));
               entityToSpawn.m_32010_(10);
               _level.m_7967_(entityToSpawn);
            }
         }

         for(index5 = 0; index5 < Mth.m_216271_(RandomSource.m_216327_(), 16, 24); ++index5) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ADVANCED_COMPONENT.get()));
               entityToSpawn.m_32010_(10);
               _level.m_7967_(entityToSpawn);
            }
         }

         for(index5 = 0; index5 < Mth.m_216271_(RandomSource.m_216327_(), 8, 10); ++index5) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.NEUTRON_REFLECTOR.get()));
               entityToSpawn.m_32010_(10);
               _level.m_7967_(entityToSpawn);
            }
         }

         for(index5 = 0; index5 < Mth.m_216271_(RandomSource.m_216327_(), 8, 16); ++index5) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.FUEL_ROD.get()));
               entityToSpawn.m_32010_(10);
               _level.m_7967_(entityToSpawn);
            }
         }

      });
      CrustyChunksMod.queueServerWork(80, () -> {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = ((EntityType)CrustyChunksModEntities.COMMANDER.get()).m_262496_(_level, BlockPos.m_274561_(x + 0.5D, y + 1.5D, z + 0.5D), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
            }
         }

      });
   }
}

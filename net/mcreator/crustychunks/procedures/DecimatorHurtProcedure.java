package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class DecimatorHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (Mth.m_216271_(RandomSource.m_216327_(), 1, 2) == 1 && entity.getPersistentData().m_128459_("T2") <= 0.0D) {
            entity.getPersistentData().m_128347_("T2", 20.0D);
            int horizontalRadiusSquare = 3;
            int verticalRadiusSquare = 2;
            int yIterationsSquare = verticalRadiusSquare;

            for(int i = -verticalRadiusSquare; i <= yIterationsSquare; ++i) {
               for(int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; ++xi) {
                  for(int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; ++zi) {
                     world.m_46796_(2001, BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi))));
                     if ((!(world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)).m_60800_(world, BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)) < 5.0F) || !(world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)).m_60800_(world, BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)) >= 0.0F)) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("crusty_chunks:chippable")))) {
                        HeavyCrackProcedureProcedure.execute(world, x + (double)xi, y + (double)i + 3.0D, z + (double)zi);
                     } else {
                        world.m_46961_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi), false);
                     }

                     if (world.m_8055_(BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)).m_60734_() == CrustyChunksModBlocks.STRUCTURAL_CONCRETE.get()) {
                        BlockPos _bp = BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi);
                        BlockState _bs = ((Block)CrustyChunksModBlocks.REENFORCED_CONCRETE.get()).m_49966_();
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
                        world.m_46796_(2001, BlockPos.m_274561_(x + (double)xi, y + (double)i + 3.0D, z + (double)zi), Block.m_49956_(((Block)CrustyChunksModBlocks.STEEL_BLOCK.get()).m_49966_()));
                     }
                  }
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 5.0F, 0.4F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 5.0F, 0.4F, false);
               }
            }

            if (entity instanceof DecimatorEntity) {
               ((DecimatorEntity)entity).setAnimation("Anger");
            }

            ServerLevel _level;
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x, y + 1.5D, z, 15, 2.0D, 0.0D, 2.0D, 1.0D);
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)CrustyChunksModParticleTypes.WHITE_DUST.get(), x, y + 1.5D, z, 15, 2.0D, 0.0D, 2.0D, 1.0D);
            }
         }

      }
   }
}

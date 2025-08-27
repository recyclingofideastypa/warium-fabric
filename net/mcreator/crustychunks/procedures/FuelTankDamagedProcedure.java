package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class FuelTankDamagedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FUEL_TANK.get() || world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FUEL_TANK_MODULE.get() || world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == CrustyChunksModBlocks.FUEL_TANK_INPUT.get()) {
         BlockPos _bp = BlockPos.m_274561_(x, y, z);
         BlockState _bs = ((Block)CrustyChunksModBlocks.DAMAGEDFUELTANK.get()).m_49966_();
         BlockState _bso = world.m_8055_(_bp);
         UnmodifiableIterator var10 = _bso.m_61148_().entrySet().iterator();

         while(var10.hasNext()) {
            Entry<Property<?>, Comparable<?>> entry = (Entry)var10.next();
            Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
            if (_property != null && _bs.m_61143_(_property) != null) {
               try {
                  _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
               } catch (Exception var15) {
               }
            }
         }

         BlockEntity _be = world.m_7702_(_bp);
         CompoundTag _bnbt = null;
         if (_be != null) {
            _bnbt = _be.m_187480_();
            _be.m_7651_();
         }

         world.m_7731_(_bp, _bs, 3);
         if (_bnbt != null) {
            _be = world.m_7702_(_bp);
            if (_be != null) {
               try {
                  _be.m_142466_(_bnbt);
               } catch (Exception var14) {
               }
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123744_, x + 0.5D, y + 0.5D, z + 0.5D, 15, 0.25D, 0.25D, 0.25D, 0.1D);
         }
      }

   }
}

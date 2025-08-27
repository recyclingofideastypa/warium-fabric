package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class DirectionUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == CrustyChunksModItems.AIMER.get() && (itemstack.m_41784_().m_128459_("POSX") != 0.0D || itemstack.m_41784_().m_128459_("POSY") != 0.0D || itemstack.m_41784_().m_128459_("POSZ") != 0.0D) && (world.m_8055_(BlockPos.m_274561_(itemstack.m_41784_().m_128459_("POSX"), itemstack.m_41784_().m_128459_("POSY"), itemstack.m_41784_().m_128459_("POSZ"))).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:cannon"))) || world.m_8055_(BlockPos.m_274561_(itemstack.m_41784_().m_128459_("POSX"), itemstack.m_41784_().m_128459_("POSY"), itemstack.m_41784_().m_128459_("POSZ"))).m_60734_() == CrustyChunksModBlocks.AIMER_NODE.get())) {
            AimerProcedureProcedure.execute(world, itemstack.m_41784_().m_128459_("POSX"), itemstack.m_41784_().m_128459_("POSY"), itemstack.m_41784_().m_128459_("POSZ"), entity, itemstack);
         }

      }
   }
}

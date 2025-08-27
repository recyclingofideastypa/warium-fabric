package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.DrillProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.item.HandDrillItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DrillFireScriptProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (0.0D >= itemstack.m_41784_().m_128459_("T") && 2.0D <= itemstack.m_41784_().m_128459_("Fluid")) {
            itemstack.m_41784_().m_128347_("Fluid", itemstack.m_41784_().m_128459_("Fluid") - 2.0D);
            Level projectileLevel = entity.m_9236_();
            if (!projectileLevel.m_5776_()) {
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new DrillProjectileEntity((EntityType)CrustyChunksModEntities.DRILL_PROJECTILE.get(), level);
                     entityToSpawn.m_5602_(shooter);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, 5.0F, 1);
               _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
               _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 1.7F, 0.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }

            if (itemstack.m_41720_() instanceof HandDrillItem) {
               itemstack.m_41784_().m_128359_("geckoAnim", "Fire");
            }

            itemstack.m_41784_().m_128347_("T", 7.0D);
         }

      }
   }
}

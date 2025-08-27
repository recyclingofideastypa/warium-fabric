package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;

public class FragmentDespawnMechanicProcedure {
   public static void execute(Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double var10000;
         if (immediatesourceentity instanceof Projectile) {
            Projectile _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.m_20184_().m_82553_();
         } else {
            var10000 = 0.0D;
         }

         if (var10000 < 0.75D && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}

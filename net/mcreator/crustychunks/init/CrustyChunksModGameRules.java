package net.mcreator.crustychunks.init;

import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.BooleanValue;
import net.minecraft.world.level.GameRules.Category;
import net.minecraft.world.level.GameRules.IntegerValue;
import net.minecraft.world.level.GameRules.Key;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class CrustyChunksModGameRules {
   public static final Key<IntegerValue> ENRICHMENT_TIME;
   public static final Key<BooleanValue> ALLOW_IMPACT_FUZE;
   public static final Key<BooleanValue> STRATEGIC_WEAPONS;
   public static final Key<BooleanValue> APOCALYPSE_MODE;
   public static final Key<IntegerValue> BULLET_DAMAGE_MULTIPLIER;
   public static final Key<BooleanValue> WARIUM_APOCALYPSE_DYNAMIC_PRODUCTION;

   static {
      ENRICHMENT_TIME = GameRules.m_46189_("enrichmentTime", Category.MISC, IntegerValue.m_46312_(800));
      ALLOW_IMPACT_FUZE = GameRules.m_46189_("allowImpactFuze", Category.PLAYER, BooleanValue.m_46250_(true));
      STRATEGIC_WEAPONS = GameRules.m_46189_("strategicWeapons", Category.MISC, BooleanValue.m_46250_(true));
      APOCALYPSE_MODE = GameRules.m_46189_("apocalypseMode", Category.PLAYER, BooleanValue.m_46250_(false));
      BULLET_DAMAGE_MULTIPLIER = GameRules.m_46189_("bulletDamageMultiplier", Category.PLAYER, IntegerValue.m_46312_(1));
      WARIUM_APOCALYPSE_DYNAMIC_PRODUCTION = GameRules.m_46189_("wariumApocalypseDynamicProduction", Category.MOBS, BooleanValue.m_46250_(true));
   }
}

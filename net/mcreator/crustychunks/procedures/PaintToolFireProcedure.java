package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Locale;
import java.util.Map.Entry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class PaintToolFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
      String BlockType = "";
      String result = "";
      if (1.0D <= itemstack.m_41784_().m_128459_("Fluid")) {
         BlockPos _bp;
         BlockState _bs;
         BlockState _bso;
         UnmodifiableIterator var13;
         Entry entry;
         Property _property;
         ServerLevel _level;
         Level _level;
         BlockEntity _be;
         CompoundTag _bnbt;
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:steel_armor_blocks")))) {
            if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("slab")) {
               BlockType = "_slab";
            } else if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("optic")) {
               BlockType = "_optic";
            } else if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("stairs")) {
               BlockType = "_stairs";
            } else if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("trapdoor")) {
               BlockType = "_trapdoor";
            } else {
               BlockType = "";
            }

            if (!itemstack.m_41784_().m_128461_("Color").equals("") && !itemstack.m_41784_().m_128461_("Color").equals("none") && !itemstack.m_41784_().m_128461_("Color").equals("remove")) {
               String var10000 = itemstack.m_41784_().m_128461_("Color");
               result = "crusty_chunks:" + var10000 + "_armor" + BlockType;
            }

            if (itemstack.m_41784_().m_128461_("Color").equals("remove")) {
               if (BlockType.equals("_optic")) {
                  result = "crusty_chunks:steel_optic";
               } else {
                  result = "crusty_chunks:steel_plating" + BlockType;
               }
            }

            if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(result.toLowerCase(Locale.ENGLISH))) != Blocks.f_50016_) {
               _bp = BlockPos.m_274561_(x, y, z);
               _bs = ((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation(result.toLowerCase(Locale.ENGLISH)))).m_49966_();
               _bso = world.m_8055_(_bp);
               var13 = _bso.m_61148_().entrySet().iterator();

               while(var13.hasNext()) {
                  entry = (Entry)var13.next();
                  _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                  if (_property != null && _bs.m_61143_(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                     } catch (Exception var20) {
                     }
                  }
               }

               _be = world.m_7702_(_bp);
               _bnbt = null;
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
                     } catch (Exception var19) {
                     }
                  }
               }

               itemstack.m_41784_().m_128347_("Fluid", itemstack.m_41784_().m_128459_("Fluid") - 1.0D);
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123759_, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.3D, 0.3D, 0.3D, 0.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.BLOCKS, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 1.0D));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.BLOCKS, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 1.0D), false);
                  }
               }
            }
         }

         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:aluminum_armor_blocks"))) && !ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("_dark_gray")) {
            if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("slab_wing")) {
               BlockType = "slab_wing";
            } else if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("crusty_chunks:full_armor")))) {
               BlockType = "_plating";
            } else if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("plating_slab")) {
               BlockType = "_plating_slab";
            } else if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("side_panel")) {
               BlockType = "_side_panel";
            } else if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("stairs")) {
               BlockType = "_plating_stairs";
            } else if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("trapdoor")) {
               BlockType = "_plating_trapdoor";
            } else if (ForgeRegistries.BLOCKS.getKey(world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_()).toString().contains("ac_barrel")) {
               BlockType = "_ac_barrel";
            } else {
               BlockType = "";
            }

            if (!itemstack.m_41784_().m_128461_("Color").equals("") && !itemstack.m_41784_().m_128461_("Color").equals("none")) {
               if (!BlockType.equals("slab_wing")) {
                  if (itemstack.m_41784_().m_128461_("Color").equals("remove")) {
                     result = "crusty_chunks:aluminum" + BlockType;
                     itemstack.m_41784_().m_128347_("Fluid", itemstack.m_41784_().m_128459_("Fluid") - 1.0D);
                  } else {
                     result = "crusty_chunks:aluminum" + BlockType + "_" + itemstack.m_41784_().m_128461_("Color");
                     itemstack.m_41784_().m_128347_("Fluid", itemstack.m_41784_().m_128459_("Fluid") - 1.0D);
                  }
               } else if (itemstack.m_41784_().m_128461_("Color").equals("remove")) {
                  result = "valkyrien_warium:" + BlockType;
               } else {
                  result = "valkyrien_warium:" + BlockType + "_" + itemstack.m_41784_().m_128461_("Color");
               }

               if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(result.toLowerCase(Locale.ENGLISH))) != Blocks.f_50016_) {
                  _bp = BlockPos.m_274561_(x, y, z);
                  _bs = ((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation(result.toLowerCase(Locale.ENGLISH)))).m_49966_();
                  _bso = world.m_8055_(_bp);
                  var13 = _bso.m_61148_().entrySet().iterator();

                  while(var13.hasNext()) {
                     entry = (Entry)var13.next();
                     _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                     if (_property != null && _bs.m_61143_(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                        } catch (Exception var18) {
                        }
                     }
                  }

                  _be = world.m_7702_(_bp);
                  _bnbt = null;
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
                        } catch (Exception var17) {
                        }
                     }
                  }

                  itemstack.m_41784_().m_128347_("Fluid", itemstack.m_41784_().m_128459_("Fluid") - 1.0D);
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123759_, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.3D, 0.3D, 0.3D, 0.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.BLOCKS, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 1.0D));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.BLOCKS, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7D, 1.0D), false);
                     }
                  }
               }
            }
         }
      }

   }
}

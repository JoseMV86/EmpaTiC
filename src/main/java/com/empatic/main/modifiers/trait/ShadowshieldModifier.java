package com.empatic.main.modifiers.trait;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.DurabilityShieldModifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nullable;

//Unused. Was going to be Shadow Steel's modifier
public class ShadowshieldModifier extends DurabilityShieldModifier {
  public ShadowshieldModifier() {
    super(0x665d78);
  }

  @Override
  protected int getShieldCapacity(IModifierToolStack tool, int level) {
    return (int)(level * 55 * tool.getModifier(ToolStats.DURABILITY));
  }

  @Override
  public int getPriority() {
    // higher than stoneshield, to ensure this is removed first
    return 185;
  }

  @Override
  public void onInventoryTick(IModifierToolStack tool, int level, World world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
    if (!world.isRemote && world.getGameTime() % 40 == 0 && holder.getActiveItemStack() != stack) {
      if (holder.getEntityWorld().getDimensionKey().equals("minecraft:the_end")) {
        addShield(tool, level, 1);
      } else {
        int light = holder.getEntityWorld().getLightFor(LightType.BLOCK, holder.getPosition());
        int skylight = holder.getEntityWorld().getLightFor(LightType.SKY, holder.getPosition()) - world.getSkylightSubtracted();
        if (Math.max(light, skylight) < 6) {
          addShield(tool, level, 1);
        }
      }
    }
  }

  /* Display */

  @Nullable
  @Override
  public Boolean showDurabilityBar(IModifierToolStack tool, int level) {
    return getShield(tool) > 0 ? true : null;
  }

  @Override
  public int getDurabilityRGB(IModifierToolStack tool, int level) {
    if (getShield(tool) > 0) {
      return 0xb52df7;
    }
    return -1;
  }
}

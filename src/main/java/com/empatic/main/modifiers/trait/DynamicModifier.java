package com.empatic.main.modifiers.trait;

import com.empatic.main.modifiers.template.EnergyModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import net.minecraft.world.item.ItemStack;

public class DynamicModifier extends EnergyModifier {
  private double prevX = 0, prevZ = 0;
  private boolean initial = false;
  @Override
  protected int getEnergyCapacity(IToolStackView tool, int level) {
    return (int)(level * 30);
  }

  @Override
  public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
    if ((initial) && world.isClientSide() && world.getGameTime() % 10 == 0 && (Math.pow(holder.getX() - prevX, 2) + Math.pow(holder.getZ() - prevZ, 2) > 0.05)) {
      addEnergy(tool, level, 1);
    } else {initial = true;}
    prevX = holder.getX(); prevZ = holder.getZ();
  }

  @Override
  public void onBreakSpeed(IToolStackView tool, int level, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    if (!isEffective || getEnergy(tool) < 1) {
      return;
    }
    event.setNewSpeed(event.getNewSpeed() * 1.09f * level);
  }

  @Override
  public void afterBlockBreak(IToolStackView tool, int level, ToolHarvestContext context) {
    if (getEnergy(tool) > 0) {
      addEnergy(tool, level, -1);
    }
  }

  @Override
  public int getEnergy(IToolStackView tool) {
    return super.getEnergy(tool);
  }
}

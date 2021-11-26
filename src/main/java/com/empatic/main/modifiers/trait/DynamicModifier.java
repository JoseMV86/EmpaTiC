package com.empatic.main.modifiers.trait;

import com.empatic.main.modifiers.template.EnergyModifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class DynamicModifier extends EnergyModifier {
  public DynamicModifier() {
    super(0x3f3f3f);
  }
  private double prevX = 0, prevZ = 0;
  private boolean initial = false;
  @Override
  protected int getEnergyCapacity(IModifierToolStack tool, int level) {
    return (int)(level * 30);
  }

  @Override
  public void onInventoryTick(IModifierToolStack tool, int level, World world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
    if ((initial) && !world.isRemote && world.getGameTime() % 10 == 0 && (Math.pow(holder.getPosX() - prevX, 2) + Math.pow(holder.getPosZ() - prevZ, 2) > 0.06)) {
      addEnergy(tool, level, 1);
    } else {initial = true;}
    prevX = holder.getPosX(); prevZ = holder.getPosZ();
  }

  @Override
  public void onBreakSpeed(IModifierToolStack tool, int level, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    if (!isEffective || getEnergy(tool) < 1) {
      return;
    }
    event.setNewSpeed(event.getNewSpeed() * 1.09f * level);
  }

  @Override
  public void afterBlockBreak(IModifierToolStack tool, int level, ToolHarvestContext context) {
    if (getEnergy(tool) > 0) {
      addEnergy(tool, level, -1);
    }
  }

  @Override
  public int getEnergy(IModifierToolStack tool) {
    return super.getEnergy(tool);
  }
}

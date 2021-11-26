package com.empatic.main.modifiers.trait;

import com.empatic.main.modifiers.template.EnergyModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class TornApartModifier extends EnergyModifier {
  public TornApartModifier() {
    super(0x766c64);
  }

  @Override
  protected int getEnergyCapacity(IModifierToolStack tool, int level) {
    return (int)(6);
  }

  @Override
  public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context, float baseDamage, float damage) {
    if(getEnergy(tool) == 6) {
      damage = damage + 3*level;
      addEnergy(tool, level, -6); //reset counter
    } else {addEnergy(tool, level, 1);}
    return damage;
  }

  @Override
  public int getEnergy(IModifierToolStack tool) {
    return super.getEnergy(tool);
  }
}

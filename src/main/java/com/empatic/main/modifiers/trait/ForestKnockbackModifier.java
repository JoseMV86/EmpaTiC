package com.empatic.main.modifiers.trait;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import java.util.ArrayList;

//Ironwood's knockback
public class ForestKnockbackModifier extends Modifier {
  public ForestKnockbackModifier() {
    super(0x7a966f);
  }

  @Override
  public float beforeEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseKnockback, float knockback) {
    ArrayList<ModifierEntry> modifiers = new ArrayList<ModifierEntry>(tool.getModifiers().getModifiers());
    ForestEnergyModifier comparer = new ForestEnergyModifier();
    for (ModifierEntry modifier:modifiers) { //We KNOW there's a Forestenergy there (unless you hack something I guess)
      if(modifier.getModifier().getClass().equals(comparer.getClass())) {
        comparer = (ForestEnergyModifier) modifier.getModifier();
      }
    }
    if (comparer.getEnergy(tool) > 0) {
      comparer.addEnergy(tool, level, -1);
      return knockback + 0.25f * level;
    }
    return knockback;
  }

}

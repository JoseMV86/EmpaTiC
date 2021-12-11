package com.empatic.main.modifiers.trait;

import com.empatic.main.modifiers.CompatModifiers;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;


//Ironwood's knockback
public class ForestKnockbackModifier extends Modifier {
  public ForestKnockbackModifier() {
    super(0x7a966f);
  }

  @Override
  public float beforeEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseKnockback, float knockback) {
    ForestEnergyModifier comparer = CompatModifiers.FORESTENERGY.get();
    if (comparer.getEnergy(tool) > 0) {
      comparer.addEnergy(tool, level, -1);
      return knockback + 0.4f * level;
    }
    return knockback;
  }

}

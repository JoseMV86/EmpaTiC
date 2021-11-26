package com.empatic.main.modifiers.trait;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import java.util.ArrayList;

public class FireproofModifier extends Modifier {
  public FireproofModifier() {
    super(0x5d2e19);
  }

  @Override
  public float beforeEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseKnockback, float knockback) {
    if (context.getTarget().isBurning()) {
      return knockback + 0.3f * level;
    }
    return knockback;
  }

}

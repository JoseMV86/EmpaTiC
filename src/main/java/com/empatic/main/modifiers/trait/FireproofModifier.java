package com.empatic.main.modifiers.trait;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.ArrayList;

public class FireproofModifier extends Modifier {

  @Override
  public float beforeEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damage, float baseKnockback, float knockback) {
    if (context.getTarget().isOnFire()) {
      return knockback + 0.3f * level;
    }
    return knockback;
  }

}

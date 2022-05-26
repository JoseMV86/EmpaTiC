package com.empatic.main.modifiers.trait;

import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class UnderbornModifier extends Modifier {

  private static final int SEA_LEVEL = 96; //Increased by 32 since 1.18.2 needs to get a port
  private static final float BOOST_AT_0 = 0.1f;

   @Override
   public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
    //literally just dwarven's formula
    float factor = Math.max(1f, (SEA_LEVEL - (float) context.getTarget().getY()) * level * (BOOST_AT_0 / SEA_LEVEL) + 1);
    if (factor > 1f) {
      damage = damage*factor;
    }
    return damage;
  }
}
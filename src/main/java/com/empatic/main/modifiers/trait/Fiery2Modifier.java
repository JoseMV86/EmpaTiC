package com.empatic.main.modifiers.trait;

import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.IncrementalModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class Fiery2Modifier extends IncrementalModifier {
  //Just like Bronze and Tinkers' Bronze, the modifiers have slightly different properties
  public Fiery2Modifier() {
    super(0xAB290A);
  }

  @Override
  public float beforeEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseKnockback, float knockback) {
    // vanilla hack: apply fire so the entity drops the proper items on instant kill
    LivingEntity target = context.getLivingTarget();
    if (target != null && !target.isBurning()) {
      target.setFire(1);
    }
    return knockback;
  }

  @Override
  public void failedEntityHit(IModifierToolStack tool, int level, ToolAttackContext context) {
    // conclusion of vanilla hack: we don't want the target on fire if we did not hit them
    LivingEntity target = context.getLivingTarget();
    if (target != null && target.isBurning()) {
      target.extinguish();
    }
  }

  @Override
  public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damageDealt) {
    LivingEntity target = context.getLivingTarget();
    if (target != null) {
      target.setFire(Math.round(getScaledLevel(tool, level) * (3 + RANDOM.nextInt(5))));
    }
    return 0;
  }
}

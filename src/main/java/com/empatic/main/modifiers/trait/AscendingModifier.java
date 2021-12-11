package com.empatic.main.modifiers.trait;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;


public class AscendingModifier extends Modifier {
  public AscendingModifier() {
    super(0xe8f0d4);
  }

  @Override
  public float beforeEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseKnockback, float knockback) {
    if (RANDOM.nextInt(5) == 0) {
      LivingEntity target = context.getLivingTarget();
      if (target != null) {
        target.addPotionEffect(new EffectInstance(Effects.LEVITATION, 100+level*20, level-1));
        target.addPotionEffect(new EffectInstance(Effects.GLOWING, 100+level*20, 0));
      }
      return knockback + 0.5f;
    }
    return knockback;
  }

}

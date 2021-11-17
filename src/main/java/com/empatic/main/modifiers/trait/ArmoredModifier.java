package com.empatic.main.modifiers.trait;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class ArmoredModifier extends Modifier {
  public ArmoredModifier() {
    super(0xc4d6ae);
  }

  @Override
  public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damageDealt) {
    LivingEntity attacker = context.getAttacker();
    float chance = (20 - Math.max(0, 20 - attacker.getHealth()))/20; //1 at max health
    if (RANDOM.nextFloat() > chance) {
      context.getAttacker().addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20 * (2 + (RANDOM.nextInt(level * 2 + 1))), 0));
    }
    return 0;
  }
}

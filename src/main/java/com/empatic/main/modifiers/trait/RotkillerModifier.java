package com.empatic.main.modifiers.trait;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import quek.undergarden.registry.UGTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class RotkillerModifier extends Modifier {


	public RotkillerModifier() {
		super(0xd76559);
	}

	@Override
  	public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context, float baseDamage, float damage) {
		if (context.getTarget().getType().isContained(UGTags.Entities.ROTSPAWN)) {
			return damage * (1.0f + ((float) level) / 4);
		}
		return damage;
  	}
}

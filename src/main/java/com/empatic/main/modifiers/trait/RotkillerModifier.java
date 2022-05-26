package com.empatic.main.modifiers.trait;

import quek.undergarden.registry.UGTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class RotkillerModifier extends Modifier {

	@Override
  	public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
		if (context.getTarget().getType().is(UGTags.Entities.ROTSPAWN)) {
			return damage * (1.0f + ((float) level) / 4);
		}
		return damage;
  	}
}

package com.empatic.main.modifiers.trait;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class FrostyModifier extends Modifier {


	public FrostyModifier() {
		super(0x8aadcf);
	}

	@Override
	public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damageDealt) {
		LivingEntity target = context.getLivingTarget();
		if (target != null) {
			target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 80*level, Math.max(2,level)));
		}
		return 0;
	}
}

package com.empatic.main.modifiers.trait;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class FrostyModifier extends Modifier {

	@Override
	public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
		LivingEntity target = context.getLivingTarget();
		if (target != null) {
			target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80*level, level-1));
		}
		return 0;
	}
}

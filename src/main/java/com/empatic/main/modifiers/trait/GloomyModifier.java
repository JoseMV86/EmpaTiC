package com.empatic.main.modifiers.trait;


import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class GloomyModifier extends Modifier {
	
	@Override
  	public void onBreakSpeed(IToolStackView tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    		if (!isEffective) {
      			return;
    		}
		BlockState state = event.getState();
		if(state != null && state.getBlock().getRegistryName().getNamespace().equals("undergarden")) {
			event.setNewSpeed(event.getOriginalSpeed() * (1f +((float) level)/3));
		}
  	}

	@Override
  	public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
		if(context.getTarget().getType().getRegistryName().getNamespace().equals("undergarden") && context.getTarget().canChangeDimensions()) {
			damage = damage * (1f + ((float) level)/3);
		}
		return damage;
  	}
}

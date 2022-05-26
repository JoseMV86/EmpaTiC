package com.empatic.main.modifiers.trait;


import net.minecraft.core.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import vazkii.botania.api.mana.ManaItemHandler;

public class ManaInfusedModifier extends Modifier {
	@Override
  	public void onBreakSpeed(IToolStackView tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    		if (!isEffective) {
      			return;
    		}
		Player player = (Player) event.getEntity();
    		if (ManaItemHandler.instance().requestManaExactForTool(new ItemStack(tool.getItem()), player, 120/level, false)) {
			ManaItemHandler.instance().requestManaExactForTool(new ItemStack(tool.getItem()), player, 120/level, true);
      			event.setNewSpeed(event.getNewSpeed() + 2.5f * tool.getMultiplier(ToolStats.MINING_SPEED));
    		}
  	}

	@Override
  	public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
    		if (context.isFullyCharged()) {
				Player player = (Player) context.getAttacker();
			if (ManaItemHandler.instance().requestManaExactForTool(new ItemStack(tool.getItem()), player, 180/level, false)) {
				ManaItemHandler.instance().requestManaExactForTool(new ItemStack(tool.getItem()), player, 180/level, true);
      				damage += 1f * tool.getMultiplier(ToolStats.ATTACK_DAMAGE);
    			}
    		}
    		return damage;
  	}
}

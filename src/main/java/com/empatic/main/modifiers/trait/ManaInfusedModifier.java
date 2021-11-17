package com.empatic.main.modifiers.trait;


import net.minecraft.util.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.ToolDefinition;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;
import vazkii.botania.api.mana.ManaItemHandler;

public class ManaInfusedModifier extends Modifier {
	
	
	public ManaInfusedModifier() {
		super(0x4dff60);
	}
	
	@Override
  	public void onBreakSpeed(IModifierToolStack tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    		if (!isEffective) {
      			return;
    		}
		PlayerEntity player = (PlayerEntity) event.getEntity();
    		if (ManaItemHandler.instance().requestManaExactForTool(new ItemStack(tool.getItem()), player, 120/level, false)) {
			ManaItemHandler.instance().requestManaExactForTool(new ItemStack(tool.getItem()), player, 120/level, true);
      			event.setNewSpeed(event.getNewSpeed() + 2.5f * tool.getModifier(ToolStats.MINING_SPEED));
    		}
  	}

	@Override
  	public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context, float baseDamage, float damage) {
    		if (context.isFullyCharged()) {
			PlayerEntity player = (PlayerEntity) context.getAttacker();
			if (ManaItemHandler.instance().requestManaExactForTool(new ItemStack(tool.getItem()), player, 180/level, false)) {
				ManaItemHandler.instance().requestManaExactForTool(new ItemStack(tool.getItem()), player, 180/level, true);
      				damage += 1f * tool.getModifier(ToolStats.ATTACK_DAMAGE);
    			}
    		}
    		return damage;
  	}
}

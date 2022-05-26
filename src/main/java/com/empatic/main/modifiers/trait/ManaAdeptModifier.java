package com.empatic.main.modifiers.trait;

import java.lang.Math;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import vazkii.botania.api.mana.ManaItemHandler;

public class ManaAdeptModifier extends Modifier{
	
	@Override 
	public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
		if (!world.isClientSide() && world.getGameTime() % 20 == 0 && holder instanceof Player && stack.getDamageValue() > 0 && holder.getUseItem() != stack
				&& ManaItemHandler.instance().requestManaExactForTool(stack, (Player) holder, (int)(512/(Math.pow(2,level-1))), true)) {
			stack.setDamageValue(stack.getDamageValue() - 1);
		}
	}
}

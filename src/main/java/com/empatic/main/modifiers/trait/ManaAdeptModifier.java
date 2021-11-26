package com.empatic.main.modifiers.trait;

import java.lang.Math;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import vazkii.botania.api.mana.ManaItemHandler;

public class ManaAdeptModifier extends Modifier{
	
	public ManaAdeptModifier() {
		super(0x36d6c6);
	}
	
	@Override 
	public void onInventoryTick(IModifierToolStack tool, int level, World world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
		if (!world.isRemote && world.getGameTime() % 20 == 0 && holder instanceof PlayerEntity && stack.getDamage() > 0 && holder.getActiveItemStack() != stack
				&& ManaItemHandler.instance().requestManaExactForTool(stack, (PlayerEntity) holder, (int)(512/(Math.pow(2,level-1))), true)) {
			stack.setDamage(stack.getDamage() - 1);
		}
	}
}

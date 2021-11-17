package com.empatic.main.modifiers.trait;

import java.lang.Math;

import net.minecraft.entity.SpawnReason;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.RegistryEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import vazkii.botania.common.entity.EntityPixie;


public class PixieModifier extends Modifier {
	
	public PixieModifier() {
		super(0xff5787);
	}
	

	@Override
  	public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damageDealt) {
			if (context.isFullyCharged() && damageDealt > 0) {
				if (RANDOM.nextInt(4) == 0) {
					PlayerEntity player = (PlayerEntity) context.getAttacker();
					EntityPixie pixie = new EntityPixie(player.world);
					pixie.setPosition(player.getPosX(), player.getPosY() + 2, player.getPosZ());
					float dmg = 2 + level * 0.5f;
					pixie.setProps(context.getLivingTarget(), player, 0, dmg);
					pixie.onInitialSpawn((ServerWorld) player.world, player.world.getDifficultyForLocation(pixie.getPosition()),
							SpawnReason.EVENT, null, null);
					player.world.addEntity(pixie);
				}
			}
			return 0;
	}
}

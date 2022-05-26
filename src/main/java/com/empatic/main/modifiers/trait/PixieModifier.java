package com.empatic.main.modifiers.trait;

import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ServerLevelAccessor;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import vazkii.botania.common.entity.EntityPixie;


public class PixieModifier extends Modifier {

	@Override
  	public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
			if (context.isFullyCharged() && damageDealt > 0) {
				if (RANDOM.nextInt(4) == 0) {
					Player player = (Player) context.getAttacker();
					EntityPixie pixie = new EntityPixie(player.level);
					pixie.setPos(player.getX(), player.getY() + 2, player.getZ());
					float dmg = 3f * level;
					pixie.setProps(context.getLivingTarget(), player, 0, dmg);
					pixie.finalizeSpawn((ServerLevelAccessor) player.level, player.level.getCurrentDifficultyAt(pixie.blockPosition()),
							MobSpawnType.EVENT, null, null);
					player.level.addFreshEntity(pixie);
				}
			}
			return 0;
	}
}

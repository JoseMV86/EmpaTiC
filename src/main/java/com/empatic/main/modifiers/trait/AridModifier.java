package com.empatic.main.modifiers.trait;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class AridModifier extends Modifier {

  @Override
  public int getPriority() {
    return 125; // run before trait boosts such as dwarven
  }

  @Override
  public void onBreakSpeed(IToolStackView tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    BlockState block = event.getState();
    if (isEffective && (block.is(Tags.Blocks.SANDSTONE) || block.is(Tags.Blocks.SAND))) {
      event.setNewSpeed(event.getNewSpeed() + (level * 4 * tool.getMultiplier(ToolStats.MINING_SPEED)));
    }
  }
}
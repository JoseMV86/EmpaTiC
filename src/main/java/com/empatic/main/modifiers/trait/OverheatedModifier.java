package com.empatic.main.modifiers.trait;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class OverheatedModifier extends Modifier {
  public OverheatedModifier() {
    super(0xba9d7b);
  }

  @Override
  public int getPriority() {
    return 125; // run before trait boosts such as dwarven
  }

  @Override
  public void onBreakSpeed(IModifierToolStack tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    Block block = event.getState().getBlock();
    if (isEffective && RANDOM.nextInt(20) < 3*level) {
      event.setNewSpeed(event.getNewSpeed()*2f);
    }
  }
}
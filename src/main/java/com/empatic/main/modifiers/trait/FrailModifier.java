package com.empatic.main.modifiers.trait;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class FrailModifier extends Modifier {
  @Override
  public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
    ToolStats.DURABILITY.multiply(builder, 1 - (level * 0.08f));
    ToolStats.MINING_SPEED.multiply(builder, 1 + (level * 0.12f));
  }
}

package com.empatic.main.modifiers.trait;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.Tags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.library.utils.TooltipFlag;

import java.util.List;

public class AridModifier extends Modifier {
  public AridModifier() {
    super(0xD1BA8A);
  }

  @Override
  public int getPriority() {
    return 125; // run before trait boosts such as dwarven
  }

  @Override
  public void onBreakSpeed(IModifierToolStack tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    Block block = event.getState().getBlock();
    if (isEffective && (block.getTags().contains(new ResourceLocation("forge:sandstone")) || block.getTags().contains(new ResourceLocation("forge:sand")))) {
      event.setNewSpeed(event.getNewSpeed() + (level * 4 * tool.getModifier(ToolStats.MINING_SPEED)));
    }
  }
}
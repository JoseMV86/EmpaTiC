package com.empatic.main.modifiers.trait;

import com.empatic.main.modifiers.CompatModifiers;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Direction;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;


//Steeleaf's mining speed
public class ForestSpeedModifier extends Modifier {
  public ForestSpeedModifier() {
    super(0x52873a);
  }

  @Override
  public void onBreakSpeed(IModifierToolStack tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
      ForestEnergyModifier comparer = CompatModifiers.FORESTENERGY.get();
      if (!isEffective || comparer.getEnergy(tool) < 1) {
        return;
      }
      event.setNewSpeed(event.getNewSpeed() * 1.1f * level);
  }
  @Override
  public void afterBlockBreak(IModifierToolStack tool, int level, ToolHarvestContext context) {
      ForestEnergyModifier comparer = CompatModifiers.FORESTENERGY.get();
      if (comparer.getEnergy(tool) > 0 && !ItemTags.LEAVES.contains(context.getState().getBlock().asItem())) {
        comparer.addEnergy(tool, level, -1);
      }
  }
}

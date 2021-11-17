package com.empatic.main.modifiers.trait;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.Direction;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;

import java.util.ArrayList;

//Steeleaf's mining speed
public class ForestSpeedModifier extends Modifier {
  ForestEnergyModifier comparer = new ForestEnergyModifier();
  public ForestSpeedModifier() {
    super(0x52873a);
  }

  @Override
  public void onBreakSpeed(IModifierToolStack tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
      ArrayList<ModifierEntry> modifiers = new ArrayList<>(tool.getModifiers().getModifiers());
      for (ModifierEntry modifier : modifiers) { //We KNOW there's a Forestenergy there (unless you hack something I guess)
        if (modifier.getModifier().getClass().equals(comparer.getClass())) {
          comparer = (ForestEnergyModifier) modifier.getModifier();
        }
      }
    if (!isEffective || comparer.getEnergy(tool) < 1) {
      return;
    }
    event.setNewSpeed(event.getNewSpeed() * 1.1f * level);
  }
  @Override
  public void afterBlockBreak(IModifierToolStack tool, int level, ToolHarvestContext context) {
      ArrayList<ModifierEntry> modifiers = new ArrayList<>(tool.getModifiers().getModifiers());
      for (ModifierEntry modifier : modifiers) { //We KNOW there's a Forestenergy there (unless you hack something I guess)
        if (modifier.getModifier().getClass().equals(comparer.getClass())) {
          comparer = (ForestEnergyModifier) modifier.getModifier();
        }
      }
    if (comparer.getEnergy(tool) > 0 && !ItemTags.LEAVES.contains(context.getState().getBlock().asItem())) {
      comparer.addEnergy(tool, level, -1);
    }
  }

}

package com.empatic.main.modifiers.trait;

import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.tags.ItemTags;
import com.empatic.main.modifiers.template.EnergyModifier;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

//Previously copied from Stoneshield, ended up being more unique than I thought. Worth it so that Ironwood/Steeleaf aren't bland
public class ForestEnergyModifier extends EnergyModifier {
  public ForestEnergyModifier() {
    super(0x5f513e);
  }

  @Override
  protected int getEnergyCapacity(IModifierToolStack tool, int level) {
    return (int)(level * 100);
  }


  @Override
  public void afterBlockBreak(IModifierToolStack tool, int level, ToolHarvestContext context) {
    int addedShield = 0;
      if (ItemTags.LEAVES.contains(context.getState().getBlock().asItem())) {
          addedShield += 1;
    }
    // if we found any leaf, add shield
    if (addedShield > 0) {
      // 1+level energy per leaf eaten
      addEnergy(tool, level, addedShield * (1+level));
    }
  }
  @Override
  public int getEnergy(IModifierToolStack tool) {
    return super.getEnergy(tool);
  }
}

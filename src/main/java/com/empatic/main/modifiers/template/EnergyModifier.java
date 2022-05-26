package com.empatic.main.modifiers.template;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.recipe.tinkerstation.ValidatedResult;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

public abstract class EnergyModifier extends Modifier {

  @Override
  public Component getDisplayName(IToolStackView tool, int level) {
    return getDisplayName(level).copy()
                                .append(": " + getEnergy(tool) + " / " + getEnergyCapacity(tool, level));
  }


  /* Tool building */

  @Override
  public ValidatedResult validate(IToolStackView tool, int level) {
    // clear excess energy
    if (level > 0) {
      int cap = getEnergyCapacity(tool, level);
      if (getEnergy(tool) > cap) {
        setEnergy(tool.getPersistentData(), cap);
      }
    }
    return ValidatedResult.PASS;
  }

  @Override
  public void onRemoved(IToolStackView tool) {
    // remove all energy on removal
    tool.getPersistentData().remove(getEnergyKey());
  }

  /* Helpers */

  /** Gets the key to use for the energy */
  protected ResourceLocation getEnergyKey() {
    return getId();
  }

  /** Gets the current energy amount */
  protected int getEnergy(IToolStackView tool) {
    return tool.getPersistentData().getInt(getEnergyKey());
  }

  /** Gets the capacity of the energy for the given tool */
  protected abstract int getEnergyCapacity(IToolStackView tool, int level);

  /**
   * Sets the energy, bypassing the capacity
   * @param persistentData  Persistent data
   * @param amount          Amount to set
   */
  protected void setEnergy(ModDataNBT persistentData, int amount) {
    persistentData.putInt(getEnergyKey(), Math.max(amount, 0));
  }

  /**
   * Sets the energy on a tool
   */
  protected void setEnergy(IToolStackView tool, int level, int amount) {
    setEnergy(tool.getPersistentData(), Math.min(amount, getEnergyCapacity(tool, level)));
  }

  /** Adds the given amount to the current shield */
  public void addEnergy(IToolStackView tool, int level, int amount) {
    setEnergy(tool, level, amount + getEnergy(tool));
  }
}

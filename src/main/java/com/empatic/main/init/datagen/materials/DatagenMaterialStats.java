package com.empatic.main.init.datagen.materials;

import com.empatic.main.init.materials.CompatIDs;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

import static net.minecraft.world.item.Tiers.DIAMOND;

public class DatagenMaterialStats extends AbstractMaterialStatsDataProvider {
  public DatagenMaterialStats(PackOutput packOutput, AbstractMaterialDataProvider materials) {
    super(packOutput, materials);
  }

  @Override
  public String getName() {
    return "EmpaTiC Material Stats";
  }

  @Override
  protected void addMaterialStats() {
    addMeleeHarvest();
    addRanged();
    addArmor();
  }

  private void addMeleeHarvest() {
    // head order is durability, mining speed, mining level, damage

    // EmpaTiC
    addMaterialStats(CompatIDs.milkonstantan,
                     new HeadMaterialStats(580, 7.5f, DIAMOND, 2.25f),
                     HandleMaterialStats.multipliers().durability(0.90f).attackSpeed(1.05f).miningSpeed(1.15f).build(),
                     StatlessMaterialStats.BINDING);

  }

  private void addRanged() {
    // limb order is durability, drawspeed, velocity, accuracy
    // grip order is durability, accuracy, melee

    // EmpaTiC
    addMaterialStats(CompatIDs.milkonstantan,
                     new LimbMaterialStats(580, 0.2f, -0.05f, -0.15f),
                     new GripMaterialStats(-0.10f, 0.1f, 2.25f));

  }

  private void addArmor() {
    // EmpaTiC
    addArmorShieldStats(CompatIDs.milkonstantan, PlatingMaterialStats.builder().durabilityFactor(21).armor(2, 5, 6, 2).toughness(1).knockbackResistance(0.1f), StatlessMaterialStats.MAILLE);

  }
}

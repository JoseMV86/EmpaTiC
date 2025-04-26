package com.empatic.main.init.datagen.materials;

import com.empatic.main.init.materials.CompatIDs;
import com.empatic.main.init.modifiers.CompatModifiers;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;

public class DatagenMaterialTraits extends AbstractMaterialTraitDataProvider {
  public DatagenMaterialTraits(PackOutput packOutput, AbstractMaterialDataProvider materials) {
    super(packOutput, materials);
  }

  @Override
  public String getName() {
    return "EmpaTiC Material Traits";
  }

  @Override
  protected void addMaterialTraits() {
    // EmpaTiC
    addDefaultTraits(CompatIDs.milkonstantan, CompatModifiers.CLEARING);

  }
}

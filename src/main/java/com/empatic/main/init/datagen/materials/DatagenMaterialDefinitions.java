package com.empatic.main.init.datagen.materials;

import com.empatic.main.init.materials.CompatIDs;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class DatagenMaterialDefinitions extends AbstractMaterialDataProvider {
  public DatagenMaterialDefinitions(PackOutput packOutput) {
    super(packOutput);
  }

  @Override
  public @NotNull String getName() {
    return "EmpaTiC Materials";
  }

  @Override
  protected void addMaterials() {
    // EmpaTiC
    addMaterial(CompatIDs.milkonstantan, 3, ORDER_COMPAT + ORDER_HARVEST, false);
  }
}

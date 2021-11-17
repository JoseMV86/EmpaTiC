package com.empatic.main.init;

import com.empatic.main.EmpaTiC;

import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public final class CompatIDs {
  // Own
  public static final MaterialId sandstone = id("sandstone");
  public static final MaterialId milkonstantan = id("milkonstantan");
  public static final MaterialId mdebristone = id("mdebristone");

  // Botania
  public static final MaterialId manasteel = id("manasteel");
  public static final MaterialId elementium = id("elementium");
  public static final MaterialId terrasteel = id("terrasteel");

  // Blue Skies
  public static final MaterialId ventium = id("ventium");
  public static final MaterialId horizonite = id("horizonite");
  public static final MaterialId falsite = id("falsite");

  /**
   * Creates a new material ID
   * @param name  ID name
   * @return  Material ID object
   */
  private static MaterialId id(String name) {
    return new MaterialId(new ResourceLocation(EmpaTiC.MODID, name));
  }
}
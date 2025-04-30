package com.empatic.main.init.datagen;

import com.empatic.main.EmpaTiC;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slimeknights.mantle.recipe.data.IRecipeHelper;

import java.util.function.Consumer;

/**
 * Shared logic for each module's recipe provider
 */
public abstract class BaseEmpaticProvider extends RecipeProvider implements IConditionBuilder, IRecipeHelper {
  public BaseEmpaticProvider(PackOutput generator) {
    super(generator);
    sealEmpaTiCClass(this, "BaseEmpaticProvider", "BaseEmpaticProvider is trivial to recreate and directly extending can lead to addon recipes polluting our namespace.");
  }

  public static void sealEmpaTiCClass(Object self, String base, String solution) {
    String name = self.getClass().getName();
    if (!name.startsWith("com.empatic.")) { //CHANGE THIS IF YOU AREN'T CONTRIBUTING TO EMPATIC
      throw new IllegalStateException(base + " being extended from invalid package " + name + ". " + solution);
    }
  }

  @Override
  protected abstract void buildRecipes(Consumer<FinishedRecipe> consumer);

  @Override
  public String getModId() {
    return EmpaTiC.MODID;
  }
}

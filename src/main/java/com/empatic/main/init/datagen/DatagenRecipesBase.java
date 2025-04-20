package com.empatic.main.init.datagen;

import com.empatic.main.EmpaTiC;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slimeknights.mantle.recipe.data.IRecipeHelper;

import java.util.function.Consumer;

public abstract class DatagenRecipesBase extends RecipeProvider implements IConditionBuilder, IRecipeHelper {

    public DatagenRecipesBase(PackOutput generator) {
        super(generator);
    }

    @Override
    protected abstract void buildRecipes(Consumer<FinishedRecipe> consumer);

    @Override
    public String getModId() {
        return EmpaTiC.MODID;
    }
}

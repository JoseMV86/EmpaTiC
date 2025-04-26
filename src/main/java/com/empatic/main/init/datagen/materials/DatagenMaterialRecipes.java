package com.empatic.main.init.datagen.materials;

import com.empatic.main.init.fluids.EmpaticFluids;
import com.empatic.main.init.materials.CompatIDs;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.recipe.data.ItemNameIngredient;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;

import java.util.function.Consumer;
import java.util.function.Function;

public class DatagenMaterialRecipes extends DatagenMaterialRecipesBase implements IMaterialRecipeHelper {
    public DatagenMaterialRecipes(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        addMaterialItems(consumer);
        addMaterialSmeltery(consumer);
    }

    private void addMaterialItems(Consumer<FinishedRecipe> consumer) {
        String folder = "tools/materials/";
        Consumer<FinishedRecipe> empaticConsumer = withCondition(consumer, modLoaded("empatic"));



        Function<String, ResourceLocation> empaticId = name -> new ResourceLocation("empatic", name);

        materialRecipe(empaticConsumer, CompatIDs.milkonstantan, ItemNameIngredient.from(empaticId.apply("milkonstantan_ingot")),      1, 1, folder + "milkonstantan/ingot");
        materialRecipe(empaticConsumer, CompatIDs.milkonstantan, ItemNameIngredient.from(empaticId.apply("milkonstantan_block")),      9, 1, folder + "milkonstantan/block");
        materialRecipe(empaticConsumer, CompatIDs.milkonstantan, ItemNameIngredient.from(empaticId.apply("milkonstantan_nugget")),      1, 9, folder + "milkonstantan/nugget");

    }

    private void addMaterialSmeltery(Consumer<FinishedRecipe> consumer) {
        String folder = "tools/materials/";
        Consumer<FinishedRecipe> empaticConsumer = withCondition(consumer, modLoaded("empatic"));

        materialMeltingCasting(empaticConsumer, CompatIDs.milkonstantan, EmpaticFluids.moltenMilkonstantan, folder);


    }

}

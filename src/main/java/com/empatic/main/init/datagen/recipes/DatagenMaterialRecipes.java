package com.empatic.main.init.datagen.recipes;

import com.empatic.main.init.blocks.EmpaticBlocks;
import com.empatic.main.init.datagen.BaseEmpaticProvider;
import com.empatic.main.init.fluids.EmpaticFluids;
import com.empatic.main.init.items.EmpaticItems;
import com.empatic.main.init.materials.CompatIDs;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;
import slimeknights.mantle.recipe.data.ItemNameIngredient;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.alloying.AlloyRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;

import java.util.function.Consumer;
import java.util.function.Function;

public class DatagenMaterialRecipes extends BaseEmpaticProvider implements IMaterialRecipeHelper, ISmelteryRecipeHelper {
    public DatagenMaterialRecipes(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //Material parts - building, casting and melting
        addMaterialItems(consumer);
        addMaterialSmeltery(consumer);

        //Casting recipes: items and blocks
        addCastingRecipes(consumer);

        //Melting recipes: items and blocks
        addMeltingRecipes(consumer);

        //Alloy recipes
        addAlloyRecipes(consumer);
    }

    private void addCastingRecipes(Consumer<FinishedRecipe> consumer) {
        // Pure Fluid Recipes
        String folder = "smeltery/casting/";
        String metalFolder = folder + "metal/";

        this.ingotCasting(consumer, EmpaticFluids.moltenMilkonstantan, FluidValues.INGOT, EmpaticItems.MILKONSTANTAN_INGOT.get(), metalFolder + "milkonstantan/ingot");
        this.nuggetCasting(consumer, EmpaticFluids.moltenMilkonstantan,  EmpaticItems.MILKONSTANTAN_NUGGET.get(), metalFolder + "milkonstantan/nugget");
        ItemCastingRecipeBuilder.basinRecipe(EmpaticBlocks.MILKONSTANTAN_BLOCK.get())
                .setFluidAndTime(EmpaticFluids.moltenMilkonstantan, FluidValues.METAL_BLOCK)
                .save(consumer, location(metalFolder + "milkonstantan/block"));

    }

    private void addMeltingRecipes(Consumer<FinishedRecipe> consumer) {
        String folder = "smeltery/melting/";
        String metalFolder = folder + "metal/";
        MeltingRecipeBuilder.melting(Ingredient.of(EmpaticItems.MILKONSTANTAN_INGOT.get()), EmpaticFluids.moltenMilkonstantan, FluidValues.INGOT, 1)
                .save(consumer, location(metalFolder + "milkonstantan/ingot"));
        MeltingRecipeBuilder.melting(Ingredient.of(EmpaticItems.MILKONSTANTAN_NUGGET.get()), EmpaticFluids.moltenMilkonstantan, FluidValues.NUGGET, (float) 1 /3)
                .save(consumer, location(metalFolder + "milkonstantan/nugget"));
        MeltingRecipeBuilder.melting(Ingredient.of(EmpaticBlocks.MILKONSTANTAN_BLOCK_ITEM.get()), EmpaticFluids.moltenMilkonstantan, FluidValues.METAL_BLOCK, 3)
                .save(consumer, location(metalFolder + "milkonstantan/block"));
    }

    private void addAlloyRecipes(Consumer<FinishedRecipe> consumer) {
        String folder = "smeltery/alloys/";

        // milkonstantan
        AlloyRecipeBuilder.alloy(EmpaticFluids.moltenMilkonstantan, FluidValues.INGOT)
                .addInput(TinkerFluids.moltenCopper.ingredient(FluidValues.INGOT))
                .addInput(TinkerFluids.moltenQuartz.ingredient(FluidValues.GEM))
                .addInput(ForgeMod.MILK.get(), FluidType.BUCKET_VOLUME/2)
                .save(consumer, prefix(EmpaticFluids.moltenMilkonstantan, folder));
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

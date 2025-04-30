package com.empatic.main.init.datagen;

import com.empatic.main.EmpaTiC;
import com.empatic.main.init.datagen.fluids.DatagenFluidTags;
import com.empatic.main.init.datagen.materials.DatagenMaterialDefinitions;
import com.empatic.main.init.datagen.materials.DatagenMaterialStats;
import com.empatic.main.init.datagen.materials.DatagenMaterialTraits;
import com.empatic.main.init.datagen.recipes.DatagenMaterialRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = EmpaTiC.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Datagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        boolean server = event.includeServer();

        DatagenMaterialDefinitions materials = new DatagenMaterialDefinitions(packOutput);
        generator.addProvider(server, new DatagenMaterialRecipes(packOutput));
        generator.addProvider(server, materials);
        generator.addProvider(server, new DatagenMaterialStats(packOutput, materials));
        generator.addProvider(server, new DatagenMaterialTraits(packOutput, materials));

        generator.addProvider(server, new DatagenFluidTags(packOutput, lookupProvider, existingFileHelper));
    }
}

package com.empatic.main.init.datagen;

import com.empatic.main.EmpaTiC;
import com.empatic.main.init.datagen.materials.DatagenMaterialDefinitions;
import com.empatic.main.init.datagen.materials.DatagenMaterialRecipes;
import com.empatic.main.init.datagen.materials.DatagenMaterialStats;
import com.empatic.main.init.datagen.materials.DatagenMaterialTraits;
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

        DatagenMaterialDefinitions materials = new DatagenMaterialDefinitions(packOutput);
        generator.addProvider(event.includeServer(), new DatagenMaterialRecipes(packOutput));
        generator.addProvider(event.includeServer(), materials);
        generator.addProvider(event.includeServer(), new DatagenMaterialStats(packOutput, materials));
        generator.addProvider(event.includeServer(), new DatagenMaterialTraits(packOutput, materials));

    }
}

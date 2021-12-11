package com.empatic.main;

import com.empatic.main.blocks.StartupCommon;
import com.empatic.main.init.*;
import com.empatic.main.modifiers.BotaniaModifiers;
import com.empatic.main.modifiers.CompatModifiers;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("empatic")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EmpaTiC
{
	public static final String MODID = "empatic";
	
    	public EmpaTiC() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.register(StartupCommon.class);
        	CompatFluids.FLUIDS.register(modEventBus);
        	CompatBlocks.BLOCKS.register(modEventBus);
        	CompatItems.ITEMS.register(modEventBus);
        	CompatModifiers.MODIFIERS.register(modEventBus);
			if(ModList.get().isLoaded("botania")){
				BotaniaModifiers.MODIFIERS.register(modEventBus);
			}
			if(ModList.get().isLoaded("create")){
				CreateItems.ITEMS.register(modEventBus);
			}
		}
}

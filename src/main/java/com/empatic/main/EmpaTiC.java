package com.empatic.main;

import com.empatic.main.init.blocks.EmpaticBlocks;
import com.empatic.main.init.creative.EmpaticCreative;
import com.empatic.main.init.fluids.EmpaticFluids;
import com.empatic.main.init.items.EmpaticItems;
import com.empatic.main.modifiers.CompatModifiers;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("empatic")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EmpaTiC
{
	public static final String MODID = "empatic";
	
    	public EmpaTiC() {
			IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        	EmpaticFluids.FLUIDS.register(modEventBus);
        	EmpaticBlocks.BLOCKS.register(modEventBus);
			EmpaticBlocks.ITEMS.register(modEventBus);
			EmpaticCreative.CREATIVE_MODE_TABS.register(modEventBus);
        	EmpaticItems.ITEMS.register(modEventBus);
        	CompatModifiers.MODIFIERS.register(modEventBus);
			modEventBus.register(new EmpaticFluids());
			modEventBus.addListener(this::addCreative);
		}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(EmpaticItems.MILKONSTANTAN_INGOT);
			event.accept(EmpaticItems.MILKONSTANTAN_NUGGET);
		}
	}

	public static String makeDescriptionId(String type, String name) {
		return type + "." + MODID + "." + name;
	}
}

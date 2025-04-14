package com.empatic.main.init.creative;

import com.empatic.main.EmpaTiC;
import com.empatic.main.init.blocks.EmpaticBlocks;
import com.empatic.main.init.fluids.EmpaticFluids;
import com.empatic.main.init.items.EmpaticItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EmpaticCreative {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EmpaTiC.MODID);

    public static final RegistryObject<CreativeModeTab> EMPATIC_ITEMS_TAB = CREATIVE_MODE_TABS.register("empatic_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(EmpaticItems.MILKONSTANTAN_NUGGET.get()))
                    .title(Component.translatable("creativetab.empatic_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(EmpaticItems.MILKONSTANTAN_INGOT.get());
                        output.accept(EmpaticBlocks.MILKONSTANTAN_BLOCK_ITEM.get());
                        output.accept(EmpaticItems.MILKONSTANTAN_NUGGET.get());
                        output.accept(EmpaticFluids.moltenMilkonstantan);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

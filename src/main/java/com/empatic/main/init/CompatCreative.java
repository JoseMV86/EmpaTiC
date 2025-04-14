package com.empatic.main.init;

import com.empatic.main.EmpaTiC;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CompatCreative {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EmpaTiC.MODID);

    public static final RegistryObject<CreativeModeTab> EMPATIC_ITEMS_TAB = CREATIVE_MODE_TABS.register("empatic_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CompatItems.MILKONSTANTAN_NUGGET.get()))
                    .title(Component.translatable("empatic.creative.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CompatItems.MILKONSTANTAN_INGOT.get());
                        output.accept(CompatBlocks.MILKONSTANTAN_BLOCK_ITEM.get());
                        output.accept(CompatItems.MILKONSTANTAN_NUGGET.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

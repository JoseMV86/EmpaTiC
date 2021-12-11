package com.empatic.main.init;

import com.empatic.main.EmpaTiC;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.common.TinkerModule;

public class CreateItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EmpaTiC.MODID);

	public static final RegistryObject<Item> HAUNTED_BRASS = ITEMS.register("haunted_brass",
			() -> new Item(new Item.Properties().group(ModList.get().isLoaded("create") ? TinkerModule.TAB_GENERAL : null)));
	public static final RegistryObject<Item> CARAMEL_COMPOSITE = ITEMS.register("caramel_composite",
			() -> new Item(new Item.Properties().group(ModList.get().isLoaded("create") ? TinkerModule.TAB_GENERAL : null)));

}

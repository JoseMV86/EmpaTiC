package com.empatic.main.init;

import com.empatic.main.EmpaTiC;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.common.TinkerModule;

public class CompatItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EmpaTiC.MODID);

	public static final RegistryObject<Item> MILKONSTANTAN_INGOT = ITEMS.register("milkonstantan_ingot",
			() -> new Item(new Item.Properties().tab(TinkerModule.TAB_GENERAL)));
	public static final RegistryObject<Item> MILKONSTANTAN_NUGGET = ITEMS.register("milkonstantan_nugget",
			() -> new Item(new Item.Properties().tab(TinkerModule.TAB_GENERAL)));


}

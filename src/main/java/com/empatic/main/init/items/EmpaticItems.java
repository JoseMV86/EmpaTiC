package com.empatic.main.init.items;

import com.empatic.main.EmpaTiC;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EmpaticItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EmpaTiC.MODID);

	public static final RegistryObject<Item> MILKONSTANTAN_INGOT = ITEMS.register("milkonstantan_ingot",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MILKONSTANTAN_NUGGET = ITEMS.register("milkonstantan_nugget",
			() -> new Item(new Item.Properties()));


}

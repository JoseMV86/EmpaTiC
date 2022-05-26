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
	public static final RegistryObject<Item> MILKONSTANTAN_BUCKET = ITEMS.register("milkonstantan_bucket", 
			() -> new BucketItem(CompatFluids.MILKONSTANTAN,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
	//botania
	public static final RegistryObject<Item> MANASTEEL_BUCKET = ITEMS.register("manasteel_bucket", 
			() -> new BucketItem(CompatFluids.MANASTEEL,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("botania") ? CreativeModeTab.TAB_MISC : null)));
	public static final RegistryObject<Item> ELEMENTIUM_BUCKET = ITEMS.register("elementium_bucket",
			() -> new BucketItem(CompatFluids.ELEMENTIUM,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("botania") ? CreativeModeTab.TAB_MISC : null)));
	public static final RegistryObject<Item> TERRASTEEL_BUCKET = ITEMS.register("terrasteel_bucket", 
			() -> new BucketItem(CompatFluids.TERRASTEEL,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("botania") ? CreativeModeTab.TAB_MISC : null)));
	//blue skies
	public static final RegistryObject<Item> VENTIUM_BUCKET_EMPATIC = ITEMS.register("ventium_bucket_empatic", 
			() -> new BucketItem(CompatFluids.VENTIUM,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("blue_skies") ? CreativeModeTab.TAB_MISC : null)));
	public static final RegistryObject<Item> HORIZONITE_BUCKET = ITEMS.register("horizonite_bucket", 
			() -> new BucketItem(CompatFluids.HORIZONITE,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("blue_skies") ? CreativeModeTab.TAB_MISC : null)));
	public static final RegistryObject<Item> FALSITE_BUCKET = ITEMS.register("falsite_bucket", 
			() -> new BucketItem(CompatFluids.FALSITE,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("blue_skies") ? CreativeModeTab.TAB_MISC : null)));
	//the undergarden
	public static final RegistryObject<Item> CLOGGRUM_BUCKET = ITEMS.register("cloggrum_bucket",
			() -> new BucketItem(CompatFluids.CLOGGRUM,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("undergarden") ? CreativeModeTab.TAB_MISC : null)));
	public static final RegistryObject<Item> UTHERIUM_BUCKET = ITEMS.register("utherium_bucket",
			() -> new BucketItem(CompatFluids.UTHERIUM,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("undergarden") ? CreativeModeTab.TAB_MISC : null)));
	public static final RegistryObject<Item> FROSTSTEEL_BUCKET = ITEMS.register("froststeel_bucket",
			() -> new BucketItem(CompatFluids.FROSTSTEEL,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("undergarden") ? CreativeModeTab.TAB_MISC : null)));
	public static final RegistryObject<Item> FORGOTTEN_BUCKET = ITEMS.register("forgotten_bucket",
			() -> new BucketItem(CompatFluids.FORGOTTEN,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("undergarden") ? CreativeModeTab.TAB_MISC : null)));
	//create
	public static final RegistryObject<Item> CARAMELCOMPOSITE_BUCKET = ITEMS.register("caramelcomposite_bucket",
			() -> new BucketItem(CompatFluids.CARAMELCOMPOSITE,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("create") ? CreativeModeTab.TAB_MISC : null)));
	public static final RegistryObject<Item> HAUNTEDBRASS_BUCKET = ITEMS.register("hauntedbrass_bucket",
			() -> new BucketItem(CompatFluids.HAUNTEDBRASS,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModList.get().isLoaded("create") ? CreativeModeTab.TAB_MISC : null)));

}

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

public class CompatItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EmpaTiC.MODID);

	public static final RegistryObject<Item> MILKONSTANTAN_INGOT = ITEMS.register("milkonstantan_ingot",
			() -> new Item(new Item.Properties().group(TinkerModule.TAB_GENERAL)));
	public static final RegistryObject<Item> MILKONSTANTAN_NUGGET = ITEMS.register("milkonstantan_nugget",
			() -> new Item(new Item.Properties().group(TinkerModule.TAB_GENERAL)));
	public static final RegistryObject<Item> MILKONSTANTAN_BUCKET = ITEMS.register("milkonstantan_bucket", 
			() -> new BucketItem(CompatFluids.MILKONSTANTAN, new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC)));
	//botania
	public static final RegistryObject<Item> MANASTEEL_BUCKET = ITEMS.register("manasteel_bucket", 
			() -> new BucketItem(CompatFluids.MANASTEEL,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("botania") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> ELEMENTIUM_BUCKET = ITEMS.register("elementium_bucket", 
			() -> new BucketItem(CompatFluids.ELEMENTIUM,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("botania") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> TERRASTEEL_BUCKET = ITEMS.register("terrasteel_bucket", 
			() -> new BucketItem(CompatFluids.TERRASTEEL,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("botania") ? ItemGroup.MISC : null)));
	//blue skies
	public static final RegistryObject<Item> VENTIUM_BUCKET_EMPATIC = ITEMS.register("ventium_bucket_empatic", 
			() -> new BucketItem(CompatFluids.VENTIUM,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("blue_skies") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> HORIZONITE_BUCKET = ITEMS.register("horizonite_bucket", 
			() -> new BucketItem(CompatFluids.HORIZONITE,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("blue_skies") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> FALSITE_BUCKET = ITEMS.register("falsite_bucket", 
			() -> new BucketItem(CompatFluids.FALSITE,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("blue_skies") ? ItemGroup.MISC : null)));
	//twilight forest
	public static final RegistryObject<Item> IRONWOOD_BUCKET = ITEMS.register("ironwood_bucket",
			() -> new BucketItem(CompatFluids.IRONWOOD,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("twilightforest") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> STEELEAF_BUCKET = ITEMS.register("steeleaf_bucket",
			() -> new BucketItem(CompatFluids.STEELEAF,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("twilightforest") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> KNIGHTMETAL_BUCKET = ITEMS.register("knightmetal_bucket",
			() -> new BucketItem(CompatFluids.KNIGHTMETAL,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("twilightforest") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> FIERY_BUCKET = ITEMS.register("fiery_bucket",
			() -> new BucketItem(CompatFluids.FIERY,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("twilightforest") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> FIERY_ESSENCE_BUCKET = ITEMS.register("fiery_essence_bucket",
			() -> new BucketItem(CompatFluids.FIERYESSENCE,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("twilightforest") ? ItemGroup.MISC : null)));
	//the undergarden
	public static final RegistryObject<Item> CLOGGRUM_BUCKET = ITEMS.register("cloggrum_bucket",
			() -> new BucketItem(CompatFluids.CLOGGRUM,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("undergarden") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> UTHERIUM_BUCKET = ITEMS.register("utherium_bucket",
			() -> new BucketItem(CompatFluids.UTHERIUM,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("undergarden") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> FROSTSTEEL_BUCKET = ITEMS.register("froststeel_bucket",
			() -> new BucketItem(CompatFluids.FROSTSTEEL,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("undergarden") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> FORGOTTEN_BUCKET = ITEMS.register("forgotten_bucket",
			() -> new BucketItem(CompatFluids.FORGOTTEN,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("undergarden") ? ItemGroup.MISC : null)));
	//create
	public static final RegistryObject<Item> CARAMELCOMPOSITE_BUCKET = ITEMS.register("caramelcomposite_bucket",
			() -> new BucketItem(CompatFluids.CARAMELCOMPOSITE,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("create") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> REFINEDRADIANCE_BUCKET = ITEMS.register("refinedradiance_bucket",
			() -> new BucketItem(CompatFluids.REFINEDRADIANCE,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("create") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> SHADOWSTEEL_BUCKET = ITEMS.register("shadowsteel_bucket",
			() -> new BucketItem(CompatFluids.SHADOWSTEEL,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("create") ? ItemGroup.MISC : null)));
	public static final RegistryObject<Item> HAUNTEDBRASS_BUCKET = ITEMS.register("hauntedbrass_bucket",
			() -> new BucketItem(CompatFluids.HAUNTEDBRASS,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModList.get().isLoaded("create") ? ItemGroup.MISC : null)));

}

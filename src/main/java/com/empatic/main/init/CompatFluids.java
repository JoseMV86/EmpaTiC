package com.empatic.main.init;

import com.empatic.main.EmpaTiC;

import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CompatFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, EmpaTiC.MODID);

    public static final ResourceLocation MOLTEN_METAL_STILL = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/molten_metal_still");
    public static final ResourceLocation MOLTEN_METAL_FLOW = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/molten_metal_flowing");
    public static final ResourceLocation MOLTEN_STONE_STILL = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/molten_stone_still");
    public static final ResourceLocation MOLTEN_STONE_FLOW = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/molten_stone_flowing");
    public static final ResourceLocation LIQUID_STILL = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/liquid_still");
    public static final ResourceLocation LIQUID_FLOW = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/liquid_flowing");

    
    //materials
    
    public static final RegistryObject<ForgeFlowingFluid.Source> MILKONSTANTAN = FLUIDS.register("molten_milkonstantan",
            () -> new ForgeFlowingFluid.Source(makeMoltenMilkonstantanProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_MILKONSTANTAN = FLUIDS.register("flowing_molten_milkonstantan",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenMilkonstantanProperties()));

    	//botania
    public static final RegistryObject<ForgeFlowingFluid.Source> MANASTEEL = FLUIDS.register("molten_manasteel",
            () -> new ForgeFlowingFluid.Source(makeMoltenManasteelProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_MANASTEEL = FLUIDS.register("flowing_molten_manasteel",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenManasteelProperties()));
    
    public static final RegistryObject<ForgeFlowingFluid.Source> ELEMENTIUM = FLUIDS.register("molten_elementium",
            () -> new ForgeFlowingFluid.Source(makeMoltenElementiumProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_ELEMENTIUM = FLUIDS.register("flowing_molten_elementium",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenElementiumProperties()));
    
    public static final RegistryObject<ForgeFlowingFluid.Source> TERRASTEEL = FLUIDS.register("molten_terrasteel",
            () -> new ForgeFlowingFluid.Source(makeMoltenTerrasteelProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_TERRASTEEL = FLUIDS.register("flowing_molten_terrasteel",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenTerrasteelProperties()));

    	//blue skies
    public static final RegistryObject<ForgeFlowingFluid.Source> VENTIUM = FLUIDS.register("molten_ventium",
            () -> new ForgeFlowingFluid.Source(makeMoltenVentiumProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_VENTIUM = FLUIDS.register("flowing_molten_ventium",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenVentiumProperties()));
    
    public static final RegistryObject<ForgeFlowingFluid.Source> HORIZONITE = FLUIDS.register("molten_horizonite",
            () -> new ForgeFlowingFluid.Source(makeMoltenHorizoniteProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_HORIZONITE = FLUIDS.register("flowing_molten_horizonite",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenHorizoniteProperties()));
    
    public static final RegistryObject<ForgeFlowingFluid.Source> FALSITE = FLUIDS.register("molten_falsite",
            () -> new ForgeFlowingFluid.Source(makeMoltenFalsiteProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_FALSITE = FLUIDS.register("flowing_molten_falsite",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenFalsiteProperties()));

    //twilight forest
    public static final RegistryObject<ForgeFlowingFluid.Source> IRONWOOD = FLUIDS.register("molten_ironwood",
            () -> new ForgeFlowingFluid.Source(makeMoltenIronwoodProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_IRONWOOD = FLUIDS.register("flowing_molten_ironwood",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenIronwoodProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Source> STEELEAF = FLUIDS.register("molten_steeleaf",
            () -> new ForgeFlowingFluid.Source(makeMoltenSteeleafProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_STEELEAF = FLUIDS.register("flowing_molten_steeleaf",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenSteeleafProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Source> KNIGHTMETAL = FLUIDS.register("molten_knightmetal",
            () -> new ForgeFlowingFluid.Source(makeMoltenKnightmetalProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_KNIGHTMETAL = FLUIDS.register("flowing_molten_knightmetal",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenKnightmetalProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Source> FIERY = FLUIDS.register("molten_fiery",
            () -> new ForgeFlowingFluid.Source(makeMoltenFieryProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_FIERY = FLUIDS.register("flowing_molten_fiery",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenFieryProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Source> FIERYESSENCE = FLUIDS.register("fiery_essence",
            () -> new ForgeFlowingFluid.Source(makeFieryEssenceProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_FIERYESSENCE = FLUIDS.register("flowing_fiery_essence",
            () -> new ForgeFlowingFluid.Flowing(makeFieryEssenceProperties()));
    
    
    //molten material properties

    private static ForgeFlowingFluid.Properties makeMoltenMilkonstantanProperties() {
        return new ForgeFlowingFluid.Properties(MILKONSTANTAN, flowing_MILKONSTANTAN,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFFAD88F)
                        .luminosity(10).density(3500).viscosity(7000).temperature(875).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
        		.bucket(CompatItems.MILKONSTANTAN_BUCKET).block(CompatBlocks.MOLTEN_MILKONSTANTAN).explosionResistance(1000F).tickRate(9);
    }

    	//botania
    private static ForgeFlowingFluid.Properties makeMoltenManasteelProperties() {
        return new ForgeFlowingFluid.Properties(MANASTEEL, flowing_MANASTEEL,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF64AAFF)
                        .luminosity(12).density(3000).viscosity(6000).temperature(725).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
        		.bucket(CompatItems.MANASTEEL_BUCKET).block(CompatBlocks.MOLTEN_MANASTEEL).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenElementiumProperties() {
        return new ForgeFlowingFluid.Properties(ELEMENTIUM, flowing_ELEMENTIUM,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFFF4FAF)
                        .luminosity(14).density(3000).viscosity(6000).temperature(925).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.ELEMENTIUM_BUCKET).block(CompatBlocks.MOLTEN_ELEMENTIUM).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenTerrasteelProperties() {
        return new ForgeFlowingFluid.Properties(TERRASTEEL, flowing_TERRASTEEL,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF53F100)
                        .luminosity(14).density(3000).viscosity(6000).temperature(1250).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.TERRASTEEL_BUCKET).block(CompatBlocks.MOLTEN_TERRASTEEL).explosionResistance(1000F).tickRate(5);
    }

	//blue skies
    private static ForgeFlowingFluid.Properties makeMoltenVentiumProperties() {
        return new ForgeFlowingFluid.Properties(VENTIUM, flowing_VENTIUM,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFDC3838)
                        .luminosity(12).density(3000).viscosity(6000).temperature(800).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
        		.bucket(CompatItems.VENTIUM_BUCKET_EMPATIC).block(CompatBlocks.MOLTEN_VENTIUM).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenHorizoniteProperties() {
        return new ForgeFlowingFluid.Properties(HORIZONITE, flowing_HORIZONITE,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFFF6E29)
                        .luminosity(14).density(3000).viscosity(6000).temperature(950).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.HORIZONITE_BUCKET).block(CompatBlocks.MOLTEN_HORIZONITE).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenFalsiteProperties() {
        return new ForgeFlowingFluid.Properties(FALSITE, flowing_FALSITE,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF7662E5)
                        .luminosity(12).density(3000).viscosity(6000).temperature(875).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.FALSITE_BUCKET).block(CompatBlocks.MOLTEN_FALSITE).explosionResistance(1000F).tickRate(5);
    }

    //twilight forest
    private static ForgeFlowingFluid.Properties makeMoltenIronwoodProperties() {
        return new ForgeFlowingFluid.Properties(IRONWOOD, flowing_IRONWOOD,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF7A966F)
                        .luminosity(12).density(3000).viscosity(6000).temperature(720).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.IRONWOOD_BUCKET).block(CompatBlocks.MOLTEN_IRONWOOD).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenSteeleafProperties() {
        return new ForgeFlowingFluid.Properties(STEELEAF, flowing_STEELEAF,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF52873A)
                        .luminosity(12).density(3000).viscosity(6000).temperature(825).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.STEELEAF_BUCKET).block(CompatBlocks.MOLTEN_STEELEAF).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenKnightmetalProperties() {
        return new ForgeFlowingFluid.Properties(KNIGHTMETAL, flowing_KNIGHTMETAL,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFc4d6ae)
                        .luminosity(9).density(3000).viscosity(6000).temperature(845).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.KNIGHTMETAL_BUCKET).block(CompatBlocks.MOLTEN_KNIGHTMETAL).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenFieryProperties() {
        return new ForgeFlowingFluid.Properties(FIERY, flowing_FIERY,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF531A09)
                        .luminosity(14).density(3000).viscosity(6000).temperature(1325).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.FIERY_BUCKET).block(CompatBlocks.MOLTEN_FIERY).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeFieryEssenceProperties() {
        return new ForgeFlowingFluid.Properties(FIERYESSENCE, flowing_FIERYESSENCE,
                FluidAttributes.builder(LIQUID_STILL, LIQUID_FLOW).overlay(LIQUID_STILL).color(0xFF850a0a)
                        .luminosity(2).density(1200).viscosity(8000).temperature(1375).sound(SoundEvents.ITEM_BUCKET_FILL, SoundEvents.ITEM_BUCKET_EMPTY))
                .bucket(CompatItems.FIERY_ESSENCE_BUCKET).block(CompatBlocks.FIERY_ESSENCE).explosionResistance(1000F).tickRate(5);
    }
}
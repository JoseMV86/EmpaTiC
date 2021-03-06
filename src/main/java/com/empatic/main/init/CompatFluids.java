package com.empatic.main.init;

import com.empatic.main.EmpaTiC;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;
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


    //undergarden
    public static final RegistryObject<ForgeFlowingFluid.Source> CLOGGRUM = FLUIDS.register("molten_cloggrum",
            () -> new ForgeFlowingFluid.Source(makeMoltenCloggrumProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_CLOGGRUM = FLUIDS.register("flowing_molten_cloggrum",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenCloggrumProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Source> UTHERIUM = FLUIDS.register("molten_utherium",
            () -> new ForgeFlowingFluid.Source(makeMoltenUtheriumProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_UTHERIUM = FLUIDS.register("flowing_molten_utherium",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenUtheriumProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Source> FROSTSTEEL = FLUIDS.register("molten_froststeel",
            () -> new ForgeFlowingFluid.Source(makeMoltenFroststeelProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_FROSTSTEEL = FLUIDS.register("flowing_molten_froststeel",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenFroststeelProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Source> FORGOTTEN = FLUIDS.register("molten_forgotten",
            () -> new ForgeFlowingFluid.Source(makeMoltenForgottenProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_FORGOTTEN = FLUIDS.register("flowing_molten_forgotten",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenForgottenProperties()));

    //create
    public static final RegistryObject<ForgeFlowingFluid.Source> CARAMELCOMPOSITE = FLUIDS.register("molten_caramelcomposite",
            () -> new ForgeFlowingFluid.Source(makeMoltenCaramelCompositeProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_CARAMELCOMPOSITE = FLUIDS.register("flowing_molten_caramelcomposite",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenCaramelCompositeProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Source> HAUNTEDBRASS = FLUIDS.register("molten_hauntedbrass",
            () -> new ForgeFlowingFluid.Source(makeMoltenHauntedBrassProperties()));
    public static final RegistryObject<ForgeFlowingFluid.Flowing> flowing_HAUNTEDBRASS = FLUIDS.register("flowing_molten_hauntedbrass",
            () -> new ForgeFlowingFluid.Flowing(makeMoltenHauntedBrassProperties()));


    
    
    //molten material properties

    private static ForgeFlowingFluid.Properties makeMoltenMilkonstantanProperties() {
        return new ForgeFlowingFluid.Properties(MILKONSTANTAN, flowing_MILKONSTANTAN,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFFAD88F)
                        .luminosity(10).density(3500).viscosity(7000).temperature(875).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
        		.bucket(CompatItems.MILKONSTANTAN_BUCKET).block(CompatBlocks.MOLTEN_MILKONSTANTAN).explosionResistance(1000F).tickRate(9);
    }

    //botania
    private static ForgeFlowingFluid.Properties makeMoltenManasteelProperties() {
        return new ForgeFlowingFluid.Properties(MANASTEEL, flowing_MANASTEEL,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF64AAFF)
                        .luminosity(12).density(3000).viscosity(6000).temperature(725).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
        		.bucket(CompatItems.MANASTEEL_BUCKET).block(CompatBlocks.MOLTEN_MANASTEEL).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenElementiumProperties() {
        return new ForgeFlowingFluid.Properties(ELEMENTIUM, flowing_ELEMENTIUM,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFFF4FAF)
                        .luminosity(14).density(3000).viscosity(6000).temperature(925).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.ELEMENTIUM_BUCKET).block(CompatBlocks.MOLTEN_ELEMENTIUM).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenTerrasteelProperties() {
        return new ForgeFlowingFluid.Properties(TERRASTEEL, flowing_TERRASTEEL,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF53F100)
                        .luminosity(14).density(3000).viscosity(6000).temperature(1250).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.TERRASTEEL_BUCKET).block(CompatBlocks.MOLTEN_TERRASTEEL).explosionResistance(1000F).tickRate(5);
    }

	//blue skies
    private static ForgeFlowingFluid.Properties makeMoltenVentiumProperties() {
        return new ForgeFlowingFluid.Properties(VENTIUM, flowing_VENTIUM,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFDC3838)
                        .luminosity(12).density(3000).viscosity(6000).temperature(800).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
        		.bucket(CompatItems.VENTIUM_BUCKET_EMPATIC).block(CompatBlocks.MOLTEN_VENTIUM).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenHorizoniteProperties() {
        return new ForgeFlowingFluid.Properties(HORIZONITE, flowing_HORIZONITE,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFFF6E29)
                        .luminosity(14).density(3000).viscosity(6000).temperature(950).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.HORIZONITE_BUCKET).block(CompatBlocks.MOLTEN_HORIZONITE).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenFalsiteProperties() {
        return new ForgeFlowingFluid.Properties(FALSITE, flowing_FALSITE,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF7662E5)
                        .luminosity(12).density(3000).viscosity(6000).temperature(875).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.FALSITE_BUCKET).block(CompatBlocks.MOLTEN_FALSITE).explosionResistance(1000F).tickRate(5);
    }

    //the undergarden
    private static ForgeFlowingFluid.Properties makeMoltenCloggrumProperties() {
        return new ForgeFlowingFluid.Properties(CLOGGRUM, flowing_CLOGGRUM,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF7b6959)
                        .luminosity(6).density(3000).viscosity(6000).temperature(865).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.CLOGGRUM_BUCKET).block(CompatBlocks.MOLTEN_CLOGGRUM).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenUtheriumProperties() {
        return new ForgeFlowingFluid.Properties(UTHERIUM, flowing_UTHERIUM,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFc3434c)
                        .luminosity(12).density(3000).viscosity(6000).temperature(865).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.UTHERIUM_BUCKET).block(CompatBlocks.MOLTEN_UTHERIUM).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenFroststeelProperties() {
        return new ForgeFlowingFluid.Properties(FROSTSTEEL, flowing_FROSTSTEEL,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF616a9b)
                        .luminosity(9).density(3000).viscosity(6000).temperature(865).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.FROSTSTEEL_BUCKET).block(CompatBlocks.MOLTEN_FROSTSTEEL).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenForgottenProperties() {
        return new ForgeFlowingFluid.Properties(FORGOTTEN, flowing_FORGOTTEN,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF278a6f)
                        .luminosity(12).density(3000).viscosity(6000).temperature(1465).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.FORGOTTEN_BUCKET).block(CompatBlocks.MOLTEN_FORGOTTEN).explosionResistance(1000F).tickRate(5);
    }

    //create
    private static ForgeFlowingFluid.Properties makeMoltenCaramelCompositeProperties() {
        return new ForgeFlowingFluid.Properties(CARAMELCOMPOSITE, flowing_CARAMELCOMPOSITE,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFFfed32e)
                        .luminosity(10).density(3000).viscosity(6000).temperature(900).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.CARAMELCOMPOSITE_BUCKET).block(CompatBlocks.MOLTEN_CARAMELCOMPOSITE).explosionResistance(1000F).tickRate(5);
    }

    private static ForgeFlowingFluid.Properties makeMoltenHauntedBrassProperties() {
        return new ForgeFlowingFluid.Properties(HAUNTEDBRASS, flowing_HAUNTEDBRASS,
                FluidAttributes.builder(MOLTEN_METAL_STILL, MOLTEN_METAL_FLOW).overlay(MOLTEN_METAL_STILL).color(0xFF816c53)
                        .luminosity(6).density(3000).viscosity(6000).temperature(860).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(CompatItems.HAUNTEDBRASS_BUCKET).block(CompatBlocks.MOLTEN_HAUNTEDBRASS).explosionResistance(1000F).tickRate(5);
    }
}

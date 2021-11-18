package com.empatic.main.init;

import com.empatic.main.EmpaTiC;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CompatBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EmpaTiC.MODID);
 
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_MILKONSTANTAN = BLOCKS
            .register("molten_milkonstantan_block", () -> new FlowingFluidBlock(CompatFluids.MILKONSTANTAN,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 10;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));   
    
    //botania
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_MANASTEEL = BLOCKS
            .register("molten_manasteel_block", () -> new FlowingFluidBlock(CompatFluids.MANASTEEL,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 12;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_ELEMENTIUM = BLOCKS
            .register("molten_elementium_block", () -> new FlowingFluidBlock(CompatFluids.ELEMENTIUM,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 14;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_TERRASTEEL = BLOCKS
            .register("molten_terrasteel_block", () -> new FlowingFluidBlock(CompatFluids.TERRASTEEL,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 14;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));

    //blue skies
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_VENTIUM = BLOCKS
            .register("molten_ventium_block", () -> new FlowingFluidBlock(CompatFluids.VENTIUM,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 12;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_HORIZONITE = BLOCKS
            .register("molten_horizonite_block", () -> new FlowingFluidBlock(CompatFluids.HORIZONITE,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 14;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_FALSITE = BLOCKS
            .register("molten_falsite_block", () -> new FlowingFluidBlock(CompatFluids.FALSITE,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 12;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));    

    //twilight forest
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_IRONWOOD = BLOCKS
            .register("molten_ironwood_block", () -> new FlowingFluidBlock(CompatFluids.IRONWOOD,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 12;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_STEELEAF = BLOCKS
            .register("molten_steeleaf_block", () -> new FlowingFluidBlock(CompatFluids.STEELEAF,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 12;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_KNIGHTMETAL = BLOCKS
            .register("molten_knightmetal_block", () -> new FlowingFluidBlock(CompatFluids.KNIGHTMETAL,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 9;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_FIERY = BLOCKS
            .register("molten_fiery_block", () -> new FlowingFluidBlock(CompatFluids.FIERY,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 14;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> FIERY_ESSENCE = BLOCKS
            .register("fiery_essence_block", () -> new FlowingFluidBlock(CompatFluids.FIERYESSENCE,
                    Block.Properties.create(Material.LAVA).setLightLevel((state) -> {	return 2;	}).tickRandomly().hardnessAndResistance(100.0F).noDrops()));

}
package com.empatic.main.init;

import com.empatic.main.EmpaTiC;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CompatBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EmpaTiC.MODID);
 
    public static final RegistryObject<LiquidBlock> MOLTEN_MILKONSTANTAN = BLOCKS
            .register("molten_milkonstantan_block", () -> new LiquidBlock(CompatFluids.MILKONSTANTAN,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 10; }).randomTicks().strength(100.0F).noDrops()));
    
    //botania
    public static final RegistryObject<LiquidBlock> MOLTEN_MANASTEEL = BLOCKS
            .register("molten_manasteel_block", () -> new LiquidBlock(CompatFluids.MANASTEEL,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 12; }).randomTicks().strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_ELEMENTIUM = BLOCKS
            .register("molten_elementium_block", () -> new LiquidBlock(CompatFluids.ELEMENTIUM,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 14; }).randomTicks().strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_TERRASTEEL = BLOCKS
            .register("molten_terrasteel_block", () -> new LiquidBlock(CompatFluids.TERRASTEEL,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 14; }).randomTicks().strength(100.0F).noDrops()));

    //blue skies
    public static final RegistryObject<LiquidBlock> MOLTEN_VENTIUM = BLOCKS
            .register("molten_ventium_block", () -> new LiquidBlock(CompatFluids.VENTIUM,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 12; }).randomTicks().strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_HORIZONITE = BLOCKS
            .register("molten_horizonite_block", () -> new LiquidBlock(CompatFluids.HORIZONITE,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 14; }).randomTicks().strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_FALSITE = BLOCKS
            .register("molten_falsite_block", () -> new LiquidBlock(CompatFluids.FALSITE,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 12; }).randomTicks().strength(100.0F).noDrops()));

    //the undergarden
    public static final RegistryObject<LiquidBlock> MOLTEN_CLOGGRUM = BLOCKS
            .register("molten_cloggrum_block", () -> new LiquidBlock(CompatFluids.CLOGGRUM,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 6; }).randomTicks().strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_UTHERIUM = BLOCKS
            .register("molten_utherium_block", () -> new LiquidBlock(CompatFluids.UTHERIUM,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 12; }).randomTicks().strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_FROSTSTEEL = BLOCKS
            .register("molten_froststeel_block", () -> new LiquidBlock(CompatFluids.FROSTSTEEL,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 9; }).randomTicks().strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_FORGOTTEN = BLOCKS
            .register("molten_forgotten_block", () -> new LiquidBlock(CompatFluids.FORGOTTEN,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 12; }).randomTicks().strength(100.0F).noDrops()));

    //create
    public static final RegistryObject<LiquidBlock> MOLTEN_CARAMELCOMPOSITE = BLOCKS
            .register("molten_caramelcomposite_block", () -> new LiquidBlock(CompatFluids.CARAMELCOMPOSITE,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 10; }).randomTicks().strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_HAUNTEDBRASS = BLOCKS
            .register("molten_hauntedbrass_block", () -> new LiquidBlock(CompatFluids.HAUNTEDBRASS,
                    Block.Properties.of(Material.LAVA).lightLevel((state) -> { return 6; }).randomTicks().strength(100.0F).noDrops()));

}

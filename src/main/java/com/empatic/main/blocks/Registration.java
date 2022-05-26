package com.empatic.main.blocks;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.shared.TinkerCommons;

public class Registration
{
  private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "empatic");
  private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "empatic");

  public static void init() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    BLOCKS.register(bus);
    ITEMS.register(bus);
  }

  // Some common properties for our blocks and items
  public static final BlockBehaviour.Properties BLOCK_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(20.0f, 900.0f).requiresCorrectToolForDrops();
  public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(TinkerCommons.TAB_GENERAL);


  public static final RegistryObject<Block> DEBRISTONE = BLOCKS.register("debristone", () -> new Block(BLOCK_PROPERTIES));
  public static final RegistryObject<Item> DEBRISTONE_ITEM = fromBlock(DEBRISTONE);
  public static final RegistryObject<Block> CHISELED_DEBRISTONE = BLOCKS.register("chiseled_debristone", () -> new Block(BLOCK_PROPERTIES));
  public static final RegistryObject<Item> CHISELED_DEBRISTONE_ITEM = fromBlock(CHISELED_DEBRISTONE);
  public static final RegistryObject<Block> CUT_DEBRISTONE = BLOCKS.register("cut_debristone", () -> new Block(BLOCK_PROPERTIES));
  public static final RegistryObject<Item> CUT_DEBRISTONE_ITEM = fromBlock(CUT_DEBRISTONE);
  public static final RegistryObject<Block> SMOOTH_DEBRISTONE = BLOCKS.register("smooth_debristone", () -> new Block(BLOCK_PROPERTIES));
  public static final RegistryObject<Item> SMOOTH_DEBRISTONE_ITEM = fromBlock(SMOOTH_DEBRISTONE);
  public static final RegistryObject<Block> MILKONSTANTAN_BLOCK = BLOCKS.register("milkonstantan_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5.0f, 6.0f).requiresCorrectToolForDrops()));
  public static final RegistryObject<Item> MILKONSTANTAN_BLOCK_ITEM = fromBlock(MILKONSTANTAN_BLOCK);

  // Conveniance function: Take a RegistryObject<Block> and make a corresponding RegistryObject<Item> from it
  public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
    return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
  }
}

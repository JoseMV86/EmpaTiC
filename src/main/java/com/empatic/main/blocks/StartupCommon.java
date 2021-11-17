package com.empatic.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.shared.TinkerCommons;

public class StartupCommon
{
  public static DebriStone debriStone;
  public static BlockItem itemDebriStone;
  public static CutDebriStone cutDebriStone;
  public static BlockItem itemCutDebriStone;
  public static ChiseledDebriStone chiseledDebriStone;
  public static BlockItem itemChiseledDebriStone;
  public static SmoothDebriStone smoothDebriStone;
  public static BlockItem itemSmoothDebriStone;
  public static MilkonstantanBlock milkonstantanBlock;
  public static BlockItem itemMilkonstantanBlock;

  @SubscribeEvent
  public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
    debriStone = (DebriStone)(new DebriStone().setRegistryName("empatic", "debristone"));
    cutDebriStone = (CutDebriStone)(new CutDebriStone().setRegistryName("empatic", "cut_debristone"));
    chiseledDebriStone = (ChiseledDebriStone)(new ChiseledDebriStone().setRegistryName("empatic", "chiseled_debristone"));
    smoothDebriStone = (SmoothDebriStone)(new SmoothDebriStone().setRegistryName("empatic", "smooth_debristone"));
    milkonstantanBlock = (MilkonstantanBlock)(new MilkonstantanBlock().setRegistryName("empatic", "milkonstantan_block"));
    blockRegisterEvent.getRegistry().register(debriStone);
    blockRegisterEvent.getRegistry().register(cutDebriStone);
    blockRegisterEvent.getRegistry().register(chiseledDebriStone);
    blockRegisterEvent.getRegistry().register(smoothDebriStone);
    blockRegisterEvent.getRegistry().register(milkonstantanBlock);
  }

  @SubscribeEvent
  public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
    // We need to create a BlockItem so the player can carry this block in their hand and it can appear in the inventory
    final int MAXIMUM_STACK_SIZE = 64;

    Item.Properties itemSimpleProperties = new Item.Properties()
                                                   .maxStackSize(MAXIMUM_STACK_SIZE)
                                                   .group(TinkerCommons.TAB_GENERAL);  // which inventory tab?

    itemDebriStone = new BlockItem(debriStone, itemSimpleProperties);
    itemDebriStone.setRegistryName(debriStone.getRegistryName());
    itemRegisterEvent.getRegistry().register(itemDebriStone);

    itemCutDebriStone = new BlockItem(cutDebriStone, itemSimpleProperties);
    itemCutDebriStone.setRegistryName(cutDebriStone.getRegistryName());
    itemRegisterEvent.getRegistry().register(itemCutDebriStone);

    itemChiseledDebriStone = new BlockItem(chiseledDebriStone, itemSimpleProperties);
    itemChiseledDebriStone.setRegistryName(chiseledDebriStone.getRegistryName());
    itemRegisterEvent.getRegistry().register(itemChiseledDebriStone);

    itemSmoothDebriStone = new BlockItem(smoothDebriStone, itemSimpleProperties);
    itemSmoothDebriStone.setRegistryName(smoothDebriStone.getRegistryName());
    itemRegisterEvent.getRegistry().register(itemSmoothDebriStone);

    itemMilkonstantanBlock = new BlockItem(milkonstantanBlock, itemSimpleProperties);
    itemMilkonstantanBlock.setRegistryName(milkonstantanBlock.getRegistryName());
    itemRegisterEvent.getRegistry().register(itemMilkonstantanBlock);
  }
}

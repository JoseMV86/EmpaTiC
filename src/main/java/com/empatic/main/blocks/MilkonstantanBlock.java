package com.empatic.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;


public class MilkonstantanBlock extends Block
{
  public MilkonstantanBlock()
  {
    super(Properties.create(Material.IRON)
                            .hardnessAndResistance(5f, 6f)
                            .sound(SoundType.METAL)
                            .harvestLevel(2)
                            .harvestTool(ToolType.PICKAXE)  // look at Block.Properties for further options

         );
 }
  @Override
  public BlockRenderType getRenderType(BlockState blockState) {
    return BlockRenderType.MODEL;
  }
}



                            
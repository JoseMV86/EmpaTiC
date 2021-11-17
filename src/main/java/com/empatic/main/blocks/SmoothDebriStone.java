package com.empatic.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;


public class SmoothDebriStone extends Block
{
  public SmoothDebriStone()
  {
    super(Block.Properties.create(Material.ROCK)
                            .hardnessAndResistance(20.0f, 900.0f)
                            .sound(SoundType.STONE)
                            .harvestLevel(3)
                            .harvestTool(ToolType.PICKAXE)  // look at Block.Properties for further options

         );
 }
  @Override
  public BlockRenderType getRenderType(BlockState blockState) {
    return BlockRenderType.MODEL;
  }
}



                            
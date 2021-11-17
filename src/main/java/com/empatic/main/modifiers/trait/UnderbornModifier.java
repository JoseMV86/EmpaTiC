package com.empatic.main.modifiers.trait;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.Tags;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.tools.ToolDefinition;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.library.utils.TooltipFlag;

import java.util.List;

public class UnderbornModifier extends Modifier {

  private static final int SEA_LEVEL = 64;
  private static final float BOOST_AT_0 = 0.1f;

  public UnderbornModifier() {
    super(0x584035);
  }


   @Override
   public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context, float baseDamage, float damage) {
    //literally just dwarven's formula
    float factor = Math.max(1f, (SEA_LEVEL - context.getTarget().getPosition().getY()) * level * (BOOST_AT_0 / SEA_LEVEL) + 1);
    if (factor > 1f) {
      damage = damage*factor;
    }
    return damage;
  }
}
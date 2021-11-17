package com.empatic.main.modifiers.trait;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import slimeknights.tconstruct.library.modifiers.IncrementalModifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.utils.Util;
import slimeknights.tconstruct.tools.TinkerModifiers;

import java.util.List;

public class UnreliableModifier extends IncrementalModifier {
  //Resembles the duritae modifier from previous Tinkers versions
  public UnreliableModifier() {
    super(0x761ED8);
  }

  public int getPriority() {
    return 85; // before reinforced, after unbreakable
  }

  @Override
  public int onDamageTool(IModifierToolStack tool, int level, int amount) {
    int dealt = 0;
    for (int i = 0; i < amount; i++) { //25% at level 1 of taking 3, which means 0.75 dmg on average
      if (RANDOM.nextFloat() <= (0.3f - 0.05f * level)) { //0.6 on average at level 2, etc.
        dealt += 3; //max 0.3 on average at level 4
      }
    }
    return dealt;
  }
}

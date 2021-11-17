package com.empatic.main.modifiers.trait;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class ClearingModifier extends Modifier {
  public ClearingModifier() {
    super(0xD7D0BD);
  }

  @Override
  public void onBreakSpeed(IModifierToolStack tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    if (!isEffective) {
      return;
    }
    List<EffectInstance> efectos = new ArrayList(((PlayerEntity)(event.getEntity())).getActivePotionEffects());
    boolean fatiga = false;
    boolean herido = false;
    boolean trampas = false;
    for (EffectInstance efecto:efectos) {
    if (efecto.getPotion().equals(Effects.MINING_FATIGUE)){
      fatiga = true;
     }
    }
    if (!fatiga) {
     for (EffectInstance efecto:efectos) {
      if (!(efecto.getPotion().isBeneficial())){
       herido = true;
       } else {
       trampas = true;
       }
      }
     if (herido && !trampas) {
      event.setNewSpeed(event.getNewSpeed() * 1.125f * level);
     }
    }
  }
}

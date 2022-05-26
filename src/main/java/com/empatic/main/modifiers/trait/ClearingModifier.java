package com.empatic.main.modifiers.trait;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ClearingModifier extends Modifier {

  @Override
  public void onBreakSpeed(IToolStackView tool, int level, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
    if (!isEffective) {
      return;
    }
    List<MobEffectInstance> efectos = new ArrayList(((Player)(event.getEntity())).getActiveEffects());
    boolean fatiga = false;
    boolean herido = false;
    boolean trampas = false;
    for (MobEffectInstance efecto:efectos) {
    if (efecto.getEffect().equals(MobEffects.DIG_SLOWDOWN)){
      fatiga = true;
     }
    }
    if (!fatiga) {
     for (MobEffectInstance efecto:efectos) {
      if (!(efecto.getEffect().isBeneficial())){
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

package com.empatic.main.modifiers.trait;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nullable;

public class VoidCallingModifier extends Modifier {
  public VoidCallingModifier() {
    super(0x665d78);
  }

  @Override
  public int getPriority() {
    return 185; // Just like Solar Powered

  }

  @Override
  public int onDamageTool(IModifierToolStack toolStack, int level, int amount, @Nullable LivingEntity holder) {
    if (holder != null) {
      World world = holder.getEntityWorld();
      int light = world.getLightFor(LightType.BLOCK, holder.getPosition());
      int skylight = world.getLightFor(LightType.SKY, holder.getPosition()) - world.getSkylightSubtracted();
      if (Math.max(light, skylight) < 8) {
        float chance = level * 0.2f;
        int maxDamage = amount;
        // for each damage we will take, if the random number is below chance, reduce
        for (int i = 0; i < maxDamage; i++) {
          if (RANDOM.nextFloat() < chance) {
            amount--;
          }
        }
      }
    }
    return amount;
  }
}

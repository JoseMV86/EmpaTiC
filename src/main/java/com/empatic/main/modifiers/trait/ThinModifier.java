package com.empatic.main.modifiers.trait;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class ThinModifier extends Modifier {

  @Override
  public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
    ToolStats.ATTACK_SPEED.multiply(builder, 1 + (0.105f * level));
  }

    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        if (RANDOM.nextFloat() < level * 0.1) {
            context.getAttacker().addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20 * (3 + (RANDOM.nextInt(4))), 0));
        }
        return 0;
    }
}

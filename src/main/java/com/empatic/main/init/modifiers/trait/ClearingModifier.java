package com.empatic.main.init.modifiers.trait;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClearingModifier extends Modifier implements BreakSpeedModifierHook, ConditionalStatModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.CONDITIONAL_STAT, ModifierHooks.BREAK_SPEED);
    }

    @Override
    public int getPriority() {
        return 85; // after flat boosts, before multipliers
    }


    /** Increase stats if affected by a harmful effect. Cancelled by beneficial effects */
    private static float getBoost(LivingEntity living, ModifierEntry entry, float baseSpeed) {
        List<MobEffectInstance> efectos = new ArrayList<>((living).getActiveEffects());
        boolean fatiga = false;
        boolean herido = false;
        boolean trampas = false;
        for (MobEffectInstance efecto:efectos) {
            //Cancelled by Mining Fatigue
            if (efecto.getEffect().equals(MobEffects.DIG_SLOWDOWN)){
                fatiga = true;
            }
        }
        if (!fatiga) {
            for (MobEffectInstance efecto:efectos) {
                if (efecto.getEffect().getCategory() == MobEffectCategory.HARMFUL){
                    //You need to be affected by at least one harmful effect
                    herido = true;
                } else if (efecto.getEffect().getCategory() == MobEffectCategory.BENEFICIAL) {
                    //You mustn't be affected by beneficial effects. Note that neutral ones don't matter
                    trampas = true;
                }
            }
            if (herido && !trampas) {
                //12.5% boost per level
                return baseSpeed * (1 + 0.125f * entry.getEffectiveLevel());
            }
        }
        return baseSpeed;
    }

    @Override
    public void onBreakSpeed(@NotNull IToolStackView tool, @NotNull ModifierEntry modifier, BreakSpeed event, @NotNull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        Optional<BlockPos> pos = event.getPosition();
        if (!isEffective || pos.isEmpty()) {
            return;
        }
        event.setNewSpeed(getBoost(event.getEntity(), modifier, event.getNewSpeed()));
    }

    @Override
    public float modifyStat(IToolStackView tool, ModifierEntry modifier, LivingEntity living, FloatToolStat stat, float baseValue, float multiplier) {
        if (stat == ToolStats.DRAW_SPEED) {
            return getBoost(living, modifier, baseValue);
        }
        return baseValue;
    }
}

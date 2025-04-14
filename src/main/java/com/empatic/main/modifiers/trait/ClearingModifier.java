package com.empatic.main.modifiers.trait;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.stats.ToolType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: convert into a module
public class ClearingModifier extends Modifier implements BreakSpeedModifierHook {

    private static final ToolType[] TYPES = { ToolType.MELEE };

    @Override
    public int getPriority() {
        return 85; // after flat boosts, before multipliers
    }


    /** Gets the boost for the given level and height, can go negative */
    private static float getBoost(LivingEntity living, ModifierEntry entry, float baseSpeed) {
        List<MobEffectInstance> efectos = new ArrayList<>((living).getActiveEffects());
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
                return baseSpeed * 1.125f * entry.getEffectiveLevel();
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
}

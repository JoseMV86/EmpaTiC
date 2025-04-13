package com.empatic.main.modifiers.trait;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap.Builder;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.stats.ToolType;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

// TODO: convert into a module
public class ClearingModifier extends Modifier implements BreakSpeedModifierHook {
    private static final Component MINING_SPEED = TConstruct.makeTranslation("modifier", "dwarven.mining_speed");
    private static final Component VELOCITY = TConstruct.makeTranslation("modifier", "dwarven.velocity");
    /** Distance below sea level to get boost */
    private static final float BOOST_DISTANCE = 64f;
    /** Blocks above 0 when debuff starts, and the range of debuff in the world */
    private static final float DEBUFF_RANGE = 128f;
    /** Mining speed boost when at distance, gets larger when lower */
    private static final float MINING_BONUS = 6;
    /** Velocity boost when at distance, gets larger when lower */
    private static final float VELOCITY_BONUS = 0.05f;

    private static final ToolType[] TYPES = { ToolType.RANGED, ToolType.MELEE };

    @Override
    public int getPriority() {
        return 85; // after flat boosts, before multipliers
    }


    /** Gets the boost for the given level and height, can go negative */
    private static float getBoost(LivingEntity living, ModifierEntry entry, float baseSpeed) {
        List<MobEffectInstance> efectos = new ArrayList((living).getActiveEffects());
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
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        Optional<BlockPos> pos = event.getPosition();
        if (!isEffective || pos.isEmpty()) {
            return;
        }
        event.setNewSpeed(getBoost(event.getEntity(), modifier, event.getNewSpeed()));
    }
}

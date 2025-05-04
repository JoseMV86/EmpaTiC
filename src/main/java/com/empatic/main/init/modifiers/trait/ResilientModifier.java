package com.empatic.main.init.modifiers.trait;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.mantle.data.predicate.damage.DamageSourcePredicate;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.ProtectionModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.ArrayList;
import java.util.List;

public class ResilientModifier extends Modifier implements ProtectionModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.PROTECTION);
    }

    @Override
    public int getPriority() {
        return 85; // after flat boosts, before multipliers
    }


    /** Increase stats if affected by a harmful effect. Cancelled by beneficial effects */
    private static float getBoost(LivingEntity living, ModifierEntry entry) {
        List<MobEffectInstance> efectos = new ArrayList<>((living).getActiveEffects());
        boolean herido = false;
        boolean trampas = false;
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
            //+4% boost per level
            return entry.getEffectiveLevel(); //No need to multiply because 4% = 1
        }
        return 0;
    }

    @Override
    public float getProtectionModifier(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slotType, DamageSource source, float modifierValue) {
        if (DamageSourcePredicate.CAN_PROTECT.matches(source)) {
            modifierValue += getBoost(context.getEntity(), modifier);
        }
        return modifierValue;
    }
}

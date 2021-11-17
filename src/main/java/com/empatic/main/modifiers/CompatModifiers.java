package com.empatic.main.modifiers;

import com.empatic.main.EmpaTiC;
import com.empatic.main.modifiers.trait.*;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.tools.modifiers.effect.BleedingEffect;

public class CompatModifiers {
	public static final DeferredRegister<Modifier> MODIFIERS = DeferredRegister.create(Modifier.class, EmpaTiC.MODID);

	//trait
	public static final RegistryObject<AridModifier> ARID = MODIFIERS.register("arid", AridModifier::new);
	public static final RegistryObject<ClearingModifier> CLEARING = MODIFIERS.register("clearing", ClearingModifier::new);
	public static final RegistryObject<Fiery2Modifier> FIERY2 = MODIFIERS.register("fiery2", Fiery2Modifier::new);
	public static final RegistryObject<FrailModifier> FRAIL = MODIFIERS.register("frail", FrailModifier::new);
	public static final RegistryObject<UnderbornModifier> UNDERBORN = MODIFIERS.register("underborn", UnderbornModifier::new);
	public static final RegistryObject<UnreliableModifier> UNRELIABLE = MODIFIERS.register("unreliable", UnreliableModifier::new);
	public static final RegistryObject<ForestEnergyModifier> FORESTENERGY = MODIFIERS.register("forestenergy", ForestEnergyModifier::new);
	public static final RegistryObject<ForestKnockbackModifier> FORESTKNOCKBACK = MODIFIERS.register("forestknockback", ForestKnockbackModifier::new);
	public static final RegistryObject<ForestSpeedModifier> FORESTSPEED = MODIFIERS.register("forestspeed", ForestSpeedModifier::new);
	public static final RegistryObject<ArmoredModifier> ARMORED = MODIFIERS.register("armored", ArmoredModifier::new);
}
package com.empatic.main.init.modifiers;

import com.empatic.main.EmpaTiC;
import com.empatic.main.init.modifiers.trait.ClearingModifier;
import com.empatic.main.init.modifiers.trait.UnderbornModifier;

import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;


public class CompatModifiers {
	public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(EmpaTiC.MODID);

	//trait
	public static final StaticModifier<ClearingModifier> CLEARING = MODIFIERS.register("clearing", ClearingModifier::new);
	public static final StaticModifier<UnderbornModifier> UNDERBORN = MODIFIERS.register("underborn", UnderbornModifier::new);

}
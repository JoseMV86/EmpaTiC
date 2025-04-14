package com.empatic.main.modifiers;

import com.empatic.main.EmpaTiC;
import com.empatic.main.modifiers.trait.*;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;


public class CompatModifiers {
	public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(EmpaTiC.MODID);

	//trait
	public static final StaticModifier<ClearingModifier> CLEARING = MODIFIERS.register("clearing", ClearingModifier::new);
	public static final StaticModifier<UnderbornModifier> UNDERBORN = MODIFIERS.register("underborn", UnderbornModifier::new);

}
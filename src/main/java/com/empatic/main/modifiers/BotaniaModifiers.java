package com.empatic.main.modifiers;

import com.empatic.main.EmpaTiC;
import com.empatic.main.modifiers.trait.*;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;

public class BotaniaModifiers {
	public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(EmpaTiC.MODID);
	public static final StaticModifier<ManaAdeptModifier> MANAADEPT = MODIFIERS.register("manaadept", ManaAdeptModifier::new);
	public static final StaticModifier<ManaInfusedModifier> MANAINFUSED = MODIFIERS.register("manainfused", ManaInfusedModifier::new);
	public static final StaticModifier<PixieModifier> PIXIE = MODIFIERS.register("pixie", PixieModifier::new);
}
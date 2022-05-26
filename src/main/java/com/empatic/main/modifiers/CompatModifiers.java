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
	public static final StaticModifier<AridModifier> ARID = MODIFIERS.register("arid", AridModifier::new);
	public static final StaticModifier<ClearingModifier> CLEARING = MODIFIERS.register("clearing", ClearingModifier::new);
	public static final StaticModifier<FrailModifier> FRAIL = MODIFIERS.register("frail", FrailModifier::new);
	public static final StaticModifier<UnderbornModifier> UNDERBORN = MODIFIERS.register("underborn", UnderbornModifier::new);
	public static final StaticModifier<UnreliableModifier> UNRELIABLE = MODIFIERS.register("unreliable", UnreliableModifier::new);
	public static final StaticModifier<OverheatedModifier> OVERHEATED = MODIFIERS.register("overheated", OverheatedModifier::new);
	public static final StaticModifier<FrostyModifier> FROSTY = MODIFIERS.register("frosty", FrostyModifier::new);
	public static final StaticModifier<RotkillerModifier> ROTKILLER = MODIFIERS.register("rotkiller", RotkillerModifier::new);
	public static final StaticModifier<GloomyModifier> GLOOMY = MODIFIERS.register("gloomy", GloomyModifier::new);
	public static final StaticModifier<TornApartModifier> TORNAPART = MODIFIERS.register("tornapart", TornApartModifier::new);
	public static final StaticModifier<DynamicModifier> DYNAMIC = MODIFIERS.register("dynamic", DynamicModifier::new);
	public static final StaticModifier<FireproofModifier> FIREPROOF = MODIFIERS.register("fireproof", FireproofModifier::new);
	public static final StaticModifier<OverlightModifier> OVERLIGHT = MODIFIERS.register("overlight", OverlightModifier::new);
	public static final StaticModifier<ThinModifier> THIN = MODIFIERS.register("thin", ThinModifier::new);
}
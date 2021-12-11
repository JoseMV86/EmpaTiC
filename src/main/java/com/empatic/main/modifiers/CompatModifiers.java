package com.empatic.main.modifiers;

import com.empatic.main.EmpaTiC;
import com.empatic.main.modifiers.trait.*;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

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
	public static final RegistryObject<OverheatedModifier> OVERHEATED = MODIFIERS.register("overheated", OverheatedModifier::new);
	public static final RegistryObject<FrostyModifier> FROSTY = MODIFIERS.register("frosty", FrostyModifier::new);
	public static final RegistryObject<RotkillerModifier> ROTKILLER = MODIFIERS.register("rotkiller", RotkillerModifier::new);
	public static final RegistryObject<GloomyModifier> GLOOMY = MODIFIERS.register("gloomy", GloomyModifier::new);
	public static final RegistryObject<TornApartModifier> TORNAPART = MODIFIERS.register("tornapart", TornApartModifier::new);
	public static final RegistryObject<DynamicModifier> DYNAMIC = MODIFIERS.register("dynamic", DynamicModifier::new);
	public static final RegistryObject<FireproofModifier> FIREPROOF = MODIFIERS.register("fireproof", FireproofModifier::new);
	public static final RegistryObject<AscendingModifier> ASCENDING = MODIFIERS.register("ascending", AscendingModifier::new);
	public static final RegistryObject<OverlightModifier> OVERLIGHT = MODIFIERS.register("overlight", OverlightModifier::new);
	public static final RegistryObject<ShadowshieldModifier> SHADOWSHIELD = MODIFIERS.register("shadowshield", ShadowshieldModifier::new); //Unused
	public static final RegistryObject<VoidCallingModifier> VOIDCALLING = MODIFIERS.register("voidcalling", VoidCallingModifier::new);
	public static final RegistryObject<ThinModifier> THIN = MODIFIERS.register("thin", ThinModifier::new);
}
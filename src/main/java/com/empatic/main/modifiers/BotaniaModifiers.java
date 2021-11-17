package com.empatic.main.modifiers;

import com.empatic.main.EmpaTiC;
import com.empatic.main.modifiers.trait.*;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class BotaniaModifiers {
	public static final DeferredRegister<Modifier> MODIFIERS = DeferredRegister.create(Modifier.class, EmpaTiC.MODID);
	public static final RegistryObject<ManaAdeptModifier> MANAADEPT = MODIFIERS.register("manaadept", ManaAdeptModifier::new);
	public static final RegistryObject<ManaInfusedModifier> MANAINFUSED = MODIFIERS.register("manainfused", ManaInfusedModifier::new);
	public static final RegistryObject<PixieModifier> PIXIE = MODIFIERS.register("pixie", PixieModifier::new);
}
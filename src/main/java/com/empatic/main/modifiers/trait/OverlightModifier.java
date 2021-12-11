package com.empatic.main.modifiers.trait;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.ToolDefinition;
import slimeknights.tconstruct.library.tools.nbt.IModDataReadOnly;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.modifiers.slotless.OverslimeModifier;

public class OverlightModifier extends Modifier {
  public OverlightModifier() {
    super(0xffbb3b);
  }

  @Override
  public int getPriority() {
    return 95; // after overcast
  }

  @Override
  public void addVolatileData(ToolDefinition toolDefinition, StatsNBT baseStats, IModDataReadOnly persistentData, int level, ModDataNBT volatileData) {
    OverslimeModifier overslime = TinkerModifiers.overslime.get();
    overslime.setFriend(volatileData);
    overslime.addCapacity(volatileData, level * 10);
    overslime.multiplyCapacity(volatileData, 1f + (level * 0.2f));
  }

  @Override
  public void onInventoryTick(IModifierToolStack tool, int level, World world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
    if (!world.isRemote && world.getGameTime() % 20 == 0 && holder.getActiveItemStack() != stack) {
      OverslimeModifier overslime = TinkerModifiers.overslime.get();
      int skylight = holder.getEntityWorld().getLightFor(LightType.SKY, holder.getPosition()) - world.getSkylightSubtracted() - 7;
      if (skylight > 0) {
        float chance = ((float) skylight * level)/60f;
        if (RANDOM.nextFloat() < chance) {
          overslime.addOverslime(tool, 1);
        }
      }
    }
  }
}

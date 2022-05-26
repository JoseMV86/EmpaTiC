package com.empatic.main.modifiers.trait;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.modifiers.slotless.OverslimeModifier;

public class OverlightModifier extends Modifier {

  @Override
  public int getPriority() {
    return 95; // after overcast
  }

  @Override
  public void addVolatileData(ToolRebuildContext toolDefinition, int level, ModDataNBT volatileData) {
    OverslimeModifier overslime = TinkerModifiers.overslime.get();
    overslime.setFriend(volatileData);
    overslime.addCapacity(volatileData, level * 10);
    overslime.multiplyCapacity(volatileData, 1f + (level * 0.2f));
  }

  @Override
  public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
    if (!world.isClientSide() && world.getGameTime() % 20 == 0 && holder.getUseItem() != stack) {
      OverslimeModifier overslime = TinkerModifiers.overslime.get();
      int skylight = holder.getCommandSenderWorld().getBrightness(LightLayer.SKY, holder.blockPosition()) - world.getSkyDarken() - 7;
      if (skylight > 0) {
        float chance = ((float) skylight * level)/60f;
        if (RANDOM.nextFloat() < chance) {
          overslime.addOverslime(tool, 1);
        }
      }
    }
  }
}

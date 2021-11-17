package com.empatic.main.blocks;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class StartupClientOnly
{
  /**
   * Tell the renderer this is a solid block
   * @param event
   */
  @SubscribeEvent
  public static void onClientSetupEvent(FMLClientSetupEvent event) {
    RenderTypeLookup.setRenderLayer(StartupCommon.debriStone, RenderType.getSolid());
    RenderTypeLookup.setRenderLayer(StartupCommon.cutDebriStone, RenderType.getSolid());
    RenderTypeLookup.setRenderLayer(StartupCommon.chiseledDebriStone, RenderType.getSolid());
    RenderTypeLookup.setRenderLayer(StartupCommon.smoothDebriStone, RenderType.getSolid());
    RenderTypeLookup.setRenderLayer(StartupCommon.milkonstantanBlock, RenderType.getSolid());
  }
}

package com.empatic.main.init.datagen.fluids;

import com.empatic.main.EmpaTiC;
import com.empatic.main.init.fluids.EmpaticFluids;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class DatagenFluidTags extends FluidTagsProvider {

  public DatagenFluidTags(PackOutput packOutput, CompletableFuture<Provider> lookupProvider, ExistingFileHelper helper) {
    super(packOutput, lookupProvider, EmpaTiC.MODID, helper);
  }

  @Override
  protected void addTags(Provider pProvider) {
    // first, register common tags
    // EmpaTiC
    fluidTag(EmpaticFluids.moltenMilkonstantan);

    // tooltips //
    this.tag(TinkerTags.Fluids.METAL_TOOLTIPS).addTags(
        // EmpaTiC
            EmpaticFluids.moltenMilkonstantan.getTag()
    );
  }

  @Override
  public String getName() {
    return "EmpaTiC Fluid TinkerTags";
  }


  /** Adds tags for a placable fluid */
  private void fluidTag(FlowingFluidObject<?> fluid) {
    tag(fluid.getLocalTag()).add(fluid.getStill(), fluid.getFlowing());
    TagKey<Fluid> tag = fluid.getCommonTag();
    if (tag != null) {
      tag(tag).addTag(fluid.getLocalTag());
    }
  }
}

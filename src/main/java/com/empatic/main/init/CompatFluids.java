package com.empatic.main.init;

import com.empatic.main.EmpaTiC;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;

import static slimeknights.tconstruct.fluids.block.BurningLiquidBlock.createBurning;

public class CompatFluids {
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(EmpaTiC.MODID);

    public static final ResourceLocation MOLTEN_METAL_STILL = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/molten_metal_still");
    public static final ResourceLocation MOLTEN_METAL_FLOW = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/molten_metal_flowing");
    public static final ResourceLocation MOLTEN_STONE_STILL = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/molten_stone_still");
    public static final ResourceLocation MOLTEN_STONE_FLOW = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/molten_stone_flowing");
    public static final ResourceLocation LIQUID_STILL = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/liquid_still");
    public static final ResourceLocation LIQUID_FLOW = new ResourceLocation(EmpaTiC.MODID,
            "block/fluids/liquid_flowing");


    //materials
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenMilkonstantan = FLUIDS.register("molten_milkonstantan").type(hot("molten_milkonstantan").temperature(875).lightLevel(10)).block(createBurning(MapColor.SAND, 10, 10, 6f)).bucket().commonTag().flowing();


    /**
     * Creates a builder for a hot with sounds and description
     */
    private static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
                .descriptionId(EmpaTiC.makeDescriptionId("fluid", name))
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                // from forge lava type
                .motionScale(0.0023333333333333335D)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);

    }
}
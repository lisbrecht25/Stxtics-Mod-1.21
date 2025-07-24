package net.lukeisbrecht.stxticsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lukeisbrecht.stxticsmod.block.ModBlocks;
import net.lukeisbrecht.stxticsmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        BlockStateModelGenerator.BlockTexturePool nocturaPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.NOCTURA_PLANKS);
        nocturaPool.stairs(ModBlocks.NOCTURA_STAIRS);
        nocturaPool.slab(ModBlocks.NOCTURA_SLAB);
        nocturaPool.button(ModBlocks.NOCTURA_BUTTON);
        nocturaPool.pressurePlate(ModBlocks.NOCTURA_PRESSURE_PLATE);
        nocturaPool.fence(ModBlocks.NOCTURA_FENCE);
        nocturaPool.fenceGate(ModBlocks.NOCTURA_FENCE_GATE);
        nocturaPool.wall(ModBlocks.NOCTURA_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.NOCTURA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.NOCTURA_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NOCTURA_SAPLING, Models.GENERATED);
    }
}

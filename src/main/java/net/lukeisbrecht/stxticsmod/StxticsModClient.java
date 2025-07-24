package net.lukeisbrecht.stxticsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.lukeisbrecht.stxticsmod.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class StxticsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NOCTURA_DOOR, RenderLayer.getCutout());
    }
}

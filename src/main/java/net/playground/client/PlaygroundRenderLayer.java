package net.playground.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import net.playground.registry.PlaygroundBlocks;

public class PlaygroundRenderLayer {
    public static void init() {
        BlockRenderLayerMap.INSTANCE.putBlock(PlaygroundBlocks.BACKPACK, RenderLayer.getCutout());
    }
}
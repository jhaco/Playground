package net.playground.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

import net.playground.registry.PlaygroundBlocks;

public class PlaygroundColors {
	public static void init() {
		ColorProviderRegistry.BLOCK.register(new BlockColorProvider() {
			@Override
			public int getColor(BlockState state, BlockRenderView view, BlockPos pos, int tintIndex) {return 0x3495eb;}}, PlaygroundBlocks.BACKPACK);

        ColorProviderRegistry.ITEM.register((itemStack, layer) -> {return 0x3495eb;}, PlaygroundBlocks.BACKPACK);
        
        BlockRenderLayerMap.INSTANCE.putBlock(PlaygroundBlocks.BACKPACK, RenderLayer.getCutout());
	}
}
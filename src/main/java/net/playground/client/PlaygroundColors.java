package net.playground.client;

import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

import net.playground.registry.PlaygroundBlocks;

public class PlaygroundColors {
	public static void init() {
		ColorProviderRegistry.BLOCK.register(new BlockColorProvider() {
			@Override
			public int getColor(BlockState state, BlockRenderView view, BlockPos pos, int tintIndex) {return 8606770;}}, PlaygroundBlocks.BACKPACK);

        ColorProviderRegistry.ITEM.register((itemStack, layer) -> {return 8606770;}, PlaygroundBlocks.BACKPACK);
	}
}
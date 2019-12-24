package net.playground.registry;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import net.playground.Playground;
import net.playground.block.Backpack;

public class PlaygroundBlocks {

    public static final Block BACKPACK = register("backpack", new Backpack(Block.Settings.of(Material.PISTON).strength(0.5f, 1200)));

    private PlaygroundBlocks() {

    }

    public static void init() {
        // BlockRenderLayerMap.INSTANCE.putBlock(BACKPACK, RenderLayer.getCutout());

		// ColorProviderRegistry.BLOCK.register(new BlockColorProvider() {
			// @Override
			// public int getColor(BlockState state, BlockRenderView view, BlockPos pos, int tintIndex) {return 0x3495eb;}}, BACKPACK);

		// ColorProviderRegistry.ITEM.register((itemStack, layer) -> {return 0x3495eb;}, BACKPACK);
    }

    static <T extends Block> T register(String name, T block, Item.Settings settings) {
		return register(name, block, new BlockItem(block, settings));
    }
    
    static <T extends Block> T register(String name, T block) {
		return register(name, block, new Item.Settings().group(Playground.GROUP));
    }
    
    static <T extends Block> T register(String name, T block, BlockItem item) {
		T b = Registry.register(Registry.BLOCK, Playground.id(name), block);
		if (item != null) {
			PlaygroundItems.register(name, item);
		}
		return b;
	}

}



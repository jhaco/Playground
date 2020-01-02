package net.playground.registry;

import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import net.playground.Playground;
import net.playground.block.BackpackBlock;

public class PlaygroundBlocks {

    public static final Block BACKPACK = register("backpack", new BackpackBlock(Block.Settings.of(Material.PISTON).strength(0.5f, 1200)));

    private PlaygroundBlocks() {

    }

    public static void init() {
		
    }

    static <T extends Block> T register(String name, T block, Item.Settings settings) {
		    return register(name, block, new BlockItem(block, settings));
    }

    static <T extends Block> T register(String name, T block) {
		    return register(name, block, new Item.Settings().group(Playground.GROUP));
    }

    static <T extends Block> T register(String name, T block, Function<T, BlockItem> itemFactory) {
		return register(name, block, itemFactory.apply(block));
	}
    
    static <T extends Block> T register(String name, T block, BlockItem item) {
		    T b = Registry.register(Registry.BLOCK, Playground.id(name), block);
		    if (item != null) {
			      PlaygroundItems.register(name, item);
		    }
		    return b;
	  }

}



package net.playground.registry;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import net.playground.Playground;

public class PlaygroundItems {
    private PlaygroundItems() {

	}
	
	static Item.Settings newSettings() {
		return new Item.Settings().group(Playground.GROUP);
	}
	
	public static void init() {
		
	}
	
	protected static <T extends Item> T register(String name, T item) {
		return Registry.register(Registry.ITEM, Playground.id(name), item);
	}
}
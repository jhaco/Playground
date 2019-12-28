package net.playground.registry;

import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;

import net.playground.Playground;

public class PlaygroundItems {

	public static final Item ABYSSAL_ZOMBIE_SPAWN_EGG = register("abyssal_zombie_spawn_egg", new SpawnEggItem(PlaygroundEntities.ABYSSAL_ZOMBIE, 0x102F4E, 0x01041E, newSettings()));

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
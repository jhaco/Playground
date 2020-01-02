package net.playground.registry;

import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;

import net.playground.Playground;

public class PlaygroundItems {

	public static final Item ABYSSAL_ZOMBIE_SPAWN_EGG = register("abyssal_zombie_spawn_egg", new SpawnEggItem(PlaygroundEntities.ABYSSAL_ZOMBIE, 0x102F4E, 0x52C5EF, newSettings()));
	public static final Item SHADOW_BEAST_SPAWN_EGG = register("shadow_beast_spawn_egg", new SpawnEggItem(PlaygroundEntities.SHADOW_BEAST, 0x161616, 0xA4A4A4, newSettings()));
	public static final Item SHADOW_CREATURE_SPAWN_EGG = register("shadow_creature_spawn_egg", new SpawnEggItem(PlaygroundEntities.SHADOW_CREATURE, 0x161616, 0x454545, newSettings()));
	public static final Item SHADOW_MONSTER_SPAWN_EGG = register("shadow_monster_spawn_egg", new SpawnEggItem(PlaygroundEntities.SHADOW_MONSTER, 0x161616, 0x161616, newSettings()));


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
package net.playground;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import net.playground.registry.PlaygroundBlockEntities;
import net.playground.registry.PlaygroundBlocks;
import net.playground.registry.PlaygroundEntities;
import net.playground.registry.PlaygroundEventHandler;
import net.playground.registry.PlaygroundItems;
import net.playground.registry.PlaygroundSounds;

public class Playground implements ModInitializer {
	public static final String MOD_ID = "playground";
	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(PlaygroundBlocks.BACKPACK));

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
	
	@Override
	public void onInitialize() {
		PlaygroundBlocks.init();
		PlaygroundBlockEntities.init();
		PlaygroundItems.init();

		PlaygroundEntities.init();
		PlaygroundSounds.init();

		PlaygroundEventHandler.init();
	}	
}